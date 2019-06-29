package com.obpoo.gfsfabricsoftware.Report.MVP;

/**
 * Created by PHD on 2/18/2019.
 */

public interface ReportPresenter {
    void onSend_Bill_Invoice_Report(String method,String from, String to);
    void onSend_Customer_Pending_report(String method,String customer_id);
    void onSend_CutStock(String method,String from,String to);
    void onSend_FabricAnalytics(String method,String from,String to);
    void onSend_FabricNames(String method);
    void onSend_FabricGraphHistory(String method, String fab_name);
    void onSend_PaymentReceived(String method,String from,String to );
    void onSend_PoDetails(String method);
    void onSend_PO_Fabric_List(String method,String from, String to);
    void onSend_PO_LeftOvers(String method,String from_date,String to_date);
    void onSend_PO_checkIN(String method,String from_date,String to_date);
    void onSend_PO_checkOUT(String method,String from_date,String to_date);
    void onSend_Sold_Fabric(String method,String from, String to);
    void onSend_item_easy_report(String status,String from,String method,String to,String page_no );
    void onSend_PO_Detail(String method,String status,String to,String from,String page_no );

}
