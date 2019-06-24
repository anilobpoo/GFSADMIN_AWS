package com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 11/16/2018.
 */

public class updateArticleInteractorImpl implements updateArticleInteractor {
    @Override
    public void updateArticleFN(String method,String articleId, String articleNo, String note, String ft, String pricefullroll,
                                String price1to9, String price10plus, String pricefullrollmtrs,
                                String price1to9mtrs, String price10plusmtrs, String composition, String occassion,final updateArticleListener updateArticleResponse ) {

        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        updateArticleRequest request = new updateArticleRequest(method,articleId,
                articleNo,note,ft,pricefullroll,price1to9,price10plus,pricefullrollmtrs,price1to9mtrs,price10plusmtrs,composition,occassion);
        Call<com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse> call = apis.updateArticle(request);
        call.enqueue(new Callback<com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse>() {
            @Override
            public void onResponse(Call<com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse> call, Response<com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse> response) {
                if (response.isSuccessful()) {
                    updateArticleResponse.onSuccess(response.body());

                } else {
                    updateArticleResponse.onFailure("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse> call, Throwable t) {
                updateArticleResponse.onFailure(t.getMessage());
                Log.i("response",t.getMessage());
            }
        });
    }


}
