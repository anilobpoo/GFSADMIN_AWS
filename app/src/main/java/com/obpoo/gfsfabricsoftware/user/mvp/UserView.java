package com.obpoo.gfsfabricsoftware.user.mvp;

import com.obpoo.gfsfabricsoftware.mvp.BaseView;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;

public interface UserView extends BaseView {
    void onValidationFail(int type);

    void viewUserList(UserResponse response);



}
