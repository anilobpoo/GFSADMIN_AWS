package com.obpoo.gfsfabricsoftware.fabric.mvp.fabriccolor;

import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface FabricColorView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(FabricColorResponse response);
}
