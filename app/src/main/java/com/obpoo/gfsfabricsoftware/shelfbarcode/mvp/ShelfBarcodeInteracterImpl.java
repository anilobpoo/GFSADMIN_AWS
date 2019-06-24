package com.obpoo.gfsfabricsoftware.shelfbarcode.mvp;

import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeRequest;
import com.obpoo.gfsfabricsoftware.utilities.ApiClient;
import com.obpoo.gfsfabricsoftware.utilities.WebApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShelfBarcodeInteracterImpl implements ShelfBarcodeInteracter {


    @Override
    public void viewShopList(ShelfBarcodeRequest request, final ShelfBarocdeListener listener) {
        Retrofit retrofit = ApiClient.getRetrofit();
        WebApi webApi = retrofit.create(WebApi.class);
        Call<ShelfBarcodeResponse> call = webApi.bshelf(request);
        call.enqueue(new Callback<ShelfBarcodeResponse>() {
            @Override
            public void onResponse(Call<ShelfBarcodeResponse> call, Response<ShelfBarcodeResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Please Try Again.");
                }
            }

            @Override
            public void onFailure(Call<ShelfBarcodeResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }



}
