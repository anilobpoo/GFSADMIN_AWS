package com.obpoo.gfsfabricsoftware.fabrictype.ui;

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
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeDetail;
import com.obpoo.gfsfabricsoftware.fabrictype.datamodels.FabricTypeResponse;
import com.obpoo.gfsfabricsoftware.fabrictype.mvp.FabricTypePresenterImpl;
import com.obpoo.gfsfabricsoftware.fabrictype.mvp.FabricTypeView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.fabrictype.adapter.FabricTypeAdapter;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FabricType extends BaseActivity implements FabricTypeView{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private NetworkDetection networkDetection;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<FabricTypeDetail> cartList=new ArrayList<>();
    private FabricTypeAdapter mAdapter;
    @BindView(R.id.etSearch) EditText etSearch;

    FabricTypePresenterImpl presenter;

    void filter(String text) {
        ArrayList<FabricTypeDetail> temp = new ArrayList();
        for (FabricTypeDetail d : cartList) {
            if (d.getFabric_type().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabric_type);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fabric Type");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter=new FabricTypePresenterImpl(this);
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

                presenter.add("insert",deptName);
            }
        });


        name.setHint("Fabric Type");
        presenter.viewAll("view_all");

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
    }






    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(FabricTypeResponse response) {
        Log.e("Response",response.toString());

        if (response.getStatus().equals(AppConstants.SUCCESS)) {

            if (response.getMessage().toLowerCase().contains("added"))
            {                closeProgressbar();

                Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
                name.setText("");
                presenter.viewAll("view_all");
            }else
            {
                closeProgressbar();
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new FabricTypeAdapter(this, cartList);
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
