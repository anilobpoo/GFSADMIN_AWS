package com.obpoo.gfsfabricsoftware.Composition.mvp;


import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ViewCompositionRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CompositionInteractorImpl implements CompositionInteractor {


    @Override
    public void addcomposition(String name, String description, CompositionListener listener) {

    }


    @Override
    public void viewCompositionList(ViewCompositionRequest request, final CompositionListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<CompositionResponse> call = webApi.comp(request);
        call.enqueue(new Callback<CompositionResponse>() {
            @Override
            public void onResponse(Call<CompositionResponse> call, Response<CompositionResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<CompositionResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }


}
