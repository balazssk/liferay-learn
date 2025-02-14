# CSVデータソースを追加する

CSVファイルから連絡先のプロフィールデータをインポートして、ユーザーの業界、職種、年収など、ビジネスにとって重要なメトリクスに関連した追加データで顧客プロフィールを充実させることができます。 データベースに顧客プロフィールデータがある場合や、Webフォームで収集した場合は、CSVファイルにエクスポートすることができます。

```{important}
   CSVファイルにはメール欄が必要です。
```

CSVファイルから連絡先データを統合する方法をご紹介します。

1. **データソース** ページで、 ［**データソースの追加**］ をクリックします。 データソースの種類を示すページが表示されます。

1. **CSVファイル** アイコンを選択します。 **CSVファイル** のアップロードページが表示されます。

1. **CSVファイル** をアップロードするには、アップロードエリアにドラッグするか、ファイルシステムからブラウズして選択してください。

1. データソースの名前を入力し、 ［**Next**］ をクリックします。

    ![データソースに名前をつけます。](adding-a-csv-data-source/images/01.png)

1. [連絡先データのマッピング](#mapping-contact-data) の手順に従って、CSV ファイルから Analytics Cloud の連絡先データモデルに連絡先データをマッピングします。 データをマッピングしたら、［次へ］ をクリックします。

連絡先プロフィールデータの同期を開始します。 同期にかかる時間は、連絡先の数によって異なります。

<a name="mapping-contact-data" />

## コンタクトデータのマッピング

Analytics Cloudでは、連絡先のプロフィールフィールドを統一された顧客データモデルにマッピングすることができます。 デフォルトのモデルでスタートします。 同期する連絡先を選択すると、Analytics Cloudは、データソースから連絡先のデータフィールドを統合された連絡先データモデルにマッピングするように最善を尽くします。

Analytics Cloudでは、いくつかのコンタクト データ マッピング オプションが用意されています。

* 最も適切なデータモデルフィールドを選択する-Analytics Cloudは、一致する可能性のあるデータモデルを提案します。
* 新しいカスタムデータモデルフィールドを追加し、それにソースデータをマッピングします。
* 複数のデータソースから同じデータモデルフィールドにソースフィールドをマッピングします。

```{note}
   複数のデータソースのソースフィールドを同じモデルフィールドにマッピングした場合、最新の修正値が使用されます。
```

ソース・フィールドをデータ・モデルにマッピングすると、データ・モデルのフィールドを検索して選択したり、提案されたフィールドを使用したり、新しいカスタム・フィールドを作成したりすることができます。

![Analytics Cloudでは、適切なデータモデルフィールドの検索や提案が容易になります。](adding-a-csv-data-source/images/02.png)

ここでは、カスタムコンタクトデータのモデルフィールドを作成する方法をご紹介します。

1. データモデルフィールドのセレクタをクリックします。

1. ［**New Field**］ をクリックします。 新しいフィールドを作成するためのダイアログが表示されます。

1. ダイアログで、新しいフィールドに名前を付け、そのタイプを選択します。

1. ［作成］をクリックします。

カスタムモデルフィールドをソースフィールドにマッチさせる準備ができています。

![新しいモデルフィールドを作成します。](adding-a-csv-data-source/images/03.png)

データのマッピングが終わったら、Doneボタンをクリックします。

