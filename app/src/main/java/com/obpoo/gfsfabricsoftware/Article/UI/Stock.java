package com.obpoo.gfsfabricsoftware.Article.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.Article.Adapter.stockAdapter;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.FabricTypePOJOArrayData;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.SettingsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Stock extends AppCompatActivity implements StockView, View.OnClickListener {

    @BindView(R.id.recyclerView_stock)
    RecyclerView recyclerView_stock;
    private List<SettingsItem> StockList;
    ArrayList<StockDataResponse> stockDataResponses;
    stockAdapter adapter;
    com.obpoo.gfsfabricsoftware.ui.adapters.Adapter StockAdapter;
    ImageView back_stock_article, add_stock_article;
    @BindView(R.id.etSearch)
    EditText etSearch;
    StockPresenterImpl presenter;
    static ArrayList<FabricTypePOJOArrayData> fabricTypeList;
    @BindView(R.id.pbatshowArticle)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_stock_article);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        back_stock_article = (ImageView) toolbar.findViewById(R.id.back_stock_article);

        add_stock_article = (ImageView) toolbar.findViewById(R.id.add_stock_article);
        back_stock_article.setOnClickListener(this);
        add_stock_article.setOnClickListener(this);

        etSearch.setHint("Search by Article/Composition");


        presenter = new StockPresenterImpl(this);


        try {
            presenter.showMenu(getString(R.string.stock_article), R.drawable.ic_cloth);
            presenter.showResponse("viewall");
            presenter.showFabricType("view_all");                        //To get fabricType


        } catch (Exception e) {
            Log.i("Exception", e.getMessage());
        }

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (stockDataResponses != null) {
                    filter(editable.toString());
                }

            }
        });
    }

    void filter(String text) {
        ArrayList<StockDataResponse> temp = new ArrayList();
        for (StockDataResponse d : stockDataResponses) {
            if (d.getArticleno().toLowerCase().contains(text.toLowerCase()) || d.getComposition().toLowerCase().contains(text.toLowerCase()) || d.getCompositionCode().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        adapter.updateList(temp);
    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onGetResponse(String name, int drawable) {

//        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onShowStock(stockPOJO response) {
        setDataInRecyclerview(response);

    }

    @Override
    public void onshowFabricType(fabricTypePOJO response) {
        fabricTypeList = response.getData();


    }

    @Override
    public void onshowDeleteArticel(deletearticelPOJO response) {
    }

    private void setDataInRecyclerview(stockPOJO response) {
        ArrayList<StockDataResponse>stockDataResponses = response.getData();
        this.stockDataResponses = stockDataResponses;
        adapter = new stockAdapter(Stock.this, stockDataResponses);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Stock.this);
        recyclerView_stock.setLayoutManager(linearLayoutManager);
        recyclerView_stock.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_stock_article:
                Intent in = new Intent(Stock.this, AddStockArticle.class);
                startActivity(in);
                finish();
                break;
            case R.id.back_stock_article:
                finish();
                break;
            default:
                break;
        }
    }
}
