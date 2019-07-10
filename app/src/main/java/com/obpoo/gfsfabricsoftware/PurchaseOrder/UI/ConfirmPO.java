package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ConfirmPOAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmPO extends BaseActivity implements PoView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.tranparent_bg)
    ImageView tranparent_bg;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.search_view)
    LinearLayout search_view;
    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.search_et)
    EditText search_et;

    ConfirmPOAdapter adapter;
    PoPresenterImpl presenter;
    ArrayList<poDatum> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_po);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Confirm PO");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new PoPresenterImpl(this);
        presenter.OnViewPO("view_unconfirmed", "1");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ConfirmPO.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (data != null) {
                    filter(editable.toString());
                }

            }
        });

    }
    @OnClick(R.id.search_cancel)
    public void searchCancelClick() {
        search_view.setVisibility(View.VISIBLE);
        search.setVisibility(View.GONE);
        search_et.getText().clear();
        adapter = new ConfirmPOAdapter(ConfirmPO.this, data);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        InputMethodManager imm = (InputMethodManager)getSystemService(ConfirmPO.this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(search_et.getWindowToken(), 0);
    }

    @OnClick(R.id.search_view)
    public void searchViewClick() {
        search_view.setVisibility(View.GONE);
        search.setVisibility(View.VISIBLE);
        search_et.requestFocus();
        search_et.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) getSystemService(ConfirmPO.this.INPUT_METHOD_SERVICE);
        imm.showSoftInput(search_et, InputMethodManager.SHOW_FORCED);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ConfirmPO.this, PO.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onShowViewPO(poPOJO response) {
        data = response.getData();
        adapter = new ConfirmPOAdapter(ConfirmPO.this, data);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ConfirmPO.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {

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

    void filter(String text) {
        ArrayList<poDatum> temp = new ArrayList();
        for (poDatum d : data) {
            if (d.getStatusText().toLowerCase().contains(text.toLowerCase()) || d.getFactory().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        adapter.updateList(temp);

    }
}
