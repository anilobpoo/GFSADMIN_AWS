package com.obpoo.gfsfabricsoftware.zone.mvp;

import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneRequest;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ZoneInteracterImpl implements ZoneInteracter {


    @Override
    public void viewShopList(ZoneRequest request, final ZoneListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<ZoneResponse> call = webApi.zone(request);
        call.enqueue(new Callback<ZoneResponse>() {
            @Override
            public void onResponse(Call<ZoneResponse> call, Response<ZoneResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<ZoneResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
