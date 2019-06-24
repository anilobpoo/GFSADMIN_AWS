package com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model;

/**
 * Created by PHD on 2/19/2019.
 */

public class CustomerPendingRequest {
    String method,customer_id;

    public CustomerPendingRequest(String method, String customer_id) {
        this.method = method;
        this.customer_id = customer_id;
    }
}
