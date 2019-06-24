package com.obpoo.gfsfabricsoftware.Article.MVP.stock;


import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;


/**
 * Created by PHD on 11/14/2018.
 */

public class StockPresenterImpl implements StockPresenter, StockInteractor.StockListResponse,StockInteractor.FabricTypeResponse,StockInteractor.deleteArticleResponse {
    StockView stockView;
    StockInteractorImpl interactor;

    public StockPresenterImpl(StockView stockView) {

        this.stockView = stockView;
        interactor = new StockInteractorImpl();
    }

    @Override
    public void showMenu(String name, int drawable) {
        StockInteractorImpl sii = new StockInteractorImpl(name,drawable);
        stockView.onGetResponse(sii.getStock_name(),sii.getDrawable());
 }

    @Override
    public void showResponse(String method) {
        if(stockView!=null){
            stockView.showDialog();
            interactor.stocklogin(method,this);
        }


    }

    @Override
    public void showFabricType(String method) {
        interactor.fabricTypeRetCall(method,this);

    }

    @Override
    public void DeleteArticle(String method,String  id) {
        interactor.deleteArticle(method,id,this);

    }


    @Override
    public void onGetStockListResponse(stockPOJO response) {
        if(stockView!=null){
//            stockView.hideDialog();
            stockView.onShowStock(response);
        }


    }

    @Override
    public void onGetStockListError(String message) {


    }

    @Override
    public void onGetFabricTypeResponse(fabricTypePOJO response) {
        stockView.onshowFabricType(response);

    }

    @Override
    public void onGetFabricTypeError(String message) {

    }

    @Override
    public void onGetdeleteArticleResponse(deletearticelPOJO response) {
        stockView.onshowDeleteArticel(response);

    }

    @Override
    public void onGetDeleteArticleError(String message) {

    }
}
