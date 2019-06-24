package com.obpoo.gfsfabricsoftware.color.mvp;


import com.obpoo.gfsfabricsoftware.color.datamodels.ColorRequest;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;

public interface ColorInteracter {
    interface ColorListener {
        void onSuccess(ColorResponse response);

        void onError(String message);
    }

    void  viewShopList(ColorRequest request, ColorInteracter.ColorListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
