package com.obpoo.gfsfabricsoftware.customertype.mvp;

import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeRequest;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CustomerTypeInteracterImpl implements CustomerTypeInteracter {


    @Override
    public void viewList(CustomerTypeRequest request, final CustomerTypeListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<CustomerTypeResponse> call = webApi.customertype(request);
        call.enqueue(new Callback<CustomerTypeResponse>() {
            @Override
            public void onResponse(Call<CustomerTypeResponse> call, Response<CustomerTypeResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<CustomerTypeResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
