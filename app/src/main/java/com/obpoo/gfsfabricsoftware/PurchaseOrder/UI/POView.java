package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.poViewDetailsAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class POView extends BaseActivity {
    poDatum podataList;
    ArrayList<poItem> poItemList = new ArrayList<>();
    int viewIndex;
    @BindView(R.id.rv_po_view)
    RecyclerView rv_po_view;

    @BindView(R.id.ven_mco)
    TextView ven_mco;
    @BindView(R.id.mco_status)
    TextView mco_status;
    @BindView(R.id.notes_mco)
    TextView notes_mco;
    @BindView(R.id.cur_mco)
    TextView cur_mco;
    @BindView(R.id.cd_mco)
    TextView cd_mco;
    @BindView(R.id.del_mco)
    TextView del_mco;
    @BindView(R.id.per_mco)
    TextView per_mco;
    @BindView(R.id.mail_mco)
    TextView mail_mco;
    @BindView(R.id.order_mco)
    TextView order_mco;
    String modify_tag;
    boolean menu_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Order Detail");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        podataList = getIntent().getParcelableExtra("POdata");
        viewIndex = getIntent().getIntExtra("POdataIndex", 0);
        modify_tag=getIntent().getStringExtra("ModifyTag");

        if(modify_tag.equals("3")){
            menu_state=true;
            invalidateOptionsMenu();
        }
        else{
            menu_state=false;
        }

        Log.i("checkPOItem", podataList.getItems().size() + "");

        ven_mco.setText(podataList.getFactory());
        mco_status.setText(podataList.getStatusText());
        notes_mco.setText(podataList.getNotes());
        if (podataList.getCurrency() != null) {
            cur_mco.setText(podataList.getCurrency());

        } else {
            cur_mco.setText("N/A");

        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df.parse(podataList.getCreatedOn());

            DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
            String output1 = outputFormatter1.format(date);
            cd_mco.setText(output1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(podataList.getDelivery_date().equals("")){
            del_mco.setText("N/A");
        }
        else
        {  del_mco.setText(podataList.getDelivery_date());}
        per_mco.setText(podataList.getStaff());
        mail_mco.setText(podataList.getCcEmail());
        order_mco.setText("Order "+podataList.getId());


        poViewDetailsAdapter adapter = new poViewDetailsAdapter(getApplicationContext(), podataList.getItems());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(POView.this);
        rv_po_view.setLayoutManager(linearLayoutManager);
        rv_po_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.modifymenu,menu);
        if(menu_state){
            menu.getItem(0).setVisible(true);
        }
        else{
            menu.getItem(0).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_modify:
                Intent in = new Intent(POView.this, POAdd.class);
                in.putExtra("mediateVIA", "Modify_status");
                in.putExtra("POdata",podataList);
                // in.putExtra("getItemList", "addItemList");
                startActivity(in);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
