package com.obpoo.gfsfabricsoftware.Stock.MVP;

import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;

/**
 * Created by PHD on 1/29/2019.
 */

public interface ViewStock {
    void onShowStock(ViewStockResponse response);
    void onShowNewStock(ViewStockNewResponse response);
    void onShowActivityLog(ActivityLogResponse response);
    void onShowFabSearch(FabSearchRes response);
    void onShowCustomerReserve(CustomerResResp response);
    void onShowSearchFabrics(AddReserveRes response);
    void onAddCustomerReserve(AddCustomerReserveFinal response);

}
