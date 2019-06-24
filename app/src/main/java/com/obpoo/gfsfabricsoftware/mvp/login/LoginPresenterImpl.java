package com.obpoo.gfsfabricsoftware.mvp.login;

import com.obpoo.gfsfabricsoftware.others.datamodels.login.LoginResponse;

public class LoginPresenterImpl implements LoginPresenter, LoginInteracter.LoginListener {

    LoginView view;
    LoginInteracterImpl interacter;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interacter = new LoginInteracterImpl();
    }

    @Override
    public void validate(String userName, String password) {
        if (userName.isEmpty()) {
            view.onValidationFail(1);
        } else if (password.length() < 5) {
            view.onValidationFail(2);
        } else {
            view.showDialog();
            interacter.login(userName, password, this);
        }
    }

    @Override
    public void onSuccess(LoginResponse response) {
        if (view != null) {
            view.hideDialog();
            view.onLogin(response);
        }
    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.hideDialog();
            view.showError(message);
        }
    }
}
