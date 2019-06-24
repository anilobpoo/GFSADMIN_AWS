package com.obpoo.gfsfabricsoftware.fabrictype.mvp;


import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeRequest;
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FabricTypepInteracterImpl implements FabricTypeInteracter {


    @Override
    public void viewShopList(FabricTypeRequest request, final FabricTypeListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<FabricTypeResponse> call = webApi.fabrictype(request);
        call.enqueue(new Callback<FabricTypeResponse>() {
            @Override
            public void onResponse(Call<FabricTypeResponse> call, Response<FabricTypeResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<FabricTypeResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
