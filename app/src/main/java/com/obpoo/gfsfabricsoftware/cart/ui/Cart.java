package com.obpoo.gfsfabricsoftware.cart.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.cart.adapter.CartAdapter;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartDetail;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartPresenterImpl;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartView;
import com.obpoo.gfsfabricsoftware.salesorder.ui.Billing;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Cart extends BaseActivity implements CartView,IMethodCaller {

    NetworkDetection networkDetection;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.totalPrice)
    TextView totalPrice;
    private ArrayList<CartDetail> cartList=new ArrayList<>();
    private CartAdapter mAdapter;
    CartPresenterImpl presenter;
    String id,discount;
    double price=0,actualprice=0;
    int qty=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent  intent=getIntent();
        id=intent.getStringExtra("id");
        discount=intent.getStringExtra("discount");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cart");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        networkDetection = new NetworkDetection();
        presenter = new CartPresenterImpl(this);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Cart.this,Billing.class);
                intent.putExtra("id",id);
                intent.putExtra("st",""+new DecimalFormat("#.##").format(price));
                intent.putExtra("ap",""+new DecimalFormat("#.##").format(actualprice));
                intent.putExtra("discount",""+discount);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        price=0;actualprice=0;
        qty=0;

        mShimmerViewContainer.startShimmerAnimation();
        presenter.view("view_by_oid",id);
        showDialog();

    }

    public void onPause(){
        super.onPause();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CartResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            if (response.getStatus().equals(AppConstants.SUCCESS)) {
                cartList.clear();
                cartList = response.getDetail();
                mAdapter = new CartAdapter(this, cartList,id);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
                mShimmerViewContainer.setVisibility(View.GONE);
                mShimmerViewContainer.stopShimmerAnimation();
                mAdapter.notifyDataSetChanged();

                Integer size = cartList.size();
                for (int i = 0; i < size; ++i) {
                    price += Double.parseDouble(cartList.get(i).getSubtotal());
                    qty+=Double.parseDouble(cartList.get(i).getQuantity());
                    actualprice+=(Double.parseDouble(cartList.get(i).getActual_price()));
                }
                Log.e("Total:",""+price);
                Log.e("Total Qty:",""+qty);
                Log.e("Total APrice:",""+actualprice);

                totalPrice.setText("THB"+" "+new DecimalFormat("#.##").format(price));




            }else
            {
                hideDialog();
                showError(response.getMessage().toString());
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

    @Override
    public void yourDesiredMethod(String text) {
        onResume();
    }
}
