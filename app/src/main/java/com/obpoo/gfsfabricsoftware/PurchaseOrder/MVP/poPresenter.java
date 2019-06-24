package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

        import java.util.ArrayList;
        import java.util.HashMap;

/**
 * Created by PHD on 11/23/2018.
 */

public interface poPresenter {
    void OnViewPO(String method, String page_no);

    void OnAddPO(String method, String factory_id, String staff_id, String cc_email, String brand_name, String created_by, String updated_by, ArrayList<HashMap<String, String>> items);

    void OnConfirmPO(String method, String id, String ststus,String tag);
    void viewPOOrder(String method, String from_date, String to_date,String page_no);
    void onTrackPO(String user_id,String method);
    void onTrackPODet(String cid,String method);
}
