package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 11/23/2018.
 */

public interface PoView extends BaseView {
    void onShowViewPO(poPOJO response);
    void onShowAddPO(AddPoPojo response);         // for both modify and create PO
    void onConfirmPO(ConfirmPOResponse response);
    void  onValidationfail(int type);
    void onTrackPObyCustomer(TrackPOByCusRes response);
    void onTrackPOdetails(TrackPODetRes response);
    void onModifyNotes(ModifyNotes response);
    void onShowFilter(PoFilterResponse response);

}
