package com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;

public interface ATinteractor {
    interface ATinterface{
        void ATsuccess(ATresponse response);
        void ATerror(String message);
    }
    void callRetroAT(String method, ATinterface response);

    interface AssociateActI{
        void associateActSuccess(AssociateActivity response);
        void associateActError(String message);
    }
    void callRetroAssoAct(String method,String ts_id,String activity,String status,AssociateActI response);

    interface FabricAssociation{
        void fabricAssocSuccess(AssoFabricResponse response);
        void fabricAssocFailure(String message);
    }
    void callRetroFabricAssoc(String method,FabricAssociation response);

    interface ChangeFabricURlINter{
        void changeFabricURlSuccess(AssociateFabricChangeURL response);
        void changeFabricURLerror(String message);
    }
    void callRetrochangeFabricURL(String method,ChangeFabricURlINter response);

    interface ChangeFabricStatus{
        void onChangeFabricStatusSuccess(AssociateFabircChangeRes response);
        void onChangeFabricStautserror(String message);
    }
    void callRetroFabricStatus(String method,String id,String action, String store_url,ChangeFabricStatus response);

    interface changeTailorRequestI{
        void tailorRequestSuccess(AssociateActivity response);
        void tailorRequestError(String message);
    }
    void callRetroTailorRequest(String method,String ts_id,String cod_status,String vat_status,
                                String credit_time,String credit_limit,String activity,changeTailorRequestI response);
}
