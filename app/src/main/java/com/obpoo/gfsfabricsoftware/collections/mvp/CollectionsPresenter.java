package com.obpoo.gfsfabricsoftware.collections.mvp;

public interface CollectionsPresenter {

    void view(String to_date, String from_date, String method, String[] previledges);
    void viewInvoice(String date, String method, String pg_id);
    void updateInvoice(String method, String id, String supervisor, String cashier, String accsuper);
}
