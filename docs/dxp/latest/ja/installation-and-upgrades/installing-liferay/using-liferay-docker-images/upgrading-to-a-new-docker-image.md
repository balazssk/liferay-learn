# 新しいDockerイメージへのアップグレード

新しいLiferayバージョンがDockerイメージとしてリリースされると、それらにアップグレードできます。 [Upgrade Overview](../../upgrading-liferay/upgrade-basics/upgrade-overview.md)では、プロセスについて説明しています。

```{important}
   アップグレードする前に、**必ず**データベースとインストールをバックアップ<../../maintaining-a-liferay-dxp-installation/backing-up.md>してください。 バックアップコピーでアップグレードプロセスをテストすることをお勧めします。
```

アップグレードには、設定、マーケットプレイスアプリケーション、およびカスタムコードの更新が含まれます。 おそらく、アップグレードの最大の部分は、Liferayデータベースのアップグレードです。 データベースをアップグレードするには、2つの方法があります。

* [Liferay起動時にDockerイメージで自動アップグレードを使用する](../../upgrading-liferay/upgrade-basics/upgrading-via-docker.md): 自動アップグレードを有効にして新しいLiferay Dockerイメージを実行すると、Liferayの起動時にデータベースがアップグレードされます。 アップグレードが完了した後、Dockerコンテナを介してLiferayを引き続き使用できます。 シンプルでデータセットが小さいポータル環境は、この方法でアップグレードできます。

* [データベースアップグレードツールを使用する](../../upgrading-liferay/upgrade-basics/using-the-database-upgrade-tool.md): データベースアップグレードツールを使用したデータベースのアップグレードは、コンテナ化されていないLiferayのインストールで行う必要があります。 アップグレードが完了したら、新しいLiferay Dockerコンテナを指定できます。 複雑で、より大きなデータセットを持つ、または多くのカスタマイズがあるDXP環境およびポータル環境は、データベースアップグレードツールを使用してアップグレードする必要があります。

<a name="whats-next" />

## 次のステップ

まず、[Upgrade Overview](../../upgrading-liferay/upgrade-basics/upgrade-overview.md)をお読みください。 その後、新しいコンテナで自動アップグレードを使用したい場合は、[Upgrading via Docker](../../upgrading-liferay/upgrade-basics/upgrading-via-docker.md)を参照してください。 ご使用の環境でデータベースアップグレードツールの使用が必要な場合は、[データベースアップグレードツール](../../upgrading-liferay/upgrade-basics/using-the-database-upgrade-tool.md)を参照してください。
