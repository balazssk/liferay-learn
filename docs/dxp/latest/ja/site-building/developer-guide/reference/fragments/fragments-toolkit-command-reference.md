# フラグメントツールキットコマンドリファレンス

[フラグメントツールキット](../../developing-page-fragments/using-the-fragments-toolkit.md)は、現在実行中の Liferay DXP インスタンスに接続して、フラグメントをインポートおよびエクスポートできます。 ツールキットで作成したフラグメントをポータルに自動的にインポートすることもできます。 次のコマンドを使用できます。

<!-- TODO: The description for `npm run preview` is probably too long, it's overrunning the column width into a new table cell when the site is built. Probably should consider adding an asterisk and adding the version specific info separately after the table. -->

| コマンド                                                                                                                                                                    | 説明                                                                                                                                                                            |
| :--- | :--- |
| `npm run export`                                                                                                                                                        | 実行中のサーバーからコレクションとフラグメントを取得します                                                                                                                                                 |
| `npm run import`                                                                                                                                                        | コレクションとフラグメントを現在のプロジェクトから実行中のサーバーに送信します。 フラグメントの構成 JSON (利用可能な場合) が無効な場合、インポートは失敗し、エラー メッセージが表示されます。                                                                          |
| `npm run import:watch`                                                                                                                                                  | 作成または変更されたコレクションとフラグメントをポータルに自動的にインポートします                                                                                                                                     |
| `npm run preview`                                                                                                                                                       | インポート時にフラグメントがどのように見えるかをプレビューします。 これは、フラグメントをインポートせずに、指定された Liferay サーバーでレンダリングします。 プレビュー中にフラグメントに変更が加えられると、変更は自動的にリロードされ、更新内容がすばやく表示されます。 これは Liferay DXP で利用できることに注意してください。 |
| 7.2 SP1 以降および Liferay Portal 7.2 GA2 以降。 このコマンドが正しく動作するには、ポータル インスタンスに [OAuth 2](https://web.liferay.com/marketplace/-/mp/application/109571986) プラグインをインストールする必要があります。 |                                                                                                                                                                               |
| `npm run compress`                                                                                                                                                      | ポータルに手動でインポートできる `.zip` ファイルを作成します。                                                                                                                                           |

```{note}
フラグメントコレクションプロジェクトの `package.json` の `scripts` セクションに、利用可能なすべてのタスクが表示されます。
```

これらのツールを自由に使用できるため、ローカル環境のコマンド ラインからページ フラグメントの作成と編集を効率的に管理できます。
