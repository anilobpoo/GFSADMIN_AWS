package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticleRequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.deleteCmnartRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 11/19/2018.
 */

public class cmnArtInteractorImpl implements cmnArtInteractor {
    @Override
    public void CallcmnArtGroupResponse(String method, final cmnArtGroupResponse cmnArtGroupResponse) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        cmnArticleRequest request = new cmnArticleRequest(method);
        Call<cmnArticlePOJO> call = apis.cmnArticleAPI(request);
        call.enqueue(new Callback<cmnArticlePOJO>() {
            @Override
            public void onResponse(Call<cmnArticlePOJO> call, Response<cmnArticlePOJO> response) {
                if (response.isSuccessful()) {
                    cmnArtGroupResponse.onGetcmnArtGroupResponse(response.body());

                } else {
                    cmnArtGroupResponse.onGetcmnArtGroupError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<cmnArticlePOJO> call, Throwable t) {
                cmnArtGroupResponse.onGetcmnArtGroupError(t.getMessage());

            }
        });


    }

    @Override
    public void calldeleteCmnArtGroupResponse(String method, String id, final deleteCmnArtGroupResponse deleteCmnArtGroupResponse) {
        System.out.println("two");
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        deleteCmnartRequest request = new deleteCmnartRequest(method,id);
        Call<cmnArtdeletePOJO> call = apis.deletecmnArticleAPI(request);
        call.enqueue(new Callback<cmnArtdeletePOJO>() {
            @Override
            public void onResponse(Call<cmnArtdeletePOJO> call, Response<cmnArtdeletePOJO> response) {
                if (response.isSuccessful()) {
                    deleteCmnArtGroupResponse.onGetdeleteCmnArtGroupResponse(response.body());

                } else {
                    deleteCmnArtGroupResponse.onGetdeleteCmnArtGroupError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<cmnArtdeletePOJO> call, Throwable t) {
                deleteCmnArtGroupResponse.onGetdeleteCmnArtGroupError(t.getMessage());

            }
        });

    }
}
