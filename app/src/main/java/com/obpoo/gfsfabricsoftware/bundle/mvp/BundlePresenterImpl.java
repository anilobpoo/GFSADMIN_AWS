package com.obpoo.gfsfabricsoftware.bundle.mvp;


import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleRequest;
import com.obpoo.gfsfabricsoftware.bundle.datamodels.BundleResponse;

public class BundlePresenterImpl implements BundlePresenter, BundleInteracter.BundleListener {

    BundleView view;
    BundleInteracterImpl interacter;

    public BundlePresenterImpl(BundleView view) {
        this.view = view;
        interacter = new BundleInteracterImpl();
    }



    @Override
    public void onSuccess(BundleResponse response) {
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
    public void viewAll(String methodname, String uniqueId) {
        BundleRequest request =new BundleRequest(methodname,uniqueId);
        interacter.viewShopList(request,this);
    }
}
