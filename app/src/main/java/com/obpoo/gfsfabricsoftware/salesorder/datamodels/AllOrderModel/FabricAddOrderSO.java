package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;

public interface FabricAddOrderSO {
    void AddFabricsBelowI(poItem index, String qty);
}
