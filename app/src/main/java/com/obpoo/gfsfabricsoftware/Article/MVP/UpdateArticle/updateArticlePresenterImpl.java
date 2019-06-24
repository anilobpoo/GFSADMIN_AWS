package com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle;

import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse;

/**
 * Created by PHD on 11/16/2018.
 */

public class updateArticlePresenterImpl implements updateArticlePresenter, updateArticleInteractor.updateArticleListener {

    com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle.updateArticleView updateArticleView;
    updateArticleInteractorImpl interactor;

    public updateArticlePresenterImpl(com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle.updateArticleView updateArticleView) {
        this.updateArticleView = updateArticleView;
        this.interactor = new updateArticleInteractorImpl();
    }

    @Override

    public void sendRequest(String method,String articleId, String articleNo, String note, String ft, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs,
                            String price1to9mtrs, String price10plusmtrs, String composition, String occassion) {
        if(updateArticleView!=null){
            if(articleNo.length()==0){
                updateArticleView.onValidate(1);
            }
            else if(note.length()==0){
                updateArticleView.onValidate(2);
            }
            else {
                updateArticleView.showDialog();
                interactor.updateArticleFN(method,articleId,articleNo,note,ft,pricefullroll,price1to9,price10plus,pricefullrollmtrs,price1to9mtrs,
                        price10plusmtrs,composition,occassion,this);
            }
        }


    }

    @Override
    public void onSuccess(updateArticleResponse response) {
        if(updateArticleView!=null){
            updateArticleView.hideDialog();
            updateArticleView.onUpdateArticle(response);
        }


    }

    @Override
    public void onFailure(String message) {

    }
}
