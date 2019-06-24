package com.obpoo.gfsfabricsoftware.Composition.mvp;


import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ViewCompositionRequest;

public class CompositionPresenterImpl implements CompositionPresenter,CompositionInteractor.CompositionListener {


    CompositionView view;
    CompositionInteractorImpl interacter;


    public CompositionPresenterImpl(CompositionView view) {
        this.view = view;
        interacter = new CompositionInteractorImpl();
    }

    @Override
    public void onSuccess(CompositionResponse response) {

        if(view != null){
            view.hideDialog();
            view.viewCompositionList(response);
        }

    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.hideDialog();
            view.showError(message);
        }
    }

    @Override
    public void validate(String name, String description) {

    }

    @Override
    public void viewAll(String methodname) {


        ViewCompositionRequest request =new ViewCompositionRequest(methodname);
        interacter.viewCompositionList(request,this);
    }


}
