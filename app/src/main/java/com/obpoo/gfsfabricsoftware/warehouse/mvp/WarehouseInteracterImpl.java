package com.obpoo.gfsfabricsoftware.warehouse.mvp;

import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WarehouseInteracterImpl implements WarehouseInteracter {
    @Override
    public void viewList(WarehouseRequest request, final WarehouseListerner listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<WarehouseResponse> call = webApi.warehouse(request);
        call.enqueue(new Callback<WarehouseResponse>() {
            @Override
            public void onResponse(Call<WarehouseResponse> call, Response<WarehouseResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<WarehouseResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
