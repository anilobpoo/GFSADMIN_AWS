package com.obpoo.gfsfabricsoftware.Article.MVP.stock;

/**
 * Created by PHD on 11/14/2018.
 */

public interface StockPresenter {
    void showMenu(String name, int drawable);
    void showResponse(String response);
    void showFabricType(String method);
    void DeleteArticle(String method, String id);


}
