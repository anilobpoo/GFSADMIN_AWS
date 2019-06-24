package com.obpoo.gfsfabricsoftware.user.mvp;


import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.utilities.ViewRequest;

public interface UserInteractor {

    interface  UserListener{
        void onSuccess(UserResponse response);

        void onError(String message);
    }

    void addcomposition(String name, String description, UserListener listener);

    void  viewUserList(ViewRequest request, UserListener listener);
}
