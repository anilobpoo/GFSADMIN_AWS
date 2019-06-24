package com.obpoo.gfsfabricsoftware.shop.mvp;

import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ViewShopRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShopInteracterImpl implements ShopInteracter {
    @Override
    public void viewList(ViewShopRequest request, final ShopListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<ShopResponse> call = webApi.shop(request);
        call.enqueue(new Callback<ShopResponse>() {
            @Override
            public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<ShopResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }

}
