package com.obpoo.gfsfabricsoftware.CommonArticleGroup.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.Adapter.cmnArtAdapter;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticelPOJOdata;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtPresenterImpl;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonArticleGroup extends AppCompatActivity implements cmnArtView,View.OnClickListener{
    @BindView(R.id.toolbar_artCMNgrp)
    Toolbar toolbar_artCMNgrp;
    @BindView(R.id.recyclerView_art_cmn_grp)
    RecyclerView recyclerView_art_cmn_grp;
    @BindView(R.id.pbatshowArticle)
    ProgressBar progressBar;
    ImageView back_stock_article, add_stock_article;

    cmnArtPresenterImpl presenter;
    cmnArtAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_article_group);
        ButterKnife.bind(this);
        back_stock_article = (ImageView) toolbar_artCMNgrp.findViewById(R.id.back_stock_cmngrp);
        add_stock_article = (ImageView) toolbar_artCMNgrp.findViewById(R.id.add_stock_cmngrp);
        back_stock_article.setOnClickListener(this);
        add_stock_article.setOnClickListener(this);
        presenter = new cmnArtPresenterImpl(this);
        presenter.showCmnArticleGroup("view_all");

    }

    @Override
    public void onShowCmnArtGroup(cmnArticlePOJO response) {
        showCmnArtinRecyclerView(response);

    }

    @Override
    public void ondeleteCmnArtGroup(cmnArtdeletePOJO response) {
        Toast.makeText(getApplicationContext(),response.getMessage(),Toast.LENGTH_SHORT).show();
        System.out.println("fifteen");
        adapter.notifyDataSetChanged();
    }

    private void showCmnArtinRecyclerView(cmnArticlePOJO response) {
        ArrayList<cmnArticelPOJOdata> cmnArtList  = response.getData();
        adapter = new cmnArtAdapter(CommonArticleGroup.this,cmnArtList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CommonArticleGroup.this);
        recyclerView_art_cmn_grp.setLayoutManager(linearLayoutManager);
        recyclerView_art_cmn_grp.setAdapter(adapter);
        adapter.notifyDataSetChanged();
 }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_stock_cmngrp:
                finish();
                break;
            case R.id.add_stock_cmngrp:
                int NR = -1;
                Intent in = new Intent(CommonArticleGroup.this,AddCmnArtGroup.class);
                in.putExtra("Add_UPDATE_SimilarArticleIn","AddSimilarArticle");
                in.putExtra("SimilarPosition",NR);
                startActivity(in);
                finish();

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
}
