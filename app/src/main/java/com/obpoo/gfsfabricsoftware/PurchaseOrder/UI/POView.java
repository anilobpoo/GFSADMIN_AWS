package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.poViewDetailsAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class POView extends BaseActivity {
    ArrayList<poDatum> podataList = new ArrayList<>();
    ArrayList<poItem> poItemList = new ArrayList<>();
    int viewIndex;
    @BindView(R.id.rv_po_view)
    RecyclerView rv_po_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("OrderItems");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        podataList=(ArrayList<poDatum>)getIntent().getSerializableExtra("POdata");
        viewIndex=getIntent().getIntExtra("POdataIndex",0);
        poItemList=podataList.get(viewIndex).getItems();

        poViewDetailsAdapter adapter = new poViewDetailsAdapter(getApplicationContext(), poItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(POView.this);
        rv_po_view.setLayoutManager(linearLayoutManager);
        rv_po_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}
