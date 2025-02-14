# ディスパッチUIリファレンス

<a name="dispatch-triggers" />

## ディスパッチのトリガー

![ディスパッチタスクを表示、作成、および管理します。](./dispatch-ui-reference/images/01.png)

［Dispatch Triggers］タブには、Liferayインスタンスに追加されたすべてのディスパッチタスクが一覧表示されます。

**追加**（![Add Button](../../../images/icon-add.png)）をクリックして、ディスパッチタスクエグゼキュータテンプレートを使用してディスパッチタスクを作成します。

作成すると、ディスパッチタスクごとに次のフィールドが表示されます。

| フィールド              | 説明                                            |
| ------------------ | --------------------------------------------- |
| 名前                 | ディスパッチタスクの名前                                  |
| Task Executor Type | ディスパッチタスクの作成に使用されるディスパッチタスクエグゼキュータテンプレート      |
| システム               | システムタスクかどうかを示します                              |
| 作成日                | ディスパッチタスクが作成された日付                             |
| 次の実行日              | ディスパッチタスクの次回の実行予定日                            |
| 状態                 | ディスパッチタスクの最新の実行ステータス（例： **Successful** 、 **Failed**） |
| 今すぐ実行              | ディスパッチタスクを手動で実行するためのボタン                       |

ここから、ディスパッチタスクをクリックして、次の詳細と構成オプションにアクセスします。

### ［Details］タブ

![ディスパッチタスクの一般的な詳細を表示および編集します](./dispatch-ui-reference/images/02.png)

| フィールド           | 説明                                         |
| --------------- | ------------------------------------------ |
| Name            | ディスパッチタスクの名前を表示/編集します                      |
| Settings Editor | ランタイム時にディスパッチタスクに挿入されるプロパティを定義するためのコードエディタ |

### ［Talend］タブ（Talendディスパッチタスクのみ）

![Talendジョブアーカイブファイルをアップロードします。](./dispatch-ui-reference/images/03.png)

Talend **ジョブアーカイブ** `.zip`ファイルをディスパッチタスクにアップロードします。

### ［Logs］タブ

![選択したディスパッチタスクのログを表示および削除します。 ](./dispatch-ui-reference/images/04.png)

ディスパッチタスクの **ログ** を表示および削除します。 ［**Start Date**］ , ［**ランタイム**］ , ［**Trigger**］ 、および ［**Status**］ が含まれます。

| フィールド   | 説明                               |
| ------- | -------------------------------- |
| 開始日     | 実行開始時のタイムスタンプ                    |
| ランタイム   | 実行期間                             |
| Trigger | 実行されたディスパッチタスクの名前                |
| 状態      | 実行ステータス（例： **Successful** 、 **Failed**） |

ログエントリをクリックすると、実行時のエラーと出力も確認できます。

### ［Dispatch Trigger］タブ

![ディスパッチタスクの実行をスケジュールするようにディスパッチトリガーを構成します。](./dispatch-ui-reference/images/05.png)

ディスパッチタスクの実行をスケジュールするようにディスパッチトリガーを構成します。

| フィールド                       | 説明                                                             |
| --------------------------- | -------------------------------------------------------------- |
| Active                      | 設定された実行スケジュールがアクティブか非アクティブかを決定します                              |
| Task Execution Cluster Mode | ディスパッチタスクをクラスター環境の **単一ノード** で実行するか、 **すべてのノード** で実行するかを決定します          |
| Overlap Allowed             | ディスパッチタスクの同時実行を許可するかどうかを決定します                                  |
| Cron式                       | ディスパッチタスクを自動的に実行するための時間間隔を定義します                                |
| 開始日                         | cronスケジュールに従ってディスパッチタスクの実行を開始するタイミングを定義します。デフォルトでは現在の日時に設定されます |
| 無期限                         | ディスパッチタスクの自動実行を終了するかどうかを決定します。デフォルトではオンになっています                 |
| 終了日                         | ディスパッチタスクの自動実行を終了する日時を定義します。 ［**Never End**］ がオンになっている場合は無効です     |

<a name="scheduled-jobs" />

## スケジュールジョブ

![MessageListenerインターフェイスを使用してスケジュールされたすべてのジョブを表示します。](./dispatch-ui-reference/images/06.png)

このページでは、`MessageListener`インターフェイスを使用してLiferayインスタンス全体でスケジュールされたすべてのジョブのリストをコンパイルします。

| フィールド        | 説明                                        |
| ------------ | ----------------------------------------- |
| 名前           | スケジュールされたジョブの完全な名前                        |
| システム         | システムジョブかどうかを示します                          |
| 次の実行日        | ジョブの次回の実行予定日                              |
| 状態           | ジョブの状態（例：`NORMAL`、`PAUSED`）               |
| 今すぐ実行        | ジョブを手動で実行するためのボタン                         |
| Pause/Resume | ジョブを **一時停止** / **再開** するオプション。アクションボタンからアクセスできます |

<a name="additional-information" />

## 追加情報

* [ディスパッチの使用](./using-dispatch.md)
* [ディスパッチフレームワークを理解する](./understanding-the-dispatch-framework.md)
