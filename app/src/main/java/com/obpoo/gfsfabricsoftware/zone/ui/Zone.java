package com.obpoo.gfsfabricsoftware.zone.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.zone.adapter.ZoneAdapter;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneDetail;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneResponse;
import com.obpoo.gfsfabricsoftware.zone.mvp.ZonePresenterImpl;
import com.obpoo.gfsfabricsoftware.zone.mvp.ZoneView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Zone extends BaseActivity implements ZoneView {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.zone) TextView zone;
    @BindView(R.id.warehouseno) TextView warehouseno;
    @BindView(R.id.name) TextView name;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<ZoneDetail> cartList=new ArrayList<>();
    ZonePresenterImpl presenter;
    String id,number,names,zones;
    ZoneAdapter mAdapter;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Zone");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter=new ZonePresenterImpl(this);

        Intent intent=getIntent();
        number=intent.getStringExtra("no");
        warehouseno.setText("#"+number);
        names=intent.getStringExtra("name");
        name.setText(names);
        zones=intent.getStringExtra("zone");
        id=intent.getStringExtra("id");
        zone.setText("Zones:"+zones);

        fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add_white_18dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAlert(id);
            }
        });

    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ZoneResponse response) {

        Log.e("Response",response.toString());


        if (response.getStatus().toLowerCase().equals(AppConstants.SUCCESS)) {

            hideDialog();
            if (response.getMessage().toLowerCase().contains("added"))
            {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                presenter.viewAll("view_all",id);
            }else {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new ZoneAdapter(this, cartList, names, number, zones,id);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
                //zone.setText("Zones:"+mAdapter.getItemCount());
                mShimmerViewContainer.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }




        }else
        {
            hideDialog();
            showError(response.getMessage().toString());
        }


    }

    @Override
    public void showDialog() {
        showProgressBar();
    }

    @Override
    public void hideDialog() {
        closeProgressbar();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void checkAlert(final String ids)
    {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.alert, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder.setTitle("Add Zone");
      //  alertDialogBuilder.setMessage("Enter number of zones you want to add to GD");
        final EditText userInput = (EditText) promptsView.findViewById(R.id.edittTextDialogUserInput);
        userInput.setHint("Number");
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String number=userInput.getText().toString();

                                if (number.isEmpty())
                                {
                                    Toast.makeText(Zone.this, "Add Number", Toast.LENGTH_SHORT).show();
                                }else
                                {
                                    presenter.add("create_zone",ids,number);
                                }



                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    @Override
    public void onResume() {
        super.onResume();
        showDialog();
        presenter.viewAll("view_all",id);

    }

    public void onPause(){
        super.onPause();
    }

}
