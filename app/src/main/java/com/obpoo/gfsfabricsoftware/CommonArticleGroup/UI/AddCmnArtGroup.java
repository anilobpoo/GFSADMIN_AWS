package com.obpoo.gfsfabricsoftware.CommonArticleGroup.UI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cunoraz.tagview.Tag;
import com.cunoraz.tagview.TagView;
import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockView;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.AddCadPOJOdata;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.addCagPOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticelPOJOdata;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticleDATA;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.UpdateSMGmodel;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup.AddCmgPresenterImpl;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup.AddCmgView;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtPresenterImpl;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCmnArtGroup extends BaseActivity implements AddCmgView,cmnArtView,StockView {
    @BindView(R.id.edit_QG)
    EditText edit_QG;
    @BindView(R.id.edit_QN)
    EditText edit_QN;
    @BindView(R.id.edit_QD)
    EditText edit_QD;
    @BindView(R.id.colorLayout)
    LinearLayout colorLayout;
    @BindView(R.id.tagView_add_cmnArt)
    TagView tagView_add_cmnArt;
    @BindView(R.id.addGroup)
    Button addGroup;
    @BindView(R.id.updateGroup)
    Button updateGroup;
    @BindView(R.id.pbataddArticle)
    ProgressBar progressbar;
    @BindView(R.id.clickFabrics)
    TextView clickFabrics;

    AddCmgPresenterImpl presenter;
    ArrayList<AddCadPOJOdata> CmmnArtGrpList;
    ArrayList<StockDataResponse> getArticleList;
    List<String> getCheckedValues;
    String getUpdate_addTitle;
    int similarIndex;
    ArrayList<cmnArticelPOJOdata> cmnArtList;
    cmnArtPresenterImpl presenterForEditList;
    StockPresenterImpl getArticles_presenter;
    String[] getAsArray;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {

            getCheckedValues = data.getStringArrayListExtra("checkedColors");
            System.out.println(getCheckedValues+"getCheckedValues");

            getAsArray = getCheckedValues.toArray(new String[getCheckedValues.size()]);
            tagView_add_cmnArt.removeAll();
            tagView_add_cmnArt.addTags(getAsArray);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cmn_art_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Similar Article");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        presenter = new AddCmgPresenterImpl(this);
//        presenter.showColorsForCMNArtGroup("view_all");
        getArticles_presenter = new StockPresenterImpl(this);
        getArticles_presenter.showResponse("viewall");


        Intent in = getIntent();
        getUpdate_addTitle= in.getStringExtra("Add_UPDATE_SimilarArticleIn");
        similarIndex=in.getIntExtra("SimilarPosition",0);

        Log.i("Add_UPDATE",getUpdate_addTitle+","+similarIndex);

        if(getUpdate_addTitle.equals("UpdateSimilarArticle")){
            presenterForEditList = new cmnArtPresenterImpl(this);
            presenterForEditList.showCmnArticleGroup("view_all");
            updateGroup.setVisibility(View.VISIBLE);
            addGroup.setVisibility(View.GONE);
            toolbar.setTitle("Edit Similar Article");

        }


        tagView_add_cmnArt.setOnTagLongClickListener(new TagView.OnTagLongClickListener() {
            @Override
            public void onTagLongClick(Tag tag, final int i) {
                final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddCmnArtGroup.this);
                alertBuilder.setTitle("Do you want to delete "+getAsArray[i]);
                alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getCheckedValues.remove(i);
                        getAsArray = getCheckedValues.toArray(new String[getCheckedValues.size()]);
                        tagView_add_cmnArt.removeAll();
                        tagView_add_cmnArt.addTags(getAsArray);



                    }
                });
                alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();

                    }
                });
                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();

            }
        });


    }

    @OnClick(R.id.addGroup)
    public void onClick() {
        Log.i("clicked", "ADDGROUP");

        presenter.addCmnAddArticleGroup("add_article_group", edit_QG.getText().toString(),
                getCheckedValues, edit_QD.getText().toString(), edit_QN.getText().toString());

    }
    @OnClick(R.id.updateGroup)
    public void updateGroupClik(){
        Log.i("updateGroupClik", String.valueOf(getCheckedValues.size()));
        presenter.updateCmdArticleGroup("update_group",cmnArtList.get(similarIndex).getId(),edit_QG.getText().toString(),
                getCheckedValues, edit_QD.getText().toString(), edit_QN.getText().toString());
    }

    @OnClick(R.id.colorLayout)
    public void getColors() {
        System.out.println("ArticleValues"+getArticleList.get(0).getArticleno());

        try{
        System.out.println("Enter 1");
        Intent in = new Intent(AddCmnArtGroup.this, checkColorsCAG.class);
        in.putExtra("ARTICLESlist",getArticleList);

        if(getCheckedValues!=null){
            in.putStringArrayListExtra("SelectedColorsBackCheck",(ArrayList<String>)getCheckedValues);
        }
        startActivityForResult(in, 2);}
        catch(Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onShowADDCMGVIEW(addCagPOJO response) {
        Log.i("clicked", "addCagPOJOReceived");
        CmmnArtGrpList = response.getData();


    }

    @Override
    public void onShowSimilarArticleAdded(similarArticleDATA response) {
        Toast.makeText(this, "Similar Article  Added Successfully", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(AddCmnArtGroup.this,CommonArticleGroup.class);
        startActivity(in);
        finish();


    }

    @Override
    public void onShowSimilarArticleupdate(UpdateSMGmodel response) {
        Log.i("Updated","Successfully");
        Toast.makeText(this, "Similar Article  Updated Successfully", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(AddCmnArtGroup.this,CommonArticleGroup.class);
        startActivity(in);
        finish();

    }

    @Override
    public void onValidationFail(int type) {
        switch (type){
            case 0:
                edit_QG.setError("Enter Group Name");
                break;
            case 1:
                edit_QD.setError("Enter Quality Description");
                break;
            case 2:
                edit_QN.setError("Enter Quality Name");
                break;
            case 3:
                clickFabrics.setText(getResources().getString(R.string.addArticle));
                clickFabrics.setTextColor(Color.RED);
                break;


        }

    }

    @Override
    public void onShowCmnArtGroup(cmnArticlePOJO response) {
        Log.i("ClickedForEDIT","ClickedForEDIT");
        cmnArtList=response.getData();
        edit_QG.setText(cmnArtList.get(similarIndex).getGroupName());
        edit_QN.setText(cmnArtList.get(similarIndex).getQualityName());
        edit_QD.setText(cmnArtList.get(similarIndex).getQualityDescription());

        String[] similarDataArray = null;
        try {
            if (cmnArtList.get(similarIndex).getSimillarArticleNo().equals(null)) {
                Toast.makeText(getApplicationContext(), "null@ADDCMNARTGROUP" , Toast.LENGTH_SHORT).show();

            } else {
                similarDataArray = cmnArtList.get(similarIndex).getSimillarArticleNo().toArray(new String[cmnArtList.get(similarIndex).getSimillarArticleNo().size()]);
                getCheckedValues=cmnArtList.get(similarIndex).getSimillarArticleNo();
                tagView_add_cmnArt.addTags(similarDataArray);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void ondeleteCmnArtGroup(cmnArtdeletePOJO response) {

    }

    @Override
    public void showDialog() {
        progressbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progressbar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onGetResponse(String name, int drawable) {

    }

    @Override
    public void onShowStock(stockPOJO response) {
        getArticleList=response.getData();
        Log.i("ColorDebug",response.getMessage());

    }

    @Override
    public void onshowFabricType(fabricTypePOJO response) {

    }

    @Override
    public void onshowDeleteArticel(deletearticelPOJO response) {

    }
}
