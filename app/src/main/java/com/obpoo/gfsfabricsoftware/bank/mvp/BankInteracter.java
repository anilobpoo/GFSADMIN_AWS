package com.obpoo.gfsfabricsoftware.bank.mvp;


import com.obpoo.gfsfabricsoftware.bank.datamodels.BankRequest;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;

public interface BankInteracter {
    interface BankListener {
        void onSuccess(BankResponse response);

        void onError(String message);
    }

    void  viewShopList(BankRequest request, BankInteracter.BankListener listener);
    //void update(AddShopRequest request, ShopListener listener);



}
