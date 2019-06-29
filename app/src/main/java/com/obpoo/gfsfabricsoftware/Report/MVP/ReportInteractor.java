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
import com.obpoo.gfsfabricsoftware.Report.DataModel.poDetails.PoRDetailRequest;

/**
 * Created by PHD on 2/18/2019.
 */

public interface ReportInteractor {
    interface Build_Invoice_Response_Interface{
        void onBuildInvoiceSuccess(Bill_Invoice_Response_data response);
        void onBuildInvoiceError(String message);
    }
    void onCallRetroBuildInvoiceReport(String method,String from, String to, Build_Invoice_Response_Interface response);

    interface Customer_Pending_Response_Interface{
        void onCustomerPendingSuccess(CustomerPendingResponse response);
        void onCustomerPendingError(String message);
    }
    void onCallRetroCustomerPending(String method,String customer_id,Customer_Pending_Response_Interface response);

    interface CutStock_Response_Interface{
        void onCutStockSuccess(CutStockResponse response);
        void onCutStockError(String message);
    }
    void onCallRetorCutStock(String method,String from,String to,CutStock_Response_Interface response);

    interface FabricAnalytics_Interface{
        void onFabricAnalySuccess(FabricAnalyticsResponse response);
        void onFabricAnalyError(String message);
    }
    void onCallRetroFabricAnalytics(String method,String from,String to,FabricAnalytics_Interface response);

    interface FabricNames{
        void onFabricNamesSuccess(FabricHistoryResponse resposne);
        void onFabricNamesError(String message);
    }
    void onCallFabricNames(String method,FabricNames response);

    interface FabricGraphHistory{
        void onFabricHistorySuccess(FabricGraphResponse response);
        void onFabricHistoryError(String message);
    }
    void onCallRetroFabricGraphHistore(String method, String fab_name, FabricGraphHistory response);

    interface PaymentReceived{
        void onPaymentReceivedSuccess(PaymentRecResponse response);
        void onPaymentReceivedError(String message);
    }
    void onCallRetroPaymnetReceived(String method,String from,String to,PaymentReceived response);

    interface PoDetails{
        void onPoDetailsSuccess(PoDetailsresponse response);
        void onPoDetailsError(String message);
    }
    void onCallRetroPoDetails(String method ,PoDetails response);
    void onCallRetroPoDetailsView(PoRDetailRequest request , PoDetails response);

    interface PO_FABRIC_LIST{
        void onPOFabricListSuccess(PO_Fabric_Response response);
        void onPOFabricListError(String message);
    }
    void onCallRetroPOFabricList(String method,String from, String to, PO_FABRIC_LIST response);

    interface PO_Left_Over{
        void onPOleftOVerSuccess(POleftOverResponse response);
        void onPoLeftOVerError(String message);
    }
    void onCallRetroPOLeftOver(String method,String from_date,String to_date,PO_Left_Over response );

    interface PO_Check_IN{
        void onCheckINSuccess(CheckInResponse response);
        void onCheckINError(String message);
    }
    void onCallRetroCheckIN(String method,String from_date,String to_date,PO_Check_IN response);


    interface PO_Check_OUT{
        void onCheckIOUTSuccess(CheckOutResponse response);
        void onCheckOUTError(String message);
    }
    void onCallRetroCheckOUT(String method,String from_date,String to_date,PO_Check_OUT response);

    interface Sold_Fabric{
        void onSoldFabricSuccess(SoldFabricsResponse response);
        void onSoldfabricError(String message);
    }
    void onCallRetroSoldFabric(String method,String from, String to,Sold_Fabric response);

    interface Item_SalesI{
        void itemSalesSuccess(SoldFabricsResponse response);
        void itemSalesError(String message);
    }

    void onCallItemSales(String status,String from,String method,String to,String page_no,Item_SalesI response );

}
