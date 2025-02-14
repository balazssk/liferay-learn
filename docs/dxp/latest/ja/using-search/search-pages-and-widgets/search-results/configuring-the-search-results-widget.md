# 検索結果ウィジェットの構成

オプションメニュー（![Options](../../../images/icon-app-options.png)）を開き、［**構成**］を選択して、検索結果ウィジェットを構成します。

![検索結果の表示は、ウィジェットの構成画面で構成されます。](./configuring-the-search-results-widget/images/02.png)

設定は概念的に、表示、ページネーション、および統合検索設定に分類できます。 さらに、開発およびテスト中に、 ［**ドキュメントのフォームに結果を表示**］ をチェックすることにより、各結果の検索エンジンドキュメントを検査できます。

<a name="displaying-search-results" />

## 検索結果の表示

**表示テンプレート：** 返された検索結果のスタイルを設定する [ウィジェットテンプレート](./../../../site-building/displaying-content/additional-content-display-options/styling-widgets-with-widget-templates.md) を選択します。 デフォルトの表示スタイルはページ分割されたリストです。 各リストアイテムは、検索クエリに対するヒットの要約です。 ［**テンプレートの管理** リンクをクリックして、検索結果ウィジェットの新しいウィジェットテンプレートを追加します。

![カードレイアウトは、デフォルトの検索エクスペリエンスの代替手段です。 ](./configuring-the-search-results-widget/images/01.png)

----

**強調表示を有効にする：** 検索結果のタイトルまたは要約に表示される検索語を強調表示します。

![強調表示を有効にすると、キーワードとの一致が結果の要約で強調表示されます。](./configuring-the-search-results-widget/images/03.png)

----

**選択した結果をコンテキストで表示する：** 同じサイトのページでアセットが検出された場合、クリックされたアセットをネイティブの表示ウィジェットに表示します。 たとえば、検索結果でブログ投稿をクリックすると、ブログアプリケーションにブログエントリが表示されます。 検索結果をクリックした後、検索コンテキストから離れました。

このオプションがオフの場合、またはアセットがサイトのページに表示されない場合、アセットは検索ページのコンテキスト内にある間、代わりにAsset Publisherウィンドウに表示されます。 適切な権限があれば、検索コンテキストから直接コンテンツを編集することもできます。 戻る矢印をクリックして、検索結果に戻ります。

![コンテキストで表示オプションがオフになっている場合、またはコンテンツがサイトのページに表示されていない場合、Asset Publisherウィジェットはコンテンツを検索ページ自体に表示します。](./configuring-the-search-results-widget/images/04.png)

<a name="configuring-results-pagination" />

## 結果のページ分割の構成

検索結果の下部に結果の改ページが表示されます。

![ページごとの結果の数、およびページネーションの動作を制御するために使用されるURLパラメーター名は構成可能です。](./configuring-the-search-results-widget/images/06.png)

**ページネーション開始パラメーター名：** 結果ページのURLパラメーターの名前を設定します。 デフォルト値 **start** が保持されている場合（および検索が **test** 場合）、ユーザーが2番目の結果ページに移動すると、パラメーターが表示されます。

```
http://localhost:8080/web/guest/search?q=test&start=2
```

**ページネーションデルタ：** 結果ページごとに表示する結果の数を設定します。 デフォルトは **20** です。ただし、 `search.container.page.default.delta` [プロパティ](https://learn.liferay.com/reference/latest/en/dxp/propertiesdoc/portal.properties.html#Search%20Container) を `portal-ext.properties` ファイルでカスタマイズした場合はこの限りではありません。

**ページ区切りデルタパラメータ名：** ページ区切りデルタ値を格納するURLパラメータの名前を設定します（デフォルトでは`デルタ`）。 このパラメーターは、ユーザーが番号を変更した場合にブラウザーに表示されます。 ユーザーがページごとに10件の結果を選択し、 **test** を検索すると、検索ページは次のURLでリロードされます。

```
http://localhost:8080/web/guest/search?q=test&delta=10
```

<a name="displaying-results-from-alternate-indexes" />

## 代替インデックスからの結果の表示

**統合検索キー：** このウィジェットがデフォルト以外のインデックスの検索に参加している場合は、代替検索インデックスのキーを入力します。 設定されていない場合、ウィジェットはデフォルトのインデックス（`liferay-［companyId］`）に対してデフォルトの検索に参加します。 この値は通常、アプリケーション定義のインデックスの名前です。 [低レベルの検索オプションを理解する](understanding-low-level-search-options.md) の例を参照してください。

**表示するフィールド：** 統合検索キーの設定を使用して、 [代替インデックス](./understanding-low-level-search-options.md) を検索する場合は、そのインデックスから検索するフィールドを指定します。 検索結果ウィジェットに表示されるには、フィールドがインデックスされ、 [に](https://www.elastic.co/guide/en/elasticsearch/reference/7.x/mapping-store.html) が格納されている必要があります。

<a name="inspecting-search-engine-documents" />

## 検索エンジンドキュメントの検査

本番環境ではこのオプションを使用しないでください。

**ドキュメント形式で結果を表示：** 検索結果を<a>ドキュメント</a>として表示 。 サイトの開発中にこの機能を使用して、インデックス付きのドキュメントベースの形式で検索応答を表示します。 検索インデクサーの作成の一部は、検索エンジンドキュメント（インデックスが作成されるオブジェクト）を実際のJavaオブジェクトに変換し、再度戻すことです。 この設定を使用するには、設定を有効にしてから、［検索結果の概要］の下にある［**詳細...** リンクをクリックします。検査のために結果のドキュメントビューが展開されます。

![結果ドキュメントを表示すると、特定のアセットに対して何がインデックス付けされているかを正確に検査できます。 これは1つのドキュメントのほんの一部です。](./configuring-the-search-results-widget/images/05.png)

さらに詳しい情報は、 [より良い検索語の提案を返す方法](./enabling-search-suggestions.md) （例えば、「Did you mean...」など）をご覧ください。 最初は十分な結果が返されない場合。
