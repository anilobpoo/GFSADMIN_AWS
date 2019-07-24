package com.obpoo.gfsfabricsoftware.TransferStock.MVP;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 2/7/2019.
 */

public interface TsPresenter {
    void onGetPendingOrderId(String method);
    void onGetFabricPendingOID(String method,String id);
    void onTransfer(ArrayList<String> all_id, ArrayList<String> cqty, String method, String customer_id, String group_id,
                    String discount, String Dellivery_address, String credit_time, String vat_enabled,
                    String pay_mode, String delivery_type, String order_type, String order_total,
                    String order_by, String vat_amount, String payble_amount,  ArrayList<HashMap<String, String>> items);
    void onTransferWare(ArrayList<String> all_id,String warehouse,String method);
    void onTransferWare_Ware(String method, String id);
    void onPassWare_ware(String warehouse_to,String id,String method);
    void onTransferParameters(String method,String from_date,String to_date,String page_no,String document);
    void onTransferStockOutPara(String method,ArrayList<String> ids);
    void onViewStockDoc(String method);
    void onViewSelectDoc(String method,String id);

}
