package com.obpoo.gfsfabricsoftware.ui.activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.adapters.Adapter;
import com.obpoo.gfsfabricsoftware.utilities.SettingsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MasterActivity extends BaseActivity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout mShimmerViewContainer;
    private List<SettingsItem> cartList;
    Adapter adapter;


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

        adapter = new Adapter(this, cartList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();

    }


    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.store,
                R.drawable.department,
                R.drawable.customertype,
                R.drawable.vendortype,
                R.drawable.customer,
                R.drawable.vendortype,
                R.drawable.warehouse,
                R.drawable.museum,
                R.drawable.knitting,
                R.drawable.max,
                R.drawable.honeycomb,
                R.drawable.paint,
                R.drawable.gazette,
                R.drawable.customertype,
                R.drawable.textile,
                R.drawable.gazette,
                R.drawable.gazette,
                R.drawable.customertype,
                R.drawable.ic_pickup_guy


        };

        SettingsItem a = new SettingsItem("Shop", covers[0]);
        cartList.add(a);
        a = new SettingsItem("Department", covers[1]);
        cartList.add(a);
        a = new SettingsItem("Customer Type", covers[2]);
        cartList.add(a);
        a = new SettingsItem("Vendor Type", covers[3]);
        cartList.add(a);
        a = new SettingsItem("Customers", covers[4]);
        cartList.add(a);
        a = new SettingsItem("Vendors", covers[5]);
        cartList.add(a);
        a = new SettingsItem("Warehouse", covers[6]);
        cartList.add(a);
        a = new SettingsItem("Bank", covers[7]);
        cartList.add(a);
        a = new SettingsItem("Fabric Type", covers[8]);
        cartList.add(a);
        a = new SettingsItem("Min-Max", covers[9]);
        cartList.add(a);
        a = new SettingsItem("Composition", covers[10]);
        cartList.add(a);
        a = new SettingsItem("Color", covers[11]);
        cartList.add(a);
        a = new SettingsItem("Article", covers[12]);
        cartList.add(a);
        a = new SettingsItem("Customer Group", covers[13]);
        cartList.add(a);
        a = new SettingsItem("Fabrics", covers[14]);
        cartList.add(a);
        a = new SettingsItem("Article", covers[15]);
        cartList.add(a);
        a = new SettingsItem("ArticleGroup", covers[16]);
        cartList.add(a);
        a = new SettingsItem("User", covers[17]);
        cartList.add(a);
        a= new SettingsItem("Assign Deliveries",covers[18]);
        cartList.add(a);
        adapter.notifyDataSetChanged();
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
