package com.obpoo.gfsfabricsoftware.Article.MVP.stock;


import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;


/**
 * Created by PHD on 11/14/2018.
 */

public interface StockInteractor {

    interface StockListResponse{
        void onGetStockListResponse(stockPOJO response);
        void onGetStockListError(String message);
    }

    void stocklogin(String method, StockListResponse response);

    interface FabricTypeResponse{
        void onGetFabricTypeResponse(fabricTypePOJO response);
        void onGetFabricTypeError(String message);
    }
    void fabricTypeRetCall(String method, FabricTypeResponse response);

    void deleteArticle(String method, String id, deleteArticleResponse response);

    interface  deleteArticleResponse{
    void onGetdeleteArticleResponse(deletearticelPOJO response);
    void onGetDeleteArticleError(String message);}
}
