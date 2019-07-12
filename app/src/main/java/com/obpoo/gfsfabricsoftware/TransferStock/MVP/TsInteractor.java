package com.obpoo.gfsfabricsoftware.TransferStock.MVP;

import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 2/7/2019.
 */

public interface TsInteractor {
    interface PendingOrderRes{
        void onGetPendingOrderSuccess(com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes response);
        void onGetPendingOrderError(String message);

    }
    void callRetroPOid(String method, PendingOrderRes response);

    interface FabPendingOid{
        void onGetFabPendingOidSuccess(FabricPendingOIDRes response);
        void onGetFabPendingOidError(String message);
    }

    void callRetroFabPending(String method,String id,FabPendingOid response );

    interface TransferItems{
        void onGetTIsuccess(TransferResponse response);
        void onGetTIerror(String message);
    }
    void callRetroTransferItems(ArrayList<String> all_id, ArrayList<String> cqty, String method, String customer_id, String group_id,
                                String discount, String Dellivery_address, String credit_time, String vat_enabled,
                                String pay_mode, String delivery_type, String order_type, String order_total,
                                String order_by, String vat_amount, String payble_amount,  ArrayList<HashMap<String, String>> items,TransferItems response);

    interface TranferWarehouse{
        void onGetTWSuccess(TransferResponse response);
        void onGetTWerror(String message);
    }
    void callRetroTransferWarehouse(ArrayList<String> all_id,String warehouse,String method,TranferWarehouse response);

    interface TransferWareWare{
        void onGetWWSuccess(TransferWareWareRes response);
        void onGetWWError(String message);
    }
    void callRetroTranWareWare(String method, String id,TransferWareWare response);

    interface PassWareWare{
        void onPassWareSuccess(TransferResponse response);
        void onPassWareErroe(String message);
    }
    void callRetroPassWare(String warehouse_to,String id,String method,PassWareWare response);

    interface TransferFabrics{
        void onTransferSuccess(Ts_Response response);
        void onTransferError(String message);
    }
    void callRetroTransferFabrics(String method,TransferFabrics response);

    interface TransferStockOut{
        void onTransferStockoutSuccess(TransferResponse response);
        void onTransferStockOutError(String message);
    }
    void callRetroTransferStockOut(String method,ArrayList<String> ids,TransferStockOut response);

    interface StockDocResp{
        void onStockDocSuccess(StockDocumentResponse response);
        void onStockDocError(String message);
    }
    void callStockDoc(String method, StockDocResp response);
}
