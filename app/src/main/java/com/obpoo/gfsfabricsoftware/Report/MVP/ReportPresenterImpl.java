package com.obpoo.gfsfabricsoftware.Report.MVP;

import android.util.Log;

import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response_data;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckIn.CheckInResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOutResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricGraphResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory.FabricHistoryResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POleftOverResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_Fabric_Response;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentRecResponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsresponse;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsResponse;

/**
 * Created by PHD on 2/18/2019.
 */

public class ReportPresenterImpl implements ReportPresenter,ReportInteractor.Build_Invoice_Response_Interface,
ReportInteractor.Customer_Pending_Response_Interface,ReportInteractor.CutStock_Response_Interface,ReportInteractor.FabricAnalytics_Interface,
ReportInteractor.FabricNames,ReportInteractor.FabricGraphHistory,ReportInteractor.PaymentReceived,ReportInteractor.PoDetails,ReportInteractor.PO_FABRIC_LIST,
ReportInteractor.PO_Left_Over,ReportInteractor.PO_Check_IN,ReportInteractor.PO_Check_OUT,ReportInteractor.Sold_Fabric{
    ReportInteractorImpl interactor;
    ReportView reportView;

    public ReportPresenterImpl(ReportView reportView) {
        this.reportView = reportView;
        interactor = new ReportInteractorImpl();
    }

    @Override
    public void onSend_Bill_Invoice_Report(String method, String from, String to) {
        reportView.showDialog();
        interactor.onCallRetroBuildInvoiceReport(method,from,to,this);

    }

    @Override
    public void onSend_Customer_Pending_report(String method, String customer_id) {
        reportView.showDialog();
        interactor.onCallRetroCustomerPending(method,customer_id,this);

    }

    @Override
    public void onSend_CutStock(String method, String from, String to) {
        reportView.showDialog();
        interactor.onCallRetorCutStock(method,from,to,this);

    }

    @Override
    public void onSend_FabricAnalytics(String method, String from, String to) {
        reportView.showDialog();
        interactor.onCallRetroFabricAnalytics(method,from,to,this);

    }

    @Override
    public void onSend_FabricNames(String method) {
        reportView.showDialog();
        interactor.onCallFabricNames(method,this);

    }

    @Override
    public void onSend_FabricGraphHistory(String method, String fab_name) {
        reportView.showDialog();
        interactor.onCallRetroFabricGraphHistore(method,fab_name,this);

    }

    @Override
    public void onSend_PaymentReceived(String method, String from, String to) {
        reportView.showDialog();
        interactor.onCallRetroPaymnetReceived(method,from,to,this);

    }

    @Override
    public void onSend_PoDetails(String method) {
        reportView.showDialog();
        interactor.onCallRetroPoDetails(method,this);

    }

    @Override
    public void onSend_PO_Fabric_List(String method, String from, String to) {
        reportView.showDialog();
    interactor.onCallRetroPOFabricList(method,from,to,this);

    }

    @Override
    public void onSend_PO_LeftOvers(String method, String from_date, String to_date) {
        reportView.showDialog();
        interactor.onCallRetroPOLeftOver(method,from_date,to_date,this);

    }

    @Override
    public void onSend_PO_checkIN(String method, String from_date, String to_date) {
        reportView.showDialog();
        interactor.onCallRetroCheckIN(method,from_date,to_date,this);

    }

    @Override
    public void onSend_PO_checkOUT(String method, String from_date, String to_date) {
        reportView.showDialog();
        interactor.onCallRetroCheckOUT(method,from_date,to_date,this);

    }

    @Override
    public void onSend_Sold_Fabric(String method, String from, String to) {
        reportView.showDialog();
        interactor.onCallRetroSoldFabric(method,from,to,this);

    }

    @Override
    public void onBuildInvoiceSuccess(Bill_Invoice_Response_data response) {
        reportView.hideDialog();
        reportView.onBill_Invoice_Report(response);

    }

    @Override
    public void onBuildInvoiceError(String message) {

    }

    @Override
    public void onCustomerPendingSuccess(CustomerPendingResponse response) {
        reportView.hideDialog();
        reportView.onCustomer_pending_Report(response);

    }

    @Override
    public void onCustomerPendingError(String message) {

    }

    @Override
    public void onCutStockSuccess(CutStockResponse response) {
        reportView.hideDialog();
        reportView.onCutStock_report(response);

    }

    @Override
    public void onCutStockError(String message) {

    }

    @Override
    public void onFabricAnalySuccess(FabricAnalyticsResponse response) {
        reportView.hideDialog();
        reportView.onFabricAnalytics(response);

    }

    @Override
    public void onFabricAnalyError(String message) {

    }

    @Override
    public void onFabricNamesSuccess(FabricHistoryResponse resposne) {
        reportView.hideDialog();
        reportView.onfabricNames(resposne);

    }

    @Override
    public void onFabricNamesError(String message) {

    }

    @Override
    public void onFabricHistorySuccess(FabricGraphResponse response) {
        reportView.hideDialog();
        reportView.onFabricHistory(response);

    }

    @Override
    public void onFabricHistoryError(String message) {

    }

    @Override
    public void onPaymentReceivedSuccess(PaymentRecResponse response) {
        reportView.hideDialog();
        reportView.onPaymentReceived(response);

    }

    @Override
    public void onPaymentReceivedError(String message) {

    }

    @Override
    public void onPoDetailsSuccess(PoDetailsresponse response) {
        reportView.hideDialog();
        reportView.onPOdetails(response);

    }

    @Override
    public void onPoDetailsError(String message) {
        Log.i("onPoDetailsError",message);

    }

    @Override
    public void onPOFabricListSuccess(PO_Fabric_Response response) {
        reportView.hideDialog();
        reportView.onPOfabricList(response);

    }

    @Override
    public void onPOFabricListError(String message) {

    }

    @Override
    public void onPOleftOVerSuccess(POleftOverResponse response) {
        reportView.hideDialog();
        reportView.onPOleftovers(response);

    }

    @Override
    public void onPoLeftOVerError(String message) {

    }

    @Override
    public void onCheckINSuccess(CheckInResponse response) {
        reportView.hideDialog();
        reportView.onCheckIn(response);

    }

    @Override
    public void onCheckINError(String message) {

    }

    @Override
    public void onCheckIOUTSuccess(CheckOutResponse response) {
        reportView.hideDialog();
        reportView.onCheckOut(response);

    }

    @Override
    public void onCheckOUTError(String message) {

    }

    @Override
    public void onSoldFabricSuccess(SoldFabricsResponse response) {
        reportView.hideDialog();
        reportView.onSoldFabrics(response);

    }

    @Override
    public void onSoldfabricError(String message) {

    }
}
