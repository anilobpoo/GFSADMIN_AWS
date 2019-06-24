package com.obpoo.gfsfabricsoftware.Stock.MVP;

import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.RequestObjectCustomerAddReserve;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;

/**
 * Created by PHD on 1/29/2019.
 */

public class StockPresenterImpl implements StockPresenter, StockInteractor.ViewStockResponse, StockInteractor.ViewActivityLog, StockInteractor.ViewFabricSearch, StockInteractor.CustomerReseeveI, StockInteractor.AddReserveI, StockInteractor.CustomerAddReserveI, StockInteractor.ViewNewStockResponse {
    StockInteractorImpl interactor;

    ViewStock viewStock;

    public StockPresenterImpl(ViewStock viewStock) {
        this.viewStock = viewStock;
        interactor = new StockInteractorImpl();
    }

    @Override
    public void onViewStock(String method, String filterId, String IdType) {
        interactor.callRetroViewStock(method, filterId, IdType, this);

    }

    @Override
    public void onViewNewStock(String method, String filterId, String page_no) {
        interactor.callRetroViewNewStock(method, filterId, page_no, this);
    }

    @Override
    public void onViewActivityLog(String method) {
        interactor.callRetroAL(method, this);

    }

    @Override
    public void onViewFabricSearch(String method, String fab_name) {
        interactor.callRetroFS(method, fab_name, this);

    }

    @Override
    public void onStockSuccess(ViewStockResponse response) {
        viewStock.onShowStock(response);

    }


    @Override
    public void onStockError(String message) {

    }

    @Override
    public void onALSuccess(ActivityLogResponse response) {
        viewStock.onShowActivityLog(response);

    }

    @Override
    public void onALerror(String message) {

    }

    @Override
    public void onFSsuccess(FabSearchRes response) {
        viewStock.onShowFabSearch(response);

    }

    @Override
    public void onFSfailure(String message) {

    }

    @Override
    public void onCRsuccess(CustomerResResp response) {
        viewStock.onShowCustomerReserve(response);

    }

    @Override
    public void onCRerror(String message) {

    }

    @Override
    public void onViewCustomerReserve(String method) {
        interactor.callRetroCR(method, this);
    }

    @Override
    public void onViewAddReserve(String method, String search) {
        interactor.callRetroAddReserve(method, search, this);

    }

    @Override
    public void onViewCustomerAddReserve(String method, RequestObjectCustomerAddReserve alldata) {

        interactor.callRetroCustomerAddReserve(method, alldata, this);

    }

    @Override
    public void onAddResSuccess(AddReserveRes response) {
        viewStock.onShowSearchFabrics(response);

    }

    @Override
    public void onAdResError(String message) {

    }

    @Override
    public void onCustomerAddReserveSuccess(AddCustomerReserveFinal response) {
        viewStock.onAddCustomerReserve(response);

    }

    @Override
    public void onCustomerAddReserveError(String message) {

    }

    @Override
    public void onStockNewSuccess(ViewStockNewResponse response) {
        viewStock.onShowNewStock(response);
    }

    @Override
    public void onStockNewError(String message) {

    }
}
