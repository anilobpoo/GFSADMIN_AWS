package com.obpoo.gfsfabricsoftware.Stock.DataModel;

/**
 * Created by PHD on 2/13/2019.
 */

public class AddReserveCustomerRequest {
    String method;
    RequestObjectCustomerAddReserve alldata;

    public AddReserveCustomerRequest(String method, RequestObjectCustomerAddReserve alldata) {
        this.method = method;
        this.alldata = alldata;
    }
}
