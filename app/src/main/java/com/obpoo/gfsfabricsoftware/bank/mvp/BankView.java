package com.obpoo.gfsfabricsoftware.bank.mvp;

import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface BankView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(BankResponse response);
}
