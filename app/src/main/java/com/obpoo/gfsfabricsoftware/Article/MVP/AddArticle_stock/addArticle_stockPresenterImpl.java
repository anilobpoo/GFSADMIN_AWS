package com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock;

import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleResponse;

/**
 * Created by obpoo on 11/16/2018.
 */

public class addArticle_stockPresenterImpl implements addArticle_stockPresenter,addArticle_stockInteractor.addArticleListener {
    AddArticleView addStockArticleView;
    addArticle_stockInteractorImpl interactor;

    public addArticle_stockPresenterImpl(AddArticleView addStockArticleView) {
        this.addStockArticleView = addStockArticleView;
        interactor = new addArticle_stockInteractorImpl();
    }

    @Override
    public void sendrequest(String method,String aNo,String note, String FT, String occasion, String compassion,
                            String fullYards, String _9yards, String _10Yards, String fullMtrs, String _9Mtrs, String _10Mtrs) {
        if(addStockArticleView!=null){
            if(aNo.length()==0){
                addStockArticleView.onValidationFail(1);
            }
            else if(note.length()==0){
                addStockArticleView.onValidationFail(2);
            }
            else if(FT.length()==0){
                addStockArticleView.onValidationFail(3);
            }
            else{
                addStockArticleView.showDialog();
                interactor.AddArticleFN(method,aNo,note,FT,occasion,compassion,fullYards,_9yards,_10Yards,fullMtrs,_9Mtrs,_10Mtrs,this);
            }
        }


    }



    @Override
    public void onSuccess(AddArticleResponse response) {
        if(addStockArticleView!=null){
            addStockArticleView.hideDialog();
            addStockArticleView.onGetAddArticleInsertMsg(response);

        }


    }

    @Override
    public void onFailure(String message) {

    }
}
