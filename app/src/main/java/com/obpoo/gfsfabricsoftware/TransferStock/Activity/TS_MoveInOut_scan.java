package com.obpoo.gfsfabricsoftware.TransferStock.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Adapter.TransferScanAdp;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocDataDetails;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInView;
import com.obpoo.gfsfabricsoftware.shelfassignment.ui.Scanning;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TS_MoveInOut_scan extends BaseActivity implements StockInView, TsView {
    @BindView(R.id.rv_ts_fab)
    RecyclerView rv_ts_fab;
    int fabricScanCode = 6;
    TransferScanAdp adapter;
    @BindView(R.id.submit_moveout)
    Button submit_moveout;
    @BindView(R.id.note_tv)
    TextView note_tv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    StockInPresenterImpl stockInPresenter;
    ArrayList<String> uniqueArray = new ArrayList<>();
    TsPresenterImpl presenter;
    ArrayList<DocDataDetails> docDataDetails;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == fabricScanCode && resultCode == RESULT_OK) {
            String getScannedUniqueCode = data.getStringExtra("id");
            for (DocDataDetails tsf : docDataDetails) {
                if (tsf.getUniqueCode() != null && tsf.getUniqueCode().contains(getScannedUniqueCode)) {

                    tsf.setCheckScan(true);
                    uniqueArray.add(tsf.getId());
                    break;
                }
                if (!tsf.getUniqueCode().contains(getScannedUniqueCode)) {
                    callAlertDialog(getScannedUniqueCode);
                    break;
                }
            }
            adapter.notifyDataSetChanged();
            if (uniqueArray.size() > 0) {
                submit_moveout.setVisibility(View.VISIBLE);
            } else {
                submit_moveout.setVisibility(View.GONE);
            }
        }
    }

    private void callAlertDialog(String getScannedUniqueCode) {
        final android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(TS_MoveInOut_scan.this);
        alertBuilder.setMessage(Html.fromHtml("The scanned unique Id" + getScannedUniqueCode + " is not available in the current selected document "));
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        android.app.AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ts__move_in_out_scan);
        ButterKnife.bind(this);
        note_tv.setText(getIntent().getStringExtra("note"));
        toolbar.setTitle(getIntent().getStringExtra("doc"));
        docDataDetails = getIntent().getParcelableArrayListExtra("documentdata");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        rv_ts_fab.setFocusable(false);
        adapter = new TransferScanAdp(docDataDetails, TS_MoveInOut_scan.this, new TransferScanAdp.ListItemClickListener() {
            @Override
            public void onItemClick(View view, String id,String status) {
                if (status.equals("add")){
                    uniqueArray.add(id);
                }
                if (status.equals("remove")){
                    uniqueArray.remove(id);
                }
                if (uniqueArray.isEmpty()){
                    submit_moveout.setVisibility(View.GONE);

                }
                else {
                    submit_moveout.setVisibility(View.VISIBLE);
                }
            }
        });
        final LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_ts_fab.setLayoutManager(lm);
        rv_ts_fab.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        stockInPresenter = new StockInPresenterImpl(this);

        presenter = new TsPresenterImpl(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_scan) {

            startActivityForResult(new Intent(TS_MoveInOut_scan.this, Scanning.class), fabricScanCode);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.submit_moveout)
    public void onSubmitScan() {
        String userid = PreferenceConnector.readString(this, getString(R.string.admin_id), "");
        //stockInPresenter.move(userid,"remove_packets",uniqueArray);
        presenter.onTransferStockOutPara("transfer_stock", uniqueArray);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(StockInResponse response) {
        Log.i("StockInResponse", response.getMessage());

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

    }

    @Override
    public void onTransferStockOut(TransferResponse response) {
        Log.i("TransferResponse", response.getMessage());
        // place notify change over here

    }

    @Override
    public void onStockDocView(StockDocumentResponse response) {

    }

    @Override
    public void onSelectDocView(DocumentData response) {


    }

}
