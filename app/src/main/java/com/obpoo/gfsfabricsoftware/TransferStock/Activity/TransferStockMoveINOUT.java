package com.obpoo.gfsfabricsoftware.TransferStock.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.TransferStockAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_data;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransferStockMoveINOUT extends BaseActivity implements TsView {
    TsPresenterImpl presenter;
    @BindView(R.id.rv_ts_fab)
    RecyclerView rv_ts_fab;
    String getSelctedMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_stock_move_inout);
        getSelctedMenu=getIntent().getStringExtra("getSelectedTransferVal");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSelctedMenu.equals(AppConstants.tran_stock)){
        toolbar.setTitle(AppConstants.tran_stock);}
        if(getSelctedMenu.equals(AppConstants.tran_stockIn)){
            toolbar.setTitle(AppConstants.tran_stockIn);
        }

        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter =new TsPresenterImpl(this);

        if(getSelctedMenu.equals(AppConstants.tran_stock)){
        presenter.onTransferParameters("stock_documents");
        }
        if(getSelctedMenu.equals(AppConstants.tran_stockIn)){
            presenter.onTransferParameters("transfered_stock_documents");
        }

    }

    @Override
    public void onGetPendingOrderIdResponse(PendingOrderRes response) {

    }

    @Override
    public void onGetFabricPendingRes(FabricPendingOIDRes response) {

    }

    @Override
    public void onTranferFabric(TransferResponse response) {

    }

    @Override
    public void onTransferWare(TransferWareWareRes response) {

    }

    @Override
    public void onPassWare(TransferResponse response) {

    }

    @Override
    public void onTransfer(Ts_Response response) {
        Log.i("TS_Transfer",response.getMessage());
        ArrayList<Ts_data> ts_dataArrayList = response.getData();
        TransferStockAdp adapter = new TransferStockAdp(ts_dataArrayList,TransferStockMoveINOUT.this,getSelctedMenu);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_ts_fab.setLayoutManager(lm);
        rv_ts_fab.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onTransferStockOut(TransferResponse response) {

    }

    @Override
    public void onStockDocView(StockDocumentResponse response) {

    }
}
