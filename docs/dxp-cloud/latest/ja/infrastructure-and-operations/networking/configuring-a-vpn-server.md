# VPNサーバーの設定

以下のシナリオでは、IPsecまたはOpenVPNのVPNサーバーを設定する方法を説明します。 VPNサーバーを設定すると、DXP Cloudの内部ネットワークと本番環境の間に安全な接続を確立できます。 この例では、Ubuntu Server 18.0.4をコンセプトの証明として使用しています。 DXP CloudのClient-to-Site VPNs機能の概要については、 [VPNインテグレーションの概要](./vpn-integration-overview.md) の記事をご覧ください。

```{warning}
   設定コマンドや値は変更される場合がありますので、お客様の環境に合わせて設定してください。
```

`EAP-TLS` および `EAP-MSCHAPV2` の認証プロトコルは、いずれもVPN接続に対応しています。

<a name="basic-setup-for-an-ipsec-server" />

## IPsecサーバーの基本設定

IPsecテストサーバーを設定するには

1. 以下のファイルを `~/ipsec.conf` として保存し、 `leftid` の値をVPNサーバーの外部IPに置き換えます。

    ```
    config setup
      charondebug="ike 1, knl 1, cfg 0"
      uniqueids=no

    conn ikev2-vpn
      auto=add
      compress=no
      type=tunnel
      keyexchange=ikev2
      fragmentation=yes
      forceencaps=yes
      dpdaction=clear
      dpddelay=300s
      rekey=no
      left=%any
      leftid=18.188.145.101
      leftcert=server-cert.pem
      leftsendcert=always
      leftsubnet=0.0.0.0/0
      right=%any
      rightid=%any
      rightauth=eap-mschapv2
      rightsourceip=10.10.10.0/24
      rightdns=8.8.8.8,8.8.4.4
      rightsendcert=never
      eap_identity=%identity
    ```

    `EAP-MSCHAPv2`のみの代わりに`EAP-TLS`プロトコルを使用したい場合は、 `rightauth`構成のラインに`eap-tls`を追加します：

    ```
    rightauth=eap-mschapv2,eap-tls!
    ```

1. サーバーで、 `SERVER_EXTERNAL_IP` をVPNサーバーの外部IPに置き換え、 `USERNAME/PASSWORD` を値に置き換えます。

    ```properties
    SERVER **EXTERNAL** IP="18.188.145.101"
    USERNAME="myuser"
    PASSWORD="mypassword"
    ```

1. 必要な依存関係をインストールします。

    ```bash
    sudo apt-get update
    sudo apt install -y strongswan strongswan-pki
    sudo apt install -y libstrongswan-extra-plugins
    ```

1. セキュリティ証明書とキーを設定します。

    `EAP-MSCHAPV2`を使用したい場合は、以下のコマンドを実行して証明書を生成します：

    ```bash
    mkdir -p ~/pki/{cacerts,certs,private}
    chmod 700 ~/pki
    ipsec pki --gen --type rsa --size 4096 --outform pem > ~/pki/private/ca-key.pem
    ipsec pki --self --ca --lifetime 3650 --in ~/pki/private/ca-key.pem \ --type rsa --dn "CN=VPN root CA" --outform pem > ~/pki/cacerts/ca-cert.pem

    ipsec pki --gen --type rsa --size 4096 --outform pem > ~/pki/private/server-key.pem


    ipsec pki --pub --in ~/pki/private/server-key.pem --type rsa \
    |   ipsec pki --issue --lifetime 1825 \
      --cacert ~/pki/cacerts/ca-cert.pem \
      --cakey ~/pki/private/ca-key.pem \
      --dn "CN=$SERVER **EXTERNAL** IP" --san "$SERVER **EXTERNAL** IP" \
      --flag serverAuth --flag ikeIntermediate --outform pem \
    >  ~/pki/certs/server-cert.pem

    sudo cp -r ~/pki/* /etc/ipsec.d/
    ```

    それ以外の場合は、 `EAP-TLS`を使用するには、以下のコマンドを実行します：

    ```bash
    mkdir -p ~/pki/certs
    chmod 700 ~/pki
    cd ~/pki/certs

    ipsec pki --gen --outform pem > caKey.pem
    ipsec pki --self --in caKey.pem --dn "CN=VPN CA" --ca --outform pem > caCert.pem

    openssl x509 -in caCert.pem -outform der | base64 -w0 ; echo

    export PASSWORD="password"
    export USER_NAME="client"

    ipsec pki --gen --outform pem > "${USER_NAME}Key.pem"
    ipsec pki --pub --in "${USER_NAME}Key.pem" \
    | ipsec pki --issue --cacert caCert.pem \
      --cakey caKey.pem \
      --dn "CN=${USER_NAME}" \
      --san "${USER_NAME}" \
      --flag clientAuth \
      --outform pem \
    > "${USER_NAME}Cert.pem"

    openssl pkcs12 -in "${USER_NAME}Cert.pem" \
      -inkey "${USER_NAME}Key.pem" \
      -certfile caCert.pem \
      -export -out "${USER_NAME}.p12" \
      -password "pass:${PASSWORD}"

    cd ..
    sudo cp -r ./certs/* /etc/ipsec.d/ 
    ```

