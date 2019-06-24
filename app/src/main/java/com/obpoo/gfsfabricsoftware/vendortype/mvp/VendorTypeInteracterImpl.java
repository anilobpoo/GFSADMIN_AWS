package com.obpoo.gfsfabricsoftware.vendortype.mvp;

import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeRequest;
import com.obpoo.gfsfabricsoftware.vendortype.datamodels.VendorTypeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VendorTypeInteracterImpl implements VendorTypeInteracter {
    @Override
    public void viewList(VendorTypeRequest request, final VendorTypeListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<VendorTypeResponse> call = webApi.vendortype(request);
        call.enqueue(new Callback<VendorTypeResponse>() {
            @Override
            public void onResponse(Call<VendorTypeResponse> call, Response<VendorTypeResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<VendorTypeResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
