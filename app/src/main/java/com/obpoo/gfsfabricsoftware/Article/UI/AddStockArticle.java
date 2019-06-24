package com.obpoo.gfsfabricsoftware.Article.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.Article.Adapter.CompositionSpinnerAdapter;
import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.FabricTypePOJOArrayData;
import com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock.AddArticleView;
import com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock.addArticle_stockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ComposotionDetail;
import com.obpoo.gfsfabricsoftware.Composition.mvp.CompositionPresenterImpl;
import com.obpoo.gfsfabricsoftware.Composition.mvp.CompositionView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class AddStockArticle extends BaseActivity implements AddArticleView,CompositionView {
    @BindView(R.id.article_no_add)
    EditText article_no_add;
    @BindView(R.id.ft_add)
    Spinner ft_add;
    @BindView(R.id.occassion_add)
    EditText occassion_add;
    @BindView(R.id.compassion_add)
    Spinner compassion_add;
    @BindView(R.id.fullYards_add)
    EditText fullYards_add;
    @BindView(R.id.till9_yard_add)
    EditText till9_yard_add;
    @BindView(R.id.above10_yd_add)
    EditText above10_yd_add;
    @BindView(R.id.fullmtrs_add)
    EditText fullmtrs_add;
    @BindView(R.id.till9_mtrs_add)
    EditText till9_mtrs_add;
    @BindView(R.id.above10_mtrs_add)
    EditText above10_mtrs_add;
    @BindView(R.id.addArticle)
    Button addArticle;
    @BindView(R.id.note_add)
    EditText note_add;
    @BindView(R.id.pbatshowArticle)
    ProgressBar progressBar;

    addArticle_stockPresenterImpl presenter;
    String article_no_add_str,ft_add_str,occassion_add_str,compassion_add_str,fullYards_add_str,
            till9_yard_add_str,above10_yd_add_str,fullmtrs_add_str,till9_mtrs_add_str,above10_mtrs_add_str,note_add_str;
    ArrayList<FabricTypePOJOArrayData> getFabricTypeList = Stock.fabricTypeList;
    CompositionPresenterImpl Composition_presenter;
    ArrayList<ComposotionDetail> compositionList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock_article);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("AddArticle");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);



        presenter = new addArticle_stockPresenterImpl(this);
        Composition_presenter = new CompositionPresenterImpl(this);
        Composition_presenter.viewAll("view_all");
        com.obpoo.gfsfabricsoftware.Article.Adapter.SpinnerAdapter adapter = new com.obpoo.gfsfabricsoftware.Article.Adapter.SpinnerAdapter(getFabricTypeList, this);
        ft_add.setAdapter(adapter);



        ft_add.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FabricTypePOJOArrayData ftpa = (FabricTypePOJOArrayData)parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(),ftpa.getFabricType(),Toast.LENGTH_SHORT).show();
                ft_add_str=ftpa.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @OnClick(R.id.addArticle)
    public void onClick(){
        article_no_add_str=article_no_add.getText().toString();
        note_add_str=note_add.getText().toString();
        occassion_add_str=occassion_add.getText().toString();
        fullYards_add_str=fullYards_add.getText().toString();
        till9_yard_add_str=till9_yard_add.getText().toString();
        above10_yd_add_str=above10_yd_add.getText().toString();
        fullmtrs_add_str=fullmtrs_add.getText().toString();
        till9_mtrs_add_str=till9_mtrs_add.getText().toString();
        above10_mtrs_add_str=above10_mtrs_add.getText().toString();
        presenter.sendrequest("insert",article_no_add_str,note_add_str,ft_add_str,occassion_add_str,compassion_add_str,fullYards_add_str,
                till9_yard_add_str,above10_yd_add_str,fullmtrs_add_str,till9_mtrs_add_str,above10_mtrs_add_str);
    }

    @Override
    public void onGetAddArticleInsertMsg(AddArticleResponse response) {
        Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this,Stock.class);
        startActivity(in);
        finish();


    }

    @Override
    public void onValidationFail(int type) {
        switch (type){
            case 1:
                article_no_add.setError("Enter Article Number");
                break;
            case 2:
                note_add.setError("Enter Note");
                break;
            case 3:
                ((TextView)ft_add.getSelectedView()).setError("Select Fabric Type");
                break;

        }

    }

    @Override
    public void viewCompositionList(CompositionResponse response) {
        compositionList = response.getDetail();
        CompositionSpinnerAdapter cAdapter= new CompositionSpinnerAdapter(compositionList,this);
        compassion_add.setAdapter(cAdapter);


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
    @OnItemSelected(R.id.compassion_add)
    public void onSelectedComposition(int position){
        compassion_add_str = compositionList.get(position).getId();
       // Toast.makeText(getApplicationContext(),compassion_add_str,Toast.LENGTH_SHORT).show();


    }

}
