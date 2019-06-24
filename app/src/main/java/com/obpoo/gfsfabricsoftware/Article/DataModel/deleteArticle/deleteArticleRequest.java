package com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle;

/**
 * Created by obpoo on 11/19/2018.
 */

public class deleteArticleRequest {
    String method,id;

    public deleteArticleRequest(String method, String id) {
        this.method = method;
        this.id = id;
    }
}
