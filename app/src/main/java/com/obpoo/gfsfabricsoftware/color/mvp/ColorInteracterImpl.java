package com.obpoo.gfsfabricsoftware.color.mvp;


import com.obpoo.gfsfabricsoftware.color.datamodels.ColorRequest;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ColorInteracterImpl implements ColorInteracter {


    @Override
    public void viewShopList(ColorRequest request, final ColorListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<ColorResponse> call = webApi.color(request);
        call.enqueue(new Callback<ColorResponse>() {
            @Override
            public void onResponse(Call<ColorResponse> call, Response<ColorResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<ColorResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
