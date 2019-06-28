package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 11/23/2018.
 */

public interface PoPresenter {
    void OnViewPO(String method, String page_no);

    void OnAddPO(String method, String factory_id, String staff_id, String cc_email, String brand_name, String created_by, String updated_by, ArrayList<poItem> items);

    void OnConfirmPO(String method, String id, String ststus, String tag);
    void viewPOOrder(String method, String from_date, String to_date, String page_no);
    void viewPOPendingOrder(String method);
    void onTrackPO(String user_id, String method);
    void onTrackPODet(String cid, String method);
    void onPassModifyNotes(String method,String notes,String id);
    void onVIewFilter(String method);
    void onVIewSelectFilter(String method,String status,String page_no);
    void onSearchPo(String method,String po_no,String page_no);
}
