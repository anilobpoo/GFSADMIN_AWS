package com.obpoo.gfsfabricsoftware.ui.activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Adapter.ActivityLogAdapter;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddCustomerReserveFinal;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchRes;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockNewResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockResponse;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResResp;
import com.obpoo.gfsfabricsoftware.Stock.MVP.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Stock.MVP.ViewStock;
import com.obpoo.gfsfabricsoftware.ui.adapters.StockAdapter;
import com.obpoo.gfsfabricsoftware.utilities.SettingsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public  class StockActivityMain extends BaseActivity implements ViewStock {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.recycler_view_al)
    RecyclerView recycler_view_al;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private List<SettingsItem> cartList;
    StockAdapter adapter;
    ActivityLogAdapter al_adapter;
    StockPresenterImpl presenter;
    ArrayList<ActivityLogResDet> activityLogResDetArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Master");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);



        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
        cartList = new ArrayList<>();

        adapter = new StockAdapter(this, cartList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();

        presenter = new StockPresenterImpl(this);
        presenter.onViewActivityLog("view_all");
    }


    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.ic_shipping,
                R.drawable.ic_move_file,
                R.drawable.ic_package,
                R.drawable.cusres


        };

        SettingsItem a = new SettingsItem("Add New Stock", covers[0]);
        cartList.add(a);

        a = new SettingsItem("Move Stock", covers[1]);
        cartList.add(a);

        a = new SettingsItem("View Stock",covers[2]);
        cartList.add(a);

        a= new SettingsItem("Customer Reserves",covers[3]);
        cartList.add(a);


        adapter.notifyDataSetChanged();
    }

    @Override
    public void onShowStock(ViewStockResponse response) {

    }

    @Override
    public void onShowNewStock(ViewStockNewResponse response) {

    }

    @Override
    public void onShowActivityLog(ActivityLogResponse response) {
        Log.i("OnShowActivityLog",response.getMessage());
        activityLogResDetArrayList= response.getData();
        al_adapter  = new ActivityLogAdapter(activityLogResDetArrayList,StockActivityMain.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StockActivityMain.this);
        recycler_view_al.setLayoutManager(linearLayoutManager);
        recycler_view_al.setAdapter(al_adapter);
        al_adapter.notifyDataSetChanged();

    }

    @Override
    public void onShowFabSearch(FabSearchRes response) {

    }

    @Override
    public void onShowCustomerReserve(CustomerResResp response) {

    }

    @Override
    public void onShowSearchFabrics(AddReserveRes response) {

    }

    @Override
    public void onAddCustomerReserve(AddCustomerReserveFinal response) {

    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }




}
