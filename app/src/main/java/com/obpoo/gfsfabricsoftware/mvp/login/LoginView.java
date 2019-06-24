package com.obpoo.gfsfabricsoftware.mvp.login;


import com.obpoo.gfsfabricsoftware.others.datamodels.login.LoginResponse;
import com.obpoo.gfsfabricsoftware.utilities.BaseView;

public interface LoginView extends BaseView {
    void onValidationFail(int type);

    void onLogin(LoginResponse response);
}
