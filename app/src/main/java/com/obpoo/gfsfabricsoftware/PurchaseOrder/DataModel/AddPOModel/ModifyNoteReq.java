package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel;

public class ModifyNoteReq {
    String method,notes,id;

    public ModifyNoteReq(String method, String notes, String id) {
        this.method = method;
        this.notes = notes;
        this.id = id;
    }
}
