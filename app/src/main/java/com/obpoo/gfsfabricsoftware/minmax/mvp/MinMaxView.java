package com.obpoo.gfsfabricsoftware.minmax.mvp;

import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface MinMaxView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(MinMaxResponse response);
}
