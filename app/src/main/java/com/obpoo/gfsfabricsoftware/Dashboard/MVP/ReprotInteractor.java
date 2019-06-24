package com.obpoo.gfsfabricsoftware.Dashboard.MVP;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;

import java.util.ArrayList;

/**
 * Created by PHD on 1/15/2019.
 */

public interface ReprotInteractor {
    interface ReportResponse{
        void onReportSuccess(DashResponse response);
        void onReportError(String message);
    }
    void callRetroReport(String method,ReportResponse response);
    interface  RateResponse{
        void onRateSuccess(com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse response);
        void onRateError(String message);
    }
    void callRetroRate(String base,RateResponse response);

    interface stockAlertResponse{
        void onStockAlertSuccess(Response response);
        void onStockAlertError(String message);
    }
    void callRetroStockAlert(String method,String page_no,stockAlertResponse response);

    interface  curveResponse{
        void onCurveResponseSuccess(CurveResponse response);
        void onCurveResponseError(String message);
    }
    void callRetroCurve(String method,String fab_id,String year,curveResponse response);

    interface  stockSearch_Response{
        void onStockSearchSuccess(Response response);
        void onStockSearchError(String message);
    }
    void callRetroStockSearch(String method, String fab_name,stockSearch_Response response);


    interface Previledges_Response {
        void onPreviledgesSuccess(PreviledgesResponse response);

        void onPreviledgesError(String message);
    }

    void PreviledgesSearch(String method, ArrayList<String> previleges, Previledges_Response response);

}
