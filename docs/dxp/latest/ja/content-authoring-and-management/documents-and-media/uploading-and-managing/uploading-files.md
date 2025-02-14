# ファイルのアップロード

ドキュメントとメディアを使用すると、Liferayインスタンスの[ファイルストア](../../../system-administration/file-storage/configuring-file-storage.md)または接続されたリポジトリに任意のタイプのファイルをアップロードできます。 アップロードされると、必要な[権限](../publishing-and-sharing/managing-document-access/documents-and-media-permissions-reference.md)を持つユーザーは、アップロードされたファイルを表示、編集、ダウンロード、または共有できます。

```{note}
ユーザーは、アップロード時にサポートされているアセットに自動的にタグを付けるようにLiferayを構成できます。 詳細については、 [アセットの自動タグ付けの設定](../../tags-and-categories/auto-tagging/configuring-asset-auto-tagging.md) を参照してください。 
```

```{important}
自動アンチウイルススキャンを有効にして、アップロード時にファイルをスキャンできます。 詳細については、 [アップロードされたファイルのウイルス対策スキャンを有効にする](../../../system-administration/file-storage/enabling-antivirus-scanning-for-uploaded-files.md) を参照してください。
```

ファイルをアップロードするには、最初にサイトまたはアセットライブラリのドキュメントとメディアアプリケーションに移動します。

サイト内のドキュメントとメディアにアクセスするには、 **サイトメニュー**（![Site Menu](../../../images/icon-product-menu.png)）を開き、 ［**Content & Data**］ &rarr; ［**ドキュメントとメディア**］ に移動します。

![サイトメニューの［Content & Data］の下にある［ドキュメントとメディア］をクリックします。](./uploading-files/images/01.png)

アセットライブラリのドキュメントとメディアにアクセスするには、有効になっているライブラリに移動し、 ［**ドキュメントとメディア**］ をクリックします。

![アセットライブラリの［ドキュメントとメディア］をクリックします。](./uploading-files/images/02.png)

アプリケーションを開いたら、ファイルをアップロードする最も簡単な方法は、ファイルを目的のフォルダにドラッグアンドドロップすることです。 これにより、ファイルが公開される前にアップロードを構成するように求められることなく、ファイルのアップロードがすぐに開始されます。 ファイルのアップロードが完了したら、 **アクション** ボタンをクリックして ［**編集**］ を選択することで、ファイルの詳細を編集できます。

![任意の数のファイルを目的のフォルダにドラッグアンドドロップします。](./uploading-files/images/03.png)

ただし、アップロードする前にファイルの詳細を定義する場合は、次の手順に従ってください。

1. **追加** ボタン（![Add Button](../../../images/icon-add.png)）をクリックし、 ［**ファイルアップロード**］ または ［**複数ファイルのアップロード**］ を選択します。

   ![［ファイルアップロード］または［複数ファイルのアップロード］を選択します。](./uploading-files/images/04.png)

1. 指定されたドロップゾーンにファイルをドラッグアンドドロップするか、ファイルセレクターを使用してファイルを参照します。

   ［**ファイルアップロード**］ を選択した場合、アップロード画面は次のように表示されます。

   ![アップロードするファイルを1つ選択します。](./uploading-files/images/05.png)

   ［**複数ファイルのアップロード**］ を選択した場合、アップロード画面は次のように表示されます。

   ![アップロードする複数のファイルをドラッグアンドドロップまたは選択します。](./uploading-files/images/06.png)

1. アップロードする前にファイルの詳細を構成します。 詳細については、 [Configuring File Upload Reference](#configuring-file-upload-reference) を参照してください。

1. 完了したら、 ［**公開**］ をクリックして、アップロード処理を開始します。

<a name="configuring-file-upload-reference" />

## ファイルアップロード構成のリファレンス

| フィールド           | 単一ファイルのアップロードの場合 | 複数ファイルのアップロードの場合 | 説明                                                                                                                                                                                                                                      |
| --------------- | ---------------- | ---------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| File/Files      | &#10004;         | &#10004;         | アップロードするファイルを選択します。 デフォルトでは、個々のファイルのアップロードは100MBを超えることはできません。                                                                                                                                                                           |
| Title           | &#10004;         |                  | アップロード後のファイルに使用する表示タイトルを設定します。 デフォルトでは、このフィールドには選択したファイルの元の名前が入力されていますが、アップロード中またはアップロード後に変更できます。                                                                                                                                       |
| ファイル名           | &#10004;         |                  | アップロードしたファイルに新しい名前を設定します。 デフォルトでは、このフィールドには選択したファイルの元の名前が入力されていますが、アップロード中またはアップロード後に変更できます。                                                                                                                                            |
| 説明              | &#10004;         | &#10004;         | アップロードしたファイルのファイル説明を追加します。                                                                                                                                                                                                              |
| 表示ページ           | &#10004;         | &#10004;         | アップロードされたファイルに対して[ディスプレイページテンプレート](../../../site-building/displaying-content/using-display-page-templates/about-display-page-templates-and-display-pages.md)を選択します。                                                                     |
| カテゴリの設定         | &#10004;         | &#10004;         | アップロードされたファイルにタグとパブリックカテゴリーまたは内部カテゴリーを適用します。                                                                                                                                                                                            |
| Expiration Date | &#10004;         | &#10004;         | ファイルの有効期限が切れるか、またはレビューする必要があるかを判断します。 デフォルトでは、ファイルは期限を設定しないか、レビューが必要になるように設定されています。 有効にすると、ファイルの有効期限が切れる、またはレビューする必要がある日付になります。 詳細については、 [ファイルの有効期限とレビュー日時の使用](./using-file-expiration-and-review-dates.md) を参照してください。 |
| Related Assets  | &#10004;         |                  | サイトまたは接続されたアセットライブラリから関連アセットまたはファイルを選択します。                                                                                                                                                                                              |
| 権限設定            | &#10004;         | &#10004;         | アップロードされたファイルの権限を設定します。 これらの設定により、ファイルを表示し、ファイルに関連する他のアクション（更新、削除など）を実行できるユーザーロールが決まります。                                                                                                                                                |

<a name="additional-information" />

## 追加情報

* [フォルダの作成](./creating-folders.md)
* [Media Galleryの使用](../publishing-and-sharing/publishing-documents.md#using-the-media-gallery-widget)
* [Enabling Xuggler and ImageMagick for Previews](../../../system-administration/using-the-server-administration-panel/configuring-external-services.md#enabling-document-previews)
