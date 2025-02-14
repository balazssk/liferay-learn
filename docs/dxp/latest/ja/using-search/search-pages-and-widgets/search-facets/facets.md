# ファセット

検索バーにキーワードを入力し、［検索］ボタンをクリックします。 デフォルトの検索エクスペリエンスでは、右側に結果が、左側に **ファセット** のコレクションが表示されるページにリダイレクトされます。

![検索結果のサンプルページ。](facets/images/01.png)

ファセットは、共通の特性によって検索結果を集約します。 これにより、検索結果を簡単にフィルタリングできます。 デフォルトでは、Liferayには次のファセットが含まれています。

**サイトファセット：** サイトで結果をフィルタリングします。

**タイプファセット：** アセットタイプで結果をフィルタリングします。

**タグファセット：** タグで結果をフィルタリングします。

**カテゴリファセット：** カテゴリで結果をフィルタリングします。

**フォルダファセット：** フォルダで結果をフィルタリングします。

**ユーザーファセット：** コンテンツ制作者別に結果をフィルタリングします。

**編集済みファセット：** 最後に変更された日付で結果をフィルタリングします。

**カスタムファセット：** 他のインデックス付きフィールドで結果をフィルタリングします。

ファセット内の各アイテム（チェックボックスを使用して選択）は、 **ファセット用語**（略して **用語**）と呼ばれます。

<a name="using-facets" />

## ファセットの使用

ファセットを使用するには、用語にチェックを入れて検索結果をフィルタリングします。 たとえば、Apolloに関連するドキュメントを検索している場合は、タイプファセットで用語にチェックを入れることができます。

![タイプでフィルタリングされたApollo検索結果。](facets/images/02.png)

特にApollo 11に関連するドキュメントを探している場合は、フォルダファセットで用語にチェックを入れることもできます。

![フォルダでフィルタリングされたApollo検索結果。](facets/images/03.png)

このようにして、検索結果を絞り込むことができます。

<a name="multiple-facet-selection" />

## 複数ファセット選択

上記の例で見られるように、異なるファセットの用語を選択すると、減算されます。 つまり、すべてのフィルター基準に一致する結果のみが返されます。

ただし、個々のファセット内で用語を選択すると、付加されます。 つまり、各用語の組み合わせた結果が返されます。 たとえば、Apollo 11フォルダとApollo 14フォルダの両方の検索結果をフィルタリングする場合は、両方の用語にチェックを入れます。

![両方のフォルダのApollo検索結果。](facets/images/04.png)

<a name="facets-and-friendly-urls" />

## ファセットとフレンドリURL

検索機能は、ファセットフィルタリングにわかりやすい検索URLを使用します。 デフォルト設定では、キーワード **test** を検索する場合のデフォルトのメイン検索URLは次のとおりです。

    http://localhost:8080/web/guest/search?q=test

ファセット用語を選択すると、上記のURLに新しいパラメーターが追加されます。 たとえば、タイプファセットからブログのエントリを選択すると、URLは次のようになります。

    http://localhost:8080/web/guest/search?q=test&type=com.liferay.blogs.model.BlogsEntry

同じファセットカテゴリから別のファセット用語を選択すると、同じパラメーターが再度追加されますが、新しく選択された値が追加されます。

    http://localhost:8080/web/guest/search?q=test&type=com.liferay.blogs.model.BlogsEntry&type=com.liferay.portal.kernel.model.User

残りのファセットは同じように機能します。 最終更新ファセットの過去1時間オプションでフィルタリングすると、次のURLが生成されます。 

    http://localhost:8080/web/guest/search?q=test&modified=past-hour

パラメーター名は、ファセットごとに設定できます。

各ファセットタイプの詳細は、個々の記事を参照してください。
