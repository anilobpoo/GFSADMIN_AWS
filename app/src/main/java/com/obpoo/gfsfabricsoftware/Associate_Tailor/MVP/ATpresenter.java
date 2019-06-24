package com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP;

public interface ATpresenter {
    void sendATrequest(String method);
    void sendAssociateActivity(String method,String ts_id,String activity,String status);
    void sendAssoFabrics(String method);
    void sendFabChangeURL(String method);
    void sendFabChangeStatus(String method,String id,String action, String store_url);
    void sendChangeTailorRequest(String method,String ts_id,String cod_status,String vat_status,String credit_time,String credit_limit,String activity);
}
