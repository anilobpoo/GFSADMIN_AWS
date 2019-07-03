package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;

import java.util.ArrayList;

public class ModifyPOReq {
    String method,id,po_no,factory_id,staff_id,cc_email,created_by,updated_by,notes;
    ArrayList<poItem> items;

    public ModifyPOReq(String method, String id, String po_no, String factory_id, String staff_id, String cc_email, String created_by, String updated_by, String notes, ArrayList<poItem> items) {
        this.method = method;
        this.id = id;
        this.po_no = po_no;
        this.factory_id = factory_id;
        this.staff_id = staff_id;
        this.cc_email = cc_email;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.notes = notes;
        this.items = items;
    }
}
