package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt;

/**
 * Created by PHD on 11/19/2018.
 */

public class deleteCmnartRequest {
    String method,id;

    public deleteCmnartRequest(String method, String id) {
        this.method = method;
        this.id = id;
    }
}
