package com.obpoo.gfsfabricsoftware.collections.datamodel;

public class UpdateInvoRequest {
    String method,id,supervisor,cashier,accsuper;

    public UpdateInvoRequest(String method, String id, String supervisor, String cashier, String accsuper) {
        this.method = method;
        this.id = id;
        this.supervisor = supervisor;
        this.cashier = cashier;
        this.accsuper = accsuper;
    }
}
