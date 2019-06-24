package com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActRequest;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.FabricChangeRequest;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.TailorChangeRequest;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ViewRequest;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Report_request;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ATinteractorImpl implements ATinteractor {
    @Override
    public void callRetroAT(String method, final  ATinterface aTinterface) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ViewRequest request = new ViewRequest(method);
        Call<ATresponse> call = apis.atAPI(request);
        call.enqueue(new Callback<ATresponse>() {
            @Override
            public void onResponse(Call<ATresponse> call, Response<ATresponse> response) {
                if (response.isSuccessful()) {
                    aTinterface.ATsuccess(response.body());

                } else {
                    aTinterface.ATerror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<ATresponse> call, Throwable t) {
                aTinterface.ATerror(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroAssoAct(String method, String ts_id, String activity, String status, final AssociateActI associateActI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AssociateActRequest request = new AssociateActRequest(method,ts_id,activity,status);
        Call<AssociateActivity> call = apis.assoACTAPI(request);
        call.enqueue(new Callback<AssociateActivity>() {
            @Override
            public void onResponse(Call<AssociateActivity> call, Response<AssociateActivity> response) {
                if (response.isSuccessful()) {
                    associateActI.associateActSuccess(response.body());

                } else {
                    associateActI.associateActError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AssociateActivity> call, Throwable t) {
                associateActI.associateActError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroFabricAssoc(String method, final FabricAssociation fabricAssociation) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ViewRequest request = new ViewRequest(method);
        Call<AssoFabricResponse> call = apis.assoFABAPI(request);
        call.enqueue(new Callback<AssoFabricResponse>() {
            @Override
            public void onResponse(Call<AssoFabricResponse> call, Response<AssoFabricResponse> response) {
                if (response.isSuccessful()) {
                    fabricAssociation.fabricAssocSuccess(response.body());

                } else {
                    fabricAssociation.fabricAssocFailure("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AssoFabricResponse> call, Throwable t) {
                fabricAssociation.fabricAssocFailure(t.getMessage());

            }
        });

    }

    @Override
    public void callRetrochangeFabricURL(String method, final ChangeFabricURlINter changeFabricURlINter) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ViewRequest request = new ViewRequest(method);
        Call<AssociateFabricChangeURL> call = apis.assoFABchangeURL(request);
        call.enqueue(new Callback<AssociateFabricChangeURL>() {
            @Override
            public void onResponse(Call<AssociateFabricChangeURL> call, Response<AssociateFabricChangeURL> response) {
                if (response.isSuccessful()) {
                    changeFabricURlINter.changeFabricURlSuccess(response.body());

                } else {
                    changeFabricURlINter.changeFabricURLerror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AssociateFabricChangeURL> call, Throwable t) {
                changeFabricURlINter.changeFabricURLerror(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroFabricStatus(String method, String id, String action, String store_url, final  ChangeFabricStatus changeFabricStatus) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        FabricChangeRequest request = new FabricChangeRequest(method,id,action,store_url);
        Call<AssociateFabircChangeRes> call = apis.assoFABchangeAPI(request);
        call.enqueue(new Callback<AssociateFabircChangeRes>() {
            @Override
            public void onResponse(Call<AssociateFabircChangeRes> call, Response<AssociateFabircChangeRes> response) {
                if (response.isSuccessful()) {
                    changeFabricStatus.onChangeFabricStatusSuccess(response.body());

                } else {
                    changeFabricStatus.onChangeFabricStautserror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AssociateFabircChangeRes> call, Throwable t) {
                changeFabricStatus.onChangeFabricStautserror(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroTailorRequest(String method, String ts_id, String cod_status, String vat_status, String credit_time, String credit_limit, String activity, final  changeTailorRequestI changeTailorRequestI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        TailorChangeRequest request = new TailorChangeRequest(method,ts_id,cod_status,vat_status,credit_time,credit_limit,activity);
        Call<AssociateActivity> call = apis.assotailorChangeReqAPI(request);
        call.enqueue(new Callback<AssociateActivity>() {
            @Override
            public void onResponse(Call<AssociateActivity> call, Response<AssociateActivity> response) {
                if (response.isSuccessful()) {
                    changeTailorRequestI.tailorRequestSuccess(response.body());

                } else {
                    changeTailorRequestI.tailorRequestError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AssociateActivity> call, Throwable t) {
                changeTailorRequestI.tailorRequestError(t.getMessage());

            }
        });
    }
}
