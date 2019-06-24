package com.obpoo.gfsfabricsoftware.cart.mvp;


import com.obpoo.gfsfabricsoftware.cart.datamodels.CartRequest;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartInteracterImpl implements CartInteracter {


    @Override
    public void viewList(CartRequest request, final CartListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<CartResponse> call = webApi.cart(request);
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(Call<CartResponse> call, Response<CartResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<CartResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
