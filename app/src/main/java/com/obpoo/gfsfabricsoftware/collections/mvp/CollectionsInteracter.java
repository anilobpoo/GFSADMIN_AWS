package com.obpoo.gfsfabricsoftware.collections.mvp;


import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceRequest;
import com.obpoo.gfsfabricsoftware.collections.datamodel.UpdateInvoRequest;


public interface CollectionsInteracter {
    interface CollectionsListener {
        void onSuccess(CollectionsDResponse response);

        void onError(String message);
    }
    void  viewList(CollectionsDRequest request, CollectionsListener listener);

    interface InvoiceListener {
        void onInvoiceSuccess(CollectionInvoiceResponse response);

        void onInvoiceError(String message);
    }
    void  viewInvoiceList(InvoiceRequest request, InvoiceListener listener);
    void  updateInvoiceList(UpdateInvoRequest request, InvoiceListener listener);
}
