package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.ViewDetailsItemAdapter;
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
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDetails extends BaseActivity implements PoView {
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

    @BindView(R.id.confirm)
    TextView confirm;
    @BindView(R.id.isModification)
    TextView isModification;
    @BindView(R.id.textView42)
    TextView orderNo;
    @BindView(R.id.odate_tv)
    TextView order_date_pod;
    @BindView(R.id.laypod)
    LinearLayout laypod;
    @BindView(R.id.imageView6)
    ImageView imageView_odate_viewd;
    @BindView(R.id.laymc)
    LinearLayout laymc;


    ViewDetailsItemAdapter adapter;
    PoPresenterImpl poPresenter;
    ArrayList<poItem> items;


    String factory, date, deliver_date, status, id, staf, cc_mail,prev_notes_get;
    String tag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("View Details");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        poPresenter = new PoPresenterImpl(this);
        LinearLayoutManager lm = new LinearLayoutManager(ViewDetails.this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(lm);
        recycler_view.setNestedScrollingEnabled(false);

        Intent intent = getIntent();

        items = intent.getParcelableArrayListExtra("item");


        Log.i("ConfirmItem", items.size() + "");
        id = intent.getStringExtra("id");
        tag = intent.getStringExtra("tag");
        factory = intent.getStringExtra("factory");
        status = intent.getStringExtra("status");
        date = intent.getStringExtra("date");
        deliver_date = intent.getStringExtra("deliver_date");
        staf = intent.getStringExtra("staf");
        cc_mail = intent.getStringExtra("cc_mail");
        prev_notes_get=intent.getStringExtra("PREVNOTES");
        adapter = new ViewDetailsItemAdapter(this, items);
        recycler_view.setAdapter(adapter);
        factory_tv.setText(factory);
        status_tv.setText(status);
        orderdate.setText(date);
        deiverdate.setText(deliver_date);
        stafname.setText(staf);
        cc_email.setText(cc_mail);
        orderNo.setText("Order:#" + id);


        if (tag.equals("poorder")) {
            imageView_odate_viewd.setImageResource(R.drawable.cash_icon);
            laypod.setVisibility(View.VISIBLE);
            laymc.setVisibility(View.GONE);
            order_date_pod.setText(date);
            orderdate.setText("N/A");
            orderdate.setTextColor((this.getResources().getColor(R.color.green_500)));
        }
    }


    @OnClick(R.id.isModification)
    public void modifyClick() {
        /*Intent intent = new Intent(ViewDetailsReportPO.this, ModificationPO.class);
        intent.putExtra("item", items);
        intent.putExtra("id", id);
        intent.putExtra("staf", staf);
        intent.putExtra("factory", factory);
        intent.putExtra("cc_mail", cc_mail);
        startActivity(intent);*/

        Intent in = new Intent(ViewDetails.this,ModificationNotes.class);
        in.putExtra("PREVNOTES",prev_notes_get);
        in.putExtra("ORDERID",id);
        startActivity(in);


    }

    @OnClick(R.id.confirm)
    public void confirmClick() {
        poPresenter.OnConfirmPO("change_status", id, "1", "0");
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
            Intent intent = new Intent(ViewDetails.this, ConfirmPO.class);
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

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }
}
