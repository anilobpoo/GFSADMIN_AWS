package com.obpoo.gfsfabricsoftware.Report.MVP;

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
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 2/18/2019.
 */

public interface ReportView  extends BaseView {
        void onBill_Invoice_Report(Bill_Invoice_Response_data response);
        void onCustomer_pending_Report(CustomerPendingResponse response);
        void onCutStock_report(CutStockResponse response);
        void onFabricAnalytics(FabricAnalyticsResponse response);
        void onfabricNames(FabricHistoryResponse response);
        void onFabricHistory(FabricGraphResponse response);
        void onPaymentReceived(PaymentRecResponse response);
        void onPOdetails(PoDetailsresponse response);
        void onPOfabricList(PO_Fabric_Response response);
        void onPOleftovers(POleftOverResponse response);
        void onCheckIn(CheckInResponse response);
        void onCheckOut(CheckOutResponse response);
        void onSoldFabrics(SoldFabricsResponse response);
}
