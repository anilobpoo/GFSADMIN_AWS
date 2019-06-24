package com.obpoo.gfsfabricsoftware.customertype.ui;

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
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeResponse;
import com.obpoo.gfsfabricsoftware.customertype.mvp.CustomerTypePresenterImpl;
import com.obpoo.gfsfabricsoftware.customertype.mvp.CustomerTypeView;
import com.obpoo.gfsfabricsoftware.customertype.datamodels.CustomerTypeDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.customertype.adapter.CustomerTypeAdapter;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerType extends BaseActivity implements CustomerTypeView {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<CustomerTypeDetail> cartList=new ArrayList<>();
    private CustomerTypeAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;
    CustomerTypePresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_master);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Customer Type");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        name.setHint("Customer Type");
        presenter = new CustomerTypePresenterImpl(this);
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
                showDialog();
                presenter.add("add_customer_type",deptName);
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
        ArrayList<CustomerTypeDetail> temp = new ArrayList();
        for (CustomerTypeDetail d : cartList) {
            if (d.getCustomer_type().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CustomerTypeResponse response) {

        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();

            if (response.getMessage().toLowerCase().contains("added"))
            {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                name.setText("");
                presenter.viewAll("view_all");
            }else
            {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new CustomerTypeAdapter(this, cartList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
                mShimmerViewContainer.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }



        }else
        {
            hideDialog();
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
