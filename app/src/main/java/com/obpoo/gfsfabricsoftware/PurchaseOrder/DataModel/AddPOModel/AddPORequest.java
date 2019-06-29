package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 11/27/2018.
 */

public class AddPORequest {
    String method;
    String factory_id;
    String staff_id;
    String cc_email;
    String brand_name;
    String created_by;
    String updated_by;
    ArrayList<poItem> items;
    String notes;

    public AddPORequest(String method, String factory_id, String staff_id, String cc_email
                        , String created_by, String updated_by,  ArrayList<poItem> items,String notes) {
        this.method = method;
        this.factory_id = factory_id;
        this.staff_id = staff_id;
        this.cc_email = cc_email;
        this.brand_name = brand_name;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.items = items;
        this.notes=notes;
    }


}
