package com.obpoo.gfsfabricsoftware.shop.mvp;


import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopResponse;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ViewShopRequest;

public interface ShopInteracter {
    interface ShopListener {
        void onSuccess(ShopResponse response);

        void onError(String message);
    }

    void  viewList(ViewShopRequest request, ShopListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
