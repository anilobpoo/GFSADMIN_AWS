package com.obpoo.gfsfabricsoftware.shelf.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfResponse;
import com.obpoo.gfsfabricsoftware.shelf.mvp.ShelfPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelf.mvp.ShelfView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.shelf.adapter.ShelfAdapter;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Shelf extends BaseActivity implements ShelfView {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.zone) TextView zone;
    @BindView(R.id.warehouseno) TextView warehouseno;
    @BindView(R.id.name) TextView name;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<ShelfDetail> cartList=new ArrayList<>();
    ShelfPresenterImpl presenter;
    String id,number,names,zones,warehouseId;
    ShelfAdapter mAdapter;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Shelf");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter=new ShelfPresenterImpl(this);

        Intent intent=getIntent();
        number=intent.getStringExtra("number");
        names=intent.getStringExtra("name");
        zones=intent.getStringExtra("zone");
        id=intent.getStringExtra("id");
        warehouseId=intent.getStringExtra("warehouseId");

        warehouseno.setText("#"+number);
        name.setText(names);
        zone.setText("Zone-"+zones);



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
    public void onLoad(ShelfResponse response) {

        Log.e("Response",response.toString());


        if (response.getStatus().toLowerCase().equals(AppConstants.SUCCESS)) {

            closeProgressbar();
            if (response.getMessage().toLowerCase().contains("added"))
            {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                presenter.viewShelf("view_shelves",id);
            }else {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new ShelfAdapter(this, cartList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
                mShimmerViewContainer.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }




        }else
        {
            closeProgressbar();
            showError(response.toString());
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
        Toast.makeText(this, "No Shelves", Toast.LENGTH_SHORT).show();
    }

    public void checkAlert(final String ids)
    {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.alert, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder.setTitle("Add Shelf");
        alertDialogBuilder.setMessage("Enter number of shelves you want to add to "+names+" Zone-"+zones);
        final EditText userInput = (EditText) promptsView.findViewById(R.id.edittTextDialogUserInput);
        userInput.setHint("Number");
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String numbers=userInput.getText().toString();

                                if (numbers.isEmpty())
                                {
                                    Toast.makeText(Shelf.this, "Add Number", Toast.LENGTH_SHORT).show();
                                }else
                                {
                                    presenter.addShelf("create_shelf",warehouseId,ids,number,numbers);
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
        presenter.viewShelf("view_shelves",id);

    }

    public void onPause(){
        super.onPause();
    }
}
