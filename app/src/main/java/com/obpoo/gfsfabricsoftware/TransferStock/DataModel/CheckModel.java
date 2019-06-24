package com.obpoo.gfsfabricsoftware.TransferStock.DataModel;

/**
 * Created by PHD on 2/11/2019.
 */

public class CheckModel {
    String id,oid,fab_id,qty_final,created_on,status,factory_id,fab_name,fab_img,sell_pr_mtr,po_satatus,vendor,country,cQty;
    Integer pos;
    boolean isSelected;

    public String getcQty() {
        return cQty;
    }

    public CheckModel(Integer pos, boolean isSelected, String id, String oid, String fab_id, String qty_final, String created_on, String status, String factory_id, String fab_name, String fab_img, String sell_pr_mtr, String po_satatus, String vendor, String country, String cQty) {
        this.id = id;
        this.oid = oid;
        this.fab_id = fab_id;
        this.qty_final = qty_final;
        this.created_on = created_on;
        this.status = status;
        this.factory_id = factory_id;

        this.fab_name = fab_name;
        this.fab_img = fab_img;
        this.sell_pr_mtr = sell_pr_mtr;
        this.po_satatus = po_satatus;
        this.vendor = vendor;
        this.country = country;
        this.pos=pos;
        this.isSelected = isSelected;
        this.cQty = cQty;

    }

    public String getId() {
        return id;
    }

    public String getOid() {
        return oid;
    }

    public String getFab_id() {
        return fab_id;
    }

    public String getQty_final() {
        return qty_final;
    }

    public String getCreated_on() {
        return created_on;
    }

    public String getStatus() {
        return status;
    }

    public String getFactory_id() {
        return factory_id;
    }

    public String getFab_name() {
        return fab_name;
    }

    public Integer getPos() {
        return pos;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getFab_img() {
        return fab_img;

    }

    public String getSell_pr_mtr() {
        return sell_pr_mtr;
    }

    public String getPo_satatus() {
        return po_satatus;
    }

    public String getVendor() {
        return vendor;
    }

    public String getCountry() {
        return country;
    }
}
