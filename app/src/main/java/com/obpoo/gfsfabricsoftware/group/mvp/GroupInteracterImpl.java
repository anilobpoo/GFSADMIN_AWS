package com.obpoo.gfsfabricsoftware.group.mvp;


import com.obpoo.gfsfabricsoftware.group.datamodels.GroupRequest;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GroupInteracterImpl implements GroupInteracter {


    @Override
    public void viewShopList(GroupRequest request, final GroupInteracter.GroupListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<GroupResponse> call = webApi.group(request);
        call.enqueue(new Callback<GroupResponse>() {
            @Override
            public void onResponse(Call<GroupResponse> call, Response<GroupResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<GroupResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }




}
