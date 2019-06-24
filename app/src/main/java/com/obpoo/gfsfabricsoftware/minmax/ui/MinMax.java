package com.obpoo.gfsfabricsoftware.minmax.ui;

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
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;
import com.obpoo.gfsfabricsoftware.minmax.mvp.MinMaxPresenterImpl;
import com.obpoo.gfsfabricsoftware.minmax.mvp.MinMaxView;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxDetail;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.minmax.adapter.MinMaxAdapter;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MinMax extends BaseActivity implements MinMaxView {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<MinMaxDetail> cartList=new ArrayList<>();
    private MinMaxAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;
    MinMaxPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_max);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MinMax");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter=new MinMaxPresenterImpl(this);

        networkDetection = new NetworkDetection();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shopName=name.getText().toString().trim();
                if (shopName.isEmpty())
                {
                    name.setError("Required");
                    name.requestFocus();
                    return;
                }
                showDialog();
                presenter.add("admin_max",shopName);
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

        presenter.viewAll("viewAllMinMax");
    }


    void filter(String text) {
        ArrayList<MinMaxDetail> temp = new ArrayList();
        for (MinMaxDetail d : cartList) {
            if (d.getTitle().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }

        mAdapter.updateList(temp);
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MinMaxResponse response) {

        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            if (response.getMessage().toLowerCase().contains("added"))
            {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                name.setText("");
                presenter.viewAll("viewAllMinMax");

            }else {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new MinMaxAdapter(this, cartList);
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
