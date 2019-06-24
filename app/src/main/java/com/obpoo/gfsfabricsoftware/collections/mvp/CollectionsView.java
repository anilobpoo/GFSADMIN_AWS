package com.obpoo.gfsfabricsoftware.collections.mvp;



import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;


public interface CollectionsView extends BaseView {
    void onValidationFail(int type);

    void onLoad(CollectionsDResponse response);
    void onInvoiceLoad(CollectionInvoiceResponse response);
    void onDepositeLoad(DepositeResponse response);
}

