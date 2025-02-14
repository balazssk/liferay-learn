# アプリケーションマネージャを使用する

アプリケーションマネージャはコントロールパネルの画面であり、ここからDXPインストールのアプリのインストール、アンインストール、アクティブ化、非アクティブ化を行うことができます。 また、インストールされているアプリ（およびそのモジュールとOSGiコンポーネント）の詳細を検査するために使用することもできます。

[**Control Panel**] → [**Apps**] → [**App Manager**] を選択して、アプリケーションマネージャにアクセスします。 アプリケーションマネージには、インストールされているアプリとモジュールが一覧表示され、アプリのアップロード機能が提供されます。

<a name="the-app-listing" />

## アプリのリスト

[**Filter and Order**] メニューは、アイテムをフィルタリングし、カテゴリ、ステータス、またはタイトルで並べ替えます。 上矢印または下矢印をクリックして、アイテムをそれぞれ昇順または降順に並べ替えます。 アプリまたはモジュールを検索するには、検索バーを使用します。 これは多くの場合、アイテムを見つける最も速い方法です。

![アプリケーションマネージャは、DXPインスタンスにインストールされたアプリ、モジュール、コンポーネントを管理します。](./using-the-app-manager/images/01.png)

表にリストされている各アイテムには、アイテムの説明、バージョン、ステータスが含まれています。 ステータスは次のとおりです。

  - **Installed：** アイテムはDXPにインストールされています。
  - **Resolved：** アイテムの依存関係はアクティブです。 通常、解決されたアイテムはアクティブ化できます。 ただし、一部のアイテムはアクティブ化できず、[Resolved]状態を維持することを目的としています（SOAP Webサービスを含むWSDDモジュールなど）。
  - **Active：** アイテムはDXPで実行されています。

各アイテムのアクションボタン（![Actions](./using-the-app-manager/images/02.png)）をクリックすると、そのアイテムをアクティブ化、非アクティブ化、またはアンインストールできるメニューが表示されます。

アイテムのコンテンツを表示するには、表でアイテムの名前をクリックします。

  - アプリをクリックすると、アプリのモジュールが一覧表示されます。
  - モジュールをクリックすると、モジュールのOSGiコンポーネントおよびポートレットがリストされます。

コンポーネント/ポートレットのレベルは、ソースコードにアクセスすることなく実行できる最も遠いレベルです。 アプリケーションマネージャのどのレベルでも、リストの上にアイテムの階層コンテキストを示すリンクトレイルがあります。

<a name="installing-apps" />

## アプリのインストール

アプリケーションマネージャは、[ダウンロードしたアプリ](../installing-apps/downloading-apps.md)をローカルマシンからローカルまたはリモートのDXPサーバーにインストールする便利な方法です。

```{important}
For installing and uninstalling apps in production-grade environments, install apps [using server startup](../../../installation-and-upgrades/installing-liferay/running-liferay-for-the-first-time.md#startup) instead of using the App Manager.
```

アプリケーションマネージャを使用してアプリをインストールする手順は次のとおりです。

1.  オプションボタン（![Options](./using-the-app-manager/images/03.png)）から [**Upload**] を選択します。 [Upload]ダイアログが表示されます。

2.  マシン上のアプリを参照して選択します。

3. [**Install**] をクリックします。

アプリは [自動デプロイ](../installing-apps.md#installing-apps-via-the-file-system) を介してインストールされます。 インストールが完了したら、ダイアログを閉じます。これで使用する準備が整いました。

<a name="uninstalling-apps" />

## アプリのアンインストール

アプリをアンインストールすると、アプリが非アクティブ化され（アクティブな場合）、アクティブ化できなくなります。

```{note}
アプリケーションマネージャのアンインストール、再インストール、および再アクティブ化機能には既知の問題があります（ [LPS-102506](https://issues.liferay.com/browse/LPS-102506) を参照）。 回避策として、 [ブラックリスト](./blacklisting-apps.md) を使用してインストール済みアプリを無効にしてください。
```

アプリケーションマネージャを使用して、アプリケーションのデプロイを検査および管理できます。

<a name="additional-information" />

## 追加情報

  - [アプリのブラックリスト登録](./blacklisting-apps.md)
  - [OSGiコンポーネントのブラックリスト登録](./blacklisting-osgi-components.md)
  - [クラスター化されたインストールの維持](../../../installation-and-upgrades/maintaining-a-liferay-installation/maintaining-clustered-installations.md)
