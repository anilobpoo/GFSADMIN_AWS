package com.obpoo.gfsfabricsoftware.collections.datamodel;

public class InvoiceRequest {
    String date,method,pg_id;

    public InvoiceRequest(String date, String method, String pg_id) {
        this.date = date;
        this.method = method;
        this.pg_id = pg_id;
    }
}
