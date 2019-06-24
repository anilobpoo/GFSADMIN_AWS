package com.obpoo.gfsfabricsoftware.shelfassignment.mvp;


import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInRequest;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;

public interface StockInInteracter {
    interface StockInListener {
        void onSuccess(StockInResponse response);

        void onError(String message);
    }

    void  StockInMove(StockInRequest request, StockInInteracter.StockInListener listener);




}
