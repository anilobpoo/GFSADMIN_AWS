package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.addCagPOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticleDATA;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.UpdateSMGmodel;

import java.util.List;

/**
 * Created by PHD on 11/20/2018.
 */

public class AddCmgPresenterImpl implements AddCmgPresenter,AddCmgInteractorImpl.AddCmgResponse,AddCmgInteractorImpl.AddSimilarGroup,AddCmgInteractorImpl.UpdateSimilarGroup {
    AddCmgView addCmgView;
    AddCmgInteractorImpl addCmgInteractor;

    public AddCmgPresenterImpl(AddCmgView addCmgView) {
        this.addCmgView = addCmgView;
        addCmgInteractor = new AddCmgInteractorImpl();
    }

    @Override
    public void showColorsForCMNArtGroup(String method) {
        addCmgInteractor.callAddCmg(method,this);

    }

    @Override
    public void addCmnAddArticleGroup(String method, String groupname, List<String> ArticlegrpList, String QDesc, String QName) {
        if(addCmgView!=null){
            if(groupname.length()==0){
                addCmgView.onValidationFail(0);
            }
            else if(QName.length()==0){
                addCmgView.onValidationFail(2);
            }
            else if(QDesc.length()==0){
                addCmgView.onValidationFail(1);
            }
            else if(ArticlegrpList == null){
                addCmgView.onValidationFail(3);
            }
            else{
                addCmgView.showDialog();
                addCmgInteractor.CallAddSimilarGroup(method,groupname,ArticlegrpList,QDesc,QName,this);
            }

        }



    }

    @Override
    public void updateCmdArticleGroup(String method,String id, String groupname, List<String> ArticlegrpList, String QDesc, String QName) {
        if(addCmgView!=null){
            if(groupname.length()==0){
                addCmgView.onValidationFail(0);
            }
            else if(QName.length()==0){
                addCmgView.onValidationFail(2);
            }
            else if(QDesc.length()==0){
                addCmgView.onValidationFail(1);
            }
            else if(ArticlegrpList.size()==0){
                addCmgView.onValidationFail(3);
            }
            else{
                addCmgView.showDialog();
                addCmgInteractor.CallUpdateSimilarGroup(method,id,groupname,ArticlegrpList,QDesc,QName,this);
            }

        }


    }



    @Override
    public void onGetAddCmgResponse(addCagPOJO response) {
        addCmgView.onShowADDCMGVIEW(response);


    }

    @Override
    public void onGetAddCmgError(String message) {

    }



    @Override
    public void onGetAddSimilarGroupResponse(similarArticleDATA response) {
        if(addCmgView!=null){
            addCmgView.hideDialog();
            addCmgView.onShowSimilarArticleAdded(response);
        }



    }

    @Override
    public void onGetAddSimilarGroupError(String message) {

    }

    @Override
    public void onGetUpdateSimilarGroupResponse(UpdateSMGmodel response) {
        if(addCmgView!=null){
            addCmgView.hideDialog();
            addCmgView.onShowSimilarArticleupdate(response);
        }


    }

    @Override
    public void onGetUpdateSimilarGroupError(String message) {

    }
}
