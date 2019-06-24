package com.obpoo.gfsfabricsoftware.group.mvp;


import com.obpoo.gfsfabricsoftware.group.datamodels.GroupRequest;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;

public interface GroupInteracter {
    interface GroupListener {
        void onSuccess(GroupResponse response);

        void onError(String message);
    }

    void  viewShopList(GroupRequest request, GroupInteracter.GroupListener listener);




}
