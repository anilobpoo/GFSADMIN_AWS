package com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived;

/**
 * Created by PHD on 2/21/2019.
 */

public class PaymentReceivedRequest {
    String method,from_date,to_date;

    public PaymentReceivedRequest(String method, String from_date, String to_date) {
        this.method = method;
        this.from_date = from_date;
        this.to_date = to_date;
    }
}
