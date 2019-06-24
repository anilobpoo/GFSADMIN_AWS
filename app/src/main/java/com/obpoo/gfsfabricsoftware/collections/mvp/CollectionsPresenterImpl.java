package com.obpoo.gfsfabricsoftware.collections.mvp;


import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.UpdateInvoRequest;

public class CollectionsPresenterImpl implements CollectionsPresenter, CollectionsInteracter.CollectionsListener, CollectionsInteracter.InvoiceListener {
    CollectionsInteracterImpl interacter;
    CollectionsView view;

    public CollectionsPresenterImpl(CollectionsView view) {
        this.view = view;
        interacter = new CollectionsInteracterImpl();
    }


    @Override
    public void onSuccess(CollectionsDResponse response) {
        if (view != null) {
            view.hideDialog();
            view.onLoad(response);
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void view(String to_date, String from_date, String method, String[] previledges) {
        CollectionsDRequest request = new CollectionsDRequest(to_date, from_date, method, previledges);
        interacter.viewList(request, this);
    }

    @Override
    public void viewInvoice(String date, String method, String pg_id) {

        InvoiceRequest request = new InvoiceRequest(date, method, pg_id);
        interacter.viewInvoiceList(request, this);

    }

    @Override
    public void updateInvoice(String method, String id, String supervisor, String cashier, String accsuper) {
        UpdateInvoRequest request = new UpdateInvoRequest(method, id, supervisor, cashier, accsuper);
        interacter.updateInvoiceList(request, this);
    }

    @Override
    public void onInvoiceSuccess(CollectionInvoiceResponse response) {
        if (view != null) {
            view.hideDialog();
            view.onInvoiceLoad(response);
        }
    }

    @Override
    public void onInvoiceError(String message) {

    }
}

