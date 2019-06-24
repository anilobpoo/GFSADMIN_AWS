package com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;

public class ATpresenterImpl implements ATpresenter,ATinteractorImpl.ATinterface,
        ATinteractorImpl.AssociateActI,ATinteractorImpl.FabricAssociation,
        ATinteractorImpl.ChangeFabricURlINter,ATinteractorImpl.ChangeFabricStatus,ATinteractorImpl.changeTailorRequestI {
    ATinteractorImpl interactor;
    ATview aTview;

    public ATpresenterImpl(ATview aTview) {
        this.aTview = aTview;
        interactor = new ATinteractorImpl();
    }

    @Override
    public void sendATrequest(String method) {
        aTview.showDialog();
        interactor.callRetroAT(method,this);

    }

    @Override
    public void sendAssociateActivity(String method, String ts_id, String activity, String status) {
        interactor.callRetroAssoAct(method,ts_id,activity,status,this);
    }

    @Override
    public void sendAssoFabrics(String method) {
        aTview.showDialog();
        interactor.callRetroFabricAssoc(method,this);

    }

    @Override
    public void sendFabChangeURL(String method) {
        interactor.callRetrochangeFabricURL(method,this);

    }

    @Override
    public void sendFabChangeStatus(String method, String id, String action, String store_url) {
        interactor.callRetroFabricStatus(method,id,action,store_url,this);

    }

    @Override
    public void sendChangeTailorRequest(String method, String ts_id, String cod_status, String vat_status, String credit_time, String credit_limit, String activity) {
            interactor.callRetroTailorRequest(method,ts_id,cod_status,vat_status,credit_time,credit_limit,activity,this);
    }

    @Override
    public void ATsuccess(ATresponse response) {
        aTview.hideDialog();
        aTview.ATretriveData(response);

    }

    @Override
    public void ATerror(String message) {

    }

    @Override
    public void associateActSuccess(AssociateActivity response) {
        aTview.associateActicity(response);

    }

    @Override
    public void associateActError(String message) {

    }

    @Override
    public void fabricAssocSuccess(AssoFabricResponse response) {
        aTview.hideDialog();
        aTview.assoFabrics(response);

    }

    @Override
    public void fabricAssocFailure(String message) {

    }

    @Override
    public void changeFabricURlSuccess(AssociateFabricChangeURL response) {
        aTview.changeFabURL(response);

    }

    @Override
    public void changeFabricURLerror(String message) {

    }

    @Override
    public void onChangeFabricStatusSuccess(AssociateFabircChangeRes response) {
        aTview.changeFabricStatus(response);

    }

    @Override
    public void onChangeFabricStautserror(String message) {

    }

    @Override
    public void tailorRequestSuccess(AssociateActivity response) {
        aTview.changeTailorRequest(response);

    }

    @Override
    public void tailorRequestError(String message) {

    }
}
