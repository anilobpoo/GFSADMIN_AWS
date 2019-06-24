package com.obpoo.gfsfabricsoftware.CommonArticleGroup.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.MVP.AdapterToActivityInterface;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.Adapter.ColorAdapter;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class checkColorsCAG extends BaseActivity implements SearchView.OnQueryTextListener, AdapterToActivityInterface {
    @BindView(R.id.color_check)
    ListView color_check;
    @BindView(R.id.search)
    SearchView search;
    @BindView(R.id.addColor)
    Button Addcolor;
    ColorAdapter adapter;
    List<String> getCheckedColor = new ArrayList<>();
    List<String> getBackCheckedValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_colors_cag);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Select Colors");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        search.setOnQueryTextListener(this);
        System.out.println("Enter 2");
//        ArrayList<AddCadPOJOdata> colorListCheck = new ArrayList<>();
//        colorListCheck = (ArrayList<AddCadPOJOdata>) getIntent().getSerializableExtra("COLORS");
        ArrayList<StockDataResponse> ArticleListCheck = new ArrayList<>();
        ArticleListCheck = (ArrayList<StockDataResponse>) getIntent().getSerializableExtra("ARTICLESlist");


        if (getIntent().getStringArrayListExtra("SelectedColorsBackCheck") != null) {
            getBackCheckedValues = getIntent().getStringArrayListExtra("SelectedColorsBackCheck");
            System.out.println("getBackCheckedValues" + getBackCheckedValues);
        }


     //  adapter = new ColorAdapter(checkColorsCAG.this, colorListCheck, this,getBackCheckedValues);


        adapter = new ColorAdapter(checkColorsCAG.this, ArticleListCheck, this,getBackCheckedValues);
        if(getBackCheckedValues!=null){
        getCheckedColor.addAll(getBackCheckedValues);}
        color_check.setAdapter(adapter);

        color_check.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecteditem = ((TextView) view).getText().toString();
                CheckedTextView ct = (CheckedTextView) view.findViewById(R.id.checkedvalue);

                if (!ct.isChecked()) {
                    ct.setChecked(true);

                    if (!getCheckedColor.contains(selecteditem)) {
                        getCheckedColor.add(selecteditem);
                    } else {

                    }

                } else {
                    ct.setChecked(false);
                    getCheckedColor.remove(selecteditem);
                }

            }
        });


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;

    }

    @Override
    public void setValues(ArrayList<String> s) {

    }

    @OnClick(R.id.addColor)
    public void onClick() {
        Log.i("checkedColors", getCheckedColor.toString());
        Intent in = new Intent(checkColorsCAG.this, AddCmnArtGroup.class);
        in.putStringArrayListExtra("checkedColors", (ArrayList<String>) getCheckedColor);
        setResult(2, in);
        finish();


    }
}
