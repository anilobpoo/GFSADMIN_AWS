package com.obpoo.gfsfabricsoftware.bundle.mvp;


import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleRequest;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BundleInteracterImpl implements BundleInteracter {


    @Override
    public void viewShopList(BundleRequest request, final BundleListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<BundleResponse> call = webApi.bundle(request);
        call.enqueue(new Callback<BundleResponse>() {
            @Override
            public void onResponse(Call<BundleResponse> call, Response<BundleResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<BundleResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
