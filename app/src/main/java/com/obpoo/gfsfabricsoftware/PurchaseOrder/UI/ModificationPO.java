package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ModificationPoAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModificationPO extends AppCompatActivity implements PoView {

    @BindView(R.id.factory_tv)
    TextView factory_tv;
    @BindView(R.id.stafname)
    TextView stafname;
    @BindView(R.id.cc_email)
    TextView cc_email;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.confirm)
    TextView confirm;
    @BindView(R.id.textView42)
    TextView requested;
    @BindView(R.id.tranparent_bg)
    ImageView tranparent_bg;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    ArrayList<poItem> items;
    String factory, id, staf, cc_mail;

    ModificationPoAdapter adapter;
    PoPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification_po);
        ButterKnife.bind(this);
        presenter = new PoPresenterImpl(this);
        Intent intent = getIntent();
        items = intent.getParcelableArrayListExtra("item");
        id = intent.getStringExtra("id");
        factory = intent.getStringExtra("factory");
        staf = intent.getStringExtra("staf");
        cc_mail = intent.getStringExtra("cc_mail");
        LinearLayoutManager lm = new LinearLayoutManager(ModificationPO.this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(lm);
        recycler_view.setNestedScrollingEnabled(false);
        adapter = new ModificationPoAdapter(this, items);
        recycler_view.setAdapter(adapter);
        factory_tv.setText(factory);
        stafname.setText(staf);
        cc_email.setText(cc_mail);
        requested.setText("Contract Requested To #"+id);
    }

    @OnClick(R.id.confirm)
    public void confirmOnclick() {
        presenter.OnConfirmPO("change_status", id, "1", "0");
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
            Intent intent = new Intent(ModificationPO.this, ConfirmPO.class);
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
    public void onModifyNotes(ModifyNotes response) {

    }

    @Override
    public void onShowFilter(PoFilterResponse response) {

    }

    @Override
    public void showDialog() {
        tranparent_bg.setVisibility(View.VISIBLE);
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        tranparent_bg.setVisibility(View.GONE);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }
}
