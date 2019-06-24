package com.obpoo.gfsfabricsoftware.salesorder.mvp;


import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;


public interface MyOrdersView extends BaseView {
    void onValidationFail(int type);

   // void onAdd(WarehouseResponse response);
    void onLoad(MyOrdersResponse response);
    void onAllSO(AllOrderRes response);
    void onAllSoStatus(AllOrderStatusRes response);
}
