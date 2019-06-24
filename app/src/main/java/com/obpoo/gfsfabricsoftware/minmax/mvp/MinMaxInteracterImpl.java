package com.obpoo.gfsfabricsoftware.minmax.mvp;

import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MinMaxInteracterImpl implements MinMaxInteracter {


    @Override
    public void viewShopList(MinMaxRequest request, final MinMaxListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<MinMaxResponse> call = webApi.minmax(request);
        call.enqueue(new Callback<MinMaxResponse>() {
            @Override
            public void onResponse(Call<MinMaxResponse> call, Response<MinMaxResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<MinMaxResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
