package com.obpoo.gfsfabricsoftware.collections.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.adapter.CollectionINDAdapter;
import com.obpoo.gfsfabricsoftware.collections.adapter.ODInvoiceAdapter;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceDatum;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsInvoice extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ArrayList<InvoiceDatum> invoiceData;
    ODInvoiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_invoice);
        ButterKnife.bind(this);
        invoiceData= getIntent().getParcelableArrayListExtra("data");

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderDetailsInvoice.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ODInvoiceAdapter(OrderDetailsInvoice.this,invoiceData);
        recyclerView.setAdapter(adapter);
    }
}
