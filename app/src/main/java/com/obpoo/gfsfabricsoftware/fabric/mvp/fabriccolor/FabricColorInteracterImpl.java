package com.obpoo.gfsfabricsoftware.fabric.mvp.fabriccolor;

import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FabricColorInteracterImpl implements FabricColorInteracter {


    @Override
    public void viewShopList(FabricColorRequest request, final FabricColorListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<FabricColorResponse> call = webApi.fcolor(request);
        call.enqueue(new Callback<FabricColorResponse>() {
            @Override
            public void onResponse(Call<FabricColorResponse> call, Response<FabricColorResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<FabricColorResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
