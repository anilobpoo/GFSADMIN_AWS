package com.obpoo.gfsfabricsoftware.shelf.mvp;

import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfRequest;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShelfInteracterImpl implements ShelfInteracter {


    @Override
    public void viewShopList(ShelfRequest request, final ShelfListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<ShelfResponse> call = webApi.shelf(request);
        call.enqueue(new Callback<ShelfResponse>() {
            @Override
            public void onResponse(Call<ShelfResponse> call, Response<ShelfResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<ShelfResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
