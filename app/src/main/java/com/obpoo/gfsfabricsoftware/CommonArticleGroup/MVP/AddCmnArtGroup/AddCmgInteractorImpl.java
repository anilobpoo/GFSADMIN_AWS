package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.AddCagRequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.addCagPOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticleDATA;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticlerequest;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.UpdateSMGmodel;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.updateSMGRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 11/20/2018.
 */

public class AddCmgInteractorImpl implements AddCmgInteractor {
    @Override
    public void callAddCmg(String method, final AddCmgResponse AddCmgResponse) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AddCagRequest request = new AddCagRequest(method);
        Call<addCagPOJO> call = apis.addCMGcolorAPI(request);
        call.enqueue(new Callback<addCagPOJO>() {
            @Override
            public void onResponse(Call<addCagPOJO> call, Response<addCagPOJO> response) {
                if (response.isSuccessful()) {
                    AddCmgResponse.onGetAddCmgResponse(response.body());

                } else {
                    AddCmgResponse.onGetAddCmgError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<addCagPOJO> call, Throwable t) {
                AddCmgResponse.onGetAddCmgError(t.getMessage());

            }
        });


    }

    @Override
    public void CallAddSimilarGroup(String method, String groupname, List<String> ArticlegrpList, String QDesc, String QName, final AddSimilarGroup AddSimilarGroup) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        similarArticlerequest request = new similarArticlerequest(method,groupname,ArticlegrpList,QDesc,QName);
        Call<similarArticleDATA> call = apis.similarArticleAddAPI(request);
        call.enqueue(new Callback<similarArticleDATA>() {
            @Override
            public void onResponse(Call<similarArticleDATA> call, Response<similarArticleDATA> response) {
                if (response.isSuccessful()) {
                    AddSimilarGroup.onGetAddSimilarGroupResponse(response.body());

                } else {
                    AddSimilarGroup.onGetAddSimilarGroupError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<similarArticleDATA> call, Throwable t) {
                AddSimilarGroup.onGetAddSimilarGroupError(t.getMessage());

            }
        });
    }

    @Override
    public void CallUpdateSimilarGroup(String method, String id, String groupname, List<String> ArticlegrpList, String QDesc, String QName, final UpdateSimilarGroup UpdateSimilarGroup) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        updateSMGRequest request = new updateSMGRequest(method,id,groupname,ArticlegrpList,QDesc,QName);
        Call<UpdateSMGmodel> call = apis.similarArticleUpdateAPI(request);
        call.enqueue(new Callback<UpdateSMGmodel>() {
            @Override
            public void onResponse(Call<UpdateSMGmodel> call, Response<UpdateSMGmodel> response) {
                if (response.isSuccessful()) {
                    UpdateSimilarGroup.onGetUpdateSimilarGroupResponse(response.body());

                } else {
                    UpdateSimilarGroup.onGetUpdateSimilarGroupError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<UpdateSMGmodel> call, Throwable t) {
                UpdateSimilarGroup.onGetUpdateSimilarGroupError(t.getMessage());

            }
        });
    }
}
