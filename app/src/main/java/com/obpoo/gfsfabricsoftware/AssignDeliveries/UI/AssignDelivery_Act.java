package com.obpoo.gfsfabricsoftware.AssignDeliveries.UI;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.Adapter.AssignDelivery_viewAdp;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponseList;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP.AssignDeliveryPresenterImpl;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP.AssignDeliveryView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssignDelivery_Act extends BaseActivity implements AssignDeliveryView {
    AssignDeliveryPresenterImpl presenter;
    @BindView(R.id.recycler_view_ad)
    RecyclerView recycler_view;
    ArrayList<DeliveryResponse> deliveryResponses = new ArrayList<>();
    @BindView(R.id.etSearch)
    EditText etSearch;
    AssignDelivery_viewAdp adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_delivery_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new AssignDeliveryPresenterImpl(this);
        presenter.onViewDeliveries("qc_done");

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (deliveryResponses != null) {
                    filter(editable.toString());
                }

            }
        });


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
    public void onShowViewDeliveries(DeliveryData response) {
        presenter.onViewAllPg("viewall");
        Log.i("DeliveryRes",response.getMessage());
        deliveryResponses=response.getData();



    }

    @Override
    public void onShowAllPGList(PGresponse response) {
        Log.i("AllPGList",response.getMessage());
        ArrayList<PGresponseList> pGresponseLists = new ArrayList<>();
        pGresponseLists=response.getData();
       // Log.i("check_list_2",pGresponseLists.get(0).getName());
        adapter = new AssignDelivery_viewAdp(AssignDelivery_Act.this, deliveryResponses,pGresponseLists);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AssignDelivery_Act.this);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.setAdapter(adapter);


    }

    @Override
    public void onShowAssignPg(AssignPgResponse response) {

    }
    void filter(String text) {
        ArrayList<DeliveryResponse> temp = new ArrayList();
        for (DeliveryResponse d : deliveryResponses) {
            if (d.getId().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        adapter.updateList(temp);
    }
}
