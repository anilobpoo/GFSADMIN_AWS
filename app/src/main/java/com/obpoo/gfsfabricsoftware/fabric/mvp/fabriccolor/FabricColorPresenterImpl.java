package com.obpoo.gfsfabricsoftware.fabric.mvp.fabriccolor;


import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorRequest;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorResponse;

public class FabricColorPresenterImpl implements FabricColorPresenter, FabricColorInteracter.FabricColorListener {

    FabricColorView view;
    FabricColorInteracterImpl interacter;

    public FabricColorPresenterImpl(FabricColorView view) {
        this.view = view;
        interacter = new FabricColorInteracterImpl();
    }



    @Override
    public void onSuccess(FabricColorResponse response) {
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
    public void viewAll(String methodname) {
        FabricColorRequest request =new FabricColorRequest(methodname);
        interacter.viewShopList(request,this);
    }
}
