package com.obpoo.gfsfabricsoftware.TransferStock.DataModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 2/11/2019.
 */

public class TransferRequest {
   java.util.ArrayList<String> all_id;
   ArrayList<String> cqty;
   String method, customer_id,  group_id,  discount,  Dellivery_address,  credit_time,  vat_enabled,  pay_mode,  delivery_type,  order_type,  order_total,  order_by,  vat_amount,  payble_amount;
    ArrayList<HashMap<String, String>> items;

    public TransferRequest(ArrayList<String> all_id, ArrayList<String> cqty, String method, String customer_id, String group_id, String discount, String dellivery_address, String credit_time, String vat_enabled, String pay_mode, String delivery_type, String order_type, String order_total, String order_by, String vat_amount, String payble_amount,  ArrayList<HashMap<String, String>> items) {
        this.all_id = all_id;
        this.cqty = cqty;
        this.method = method;
        this.customer_id = customer_id;
        this.group_id = group_id;
        this.discount = discount;
        Dellivery_address = dellivery_address;
        this.credit_time = credit_time;
        this.vat_enabled = vat_enabled;
        this.pay_mode = pay_mode;
        this.delivery_type = delivery_type;
        this.order_type = order_type;
        this.order_total = order_total;
        this.order_by = order_by;
        this.vat_amount = vat_amount;
        this.payble_amount = payble_amount;
        this.items = items;
    }
}
