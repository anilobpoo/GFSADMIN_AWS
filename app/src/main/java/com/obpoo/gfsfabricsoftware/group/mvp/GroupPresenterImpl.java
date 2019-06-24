package com.obpoo.gfsfabricsoftware.group.mvp;


import com.obpoo.gfsfabricsoftware.group.datamodels.GroupRequest;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;

public class GroupPresenterImpl implements GroupPresenter, GroupInteracter.GroupListener {

    GroupView view;
    GroupInteracterImpl interacter;

    public GroupPresenterImpl(GroupView view) {
        this.view = view;
        interacter = new GroupInteracterImpl();
    }

    @Override
    public void onSuccess(GroupResponse response) {
        if (view != null) {
            view.hideDialog();
            view.onLoad(response);
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
    public void viewAll(String methodname,String admin_id) {

        GroupRequest request =new GroupRequest(methodname,admin_id);
        interacter.viewShopList(request,this);
    }

    @Override
    public void addAll(String methodname,String name, String discount_per,String admin_id) {

        GroupRequest request =new GroupRequest(methodname,name,discount_per,admin_id);
        interacter.viewShopList(request,this);
    }

    @Override
    public void updateAll(String id, String methodname, String name, String discount_per, String admin_id) {
        GroupRequest request =new GroupRequest(id,methodname,name,discount_per,admin_id);
        interacter.viewShopList(request,this);
    }

    @Override
    public void delete(String methodname, String id,String del) {
        GroupRequest request =new GroupRequest(methodname,id,del);
        interacter.viewShopList(request,this);

    }
}
