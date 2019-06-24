package com.obpoo.gfsfabricsoftware.Stock.MVP;

import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.RequestObjectCustomerAddReserve;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;

/**
 * Created by PHD on 1/29/2019.
 */

public interface StockInteractor {
    interface ViewStockResponse {
        void onStockSuccess(com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse response);

        void onStockError(String message);
    }

    void callRetroViewStock(String method, String filterId, String IdType, ViewStockResponse response);

    interface ViewNewStockResponse {
        void onStockNewSuccess(ViewStockNewResponse response);

        void onStockNewError(String message);
    }

    void callRetroViewNewStock(String method, String filterId, String page_no, ViewNewStockResponse response);

    interface ViewActivityLog {
        void onALSuccess(ActivityLogResponse response);

        void onALerror(String message);
    }

    void callRetroAL(String method, ViewActivityLog response);

    interface ViewFabricSearch {
        void onFSsuccess(FabSearchRes response);

        void onFSfailure(String message);
    }

    void callRetroFS(String method, String fab_name, ViewFabricSearch viewFabricSearch);

    interface CustomerReseeveI {
        void onCRsuccess(CustomerResResp response);

        void onCRerror(String message);
    }

    void callRetroCR(String method, CustomerReseeveI response);

    interface AddReserveI {
        void onAddResSuccess(AddReserveRes response);

        void onAdResError(String message);
    }

    void callRetroAddReserve(String method, String search, AddReserveI response);

    interface CustomerAddReserveI {
        void onCustomerAddReserveSuccess(AddCustomerReserveFinal response);

        void onCustomerAddReserveError(String message);
    }

    void callRetroCustomerAddReserve(String method, RequestObjectCustomerAddReserve alldata, CustomerAddReserveI response);
}
