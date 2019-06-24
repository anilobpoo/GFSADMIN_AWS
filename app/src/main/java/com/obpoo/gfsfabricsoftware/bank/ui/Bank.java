package com.obpoo.gfsfabricsoftware.bank.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;
import com.obpoo.gfsfabricsoftware.bank.mvp.BankPresenterImpl;
import com.obpoo.gfsfabricsoftware.bank.mvp.BankView;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.bank.adapter.BankAdapter;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.EndlessRecyclerViewScrollListener;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Bank extends BaseActivity implements  BankView{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<BankDetail> cartList=new ArrayList<>();
    private BankAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;
    private EndlessRecyclerViewScrollListener scrollListener;
    BankPresenterImpl presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bank");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter=new BankPresenterImpl(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deptName=name.getText().toString().trim();

                if (deptName.isEmpty())
                {
                    name.setError("Required");
                    name.requestFocus();
                    return;
                }
                showProgressBar();
                presenter.add("insert",deptName,"dd","dd");
            }
        });

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
        ArrayList<BankDetail> temp = new ArrayList();
        for (BankDetail d : cartList) {
            if (d.getBankname().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }



    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(BankResponse response) {


        Log.e("Response",response.toString());


        if (response.getStatus().toLowerCase().equals(AppConstants.SUCCESS)) {

            closeProgressbar();
            if (response.getMessage().toLowerCase().contains("added"))
            {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                name.setText("");
                presenter.viewAll("view_all");
            }else {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new BankAdapter(this, cartList);
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

    }
}
