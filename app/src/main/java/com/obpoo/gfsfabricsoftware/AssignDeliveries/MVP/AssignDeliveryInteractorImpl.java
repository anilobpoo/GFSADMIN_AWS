package com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AllPGrequest;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgRequest;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryRequest;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 1/3/2019.
 */

public class AssignDeliveryInteractorImpl implements AssignDeliveryInteractor{

    @Override
    public void callRetroDelivery(String method, final ViewDeliveryResponse ViewDeliveryResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        DeliveryRequest request = new DeliveryRequest(method);
        Call<DeliveryData> call = apis.AssignDeliveryAPI(request);
        call.enqueue(new Callback<DeliveryData>() {
            @Override
            public void onResponse(Call<DeliveryData> call, Response<DeliveryData> response) {
                if (response.isSuccessful()) {
                    ViewDeliveryResponse.onDeliverySuccess(response.body());

                } else {
                    ViewDeliveryResponse.onDeliveryError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<DeliveryData> call, Throwable t) {
                ViewDeliveryResponse.onDeliveryError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroPgAll(String method,final viewPgAll viewPgAll) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AllPGrequest request = new AllPGrequest(method);
        Call<PGresponse> call = apis.allPGapi(request);
        call.enqueue(new Callback<PGresponse>() {
            @Override
            public void onResponse(Call<PGresponse> call, Response<PGresponse> response) {
                if (response.isSuccessful()) {
                    viewPgAll.onPgAllSuccess(response.body());

                } else {
                    viewPgAll.onPgError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<PGresponse> call, Throwable t) {
                viewPgAll.onPgError(t.getMessage());

            }
        });

    }

    @Override
    public void callRetroAssignPg(String method, String pg_user_id, String oid, final AssignPg AssignPg) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AssignPgRequest request = new AssignPgRequest(method,pg_user_id,oid);
        Call<AssignPgResponse> call = apis.assignPGapi(request);
        call.enqueue(new Callback<AssignPgResponse>() {
            @Override
            public void onResponse(Call<AssignPgResponse> call, Response<AssignPgResponse> response) {
                if (response.isSuccessful()) {
                    AssignPg.onAssignPgSuccess(response.body());

                } else {
                    AssignPg.onAssignPgError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AssignPgResponse> call, Throwable t) {
                AssignPg.onAssignPgError(t.getMessage());

            }
        });

    }
}
