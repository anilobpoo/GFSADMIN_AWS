package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;

/**
 * Created by PHD on 11/19/2018.
 */

public class cmnArtPresenterImpl implements cmnArtPresenter,cmnArtInteractor.cmnArtGroupResponse,cmnArtInteractor.deleteCmnArtGroupResponse {
    com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtView cmnArtView;
    cmnArtInteractorImpl interactor;

    public cmnArtPresenterImpl(com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtView cmnArtView) {
        this.cmnArtView = cmnArtView;
        interactor = new cmnArtInteractorImpl();
    }

    @Override
    public void showCmnArticleGroup(String method) {
        if(cmnArtView!=null){
        cmnArtView.showDialog();
        interactor.CallcmnArtGroupResponse(method,this);}

    }

    @Override
    public void deleteCmnArtGroup(String method, String id) {
        System.out.println("one");
        interactor.calldeleteCmnArtGroupResponse(method,id,this);


    }


    @Override
    public void onGetcmnArtGroupResponse(cmnArticlePOJO response) {
        if(cmnArtView!=null){
            cmnArtView.hideDialog();
            cmnArtView.onShowCmnArtGroup(response);
        }




    }

    @Override
    public void onGetcmnArtGroupError(String message) {

    }

    @Override
    public void onGetdeleteCmnArtGroupResponse(cmnArtdeletePOJO response) {
        System.out.println("three");
        cmnArtView.ondeleteCmnArtGroup(response);

    }

    @Override
    public void onGetdeleteCmnArtGroupError(String message) {

    }
}
