package com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle;

/**
 * Created by PHD on 11/16/2018.
 */

public interface updateArticlePresenter {
    void sendRequest(String method, String articleId, String articleNo, String note, String ft, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs,
                     String price1to9mtrs, String price10plusmtrs, String composition, String occassion);
}
