package com.obpoo.gfsfabricsoftware.Associate_Tailor.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.Adapter.AssoFabAdp;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponseDatum;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricData;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP.ATpresenterImpl;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP.ATview;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssociateFabrics extends BaseActivity  implements ATview {
    @BindView(R.id.rv_bi)
    RecyclerView rv_bi_af;
    ATpresenterImpl presenter;
    ArrayList<AssoFabricData> assoFabricData;
    @BindView(R.id.etSearch)
    EditText etSearch;
    AssoFabAdp adapterAssoFab;
    @BindView(R.id.progressbar_asso_fab)
    ProgressBar progressbar_asso_fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associate_fabrics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Associate Fabrics");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter = new ATpresenterImpl(this);
        presenter.sendAssoFabrics("view_fab_associates");

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });
    }

    private void filter(String text_val) {
        ArrayList<AssoFabricData> temp = new ArrayList<>();
        for(AssoFabricData af : assoFabricData ){
            if(af.getFabName().toLowerCase().contains(text_val)){
                temp.add(af);
            }
        }
        adapterAssoFab.updateList(temp);

    }

    @Override
    public void ATretriveData(ATresponse response) {


    }

    @Override
    public void associateActicity(AssociateActivity response) {

    }

    @Override
    public void assoFabrics(AssoFabricResponse response) {

        assoFabricData= response.getData();

        presenter.sendFabChangeURL("get_store_url");


    }

    @Override
    public void changeFabURL(AssociateFabricChangeURL response) {
        String store_url = response.getStoreUrl();

        Log.i("ATresponseDatum",response.getMessage());
        adapterAssoFab = new AssoFabAdp(assoFabricData,AssociateFabrics.this,store_url);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv_bi_af.setLayoutManager(lm);
        rv_bi_af.setAdapter(adapterAssoFab);

    }

    @Override
    public void changeFabricStatus(AssociateFabircChangeRes response) {

    }

    @Override
    public void changeTailorRequest(AssociateActivity response) {

    }

    @Override
    public void showDialog() {
        progressbar_asso_fab.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progressbar_asso_fab.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }
}
