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

import com.obpoo.gfsfabricsoftware.Associate_Tailor.Adapter.ATadapter;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponseDatum;
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

public class AssociateTailorMain extends BaseActivity implements ATview {


    @BindView(R.id.rv_bi)
    RecyclerView rv_at;
    ATpresenterImpl presenter;
    @BindView(R.id.progressasso_tailor)
    ProgressBar progressasso_tailor;
    @BindView(R.id.etSearch)
    EditText etSearch;
    ArrayList<ATresponseDatum> aTresponseDatumArrayList;
    ATadapter aTadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associate_tailor_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Requests");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter= new ATpresenterImpl(this);
        presenter.sendATrequest("view_requests");

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(aTresponseDatumArrayList.size()>0){
                    filter(s.toString());
                }

            }
        });


    }

    private void filter(String text_val) {
        ArrayList<ATresponseDatum> temp = new ArrayList<>();

       for(ATresponseDatum at :aTresponseDatumArrayList){
           if(at.getTailorInfo().getAdminName().toLowerCase().contains(text_val) || at.getActivity().toLowerCase().contains(text_val) ||
              at.getTailorEmail().toLowerCase().contains(text_val) ){
               temp.add(at);
           }
       }
        aTadapter.updateList(temp);



    }

    @Override
    public void ATretriveData(ATresponse response) {
        Log.i("AssociateTailorRes",response.getMessage());
        aTresponseDatumArrayList = response.getData();
        aTadapter = new ATadapter(aTresponseDatumArrayList,AssociateTailorMain.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_at.setLayoutManager(linearLayoutManager);
        rv_at.setAdapter(aTadapter);
        aTadapter.notifyDataSetChanged();

    }

    @Override
    public void associateActicity(AssociateActivity response) {

    }
    @Override
    public void assoFabrics(AssoFabricResponse response) {

    }

    @Override
    public void changeFabURL(AssociateFabricChangeURL response) {

    }

    @Override
    public void changeFabricStatus(AssociateFabircChangeRes response) {

    }

    @Override
    public void changeTailorRequest(AssociateActivity response) {

    }

    @Override
    public void showDialog() {
        progressasso_tailor.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progressasso_tailor.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }


}
