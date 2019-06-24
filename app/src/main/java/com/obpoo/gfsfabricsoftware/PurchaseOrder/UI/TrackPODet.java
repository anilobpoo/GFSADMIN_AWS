package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetAdap;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetData;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetItems;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackPODet extends BaseActivity {
    @BindView(R.id.track_po_det_rv)
    RecyclerView track_po_det_rv;
    @BindView(R.id.cus_name_track_po_det)
    TextView cus_name_track_po_det;
    ArrayList<TrackPODetData> trackPODetDataArrayList;
    TrackPODetAdap adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_podet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Track PO");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        trackPODetDataArrayList=getIntent().getParcelableArrayListExtra(AppConstants.trackPOCusDet);
        ArrayList<TrackPODetItems> trackPODetItems = trackPODetDataArrayList.get(0).getItems();
        cus_name_track_po_det.setText(trackPODetItems.get(0).getCustomerName());

       // Log.i("trackPODetDataArrayList",trackPODetDataArrayList.size()+""+trackPODetDataArrayList.get(0).getItems().size()+"");

        Log.i("trackPODetItems",trackPODetItems.size()+"");
        adapter = new TrackPODetAdap(trackPODetItems,TrackPODet.this);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        track_po_det_rv.setLayoutManager(lm);
        track_po_det_rv.setAdapter(adapter);

    }
}
