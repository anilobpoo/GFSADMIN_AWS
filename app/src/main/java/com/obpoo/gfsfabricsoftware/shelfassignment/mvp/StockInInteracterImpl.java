package com.obpoo.gfsfabricsoftware.shelfassignment.mvp;


import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInRequest;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StockInInteracterImpl implements StockInInteracter {


    @Override
    public void StockInMove(StockInRequest request, final StockInListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<StockInResponse> call = webApi.stockIn(request);
        call.enqueue(new Callback<StockInResponse>() {
            @Override
            public void onResponse(Call<StockInResponse> call, Response<StockInResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<StockInResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }




}
