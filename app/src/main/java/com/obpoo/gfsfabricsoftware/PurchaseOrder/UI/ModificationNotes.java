package com.obpoo.gfsfabricsoftware.PurchaseOrder.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModificationNotes extends BaseActivity implements poView {
    @BindView(R.id.add_notes_CPO)
    EditText add_notes_CPO;
    @BindView(R.id.pre_add_notes)
    TextView pre_add_notes;
    @BindView(R.id.save_mn)
    Button save_mn;
    @BindView(R.id.cancel_mn)
    Button cancel_mn;
    @BindView(R.id.progress_mn)
    ProgressBar progress_mn;

    String orderID;
    poPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Note");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        pre_add_notes.setText(getIntent().getStringExtra("PREVNOTES"));
        orderID = getIntent().getStringExtra("ORDERID");

        presenter = new poPresenterImpl(this);


    }
    @OnClick(R.id.save_mn)
    public void onSaveMN(View view){
        presenter.onPassModifyNotes("add_notes_mod",add_notes_CPO.getText().toString(),orderID);

    }

    @Override
    public void onShowViewPO(poPOJO response) {

    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {

    }

    @Override
    public void onValidationfail(int type) {

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    @Override
    public void onModifyNotes(ModifyNotes response) {
        if(response.getStatus().equals("success")){
            Intent in = new Intent(ModificationNotes.this,ConfirmPO.class);
            startActivity(in);
            finish();
        }

    }

    @Override
    public void showDialog() {
        progress_mn.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progress_mn.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }
    @OnClick(R.id.cancel_mn)
    public void onCancelMN(View view){
        finish();
    }
}
