package com.obpoo.gfsfabricsoftware.shelfbarcode.mvp;


import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeRequest;
import com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels.ShelfBarcodeResponse;


public class ShelfBarcodePresenterImpl implements ShelfBarcodePresenter, ShelfBarcodeInteracter.ShelfBarocdeListener {

    ShelfBarcodeView view;
    ShelfBarcodeInteracterImpl interacter;

    public ShelfBarcodePresenterImpl(ShelfBarcodeView view) {
        this.view = view;
        interacter = new ShelfBarcodeInteracterImpl();
    }



    @Override
    public void onSuccess(ShelfBarcodeResponse response) {
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
    public void viewShelf(String methodname, String scan_code) {
        ShelfBarcodeRequest request =new ShelfBarcodeRequest(methodname,scan_code);
        interacter.viewShopList(request,this);
    }
}
