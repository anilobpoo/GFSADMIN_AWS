package com.obpoo.gfsfabricsoftware.zone.mvp;


import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneRequest;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;

public interface ZoneInteracter {
    interface ZoneListener {
        void onSuccess(ZoneResponse response);

        void onError(String message);
    }

    void  viewShopList(ZoneRequest request, ZoneInteracter.ZoneListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
