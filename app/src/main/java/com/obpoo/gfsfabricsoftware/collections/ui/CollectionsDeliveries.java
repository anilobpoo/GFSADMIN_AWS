package com.obpoo.gfsfabricsoftware.collections.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.PO_Order;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.adapter.CollectionsDelAdapter;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionDatum;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsDeliveries extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    CollectionsDelAdapter adapter;
    ArrayList<CollectionDatum> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_deliveries);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        data = intent.getParcelableArrayListExtra("date");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CollectionsDeliveries.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.setNestedScrollingEnabled(false);
        Log.i("dataSize fst", data.size() + "");
        adapter = new CollectionsDelAdapter(CollectionsDeliveries.this, data);
        recycler_view.setAdapter(adapter);
    }
}
