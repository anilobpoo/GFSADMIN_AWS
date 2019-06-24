package com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle;

import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse;

/**
 * Created by PHD on 11/16/2018.
 */

public interface updateArticleInteractor {

    interface updateArticleListener{
        void onSuccess(updateArticleResponse response);
        void onFailure(String message);
    }

    void updateArticleFN(String method, String articleId, String articleNo, String note, String ft,  String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs,
                         String price1to9mtrs, String price10plusmtrs, String composition, String occassion,
                         updateArticleInteractor.updateArticleListener response);
}


