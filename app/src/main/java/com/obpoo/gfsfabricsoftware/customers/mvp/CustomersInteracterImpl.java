package com.obpoo.gfsfabricsoftware.customers.mvp;

import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersRequest;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CustomersInteracterImpl implements CustomersInteracter {


    @Override
    public void viewList(CustomersRequest request, final CustomersListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<CustomersResponse> call = webApi.customer(request);
        call.enqueue(new Callback<CustomersResponse>() {
            @Override
            public void onResponse(Call<CustomersResponse> call, Response<CustomersResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<CustomersResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }


}
