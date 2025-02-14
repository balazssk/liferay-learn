# アカウント

[Salesforceデータソース](../connecting-data-sources/adding-a-salesforce-data-source.md)をお持ちの場合、Analytics CloudはSalesforceのアカウントデータをインポートして分析することができます。 Analytics Cloud は、Salesforce のアカウントデータと他のソースからのデータを組み合わせることで、アカウントとその中にいる人の全体像を提示します。

アカウント分析を表示するには、左のナビゲーションパネルから［アカウント］を選択します。 アカウントは、各アカウントの以下のデータを一覧にした検索可能な表で表示されます。

* アカウントの種類
* ユーザー
* 活動内容

![アカウント］ タブには、Analytics Cloud にインポートされた Salesforce アカウントが一覧表示されます。](accounts/images/01.png)

アカウントをクリックすると、これらのタブに整理された情報が表示されます。

* 概要
* アクテビティ
* 興味のあるトピック
* セグメント
* ユーザー
* 詳細

次のセクションでは、各タブについて説明します。

<a name="overview" />

## 概要

［概要］ タブには、アカウントのデータのサマリーが表示されます。 これらのペインを介して、これらのサマリーを表示します。

* アカウント活動
* アカウントファームオグラフィックス
* 連絡先情報
* アカウントの興味のあるトピック
* 個人の知名度
* 関連セグメント

各タブでより多くの情報が利用可能な場合は、そのリンクからアクセスできます。 たとえば、［アカウント アクティビティ］ ペインの下部には、［すべてのアクティビティを表示］ リンクがあります。 このリンクをクリックすると、アクティビティタブに移動し、アクティビティの詳細情報が表示されます。

![概要］ タブには、アカウントのデータのサマリーが表示されます。](accounts/images/02.png)

<a name="activities" />

## アクテビティ

［アクティビティ］タブには、アカウント内の個人のアクティビティが表示されます。 ヒストグラムでは、日付ごとのアクティビティ数を表示しています。 ヒストグラムの下にある検索可能な表には、活動の詳細が表示されています。

![アクティビティ］ タブには、アカウントの個人のアクティビティに関するデータが表示されます。](accounts/images/03.png)

<a name="interests" />

## 関心事

［Interest］タブには、そのアカウントの個人が興味を持っているトピックが表示されます。 Analytics Cloudでは、個人向けに使用するのと同じ方法でこれらのトピックを識別しています。 詳しくは、 [興味のあるトピックを理解する](../../workspace-data/managing-interest-topics.md#understanding-interests) をご覧ください。

<a name="segments" />

## セグメント

［セグメント］ タブには、アカウントの個人のセグメントが表示されます。 これらのセグメントは、一般的なセグメントと同じように機能します。 唯一の違いは、ここでのセグメントは、アカウント内の個人に適用されます。 セグメントの詳細は、セグメントの作成とプロファイリングに関するドキュメントを参照してください。

<a name="individuals" />

## 個人の方

［個人］ タブには、アカウント内の個人に関する情報が表示されます。 Analytics Cloudの個人の詳細は、［個人のプロファイリング］を参照してください。

<a name="details" />

## 詳細

［詳細］ タブには、アカウントのプロパティに関する情報が表示されます。 プロパティは、Analytics Cloudの各アカウント プロパティとその値が検索可能な表に表示されます。 テーブルには、これらの値の列もあります。

***ソース名：** Salesforce データ・ソースの対応するプロパティ名。 例えば、Analytics Cloudの `accountId` プロパティは、Salesforceの `id` です。 そのため、 `accountId` 行のソース名欄には、 `id` が表示されます。
***データ・ソース：** プロパティの値が発生したデータ・ソース。
***最終更新日：** プロパティの値が最も最近変更された日付。

![詳細］ タブには、アカウントのプロパティとその値を示す検索可能なテーブルが含まれています。](accounts/images/04.png)
