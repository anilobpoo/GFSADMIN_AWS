package com.obpoo.gfsfabricsoftware.fabric.mvp;

import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface FabricsView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(FabricsResponse response);
}
