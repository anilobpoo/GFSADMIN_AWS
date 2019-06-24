package com.obpoo.gfsfabricsoftware.Dashboard.MVP;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;

import java.util.ArrayList;

/**
 * Created by PHD on 1/15/2019.
 */

public class ReportPresenterImpl implements ReportPresenter,ReprotInteractor.ReportResponse,ReprotInteractor.RateResponse,
        ReprotInteractor.stockAlertResponse,ReprotInteractor.curveResponse,ReprotInteractor.stockSearch_Response,ReprotInteractor.Previledges_Response
{
    ReportInteractorImpl interactor;
    ReportView reportView;

    public ReportPresenterImpl(ReportView reportView) {
        this.reportView = reportView;
        interactor = new ReportInteractorImpl();
    }

    @Override
    public void onViewReport(String method) {
        interactor.callRetroReport(method,this);

    }

    @Override
    public void onViewRates(String base) {
        interactor.callRetroRate(base,this);

    }

    @Override
    public void onViewStockAlert(String method, String page_no) {
        System.out.println("Enter 1");
        interactor.callRetroStockAlert(method,page_no,this);

    }

    @Override
    public void onViewCurve(String method, String fab_id, String year) {
        interactor.callRetroCurve(method,fab_id,year,this);

    }

    @Override
    public void onViewStockSearch(String method, String fab_name) {
        interactor.callRetroStockSearch(method,fab_name,this);

    }

    @Override
    public void onPreviledgesSearch(String method, ArrayList<String> previleges) {
        interactor.PreviledgesSearch(method,previleges,this);

    }

    @Override
    public void onReportSuccess(DashResponse response) {
        reportView.onGetReportResponse(response);

    }

    @Override
    public void onReportError(String message) {

    }


    @Override
    public void onRateSuccess(RateResponse response) {
        reportView.onGetExchangerate(response);

    }

    @Override
    public void onRateError(String message) {

    }

    @Override
    public void onStockAlertSuccess(Response response) {
        System.out.println("Enter 3");
        reportView.onGetStockAlert(response);


    }

    @Override
    public void onStockAlertError(String message) {
        Log.i("Stcock1Message",message);

    }

    @Override
    public void onCurveResponseSuccess(CurveResponse response) {
        reportView.onGetDSCurve(response);

    }

    @Override
    public void onCurveResponseError(String message) {

    }

    @Override
    public void onStockSearchSuccess(Response response) {
        reportView.onGetSearchStock(response);

    }

    @Override
    public void onStockSearchError(String message) {

    }

    @Override
    public void onPreviledgesSuccess(PreviledgesResponse response) {
        reportView.onGetPreviledgesStock(response);

    }

    @Override
    public void onPreviledgesError(String message) {

    }
}
