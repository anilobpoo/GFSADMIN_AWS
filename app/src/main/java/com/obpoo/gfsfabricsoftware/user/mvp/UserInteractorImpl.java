package com.obpoo.gfsfabricsoftware.user.mvp;


import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.ViewRequest;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserInteractorImpl implements UserInteractor {


    @Override
    public void addcomposition(String name, String description, UserListener listener) {

    }


    @Override
    public void viewUserList(ViewRequest request, final UserListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<UserResponse> call = webApi.viewAllUserList(request);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }


}
