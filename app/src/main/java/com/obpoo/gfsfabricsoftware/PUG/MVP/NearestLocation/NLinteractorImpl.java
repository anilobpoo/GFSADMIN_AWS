package com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation;

import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 12/7/2018.
 */

public class NLinteractorImpl implements NLinteractor {
    @Override
    public void callRetroNL(String method,final GetNLResponse GetNLResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        NLRequest request = new NLRequest(method);
        Call<NLData> call = apis.NLAPI(request);
        call.enqueue(new Callback<NLData>() {
            @Override
            public void onResponse(Call<NLData> call, Response<NLData> response) {
                if (response.isSuccessful()) {
                    GetNLResponse.onGetNLSuccess(response.body());

                } else {
                    GetNLResponse.onGetNLerror("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<NLData> call, Throwable t) {
                GetNLResponse.onGetNLerror(t.getMessage());

            }
        });

    }
}
