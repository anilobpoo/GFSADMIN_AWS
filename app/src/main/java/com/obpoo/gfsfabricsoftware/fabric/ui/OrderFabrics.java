package com.obpoo.gfsfabricsoftware.fabric.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartDetail;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartPresenterImpl;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartView;
import com.obpoo.gfsfabricsoftware.cart.ui.Cart;
import com.obpoo.gfsfabricsoftware.fabric.adapter.OrderFabricAdapter;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsPresenterImpl;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFabrics extends BaseActivity implements FabricsView,CartView,IMethodCaller {

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.textOne)
    TextView textOne;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private ArrayList<FabricsDetail> cartList=new ArrayList<>();
    private ArrayList<CartDetail> carts=new ArrayList<>();
    private OrderFabricAdapter mAdapter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    FabricsPresenterImpl presenter;
    String id;
    @BindView(R.id.cart)
    ImageView cart;
    int s=0;
    CartPresenterImpl cartPresenter;
    String discount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_fabrics);

        final Intent intent=getIntent();
        id=intent.getStringExtra("id");
        discount=intent.getStringExtra("discount");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fabrics");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new FabricsPresenterImpl(this);
        cartPresenter = new CartPresenterImpl(this);


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

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (s==0)
                {
                    Toast.makeText(OrderFabrics.this, "Please add items into cart!", Toast.LENGTH_SHORT).show();
                }else
                {
                    Intent intent=new Intent(OrderFabrics.this,Cart.class);
                    intent.putExtra("id",id);
                    intent.putExtra("discount",discount);
                    startActivity(intent);
                }


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        showProgressBar();
        presenter.viewAll("view_all_fabric");
        cartPresenter.view("view_by_oid",id);


    }

    public void onPause(){
        super.onPause();
    }

    void filter(String text) {
        ArrayList<FabricsDetail> temp = new ArrayList();
        for (FabricsDetail d : cartList) {
            if (d.getFab_name().toLowerCase().contains(text.toLowerCase())||d.getComposition().toLowerCase().contains(text.toLowerCase())||d.getColor_code().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }

    @Override
    public void onLoad(CartResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            if (response.getStatus().equals(AppConstants.SUCCESS)) {
                carts = response.getDetail();
                s=carts.size();
                if (s==0)
                {
                    textOne.setVisibility(View.GONE);
                }else
                {
                    textOne.setVisibility(View.VISIBLE);
                    textOne.setText(""+s);
                }



            }else
            {
                showError(response.getMessage().toString());
            }


        }else
        {
            showError(response.getMessage().toString());
        }



    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(FabricsResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();

            cartList.clear();
            cartList = response.getDetail();
            mAdapter = new OrderFabricAdapter(this, cartList,id,discount);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            mShimmerViewContainer.setVisibility(View.GONE);
            mAdapter.notifyDataSetChanged();
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
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void yourDesiredMethod(String text) {
        onResume();
    }

}
