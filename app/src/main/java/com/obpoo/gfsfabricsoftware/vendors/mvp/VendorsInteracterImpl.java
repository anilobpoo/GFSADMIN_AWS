package com.obpoo.gfsfabricsoftware.vendors.mvp;

import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.ViewVendorsRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VendorsInteracterImpl implements VendorsInteracter {
    @Override
    public void viewList(ViewVendorsRequest request, final VendorsListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<VendorsResponse> call = webApi.vendor(request);
        call.enqueue(new Callback<VendorsResponse>() {
            @Override
            public void onResponse(Call<VendorsResponse> call, Response<VendorsResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<VendorsResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
