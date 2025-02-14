# Dockerによるアップグレード

自動アップグレードを有効にしてLiferayのDockerイメージを実行すると、Liferayの起動時にデータベースがアップグレードされます。 アップグレードが完了した後、[そのDockerコンテナを介してLiferayの使用](../../../installation-and-upgrades/installing-liferay/using-liferay-docker-images/docker-container-basics.md)を継続するか、またはアップグレードされたデータベースに新しいLiferayオンプレミスインストールを指定できます。

```{important}
Dockerをお持ちではありませんか？ まずは以下をご確認ください：

* [Linux](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
* [Windows](https://docs.docker.com/docker-for-windows/install/)
* [OSX](https://docs.docker.com/docker-for-mac/install/)
```

| DXP版                   | イメージ                                                | タグ                                                  |
|:---------------------- |:--------------------------------------------------- |:--------------------------------------------------- |
| Liferay DXP（サブスクリプション） | [`dxp`](https://hub.docker.com/r/liferay/dxp)       | [こちら](https://hub.docker.com/r/liferay/dxp/tags)    |
| Liferay Portal         | [`portal`](https://hub.docker.com/r/liferay/portal) | [こちら](https://hub.docker.com/r/liferay/portal/tags) |

```{important}
エンタープライズサブスクライバーのインストールおよびクリティカルインストールへのアップグレードは、データベースアップグレードツールを使用して行う必要があります。 詳細は、 [データベースアップグレードツールの使用](./using-the-database-upgrade-tool.md) を参照してください。
```

```{important}
アップグレードする前に、**必ず**データベースと既存のインストールを[バックアップ](../../maintaining-a-liferay-dxp-installation/backing-up.md)してください。 バックアップコピーでアップグレードプロセスをテストすることをお勧めします。
```

<a name="upgrading-with-the-latest-docker-image" />

## 最新のDockerイメージによるアップグレード

Dockerイメージを使用してアップグレードする手順は次のとおりです。

1. 新しいLiferay Dockerイメージで使用する任意のフォルダを作成し、`files`と`deploy`というサブフォルダを作成します。 例:

    ```
    mkdir -p new-version/files
    ```

    ```
    mkdir -p new-version/deploy
    ```

    * `files`: Dockerコンテナはこのフォルダからコンテナの [Liferay Home](../../reference/liferay-home.md) フォルダにファイルをコピーします。

    * `deploy`: Dockerコンテナは、このフォルダからコンテナの自動デプロイ用フォルダにアーティファクトをコピーします。

1. [コマース](https://learn.liferay.com/commerce/latest/ja/index.html) を使用している場合は、コマースをアップグレードする準備をしてください。  詳細については、 [Liferay Commerceのアップグレード](https://learn.liferay.com/commerce/latest/ja/installation-and-upgrades/upgrading-liferay-commerce.html) を参照してください。

1. Liferayデータベースのアップグレードと一緒にマーケットプレイスアプリのデータをアップグレードする場合は、新しいLiferayバージョンの対象となる各アプリの最新バージョンを[ダウンロード](../../../system-administration/installing-and-managing-apps/installing-apps/downloading-apps.md)して、`new-version/deploy`フォルダにコピーします。 それ以外の場合は、 [アップグレード後の考慮事項](./post-upgrade-considerations.md) で説明されているようにデータベースのアップグレード後にアプリをインストールし、データをアップグレードできます。

1. 組み込みの[Elasticsearch](../../../using-search/installing-and-upgrading-a-search-engine/elasticsearch/getting-started-with-elasticsearch.md)エンジンまたはローカルの[ファイルストア\（ドキュメントライブラリ\）](../../../system-administration/file-storage/configuring-file-storage.md)を使用している場合は、`[Liferay Home]/data`フォルダを新しい`files`フォルダにコピーして`new-version/files/data`を作成します。

1. [Liferay Homeのファイル](../../maintaining-a-liferay-dxp-installation/backing-up.md#liferay-home) と [アプリケーションサーバーファイル](../../maintaining-a-liferay-dxp-installation/backing-up.md#application-server) をバックアップから`files`フォルダ内の対応する場所（新しい`［Liferay Home］`）にコピーしてマージします。 例えば、アクティベーションキーを`new-version/files/license/`にコピーします。 ファイルには次のものが含まれる場合がありますが、これらに限定されません。

    * `/license/*`：アクティベーションキー。 (サブスクリプション)

    * `/log/*`：ログファイル。

    * `/osgi/configs/*.config`：[OSGiの設定ファイル](../../../system-administration/configuring-liferay/configuration-files-and-factories/using-configuration-files.md)。

    * `portal-*.properties`： [ポータルプロパティ](../../reference/portal-properties.md) ファイル（例：`portal-ext.properties`）。

    * `setenv.sh`、`startup.sh`など：アプリケーションサーバーの設定スクリプト。

    * `web.xml`：ポータルWebアプリケーション記述子。

1. 7.2にアップグレードする場合は、`[Liferay Home]/files/osgi/config/`フォルダにある[構成ファイル](../../../system-administration/configuring-liferay/configuration-files-and-factories/using-configuration-files.md)を使用して検索インデックスを無効にします。 例:

    ```bash
    echo "indexReadOnly=\"true\"" >> new-version/files/osgi/config/com.liferay.portal.search.configuration.IndexStatusManagerConfiguration.config
    ```

1. [高度なファイルシステムストア](../../../system-administration/file-storage/configuring-file-storage.md)または[簡易ファイルシステムストア](../../../system-administration/file-storage/other-file-store-types/simple-file-system-store.md)を使用していて、保存場所を変更している場合は、ファイルストアの設定を [`.config`ファイル](../../../system-administration/configuring-liferay/configuration-files-and-factories/using-configuration-files.md#creating-configuration-files) にエクスポートして、`new-version/osgi/configs`フォルダにコピーします。

    ```{important}
    [高度なファイルシステムストア](../../../system-administration/file-storage/configuring-file-storage.md)を使用している場合は、データベースをアップグレードする前に、新しいインストールで`.config`ファイルを使って設定する必要があります。

    以下に例を示します。`com.liferay.portal.store.file.system.configuration.AdvancedFileSystemStoreConfiguration.config` file with the required `rootDir` parameter:

    `rootDir="data/document_library"`
    ```

1. データベースベンダーが推奨するJDBCデータベースドライバーを使用していることを確認してください。 たとえば、MySQLを使用している場合は、[`new-version/files/portal-ext.properties`](../../reference/portal-properties.md)でjdbc.default.driverClassName=com.mysql.cj.jdbc.Driverを設定し、アプリケーションサーバーが使用するMySQL JDBCドライバーのJARを置き換えます。 詳細は、 [Database Drivers](../configuration-and-infrastructure/migrating-configurations-and-properties.md#database-drivers) を参照してください。

1. 新しいバージョンのフォルダにマウントされた[Dockerイメージ](../../installing-liferay/using-liferay-docker-images/providing-files-to-the-container.md)を、以下のコマンドで実行します。 必要に応じて、イメージ名、タグ、環境値を差し替えてください。

    ```bash
    docker run -it -m 8g -p 8080:8080 \
     -v $(pwd)/new-version:/mnt/liferay \
     -e LIFERAY **UPGRADE** PERIOD **DATABASE** PERIOD **AUTO** PERIOD_RUN=true \
     liferay/[place image name here]:[place tag here]
    ```

    `-v new-version:/mnt/liferay`の引数は、ホストの`new-version`フォルダをコンテナの`/mnt/liferay`フォルダにバインドマウントします。 コンテナのLiferay Homeへのファイルのマッピングについては、 [コンテナへのファイルの提供](../../installing-liferay/using-liferay-docker-images/providing-files-to-the-container.md) を参照してください。

    パラメータ`-e LIFERAY_UPGRADE_PERIOD_DATABASE_PERIOD_AUTO_PERIOD_RUN=true`は、データベースのアップグレードをトリガーします。

1. コンソールまたはログで、データベースのアップグレードとサーバーの起動が成功したことを確認します。 アップグレードメッセージに、各アップグレードプロセスの開始と完了が表示されます。 次のようなメッセージは、サーバーの起動が完了したことを示しています。

    ```bash
    org.apache.catalina.startup.Catalina.start Server startup in [x] milliseconds
    ```

    アップグレードの失敗やエラーが発生した場合は、コンソールやログに出力されます。 [Gogo Shellコマンド](../upgrade-stability-and-performance/upgrading-modules-using-gogo-shell.md)を使用して、それらの問題をトラブルシューティングし、アップグレードを完了できます。

1. 障害やエラーを解決した後、[アップグレード後の検討事項](./post-upgrade-considerations.md)を調べます。

1. 新しいインストール先で [ポータルのプロパティを更新](../configuration-and-infrastructure/migrating-configurations-and-properties.md#migrating-portal-properties) します。

1. アップグレードしたデータベースを検証します。

    ![これがLiferayのランディング画面です。](./upgrading-via-docker/images/01.png)

データベースのアップグレードが完了しました。

新しいLiferayバージョンをDocker経由で使い続けたい場合は、 `-e LIFERAY_UPGRADE_PERIOD_DATABASE_PERIOD_AUTO_PERIOD_RUN=true`環境設定を、新しいコンテナの作成に使用する`docker run ...`コマンドから外してください。

```{note}
[Docker Container Basics](../../../installation-and-upgrades/installing-liferay/using-liferay-docker-images/docker-container-basics.md)では、Dockerコンテナの作成、停止、再起動について説明しています。
```

<a name="conclusion" />

## まとめ

アップグレードされたデータベースで十分な場合は、新しいLiferayインスタンスを使用してください。 アップグレードの完了の他に作業が必要な場合は、以下の記事を参考にしてください。

* [Upgrade Overview](./upgrade-overview.md)では、アップグレードに関するすべてのトピックについて説明しています。 まだ対処しなければならないトピックが見つかるかもしれません。

* [データベースアップグレードツールの使用](./using-the-database-upgrade-tool.md) では、Liferayサーバーのオフライン時にデータベースをアップグレードする方法を示しています。 アップグレードに時間がかかりすぎる場合は、[データベースの調整](../upgrade-stability-and-performance/database-tuning-for-upgrades.md)、 [不要なデータの削除](../upgrade-stability-and-performance/database-pruning-for-faster-upgrades.md)、[データベース アップグレード ツールの使用](./using-the-database-upgrade-tool.md)を検討してください。

* [カスタム開発のアップグレード](../upgrading-custom-development.md) では、カスタムプラグインコードを新しいLiferayバージョンに適応させる方法を示しています。

* [Maintaining Clustered Installations](../../maintaining-a-liferay-dxp-installation/maintaining-clustered-installations/maintaining-clustered-installations.md)では、クラスター環境でアップグレードする方法について説明しています。

* [アップグレードのトラブルシューティング](../reference/troubleshooting-upgrades.md)