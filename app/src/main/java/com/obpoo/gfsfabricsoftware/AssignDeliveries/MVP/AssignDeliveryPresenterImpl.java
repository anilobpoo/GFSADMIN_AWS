package com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;

/**
 * Created by PHD on 1/3/2019.
 */

public class AssignDeliveryPresenterImpl implements AssignDeliveryPresenter,AssignDeliveryInteractor.ViewDeliveryResponse,
        AssignDeliveryInteractor.viewPgAll,AssignDeliveryInteractor.AssignPg{
    AssignDeliveryView adView;
    AssignDeliveryInteractorImpl interactor;

    public AssignDeliveryPresenterImpl(AssignDeliveryView adView) {

        this.adView = adView;
        interactor = new AssignDeliveryInteractorImpl();
    }

    @Override
    public void onViewDeliveries(String method) {
        if(adView!=null){
            adView.showDialog();
            interactor.callRetroDelivery(method,this);


        }

    }

    @Override
    public void onViewAllPg(String method) {
        interactor.callRetroPgAll(method,this);

    }

    @Override
    public void onAssignPg(String method, String pg_user_id, String oid) {
        interactor.callRetroAssignPg(method,pg_user_id,oid,this);

    }

    @Override
    public void onDeliverySuccess(DeliveryData response) {
        adView.onShowViewDeliveries(response);

    }

    @Override
    public void onDeliveryError(String message) {

    }

    @Override
    public void onPgAllSuccess(PGresponse response) {
        adView.onShowAllPGList(response);

    }

    @Override
    public void onPgError(String message) {

    }

    @Override
    public void onAssignPgSuccess(AssignPgResponse response) {
        adView.onShowAssignPg(response);

    }

    @Override
    public void onAssignPgError(String message) {

    }
}
