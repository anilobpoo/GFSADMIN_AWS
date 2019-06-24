package com.obpoo.gfsfabricsoftware.Report.UI;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.Adapter.PoDetailItemsAdap;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsRespoDet;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PoDeliverydetItems extends BaseActivity {
    ArrayList<PoDetailsRespoDet> poDetailsRespoDetArrayList;
    int indexitem;
    @BindView(R.id.factory_i)
    TextView factory_i;
    @BindView(R.id.status_item)
    TextView status_item;
    @BindView(R.id.remaindelay_podi)
    TextView remaindelay_podi;
    @BindView(R.id.date_item)
    TextView date_item;
    @BindView(R.id.delivery_items)
    TextView delivery_items;
    @BindView(R.id.staff_podi)
    TextView staff_podi;
    @BindView(R.id.cc_podi)
    TextView cc_podi;
    @BindView(R.id.orderno_item)
    TextView orderno_item;
    @BindView(R.id.rv_podi)
    RecyclerView rv_podi;
    @BindView(R.id.pbatshowdelivery)
    ProgressBar pbatshowdelivery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po_deliverydet_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RequestedOrder Detail");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        poDetailsRespoDetArrayList=( ArrayList<PoDetailsRespoDet>)getIntent().getSerializableExtra("PODETAILITEMS");
        Log.i("ItemsSize",poDetailsRespoDetArrayList.size()+"");
        indexitem=getIntent().getIntExtra("INDEXITEMS",0);

        factory_i.setText(poDetailsRespoDetArrayList.get(indexitem).getFactory());
        status_item.setText(poDetailsRespoDetArrayList.get(indexitem).getStatusText());
        remaindelay_podi.setText(getIntent().getStringExtra("REMAINDELAY"));
        date_item.setText(poDetailsRespoDetArrayList.get(indexitem).getCreatedOn());
        delivery_items.setText(poDetailsRespoDetArrayList.get(indexitem).getDeliveryDate());
        staff_podi.setText(poDetailsRespoDetArrayList.get(indexitem).getStaff());
        cc_podi.setText(poDetailsRespoDetArrayList.get(indexitem).getCcEmail());
        orderno_item.setText("Order No #"+poDetailsRespoDetArrayList.get(indexitem).getId());


        PoDetailItemsAdap adapter = new PoDetailItemsAdap(poDetailsRespoDetArrayList.get(indexitem).getItems(),PoDeliverydetItems.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_podi.setLayoutManager(lm);
        rv_podi.setAdapter(adapter);
        adapter.notifyDataSetChanged();





    }
}
