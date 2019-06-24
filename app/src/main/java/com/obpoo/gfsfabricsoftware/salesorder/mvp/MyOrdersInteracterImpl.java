package com.obpoo.gfsfabricsoftware.salesorder.mvp;


import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderStatusReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSelectedStatusReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSoDateFilReq;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersRequest;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyOrdersInteracterImpl implements MyOrdersInteracter {


    @Override
    public void viewList(MyOrdersRequest request, final MyOrdersListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<MyOrdersResponse> call = webApi.order(request);
        call.enqueue(new Callback<MyOrdersResponse>() {
            @Override
            public void onResponse(Call<MyOrdersResponse> call, Response<MyOrdersResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<MyOrdersResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }

    @Override
    public void allOrderCall(String method, String page_no, final AllORderSoI allORderSoI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        AllORderReq request = new AllORderReq(method,page_no);
        Call<AllOrderRes> call = webApi.allorderSOAPI(request);
        call.enqueue(new Callback<AllOrderRes>() {
            @Override
            public void onResponse(Call<AllOrderRes> call, Response<AllOrderRes> response) {
                if (response.isSuccessful()) {
                    allORderSoI.onAllORdeSuccess(response.body());
                } else {
                    allORderSoI.onAllORderError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<AllOrderRes> call, Throwable t) {
                allORderSoI.onAllORderError(t.getMessage());
            }
        });

    }

    @Override
    public void allOrderSoDateFilterCall(String method, String from, String to, String page_no, final AllORderSoI allORderSoI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        AllOrderSoDateFilReq request = new AllOrderSoDateFilReq(method,from,to,page_no);
        Call<AllOrderRes> call = webApi.allorderSODateFilAPI(request);
        call.enqueue(new Callback<AllOrderRes>() {
            @Override
            public void onResponse(Call<AllOrderRes> call, Response<AllOrderRes> response) {
                if (response.isSuccessful()) {
                    allORderSoI.onAllORdeSuccess(response.body());
                } else {
                    allORderSoI.onAllORderError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<AllOrderRes> call, Throwable t) {
                allORderSoI.onAllORderError(t.getMessage());
            }
        });

    }

    @Override
    public void allOrderSoSelectedStatusI(String method, String status, final  AllORderSoI allORderSoI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        AllOrderSelectedStatusReq request = new AllOrderSelectedStatusReq(method,status);
        Call<AllOrderRes> call = webApi.allorderSOstatusselectedAPI(request);
        call.enqueue(new Callback<AllOrderRes>() {
            @Override
            public void onResponse(Call<AllOrderRes> call, Response<AllOrderRes> response) {
                if (response.isSuccessful()) {
                    allORderSoI.onAllORdeSuccess(response.body());
                } else {
                    allORderSoI.onAllORderError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<AllOrderRes> call, Throwable t) {
                allORderSoI.onAllORderError(t.getMessage());
            }
        });
    }

    @Override
    public void allORderStatusCall(String method, final AllOrderSoStatusI allOrderSoStatusI) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        AllORderStatusReq request = new AllORderStatusReq(method);
        Call<AllOrderStatusRes> call = webApi.allorderSOstatusAPI(request);
        call.enqueue(new Callback<AllOrderStatusRes>() {
            @Override
            public void onResponse(Call<AllOrderStatusRes> call, Response<AllOrderStatusRes> response) {
                if (response.isSuccessful()) {
                    allOrderSoStatusI.onAllOrderStatusSuccess(response.body());
                } else {
                    allOrderSoStatusI.onALlORderStatusSOError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<AllOrderStatusRes> call, Throwable t) {
                allOrderSoStatusI.onALlORderStatusSOError(t.getMessage());
            }
        });


    }


}
