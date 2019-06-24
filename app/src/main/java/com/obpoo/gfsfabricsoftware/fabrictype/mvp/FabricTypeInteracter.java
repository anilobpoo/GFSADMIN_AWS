package com.obpoo.gfsfabricsoftware.fabrictype.mvp;


import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeRequest;
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeResponse;

public interface FabricTypeInteracter {
    interface FabricTypeListener {
        void onSuccess(FabricTypeResponse response);

        void onError(String message);
    }

    void  viewShopList(FabricTypeRequest request, FabricTypeInteracter.FabricTypeListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
