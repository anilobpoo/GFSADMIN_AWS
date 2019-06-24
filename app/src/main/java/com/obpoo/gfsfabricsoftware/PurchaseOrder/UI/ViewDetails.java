package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ViewDetailsItemAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDetails extends AppCompatActivity implements poView {
    @BindView(R.id.factory_tv)
    TextView factory_tv;
    @BindView(R.id.status_tv)
    TextView status_tv;
    @BindView(R.id.orderdate)
    TextView orderdate;
    @BindView(R.id.deiverdate)
    TextView deiverdate;
    @BindView(R.id.stafname)
    TextView stafname;
    @BindView(R.id.cc_email)
    TextView cc_email;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.back_PO_cmngrp)
    ImageView back_PO_cmngrp;
    @BindView(R.id.confirm)
    TextView confirm;
    @BindView(R.id.isModification)
    TextView isModification;

    ViewDetailsItemAdapter adapter;
    poPresenterImpl poPresenter;
    ArrayList<poItem> items;
    String factory, date, deliver_date, status, id, staf, cc_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        ButterKnife.bind(this);
        poPresenter = new poPresenterImpl(this);
        LinearLayoutManager lm = new LinearLayoutManager(ViewDetails.this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(lm);
        recycler_view.setNestedScrollingEnabled(false);

        Intent intent = getIntent();
        items = intent.getParcelableArrayListExtra("item");
        id = intent.getStringExtra("id");
        factory = intent.getStringExtra("factory");
        status = intent.getStringExtra("status");
        date = intent.getStringExtra("date");
        deliver_date = intent.getStringExtra("deliver_date");
        staf = intent.getStringExtra("staf");
        cc_mail = intent.getStringExtra("cc_mail");
        adapter = new ViewDetailsItemAdapter(this, items);
        recycler_view.setAdapter(adapter);
        factory_tv.setText(factory);
        status_tv.setText(status);
        orderdate.setText(date);
        deiverdate.setText(deliver_date);
        stafname.setText(staf);
        cc_email.setText(cc_mail);
    }

    @OnClick(R.id.back_PO_cmngrp)
    public void onClick() {
        finish();
    }

    @OnClick(R.id.isModification)
    public void modifyClick() {
        Intent intent = new Intent(ViewDetails.this, ModificationPO.class);
        intent.putExtra("item", items);
        intent.putExtra("id", id);
        intent.putExtra("staf", staf);
        intent.putExtra("factory", factory);
        intent.putExtra("cc_mail", cc_mail);
        startActivity(intent);
    }

    @OnClick(R.id.confirm)
    public void confirmClick() {
        poPresenter.OnConfirmPO("change_status", id, "1","0");
    }

    @Override
    public void onShowViewPO(poPOJO response) {

    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {
        if (response.getStatus().equals("success")) {
            Intent intent = new Intent(ViewDetails.this,ConfirmPO.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onValidationfail(int type) {

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

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
}
