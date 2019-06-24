package com.obpoo.gfsfabricsoftware.Article.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.obpoo.gfsfabricsoftware.Article.Adapter.CompositionSpinnerAdapter;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.FabricTypePOJOArrayData;
import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse;
import com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle.updateArticlePresenterImpl;
import com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle.updateArticleView;
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

public class ArticleEdit extends BaseActivity implements updateArticleView,CompositionView {
    @BindView(R.id.article_no_edit)
    EditText article_no_edit;
    @BindView(R.id.note_edit)
    EditText note_edit;
    @BindView(R.id.ft_edit)
    Spinner ft_edit;
    @BindView(R.id.update_article)
    Button update;
    @BindView(R.id.pbateditArticle)
    ProgressBar progressBar;
    @BindView(R.id.composition_edit)
    Spinner composition_edit;
    @BindView(R.id.occassion_edit)
    EditText occassion_edit;
    @BindView(R.id.fullYards_edit)
    EditText fullYards_edit;
    @BindView(R.id.till9_yard_edit)
    EditText till9_yard_edit;
    @BindView(R.id.above10_yd_edit)
    EditText above10_yd_edit;
    @BindView(R.id.fullmtrs_edit)
    EditText fullmtrs_edit;
    @BindView(R.id.till9_mtrs_edit)
    EditText till9_mtrs_edit;
    @BindView(R.id.above10_mtrs_edit)
    EditText above10_mtrs_edit;




    ArrayList<FabricTypePOJOArrayData> getFabricTypeList = Stock.fabricTypeList;
    updateArticlePresenterImpl presenter;
    CompositionPresenterImpl Composition_presenter;
    ArrayList<ComposotionDetail> compositionList;
    String articleId,ft_spinner_val,composition_str,occa_str,fullYards_str,till9_yard_str,above10_yd_str,fullmtrs_str,till9_mtrs_str,above10_mtrs_str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_edit);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("EditArticle");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);




        Intent in = getIntent();
        article_no_edit.setText(in.getStringExtra("article_no"));
        note_edit.setText(in.getStringExtra("note_article"));
        articleId=in.getStringExtra("article_id");

        occa_str=in.getStringExtra("occassion");
        fullYards_str=in.getStringExtra("fullYards");
        till9_yard_str=in.getStringExtra("till9_yard");
        above10_yd_str =in.getStringExtra("above10_yd");
        fullmtrs_str =in.getStringExtra("fullmtrs");
        till9_mtrs_str =in.getStringExtra("till9_mtrs");
        above10_mtrs_str =in.getStringExtra("above10_mtrs");

        occassion_edit.setText(occa_str);
        fullYards_edit.setText(fullYards_str);
        till9_yard_edit.setText(till9_yard_str);
        above10_yd_edit.setText(above10_yd_str);
        fullmtrs_edit.setText(fullmtrs_str);
        till9_mtrs_edit.setText(till9_mtrs_str);
        above10_mtrs_edit.setText(above10_mtrs_str);


        presenter = new updateArticlePresenterImpl(this);
        Composition_presenter = new CompositionPresenterImpl(this);
        Composition_presenter.viewAll("view_all");

        com.obpoo.gfsfabricsoftware.Article.Adapter.SpinnerAdapter adapter = new com.obpoo.gfsfabricsoftware.Article.Adapter.SpinnerAdapter(getFabricTypeList, this);
        ft_edit.setAdapter(adapter);

        ft_edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FabricTypePOJOArrayData ftpa = (FabricTypePOJOArrayData)parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(),ftpa.getFabricType(),Toast.LENGTH_SHORT).show();
                ft_spinner_val=ftpa.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        composition_edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ComposotionDetail cd = (ComposotionDetail)parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(),cd.getComposition(),Toast.LENGTH_SHORT).show();
                composition_str=cd.getId();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    @OnClick(R.id.update_article)
    public void onClick() {

        Log.i("updateArticelData",articleId+","+article_no_edit.getText().toString()+","+note_edit.getText().toString()+","+ft_spinner_val);
        presenter.sendRequest("update",articleId,article_no_edit.getText().toString(),note_edit.getText().toString(),ft_spinner_val,
                fullYards_edit.getText().toString(),till9_yard_edit.getText().toString(),above10_yd_edit.getText().toString(),
                fullmtrs_edit.getText().toString(),till9_mtrs_edit.getText().toString(),above10_mtrs_edit.getText().toString(),
                composition_str,occassion_edit.getText().toString());

    }


    @Override
    public void onUpdateArticle(updateArticleResponse response) {
        Log.i("ArticleUpdate",response.getMessage());
      Intent in = new Intent(ArticleEdit.this,Stock.class);
      startActivity(in);
      finish();

    }

    @Override
    public void onValidate(int type) {
        switch (type){
            case 1:
                article_no_edit.setError("Enter Article No");
                break;
            case 2:
                note_edit.setError("Enter Note");
                break;
        }

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
    public void onValidationFail(int type) {

    }

    @Override
    public void viewCompositionList(CompositionResponse response) {
        compositionList = response.getDetail();
        CompositionSpinnerAdapter cAdapter= new CompositionSpinnerAdapter(compositionList,this);
        composition_edit.setAdapter(cAdapter);
    }
}
