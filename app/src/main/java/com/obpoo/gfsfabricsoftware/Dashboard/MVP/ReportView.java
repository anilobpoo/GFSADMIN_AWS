package com.obpoo.gfsfabricsoftware.Dashboard.MVP;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;

/**
 * Created by PHD on 1/15/2019.
 */

public interface ReportView {
    void onGetReportResponse(DashResponse response);
    void onGetExchangerate(RateResponse response);
    void onGetStockAlert(Response response);
    void onGetDSCurve(CurveResponse response);
    void onGetSearchStock(Response response);
    void onGetPreviledgesStock(PreviledgesResponse response);

}
