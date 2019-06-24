package com.obpoo.gfsfabricsoftware.Stock.DataModel;

import java.util.ArrayList;

/**
 * Created by PHD on 2/13/2019.
 */

public class RequestObjectCustomerAddReserve {
    String customer,fab_name;
    ArrayList<String> unicode = new ArrayList<>();
    ArrayList<String> remain= new ArrayList<>();

    public RequestObjectCustomerAddReserve(String customer, String fab_name, ArrayList<String> unicode, ArrayList<String> remain) {
        this.customer = customer;
        this.fab_name = fab_name;
        this.unicode = unicode;
        this.remain = remain;
    }
}
