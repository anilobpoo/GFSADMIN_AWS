package com.obpoo.gfsfabricsoftware.fabric.mvp;


import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;

public interface FabricsInteracter {
    interface FabricsListener {
        void onSuccess(FabricsResponse response);

        void onError(String message);
    }

    void  viewList(FabricsRequest request, FabricsListener listener);




}
