package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter.FilterViewAdapter;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.FilterDatum;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterView extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    FilterViewAdapter adapter;

    ArrayList<FilterDatum> filterData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_view);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Apply Filter");
        setSupportActionBar(toolbar);
        enableActionBar(true);
        filterData = getIntent().getParcelableArrayListExtra("data");
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        adapter = new FilterViewAdapter(filterData,FilterView.this);
        recyclerView.setAdapter(adapter);
    }
}
