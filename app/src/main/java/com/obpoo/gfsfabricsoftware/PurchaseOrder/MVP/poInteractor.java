package com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PHD on 11/23/2018.
 */

public interface poInteractor {
    interface ViewPoResponse {
        void onViewSuccess(poPOJO response);

        void onViewError(String message);
    }

    void callRetroViewPO(String method, String page_no, ViewPoResponse response);
    void callPoOrder(String method, String from_date, String to_date, String page_no, ViewPoResponse response);
    void callPoPendingOrder(String method, ViewPoResponse response);


    interface AddPOResponse {
        void onAddPoSuccess(AddPoPojo response);

        void onAddError(String message);

    }

    void callRetroViewConfirmPO(String method, String page_no, ViewPoResponse response);

    interface ViewCPOResponse {
        void onAddCPoSuccess(ViewPoResponse response);

        void onAddError(String message);

    }

    void callRetroAddPO(String method, String factory_id, String staff_id, String cc_email,
                        String created_by, String updated_by, ArrayList<HashMap<String, String>> items, AddPOResponse response);

    interface ViewConfirmPOResponse {
        void onConfirmPOSuccess(ConfirmPOResponse response);

        void onConfirmPOError(String message);
    }

    void callConfirmPO(String method, String id, String status, String tag, ViewConfirmPOResponse response);

    interface TrackPOI{
        void onTrackPOSuccess(TrackPOByCusRes response);
        void onTrackPOError(String message);
    }
    void callRetroTrackPO(String user_id, String method, TrackPOI response);

    interface TrackPODetI{
        void onTrackPODetSuccess(TrackPODetRes response);
        void onTrackPODetError(String message);
    }
    void callRetroTrackPODet(String cid, String method, TrackPODetI response);
}
