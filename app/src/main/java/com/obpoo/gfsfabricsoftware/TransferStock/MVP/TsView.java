package com.obpoo.gfsfabricsoftware.TransferStock.MVP;

import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;

/**
 * Created by PHD on 2/7/2019.
 */

public interface  TsView {
    void onGetPendingOrderIdResponse(PendingOrderRes response);
    void onGetFabricPendingRes(FabricPendingOIDRes response);
    void onTranferFabric(TransferResponse response);
    void onTransferWare(TransferWareWareRes response);
    void onPassWare(TransferResponse response);
    void onTransfer(Ts_Response response);
    void onTransferStockOut(TransferResponse response);

}
