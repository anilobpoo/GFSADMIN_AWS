package com.obpoo.gfsfabricsoftware.fabric.mvp.fabriccolor;


import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorResponse;

public interface FabricColorInteracter {
    interface FabricColorListener {
        void onSuccess(FabricColorResponse response);

        void onError(String message);
    }

    void  viewShopList(FabricColorRequest request, FabricColorInteracter.FabricColorListener listener);



}
