# OpenID Connectの使用

OpenID Connectは、ユーザーが他のシステムにあるアカウントを使用して認証できるようにする軽量の認証レイヤーです。 これは[OAuth 2.0承認](../../../headless-delivery/using-oauth2/using-oauth2.md)プロトコルの上に構築されています。 OpenID Connectを使用することで、ユーザー認証を他のプロバイダーに **委任** し、既存のアカウントを持つユーザがLiferayのインストールで簡単に認証できるようにします。

```{note}
インストールに複数のプロバイダーを追加できますが、Liferay DXPをOpenID Connectプロバイダーにすることはできません。
```

OpenID ConnectのトークンフローはOAuth 2.0の機能の上に構築されているため、OAuth 2.0に似ています。 OAuth 2.0は認証プロトコルにすぎないため、特定のAPIへのアクセスを許可する **アクセストークン** を送信します。 OpenID Connectは、ユーザーが認証され、権限を付与されている場合に、 **名前** や **電子メール** などのユーザー情報を渡す **IDトークン** をこれに追加します。

<a name="creating-a-client-in-openid-connect-provider" />

## OpenID Connectプロバイダーでクライアントを作成する

OpenID Connectを使用するには、まずプロバイダーにクライアントとして登録する必要があります。 これはOAuth 2.0クライアントです。 プロセスはプロバイダーによって異なります。

1. プロバイダーのWebサイトに移動し、クライアントを作成します。

1. 作成プロセス中に、プロバイダーから送信されたトークンを処理できる **承認済みリダイレクトURL** を提供する必要があります。 Liferay DXPのURLは次のとおりです。

    ```
    https://[server.domain]/c/portal/login/openidconnect
    ```

1. プロバイダーはいくつかの情報を送信します。 検出エンドポイント、承認エンドポイント、発行者URLなど、これらのいくつかはクライアントに関係なく同じです。 リクエストに固有の2つの情報は、`client_id`と`client_secret`です。

プロバイダーから情報を収集します。 プロバイダー接続を作成する必要があります。

<a name="configuring-an-openid-connect-provider-connection" />

## OpenID Connectプロバイダー接続の構成

［**コントロールパネル**］ &rarr; ［**設定**］ &rarr; ［**Instance Settings**］ &rarr; ［**セキュリティ**］ &rarr; ［**SSO**］ に移動して、 ［**システムスコープ**］ の下の ***［OpenID Connect プロバイダー**］*を選択します。

![［System Settings］メニューでOpenID構成を検索する。](using-openid-connect/images/01.png)

次の手順を実行します：

1. ［**Add**］ ボタンをクリックしてプロバイダーを追加します。

1. プロバイダーから受け取った情報を使用して、フォームに記入します。

   | フィールド                                | 説明                                                                                                                                                               |
   | ------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
   | **プロバイダー名** | この名前は、ユーザーがOpenID Connectを使用してログインするときにサインインポートレットに表示されます。                                                                                                       |
   | **OpenIDクライアントID** | プロバイダーから受け取ったOAuth 2.0クライアントIDを提供します。                                                                                                                            |
   | **OpenID Connect クライアントシークレット** | プロバイダーから受け取ったOAuth 2.0クライアントシークレットを提供します。                                                                                                                        |
   | **スコープ** | ユーザー名と電子メールを要求するデフォルトのままにします。 プロバイダーは、他の範囲のユーザー情報を提供する場合があります。                                                                                                   |
   | **ディスカバリーエンドポイント** | 他のURLはこのURLから取得でき、プロバイダーによって異なります。                                                                                                                               |
   | **ディスカバリーエンドポイントキャッシュのキャッシュ時間(ミリ秒**) | この期間に検出されたエンドポイント（URL）をキャッシュします。                                                                                                                                 |
   | **認証エンドポイント** | このURLは、ユーザーを承認する（つまり、ユーザーをサインインする）ためのプロバイダーのURLを指します。                                                                                                            |
   | **発行者URL** | ユーザー情報を発行しているプロバイダーに関する情報を指すプロバイダーのURL。                                                                                                                          |
   | **JWKS URI** | プロバイダーのトークンを検証できる公開キーを含むプロバイダーのJSON Webキーセットを指すURL。                                                                                                              |
   | **IDトークンの署名アルゴリズム** | サポートされているIDトークンアルゴリズムを手動で設定します。 通常、これはディスカバリーエンドポイントで「検出」されます。 これらは必要な数だけ追加できます。                                                                                 |
   | **サブジェクトタイプ** | サブジェクト識別子は、プロバイダーがユーザーを確立するために使用する一意の、再割り当てされることのない識別子であり、クライアント（つまり、Liferay DXP）によって消費されます。 public（すべてのクライアントに同じ値を提供する）とprivate（各クライアントに異なる値を提供する）の2つのタイプがあります。 |
   | **トークン エンドポイント** | トークンをリクエストできるプロバイダーのURL。                                                                                                                                         |
   | **トークン接続のタイムアウト (ミリ秒**) | 検証のためにトークンをリクエストしたときに、タイムアウトするまでの待機時間。 `0`の値は永久に待機することを意味するため、お勧めしません。                                                                                           |
   | **ユーザー情報エンドポイント** | ユーザー情報を取得できるOAuth 2.0で保護されたURL。                                                                                                                                  |

フォームに入力し、 ［**保存**］ をクリックすると、OpenID Connect認証を有効にする準備が整います。

エクスポートされた構成は、次のシステム設定の構成ファイルになります。

```
com.liferay.portal.security.sso.openid.connect.internal.configuration.OpenIdConnectProviderConfiguration-［name］.config
```

ここで、`［name］`には、`provider1`などの一意の名前を入力します。

<a name="enabling-openid-connect-authentication" />

## OpenID Connect認証の有効化

1. ［**コントロールパネル**］ &rarr; ［**設定**］ &rarr; ［**Instance Settings**］ &rarr; ［**セキュリティ**］ &rarr; ［**SSO**］ に移動して、 ［**仮想インスタンススコープ**］ の下の ***［OpenId Connect**］*を選択します。

    ![インスタンス設定でOpenID Connect認証を有効にする。](using-openid-connect/images/02.png)

1. ［**Enabled**］ チェックボックスをクリックしてから、 ［**保存**］ をクリックします。

エクスポートされた構成は、次のシステム設定の構成ファイルになります。

```
com.liferay.portal.security.sso.openid.connect.configuration.OpenIdConnectConfiguration.config
```

これで、ユーザーはOpenID Connectでサインインできます。

<a name="signing-in-with-openid-connect" />

## OpenID Connectでサインインする

OpenID Connectでサインインするための新しいリンクがサインインポートレットに表示されます。

1. サインインポートレットの下部にあるOpenID Connectリンクをクリックします。

1. プロバイダーを選択して、 ［**Sign In**］ をクリックします。

1. プロバイダーのサインインページが表示されます。 資格情報を入力してログインします。

1. 認証が成功すると、認証された状態でLiferay DXPにリダイレクトされます。