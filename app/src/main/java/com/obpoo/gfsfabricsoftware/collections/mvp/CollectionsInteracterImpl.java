package com.obpoo.gfsfabricsoftware.collections.mvp;

import android.util.Log;


import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.UpdateInvoRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CollectionsInteracterImpl implements CollectionsInteracter {


    @Override
    public void viewList(CollectionsDRequest request, final CollectionsListener listener) {
        Retrofit retrofit = ApiClient.getoldRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Call<CollectionsDResponse> call = apis.CollectionDetApi(request);
        call.enqueue(new Callback<CollectionsDResponse>() {
            @Override
            public void onResponse(Call<CollectionsDResponse> call, Response<CollectionsDResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    listener.onError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CollectionsDResponse> call, Throwable t) {
                listener.onError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void viewInvoiceList(InvoiceRequest request, final InvoiceListener listener) {
        Retrofit retrofit = ApiClient.getoldRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Call<CollectionInvoiceResponse> call = apis.CollectionInvoApi(request);
        call.enqueue(new Callback<CollectionInvoiceResponse>() {
            @Override
            public void onResponse(Call<CollectionInvoiceResponse> call, Response<CollectionInvoiceResponse> response) {
                if (response.isSuccessful()) {
                    listener.onInvoiceSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    listener.onInvoiceError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CollectionInvoiceResponse> call, Throwable t) {
                listener.onInvoiceError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void updateInvoiceList(UpdateInvoRequest request, final InvoiceListener listener) {
        Retrofit retrofit = ApiClient.getoldRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Call<CollectionInvoiceResponse> call = apis.updateInvoApi(request);
        call.enqueue(new Callback<CollectionInvoiceResponse>() {
            @Override
            public void onResponse(Call<CollectionInvoiceResponse> call, Response<CollectionInvoiceResponse> response) {
                if (response.isSuccessful()) {
                    listener.onInvoiceSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    listener.onInvoiceError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<CollectionInvoiceResponse> call, Throwable t) {
                listener.onInvoiceError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }

    @Override
    public void viewDepositeList(DepositeRequest request, final DepositeListener listener) {
        Retrofit retrofit = ApiClient.getoldRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        Call<DepositeResponse> call = apis.depositeCollectionsApi(request);
        call.enqueue(new Callback<DepositeResponse>() {
            @Override
            public void onResponse(Call<DepositeResponse> call, Response<DepositeResponse> response) {
                if (response.isSuccessful()) {
                    listener.onDepositeSuccess(response.body());
                    Log.i("responsepo", response.body().getMessage());

                } else {
                    listener.onDepositeError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<DepositeResponse> call, Throwable t) {
                listener.onDepositeError(t.getMessage());
                Log.i("failureMSG", t.getMessage());

            }
        });
    }
}
