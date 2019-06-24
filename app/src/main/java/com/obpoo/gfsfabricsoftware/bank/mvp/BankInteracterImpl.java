package com.obpoo.gfsfabricsoftware.bank.mvp;

import com.obpoo.gfsfabricsoftware.bank.datamodels.BankRequest;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BankInteracterImpl implements BankInteracter {


    @Override
    public void viewShopList(BankRequest request, final BankInteracter.BankListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<BankResponse> call = webApi.bank(request);
        call.enqueue(new Callback<BankResponse>() {
            @Override
            public void onResponse(Call<BankResponse> call, Response<BankResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<BankResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
