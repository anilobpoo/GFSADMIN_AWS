package com.obpoo.gfsfabricsoftware.shelfbarcode.mvp;

import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface ShelfBarcodeView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(ShelfBarcodeResponse response);
}
