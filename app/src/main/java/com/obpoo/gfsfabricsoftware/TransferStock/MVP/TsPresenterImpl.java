package com.obpoo.gfsfabricsoftware.TransferStock.MVP;

import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 2/7/2019.
 */

public class TsPresenterImpl implements TsPresenter,TsInteractor.PendingOrderRes,TsInteractor.FabPendingOid,
        TsInteractor.TransferItems, TsInteractor.TranferWarehouse, TsInteractor.TransferWareWare,
        TsInteractor.PassWareWare,TsInteractor.TransferFabrics,TsInteractor.TransferStockOut,TsInteractor.StockDocResp,TsInteractor.SelectDocData {
    private TsView tsView;
    private TsInteractorImpl interactor;

    public TsPresenterImpl(TsView tsView) {
        this.tsView = tsView;
        interactor = new TsInteractorImpl();
    }

    @Override
    public void onGetPendingOrderId(String method) {
        tsView.showDialog();
        interactor.callRetroPOid(method,this);
    }

    @Override
    public void onGetFabricPendingOID(String method, String id) {
        tsView.showDialog();
        interactor.callRetroFabPending(method,id,this);

    }

    @Override
    public void onTransfer(ArrayList<String> all_id, ArrayList<String> cqty, String method, String customer_id,
                           String group_id, String discount, String Dellivery_address, String credit_time, String vat_enabled, String pay_mode, String delivery_type, String order_type, String order_total, String order_by, String vat_amount, String payble_amount, ArrayList <HashMap<String, String>>items) {
        interactor.callRetroTransferItems(all_id,cqty,method,customer_id,group_id,discount,Dellivery_address,credit_time,vat_enabled,pay_mode,delivery_type,order_type,order_total,order_by,vat_amount,payble_amount,items,this);
        tsView.showDialog();
    }

    @Override
    public void onTransferWare(ArrayList<String> all_id, String warehouse, String method) {
        interactor.callRetroTransferWarehouse(all_id,warehouse,method,this);
        tsView.showDialog();
    }

    @Override
    public void onTransferWare_Ware(String method, String id) {
        tsView.showDialog();
        interactor.callRetroTranWareWare(method,id,this);
    }

    @Override
    public void onPassWare_ware(String warehouse_to, String id, String method) {
        interactor.callRetroPassWare(warehouse_to,id,method,this);
        tsView.showDialog();
    }

    @Override
    public void onTransferParameters(String method, String from_date, String to_date, String page_no, String document) {
        interactor.callRetroTransferFabrics(method,from_date,to_date,page_no,document,this);
        tsView.showDialog();
    }


    @Override
    public void onTransferStockOutPara(String method, ArrayList<String> ids) {
        interactor.callRetroTransferStockOut(method,ids,this);
        tsView.showDialog();
    }

    @Override
    public void onViewStockDoc(String method) {
        tsView.showDialog();
        interactor.callStockDoc(method,this);
    }

    @Override
    public void onViewSelectDoc(String method, String id) {
        tsView.showDialog();
interactor.callSelectDoc(method,id,this);
    }


    @Override
    public void onGetPendingOrderSuccess(PendingOrderRes response) {
        tsView.onGetPendingOrderIdResponse(response);
        tsView.hideDialog();
    }

    @Override
    public void onGetPendingOrderError(String message) {

    }

    @Override
    public void onGetFabPendingOidSuccess(FabricPendingOIDRes response) {
        tsView.onGetFabricPendingRes(response);
        tsView.hideDialog();
    }

    @Override
    public void onGetFabPendingOidError(String message) {

    }

    @Override
    public void onGetTIsuccess(TransferResponse response) {
        tsView.onTranferFabric(response);
        tsView.hideDialog();
    }

    @Override
    public void onGetTIerror(String message) {

    }

    @Override
    public void onGetTWSuccess(TransferResponse response) {
        tsView.onTranferFabric(response);
        tsView.hideDialog();
    }

    @Override
    public void onGetTWerror(String message) {

    }

    @Override
    public void onGetWWSuccess(TransferWareWareRes response) {
        tsView.onTransferWare(response);
        tsView.hideDialog();
    }

    @Override
    public void onGetWWError(String message) {

    }

    @Override
    public void onPassWareSuccess(TransferResponse response) {
        tsView.onPassWare(response);
        tsView.hideDialog();
    }

    @Override
    public void onPassWareErroe(String message) {

    }

    @Override
    public void onTransferSuccess(Ts_Response response) {
        tsView.onTransfer(response);
        tsView.hideDialog();
    }

    @Override
    public void onTransferError(String message) {

    }

    @Override
    public void onTransferStockoutSuccess(TransferResponse response) {
        tsView.onTransferStockOut(response);
        tsView.hideDialog();
    }

    @Override
    public void onTransferStockOutError(String message) {

    }

    @Override
    public void onStockDocSuccess(StockDocumentResponse response) {
        tsView.onStockDocView(response);
        tsView.hideDialog();
    }

    @Override
    public void onStockDocError(String message) {

    }

    @Override
    public void onSelectDocSuccess(DocumentData response) {
        tsView.onSelectDocView(response);
        tsView.hideDialog();
    }

    @Override
    public void onSelectDocError(String message) {

    }
}
