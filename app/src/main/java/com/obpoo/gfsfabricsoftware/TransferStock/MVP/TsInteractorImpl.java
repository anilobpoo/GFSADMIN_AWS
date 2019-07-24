package com.obpoo.gfsfabricsoftware.TransferStock.MVP;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDReq;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PasswareWareReq;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentDataRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.TransferStockOutRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.TransferStockRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareRequest;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareReq;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 2/7/2019.
 */

public class TsInteractorImpl implements TsInteractor {
    @Override
    public void callRetroPOid(String method, final PendingOrderRes PendingOrderRes) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PendingOrderRequest request = new PendingOrderRequest(method);
        Call<com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes> call = apis.pOIapi(request);
        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes>() {
            @Override
            public void onResponse(Call<com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes> call, Response<com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes> response) {
                if (response.isSuccessful()) {
                    PendingOrderRes.onGetPendingOrderSuccess(response.body());
                    Log.i("response", "Success");
                } else {
                    PendingOrderRes.onGetPendingOrderError("Please Try Again.");
                    Log.i("response", "try again");
                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes> call, Throwable t) {
                PendingOrderRes.onGetPendingOrderError(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });

    }

    @Override
    public void callRetroFabPending(String method, String id, final FabPendingOid FabPendingOid) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        FabricPendingOIDReq request = new FabricPendingOIDReq(method, id);
        Call<FabricPendingOIDRes> call = apis.fabPOIapi(request);
        call.enqueue(new Callback<FabricPendingOIDRes>() {
            @Override
            public void onResponse(Call<FabricPendingOIDRes> call, Response<FabricPendingOIDRes> response) {
                if (response.isSuccessful()) {
                    FabPendingOid.onGetFabPendingOidSuccess(response.body());
                    Log.i("response", "Success");
                } else {
                    FabPendingOid.onGetFabPendingOidError("Please Try Again.");
                    Log.i("response", "try again");
                }
            }

            @Override
            public void onFailure(Call<FabricPendingOIDRes> call, Throwable t) {
                FabPendingOid.onGetFabPendingOidError(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });

    }

    @Override
    public void callRetroTransferItems(ArrayList<String> all_id, ArrayList<String> cqty, String method, String customer_id, String group_id, String discount, String Dellivery_address, String credit_time, String vat_enabled, String pay_mode, String delivery_type, String order_type, String order_total, String order_by, String vat_amount, String payble_amount, ArrayList<HashMap<String, String>> items, final TransferItems transferItems) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        TransferRequest request = new TransferRequest(all_id, cqty, method, customer_id, group_id, discount, Dellivery_address, credit_time, vat_enabled, pay_mode, delivery_type, order_type, order_total, order_by, vat_amount, payble_amount, items);
        Call<TransferResponse> call = apis.tranFabApi(request);
        call.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                if (response.isSuccessful()) {
                    transferItems.onGetTIsuccess(response.body());
                    Log.i("response", "Success");
                } else {
                    transferItems.onGetTIerror("Please Try Again.");
                    Log.i("response", "try again");
                }
            }

            @Override
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                transferItems.onGetTIerror(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });
    }

    @Override
    public void callRetroTransferWarehouse(ArrayList<String> all_id, String warehouse, String method, final TranferWarehouse tranferWarehouse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        TransferWareRequest request = new TransferWareRequest(all_id, warehouse, method);
        Call<TransferResponse> call = apis.tranFabWareApi(request);
        call.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                if (response.isSuccessful()) {
                    tranferWarehouse.onGetTWSuccess(response.body());

                } else {
                    tranferWarehouse.onGetTWerror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                tranferWarehouse.onGetTWerror(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });
    }

    @Override
    public void callRetroTranWareWare(String method, String id, final TransferWareWare transferWareWare) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        TransferWareWareReq request = new TransferWareWareReq(method, id);
        Call<TransferWareWareRes> call = apis.tranFabWareWare(request);
        call.enqueue(new Callback<TransferWareWareRes>() {
            @Override
            public void onResponse(Call<TransferWareWareRes> call, Response<TransferWareWareRes> response) {
                if (response.isSuccessful()) {
                    transferWareWare.onGetWWSuccess(response.body());

                } else {
                    transferWareWare.onGetWWError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<TransferWareWareRes> call, Throwable t) {
                transferWareWare.onGetWWError(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });


    }

    @Override
    public void callRetroPassWare(String warehouse_to, String id, String method, final PassWareWare passWareWare) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        PasswareWareReq request = new PasswareWareReq(warehouse_to, id, method);
        Call<TransferResponse> call = apis.passWareWare(request);
        call.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                if (response.isSuccessful()) {
                    passWareWare.onPassWareSuccess(response.body());

                } else {
                    passWareWare.onPassWareErroe("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                passWareWare.onPassWareErroe(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });

    }

    @Override
    public void callRetroTransferFabrics(String method, String from_date, String to_date, String page_no, String document, final TransferFabrics transferFabrics) {
        Retrofit retrofit = ApiClient.getRetrofit2();
        WebApi apis = retrofit.create(WebApi.class);
        TransferStockRequest request = new TransferStockRequest(method,from_date,to_date,page_no,document);
        Call<Ts_Response> call = apis.tranFabcAPI(request);
        call.enqueue(new Callback<Ts_Response>() {
            @Override
            public void onResponse(Call<Ts_Response> call, Response<Ts_Response> response) {
                if (response.isSuccessful()) {
                    transferFabrics.onTransferSuccess(response.body());

                } else {
                    transferFabrics.onTransferError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<Ts_Response> call, Throwable t) {
                transferFabrics.onTransferError(t.getMessage());
                // Log.i("response",t.getMessage());
            }
        });
    }


    @Override
    public void callRetroTransferStockOut(String method, ArrayList<String> ids, final TransferStockOut transferStockOut) {
        Retrofit retrofit = ApiClient.getRetrofit2();
        WebApi apis = retrofit.create(WebApi.class);
        TransferStockOutRequest request = new TransferStockOutRequest(method, ids);
        Call<TransferResponse> call = apis.tranStockOutFabcAPI(request);
        call.enqueue(new Callback<TransferResponse>() {
            @Override
            public void onResponse(Call<TransferResponse> call, Response<TransferResponse> response) {
                if (response.isSuccessful()) {
                    transferStockOut.onTransferStockoutSuccess(response.body());

                } else {
                    transferStockOut.onTransferStockOutError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<TransferResponse> call, Throwable t) {
                transferStockOut.onTransferStockOutError(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });
    }

    @Override
    public void callStockDoc(String method, final StockDocResp stockDocResp) {
        Retrofit retrofit = ApiClient.getRetrofit2();
        WebApi apis = retrofit.create(WebApi.class);
        StockDocRequest request = new StockDocRequest(method);
        Call<StockDocumentResponse> call = apis.stockDoc(request);
        call.enqueue(new Callback<StockDocumentResponse>() {
            @Override
            public void onResponse(Call<StockDocumentResponse> call, Response<StockDocumentResponse> response) {
                if (response.isSuccessful()) {
                    stockDocResp.onStockDocSuccess(response.body());

                } else {
                    stockDocResp.onStockDocError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<StockDocumentResponse> call, Throwable t) {
                stockDocResp.onStockDocError(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });
    }

    @Override
    public void callSelectDoc(String method, String id, final SelectDocData responseDD) {
        Retrofit retrofit = ApiClient.getRetrofit2();
        WebApi apis = retrofit.create(WebApi.class);
        DocumentDataRequest request = new DocumentDataRequest(method,id);
        Call<DocumentData> call = apis.selectDoc(request);
        call.enqueue(new Callback<DocumentData>() {
            @Override
            public void onResponse(Call<DocumentData> call, Response<DocumentData> response) {
                if (response.isSuccessful()) {
                    responseDD.onSelectDocSuccess(response.body());

                } else {
                    responseDD.onSelectDocError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<DocumentData> call, Throwable t) {
                responseDD.onSelectDocError(t.getMessage());
                Log.i("response", t.getMessage());
            }
        });
    }
}