1. VPN接続に `EAP-TLS` を使用している場合は、 `/etc/ipsec.secrets` ファイルに（VPNのパスワードを使用して）以下を追加してください：

    ```
    : P12 client.p12 'password' # key filename inside /etc/ipsec.d/private directory
    ```

1. [StrongSwan](https://www.strongswan.org/) の設定を行います（上述の `server.conf` ファイルを参照）。

    ```bash
    sudo cp ~/ipsec.conf /etc/ipsec.conf
    ```

1. VPNサーバーの認証を設定します。

    ```bash
    echo -e ": RSA \"server-key.pem\"\n$USERNAME : EAP \"$PASSWORD\"" | sudo tee /etc/ipsec.secrets

    sudo systemctl restart strongswan
    ```

1. OSのカーネルを設定します。

    ```bash
    sudo sed -i 's/#net\/ipv4\/ip **forward=1/net\/ipv4\/ip** forward=1/g' /etc/ufw/sysctl.conf
    sudo sed -i 's/#net\/ipv4\/conf\/all\/accept **redirects/net\/ipv4\/conf\/all\/accept** redirects/g' /etc/ufw/sysctl.conf
    echo "net/ipv4/conf/all/send_redirects=0" | sudo tee -a /etc/ufw/sysctl.conf
    echo "net/ipv4/ip **no** pmtu_disc=1" | sudo tee -a /etc/ufw/sysctl.conf
    ```

1. OSのファイアウォールを設定する。

    ```bash
    networkInterfaceName=$(ip link | awk -F: '$0 !~ "lo|vir|^[^0-9]"{print $2a;getline}' | head -1)
    config="-A ufw-before-forward --match policy --pol ipsec --dir in --proto esp -s 10.10.10.0/24 -j ACCEPT"
    config="$config\n-A ufw-before-forward --match policy --pol ipsec --dir out --proto esp -d 10.10.10.0/24 -j ACCEPT"
    config="$config\nCOMMIT"
    config="$config\n*nat\n-A POSTROUTING -s 10.10.10.0/24 -o $networkInterfaceName -m policy --pol ipsec --dir out -j ACCEPT"
    config="$config\n-A POSTROUTING -s 10.10.10.0/24 -o $networkInterfaceName -j MASQUERADE"
    config="$config\nCOMMIT"
    config="$config\n*mangle"
    config="$config\n-A FORWARD --match policy --pol ipsec --dir in -s 10.10.10.0/24 -o $networkInterfaceName -p tcp -m tcp --tcp-flags SYN,RST SYN -m tcpmss --mss 1361:1536 -j TCPMSS --set-mss 1360"
    config="$config\nCOMMIT"
    sudo sed -i "s/COMMIT//g" /etc/ufw/before.rules
    echo -e $config | sudo tee -a /etc/ufw/before.rules

    sudo ufw allow 500,4500/udp
    sudo ufw allow OpenSSH
    sudo ufw disable
    sudo ufw enable
    ```

1. クライアントで使用するサーバー証明書を取得します。

    ```bash
    cat /etc/ipsec.d/cacerts/ca-cert.pem
    ```

IPsec VPNサーバーの設定が完了しました。

<a name="basic-setup-for-an-openvpn-server" />

## OpenVPNサーバの基本設定

OpenVPNサーバーを使用する場合は、以下の手順に従ってください。

1. 以下の値で `~/server.conf` を作成してください。

    ```
    #Port where the VPN server will answer requests
    port 1194

    #TCP or UDP - UDP is faster
    proto udp

    #This will create a routed IP tunnel instead of an ethernet tunnel
    dev tun

    #The VPN subnet range, all IPs that connected clients will have upon connection
    #The Server will take the first IP (in this case, 10.10.20.1),
    #and all other addresses are available to clients
    server 10.10.20.0 255.255.255.0

    #SSL root certificate (ca), certificate itself (cert) and private key (key)
    #All clients use the same CA, but have their own cert and key.
    ca /etc/openvpn/keys/ca.crt
    cert /etc/openvpn/keys/server.crt
    key /etc/openvpn/keys/server.key

    #Diffie Hellman parameters, this file can be generated with
    #openssl dhparam -out dh2048.pem 2048
    dh /etc/openvpn/keys/dh2048.pem

    #Records the IP address of each client so clients can use the same IP address
    #in case of reconnection
    ifconfig-pool-persist ipp.txt

    #Keeps connection alive, sends a ping every 10 seconds, and assume the connection is
    #down if no ping is received in 120 seconds
    keepalive 10 120

    #Cryptographic cipher used. The Client must use the same cipher
    cipher AES-256-CBC

    #HMAC - Hashed Message Authentication Code - used to avoid UDP port flooding,
    #must be the same on client and server
    auth SHA256

    #Enable compression on the VPN link
    compress lz4-v2
    push "compress lz4-v2"

    #Allows username/password authentication via PAM (linux accounts, LDAP),
    #if not provided, authentication is done via x509 certificates
    plugin /usr/lib/x86_64-linux-gnu/openvpn/plugins/openvpn-plugin-auth-pam.so login

    #Explicitly disables x509 certificate authentication
    verify-client-cert none

    #Try to avoid accessing certain resources on restart,
    #since they may not be available
    persist-key
    persist-tun

    #Notify all clients when the service is restarting,
    #so they can try to reconnect automatically
    explicit-exit-notify 1

    #Short status file showing current connections, updated every minute
    status openvpn-status.log

    #Redirect log messages to a log file
    log-append  /var/log/openvpn.log

    #Log verbosity, 0 is silent, 9 is extremely verbose
    verb 7
    ```

1. 必要な依存関係をインストールします。

    ```bash
    sudo apt-get update
    sudo apt-get install -y openvpn easy-rsa
    ```

1. 証明書とキーを設定します。

    ```bash
    make-cadir ~/openvpn-ca
    cd ~/openvpn-ca
    source vars
    ./clean-all
    ln -s openssl-1.0.0.cnf openssl.cnf
    ./build-ca
    ./build-dh
    ./build-key-server server
    openvpn --genkey --secret keys/ta.key
    sudo mkdir -p /etc/openvpn/keys/ && sudo cp ~/openvpn-ca/keys/* /etc/openvpn/keys/
    ```

1. 上記のOpenVPN `server.conf` ファイルを使用します。

    ```bash
    sudo cp ~/server.conf /etc/openvpn/
    ```

1. OSのカーネルを設定します。

    ```bash
    sudo sed -i 's/#net.ipv4.ip **forward=1/net.ipv4.ip** forward=1/g' /etc/sysctl.conf
    sudo sysctl -p
    ```

1. OSファイアウォールの設定

    ```bash
    networkInterfaceName=$(ip link | awk -F: '$0 !~ "lo|vir|^[^0-9]"{print $2a;getline}' | head -1)
    echo -e "*nat\n:POSTROUTING ACCEPT [0:0]\n-A POSTROUTING -s 10.8.0.0/8 -o $networkInterfaceName -j MASQUERADE\nCOMMIT\n" | sudo tee -a /etc/ufw/before.rules
    sudo sed -i 's/DEFAULT **FORWARD** POLICY="DROP"/DEFAULT **FORWARD** POLICY="ACCEPT"/g' /etc/default/ufw
    sudo ufw allow 1194/udp
    sudo ufw allow OpenSSH
    sudo ufw disable
    sudo ufw enable
    ```

1. VPNサーバーのサービスを開始します。

    ```bash
    sudo systemctl start openvpn@server
    ```

1. VPNでの認証に使用するOSユーザーを作成します。

    ```bash
    sudo adduser myuser
    ```

OpenVPNサーバーの設定が完了しました。

<a name="additional-information" />

## 追加情報

* [VPNインテグレーションの概要](./vpn-integration-overview.md)
* [DXP CloudへのVPNサーバーの接続](./connecting-a-vpn-server-to-dxp-cloud.md)