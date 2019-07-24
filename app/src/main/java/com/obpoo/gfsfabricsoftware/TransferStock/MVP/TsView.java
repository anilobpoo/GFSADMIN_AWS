package com.obpoo.gfsfabricsoftware.TransferStock.MVP;

import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 2/7/2019.
 */

public interface  TsView extends BaseView {
    void onGetPendingOrderIdResponse(PendingOrderRes response);
    void onGetFabricPendingRes(FabricPendingOIDRes response);
    void onTranferFabric(TransferResponse response);
    void onTransferWare(TransferWareWareRes response);
    void onPassWare(TransferResponse response);
    void onTransfer(Ts_Response response);
    void onTransferStockOut(TransferResponse response);
    void onStockDocView(StockDocumentResponse response);
    void onSelectDocView(DocumentData response);

}
