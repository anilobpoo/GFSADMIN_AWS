package com.obpoo.gfsfabricsoftware.user.mvp;

import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.utilities.ViewRequest;

public class UserPresenterImpl implements UserPresenter,UserInteractor.UserListener {


    UserView view;
    UserInteractorImpl interacter;


    public UserPresenterImpl(UserView view) {
        this.view = view;
        interacter = new UserInteractorImpl();
    }

    @Override
    public void onSuccess(UserResponse response) {

        if(view != null){
            view.hideDialog();
            view.viewUserList(response);
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


        ViewRequest request =new ViewRequest(methodname);
        interacter.viewUserList(request,this);
    }


}
