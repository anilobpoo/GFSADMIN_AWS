package com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel;

public class TailorChangeRequest {
    String method,ts_id,cod_status,vat_status,credit_time,credit_limit,activity;

    public TailorChangeRequest(String method, String ts_id, String cod_status, String vat_status, String credit_time, String credit_limit, String activity) {
        this.method = method;
        this.ts_id = ts_id;
        this.cod_status = cod_status;
        this.vat_status = vat_status;
        this.credit_time = credit_time;
        this.credit_limit = credit_limit;
        this.activity = activity;
    }
}
