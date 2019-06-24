package com.obpoo.gfsfabricsoftware.bank.datamodels;

public class BankRequest {


    String method;

    String id,bankname;

    public BankRequest(String method) {
        this.method = method;
    }
    public BankRequest(String method,String id) {
        this.method = method;
        this.id = id;
    }
    public BankRequest(String method,String bankname,String id) {
        this.method = method;
        this.id = id;
        this.bankname = bankname;
    }
    public BankRequest(String method,String bankname,String add,String adds) {
        this.method = method;
        this.bankname = bankname;
    }
}
