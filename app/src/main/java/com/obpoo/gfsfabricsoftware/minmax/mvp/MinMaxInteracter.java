package com.obpoo.gfsfabricsoftware.minmax.mvp;


import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxRequest;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;

public interface MinMaxInteracter {
    interface MinMaxListener {
        void onSuccess(MinMaxResponse response);

        void onError(String message);
    }

    void  viewShopList(MinMaxRequest request, MinMaxInteracter.MinMaxListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
