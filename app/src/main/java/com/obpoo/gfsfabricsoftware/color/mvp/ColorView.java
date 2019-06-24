package com.obpoo.gfsfabricsoftware.color.mvp;

import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface ColorView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(ColorResponse response);
}
