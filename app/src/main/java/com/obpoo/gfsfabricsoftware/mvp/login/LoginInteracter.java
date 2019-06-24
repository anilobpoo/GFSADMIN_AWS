package com.obpoo.gfsfabricsoftware.mvp.login;


import com.obpoo.gfsfabricsoftware.others.datamodels.login.LoginResponse;

public interface LoginInteracter {
    interface LoginListener {
        void onSuccess(LoginResponse response);

        void onError(String message);
    }

    void login(String userName, String password, LoginListener listener);
}
