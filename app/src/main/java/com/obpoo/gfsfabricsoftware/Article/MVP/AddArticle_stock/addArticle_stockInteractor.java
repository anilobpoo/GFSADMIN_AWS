package com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock;

import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleResponse;

/**
 * Created by obpoo on 11/16/2018.
 */

public interface addArticle_stockInteractor {
    interface addArticleListener{
        void onSuccess(AddArticleResponse response);
        void onFailure(String message);
    }

    void AddArticleFN(String method, String aNo, String note, String FT, String occasion, String compassion,
                      String fullYards, String _9yards, String _10Yards, String fullMtrs, String _9Mtrs, String _10Mtrs, addArticle_stockInteractor.addArticleListener response);
}
