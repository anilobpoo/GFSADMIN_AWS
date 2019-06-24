package com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleResponse;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by obpoo on 11/16/2018.
 */

public class addArticle_stockInteractorImpl implements addArticle_stockInteractor {
    @Override
    public void AddArticleFN(String method, String aNo, String note,String FT, String occasion, String compassion, String fullYards,
                             String _9yards, String _10Yards, String fullMtrs, String _9Mtrs, String _10Mtrs,final addArticleListener Listener_response) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        AddArticleRequest request = new AddArticleRequest(method,aNo,note,FT,occasion,compassion,fullYards,_9yards,_10Yards,fullMtrs,_9Mtrs,_10Mtrs);
        Call<AddArticleResponse> call = apis.AddArticleMsg(request);
        call.enqueue(new Callback<AddArticleResponse>() {
            @Override
            public void onResponse(Call<AddArticleResponse> call, Response<AddArticleResponse> response) {
                if (response.isSuccessful()) {
                    Listener_response.onSuccess(response.body());

                } else {
                    Listener_response.onFailure("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<AddArticleResponse> call, Throwable t) {
                Listener_response.onFailure(t.getMessage());
                Log.i("response",t.getMessage());
            }
        });
    }
}
