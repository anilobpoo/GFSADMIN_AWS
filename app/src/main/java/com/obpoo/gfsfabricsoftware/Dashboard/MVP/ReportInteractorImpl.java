package com.obpoo.gfsfabricsoftware.Dashboard.MVP;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.StockAlertRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.StockSearchRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesRequest;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.ReportRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 1/15/2019.
 */

public class ReportInteractorImpl implements ReprotInteractor{
    @Override
    public void callRetroReport(String method, final ReportResponse ReportResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ReportRequest request = new ReportRequest(method);
        Call<DashResponse> call = apis.reportApi(request);
        call.enqueue(new Callback<DashResponse>() {
            @Override
            public void onResponse(Call<DashResponse> call, Response<DashResponse> response) {
                if (response.isSuccessful()) {
                    ReportResponse.onReportSuccess(response.body());

                } else {
                    ReportResponse.onReportError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<DashResponse> call, Throwable t) {
                ReportResponse.onReportError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroRate(String base, final RateResponse RateResponse) {
        Retrofit retrofit = ApiClient.getRates();
        WebApi apis = retrofit.create(WebApi.class);

        Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse> call = apis.retroEXrate(base);
        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse>() {
            @Override
            public void onResponse(Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse> call, Response<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse> response) {
                if (response.isSuccessful()) {
                    RateResponse.onRateSuccess(response.body());

                } else {
                    RateResponse.onRateError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse> call, Throwable t) {
                RateResponse.onRateError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroStockAlert(String method, String page_no, final stockAlertResponse stockAlertResponse) {
        System.out.println("Enter 2");
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        StockAlertRequest request = new StockAlertRequest(method,page_no);
        Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> call = apis.reportApi(request);
        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response>() {
            @Override
            public void onResponse(Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> call, Response<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> response) {
                if (response.isSuccessful()) {
                    stockAlertResponse.onStockAlertSuccess(response.body());

                } else {
                    stockAlertResponse.onStockAlertError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> call, Throwable t) {
                stockAlertResponse.onStockAlertError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroCurve(String method, String fab_id, String year, final  curveResponse curveResponse) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        CurveRequest request = new CurveRequest(method,fab_id,year);
        Call<CurveResponse> call = apis.curveApi(request);
        call.enqueue(new Callback<CurveResponse>() {
            @Override
            public void onResponse(Call<CurveResponse> call,  Response<CurveResponse> response) {
                if (response.isSuccessful()) {
                        curveResponse.onCurveResponseSuccess(response.body());

                } else {
                    curveResponse.onCurveResponseError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CurveResponse> call, Throwable t) {
                curveResponse.onCurveResponseError(t.getMessage());

            }
        });


    }

    @Override
    public void callRetroStockSearch(String method, String fab_name, final stockSearch_Response stockSearch_Response) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        StockSearchRequest request = new StockSearchRequest(method,fab_name);
        Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> call = apis.stockSearchApi(request);
        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response>() {
            @Override
            public void onResponse(Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> call, Response<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> response) {
                if (response.isSuccessful()) {
                    stockSearch_Response.onStockSearchSuccess(response.body());

                } else {
                    stockSearch_Response.onStockSearchError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response> call, Throwable t) {
                stockSearch_Response.onStockSearchError(t.getMessage());

            }
        });

    }

    @Override
    public void PreviledgesSearch(String method, ArrayList<String> previleges, final Previledges_Response previledges_response) {
        Retrofit retrofit = ApiClient.getRetrofit();
        PreviledgesRequest request = new PreviledgesRequest(method,previleges);
        WebApi apis = retrofit.create(WebApi.class);
        Call<PreviledgesResponse> call = apis.retroPreviledges(request);
        call.enqueue(new Callback<PreviledgesResponse>() {
            @Override
            public void onResponse(Call<PreviledgesResponse> call, Response<PreviledgesResponse> response) {
                if (response.isSuccessful()) {
                    previledges_response.onPreviledgesSuccess(response.body());

                } else {
                    previledges_response.onPreviledgesError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<PreviledgesResponse> call, Throwable t) {
                previledges_response.onPreviledgesError(t.getMessage());
                Log.i("errorPreviledge",t.getMessage());

            }
        });
    }
}
