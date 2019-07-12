package com.obpoo.gfsfabricsoftware.TransferStock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.TsMenuAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class TransferStockAct extends BaseActivity  {
    @BindView(R.id.ts_main_spinner)
    Spinner ts_main_spinner;
    @BindView(R.id.rv_ts_menu)
    RecyclerView rv_ts_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_stock);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Transfer Stock");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        ArrayList<String> main_transfer_spin = new ArrayList<>();
        // main_transfer_spin.add("Select Transfer Stock");
        main_transfer_spin.add(AppConstants.tran_stock);
        main_transfer_spin.add(AppConstants.tran_stockIn);
        main_transfer_spin.add(AppConstants.tran_cust);
        main_transfer_spin.add(AppConstants.tran_ware);
        main_transfer_spin.add(AppConstants.ware_ware);
        main_transfer_spin.add(AppConstants.warehouse_warehouse);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, main_transfer_spin);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ts_main_spinner.setAdapter(aa);

        TsMenuAdp adapter = new TsMenuAdp(main_transfer_spin, TransferStockAct.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_ts_menu.setLayoutManager(lm);
        rv_ts_menu.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnItemSelected(R.id.ts_main_spinner)
    public void onSelcteTransfer(int position) {
        String selectedTransfer = ts_main_spinner.getSelectedItem().toString();

        if (selectedTransfer.equals("Select Transfer Stock")) {

        }
        if (selectedTransfer.equals(AppConstants.tran_stock)) {
            Intent in = new Intent(this, TransferStockMoveINOUT.class);
            startActivity(in);
        }
        if (selectedTransfer.equals(AppConstants.tran_cust) || selectedTransfer.equals(AppConstants.tran_ware) || selectedTransfer.equals(AppConstants.ware_ware)) {
            Intent in = new Intent(this, Ts_Mainactivity.class);
            in.putExtra("getSelectedTransferVal", selectedTransfer);
            startActivity(in);
        }

    }


}
