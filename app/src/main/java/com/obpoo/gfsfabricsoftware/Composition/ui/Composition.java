package com.obpoo.gfsfabricsoftware.Composition.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.Composition.adapter.CompositionAdapter;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ComposotionDetail;
import com.obpoo.gfsfabricsoftware.Composition.mvp.CompositionPresenterImpl;
import com.obpoo.gfsfabricsoftware.Composition.mvp.CompositionView;
import com.obpoo.gfsfabricsoftware.R;


import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Composition extends AppCompatActivity implements CompositionView {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;


    private CompositionAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;



    CompositionPresenterImpl presenter;
    private Dialog progressDialog;

    ArrayList<ComposotionDetail> cartList;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_composition);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Composition");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);


        presenter = new CompositionPresenterImpl(this);
        networkDetection = new NetworkDetection();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        ButterKnife.bind(this);
        //recyclerView = findViewById(R.id.recycleviewcomposition);


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (cartList != null) {
                    filter(editable.toString());
                }

            }
        });

        presenter.viewAll("view_all");

    }



    void filter(String text) {
        ArrayList<ComposotionDetail> temp = new ArrayList();
        for (ComposotionDetail d : cartList) {
            if (d.getComposition().toLowerCase().contains(text.toLowerCase())||d.getId().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    public void enableActionBar(boolean backIconVisibility) {
        if (getSupportActionBar() != null) {
            if (backIconVisibility) {
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp));
            }
        }
        ButterKnife.bind(this);


    }



    private void viewCompositionList() {

        if (networkDetection.isWifiAvailable(getApplicationContext()) || networkDetection.isMobileNetworkAvailable(getApplicationContext())) {
            showProgressBar();


        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }

    }





    public void showProgressBar() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(getApplicationContext(), getString(R.string.loading_please_wait));
        } else {
            closeProgressbar();
            progressDialog = null;
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(getApplicationContext(), getString(R.string.loading_please_wait));
        }
    }

    public void closeProgressbar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void viewCompositionList(CompositionResponse response) {

        Log.e("Response",response.toString());
        Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();


        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            ArrayList<ComposotionDetail> listdata = response.getDetail();
            cartList = listdata;
            mAdapter = new CompositionAdapter(getBaseContext(), listdata);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }


    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

        Log.e("Response",message);
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
