package com.obpoo.gfsfabricsoftware.fabric.mvp;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FabricsInteracterImpl implements FabricsInteracter {


    @Override
    public void viewList(FabricsRequest request, final FabricsListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<FabricsResponse> call = webApi.fabrics(request);
        call.enqueue(new Callback<FabricsResponse>() {
            @Override
            public void onResponse(Call<FabricsResponse> call, Response<FabricsResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<FabricsResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
