package com.obpoo.gfsfabricsoftware.shelfassignment.mvp;

import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface StockInView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(StockInResponse response);
}
