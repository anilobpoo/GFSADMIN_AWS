package com.obpoo.gfsfabricsoftware.shelf.mvp;

import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface ShelfView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(ShelfResponse response);
}
