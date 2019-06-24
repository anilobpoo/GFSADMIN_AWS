package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOCusAdp;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPObyCusData;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.salesorder.adapter.AllOrderStatusAdp;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderStatusData;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackPO extends BaseActivity {
    @BindView(R.id.trackpo_cus_rv)
    RecyclerView trackpo_cus_rv;
    @BindView(R.id.etSearch)
    EditText  etSearch;
    @BindView(R.id.progress_trackPODet)
    ProgressBar progress_trackPODet;
    ArrayList<TrackPObyCusData> trackPObyCusDataArrayList;
    ArrayList<AllORderStatusData> allORderStatusDataArrayList;
    TrackPOCusAdp  adapter;
    AllOrderStatusAdp adpapterAllOrderStatus;
    String getSOPOtag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_po);
        getSOPOtag= getIntent().getStringExtra("POSOTAG");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(getSOPOtag.equals("POVAL")){
        toolbar.setTitle("Track PO");}
        else{
            toolbar.setTitle("Apply Filter");
        }
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        getSOPOtag= getIntent().getStringExtra("POSOTAG");

        if(getSOPOtag.equals("POVAL")){

        trackPObyCusDataArrayList= PreferenceConnector.getArraylistofObject(AppConstants.trackPObyCus,TrackPO.this);
        Log.i("trackPObyCus",trackPObyCusDataArrayList.size()+"");
          adapter = new TrackPOCusAdp(trackPObyCusDataArrayList,TrackPO.this,progress_trackPODet);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        trackpo_cus_rv.setLayoutManager(lm);
        trackpo_cus_rv.setAdapter(adapter);}

        else{
            allORderStatusDataArrayList = getIntent().getParcelableArrayListExtra(AppConstants.salesallOrderStatus);
            Log.i("AllSoOrderStatus",allORderStatusDataArrayList.size()+"");
            adpapterAllOrderStatus= new AllOrderStatusAdp(allORderStatusDataArrayList,TrackPO.this);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            trackpo_cus_rv.setLayoutManager(lm);
            trackpo_cus_rv.setAdapter(adpapterAllOrderStatus);

        }

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0){
                    if(getSOPOtag.equals("POVAL")){
                    filterCustomer(s.toString());}
                    else{

                    }
                }

            }
        });




    }

    private void filterCustomer(String s) {
        ArrayList<TrackPObyCusData> temp = new ArrayList<>();
            for(TrackPObyCusData d : trackPObyCusDataArrayList){
                if(d.getCustomerName().toLowerCase().contains(s.toLowerCase())){
                    temp.add(d);
                }
            }

            adapter.updateFilterData(temp);


    }
}
