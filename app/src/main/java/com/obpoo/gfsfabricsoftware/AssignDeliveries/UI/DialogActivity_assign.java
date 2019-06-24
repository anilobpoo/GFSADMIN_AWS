package com.obpoo.gfsfabricsoftware.AssignDeliveries.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.Adapter.SpinnerPgAdp;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponseList;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP.AssignDeliveryPresenterImpl;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP.AssignDeliveryView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity_assign extends Activity implements AssignDeliveryView{
    @BindView(R.id.pg_select)
    Spinner pg_spinner;
    @BindView(R.id.assign)
    Button assign;
    @BindView(R.id.cancel)
    Button cancel;
    ArrayList<PGresponseList> pglist;
    String getPgList,order_id;
    AssignDeliveryPresenterImpl presenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pgassign_dialog);
        ButterKnife.bind(this);
        this.setFinishOnTouchOutside(false);
        Intent in = getIntent();
        pglist= new ArrayList<>();
        presenter = new AssignDeliveryPresenterImpl(this);
        pglist =  (ArrayList<PGresponseList>)in.getSerializableExtra("PGRESPONSELIST");
        order_id=in.getStringExtra("ORDERID");
        Log.i("check_list",pglist.get(0).getName());

        SpinnerPgAdp adapter = new SpinnerPgAdp(pglist,DialogActivity_assign.this);

        pg_spinner.setAdapter(adapter);

        pg_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),pglist.get(position).getId(),Toast.LENGTH_SHORT).show();
                getPgList=pglist.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @OnClick(R.id.assign)
    public void onAssign(){
        Toast.makeText(getApplicationContext(),getPgList,Toast.LENGTH_SHORT).show();
        presenter.onAssignPg("pg_assign",getPgList,order_id);


    }
    @OnClick(R.id.cancel)
    public void onCancel(){
        Intent in = new Intent(DialogActivity_assign.this,AssignDelivery_Act.class);
        startActivity(in);
        finish();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onShowViewDeliveries(DeliveryData response) {

    }

    @Override
    public void onShowAllPGList(PGresponse response) {

    }

    @Override
    public void onShowAssignPg(AssignPgResponse response) {
        Log.i("assignPG",response.getMessage());
        Intent in = new Intent(DialogActivity_assign.this,AssignDelivery_Act.class);
        startActivity(in);

    }
}
