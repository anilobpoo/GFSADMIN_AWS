package com.obpoo.gfsfabricsoftware.Article.MVP.stock;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.FabricTypeRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deleteArticleRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.ViewRequest;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by PHD on 11/14/2018.
 */

public class StockInteractorImpl implements StockInteractor {

    private String stock_name;
    private int drawable;

    public StockInteractorImpl() {
    }

    public StockInteractorImpl(String stock_name, int drawable) {
        this.stock_name = stock_name;
        this.drawable = drawable;
    }

    public String getStock_name() {
        return stock_name;
    }

    public int getDrawable() {
        return drawable;
    }


    @Override
    public void stocklogin(String method,final StockListResponse stockListResponse) {
        Log.i("response","enterStockloginMethod");
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        ViewRequest request = new ViewRequest(method);
        Call<stockPOJO> call = apis.stocklistL(request);
        call.enqueue(new Callback<stockPOJO>() {
            @Override
            public void onResponse(Call<stockPOJO> call, Response<stockPOJO> response) {
                if (response.isSuccessful()) {
                    stockListResponse.onGetStockListResponse(response.body());
                    Log.i("response","Success");
                } else {
                    stockListResponse.onGetStockListError("Please Try Again.");
                    Log.i("response","try again");
                }
            }

            @Override
            public void onFailure(Call<stockPOJO> call, Throwable t) {
                stockListResponse.onGetStockListError(t.getMessage());
            }
        });
    }

    @Override
    public void fabricTypeRetCall(String method,final FabricTypeResponse fabricTypeResponse) {


        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        FabricTypeRequest request = new FabricTypeRequest(method);
        Call<fabricTypePOJO> call = apis.getFabricType(request);
        call.enqueue(new Callback<fabricTypePOJO>() {
            @Override
            public void onResponse(Call<fabricTypePOJO> call, Response<fabricTypePOJO> response) {
                if (response.isSuccessful()) {
                    fabricTypeResponse.onGetFabricTypeResponse(response.body());

                } else {
                    fabricTypeResponse.onGetFabricTypeError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<fabricTypePOJO> call, Throwable t) {
                fabricTypeResponse.onGetFabricTypeError(t.getMessage());

            }
        });

    }

    @Override
    public void deleteArticle(String method, String id, final deleteArticleResponse deleteArticleResponse) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi apis = retrofit.create(WebApi.class);
        deleteArticleRequest request = new deleteArticleRequest(method,id);
        Call<deletearticelPOJO> call = apis.deleteArticelAPI(request);
        call.enqueue(new Callback<deletearticelPOJO>() {
            @Override
            public void onResponse(Call<deletearticelPOJO> call, Response<deletearticelPOJO> response) {
                if (response.isSuccessful()) {
                    deleteArticleResponse.onGetdeleteArticleResponse(response.body());

                } else {
                    deleteArticleResponse.onGetDeleteArticleError("Please Try Again.");

                }
            }

            @Override
            public void onFailure(Call<deletearticelPOJO> call, Throwable t) {
                deleteArticleResponse.onGetDeleteArticleError(t.getMessage());

            }
        });

    }


}
