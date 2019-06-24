package com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model;

/**
 * Created by PHD on 2/18/2019.
 */

public class Bill_Invoice_Report_request {
    String method, from,  to;

    public Bill_Invoice_Report_request(String method, String from, String to) {
        this.method = method;
        this.from = from;
        this.to = to;
    }
}
