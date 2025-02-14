# ページフラグメントの管理

あなたのサイトが成長するにつれて、ページフラグメントの多くのコレクションができます。 あなたはいくつかの方法でそれらを扱うことができます：

  - 直接編集できます。
  - それらをエクスポートおよびインポートできます。
  - コレクション間でフラグメントを移動およびコピーできます。

## ページフラグメントのコレクションの管理

コレクション管理メニューにアクセスするには、次の手順に従います。

1.  製品メニューを開き、サイトメニューの下の *サイトビルダー* → *ページフラグメント* に移動します。

2.  *コレクション* リストから、管理するコレクションを選択します。

3.  コレクション名の横にある（![Actions](../../../images/icon-actions.png)）メニューを開きます。

4.  コレクションのアクションを選択します。

    **編集**：コレクションの名前または説明を変更します。

    **エクスポート**：コレクションデータをエクスポートせずに、コレクション内のすべてのページフラグメントを含む `.zip` ファイルをダウンロードします。 コレクションをコレクションデータとともにエクスポートするには、 *コレクション* 見出しの横にあるアクションメニューから *エクスポート* オプションを選択し、エクスポートする1つ以上のコレクションを選択します。 各コレクションは、個別の `.zip` ファイルにエクスポートされます。

    **インポート**：追加のページフラグメントと共にアップロードする `.zip` ファイルを選択します。 既存のコレクションを置き換える場合は、[ *Overwrite Existing Files*チェックボックスがオンになっていることを確認してください。 Liferay DXPで作成されたコレクション、外部ツールを使用して作成されたコレクション、またはコレクションのないページフラグメントをインポートできます。

    ```{note}
    ページフラグメントをエクスポートおよびインポートすることは、コードを共有したり、サイトに組み込んだりするための好ましい方法です。
    ```

    **削除**：現在のコレクションとそのすべてのコンテンツを削除します。

![コレクション内のすべてのページフラグメントをエクスポートできます。](./managing-page-fragments/images/01.png)

## 個々のページフラグメントの管理

ページフラグメント管理メニューにアクセスするには、次の手順に従います。

1.  製品メニューを開き、サイトメニューの下の *サイトビルダー* → *ページフラグメント* に移動します。

2.  *コレクション* リストから、管理するページフラグメントを含むコレクションを選択します。

3.  ページフラグメントの横にある（![Actions](../../../images/icon-actions.png)）メニューを開きます。

4.  アクションを選択：

    **編集**：ページフラグメントのコードと構成を変更します。

    **名前の変更**：ページフラグメントの名前を変更します。

    **移動**：ページフラグメントを別のコレクションに移動します。

    **コピーを作成**：ページフラグメントを複製します。 重複するページフラグメントは、末尾に *（コピー）* 追加された同じ名前を共有します。

    **サムネイルの変更**：ページフラグメントのサムネイル画像を変更します。

    **エクスポート**：ページフラグメントの `.zip` ファイルをダウンロードします。

    **削除**：ページフラグメントをコレクションから削除します。

### デフォルトのフラグメントをコピーする

> 可用性：Liferay DXP 7.2 SP1 +およびLiferay Portal 7.2 GA2 +。

デフォルトのページフラグメントは直接編集できません。 ただし、デフォルトのページフラグメントをコピーして、カスタムコレクションに移動し、そこで編集することができます。

1.  デフォルトのページフラグメントコレクションに移動します。
2.  ページフラグメントの *Actions* （![Actions](../../../images/icon-actions.png)）メニューを開き、 *Copy To*を選択します。
3.  デフォルトのページフラグメントをコピーするコレクションを選択します。
