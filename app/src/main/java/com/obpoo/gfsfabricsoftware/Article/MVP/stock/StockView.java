package com.obpoo.gfsfabricsoftware.Article.MVP.stock;


import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 11/14/2018.
 */

public interface StockView extends BaseView {
    void onGetResponse(String name, int drawable);
    void onShowStock(stockPOJO response);
    void onshowFabricType(fabricTypePOJO response);
    void onshowDeleteArticel(deletearticelPOJO response);

}
