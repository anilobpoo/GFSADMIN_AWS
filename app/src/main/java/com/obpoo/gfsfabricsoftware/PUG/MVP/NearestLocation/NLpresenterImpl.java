package com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation;

import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;

/**
 * Created by PHD on 12/7/2018.
 */

public class NLpresenterImpl implements NLPresenter,NLinteractor.GetNLResponse{
    NLView nlView;
    NLinteractorImpl interactor;

    public NLpresenterImpl(NLView nlView) {
        this.nlView = nlView;
        interactor = new NLinteractorImpl();
    }

    @Override
    public void onGetNLlatLng(String method) {
        if(nlView!=null){
            nlView.showDialog();
        interactor.callRetroNL(method,this);}

    }

    @Override
    public void onGetNLSuccess(NLData response) {
        if(nlView!=null){
            nlView.hideDialog();
        nlView.onGetNLResponse(response);}
    }

    @Override
    public void onGetNLerror(String message) {

    }
}
