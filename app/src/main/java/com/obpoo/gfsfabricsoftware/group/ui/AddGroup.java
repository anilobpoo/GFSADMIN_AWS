package com.obpoo.gfsfabricsoftware.group.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;
import com.obpoo.gfsfabricsoftware.group.mvp.GroupPresenterImpl;
import com.obpoo.gfsfabricsoftware.group.mvp.GroupView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddGroup extends BaseActivity implements GroupView {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.submit)
    Button add;
    private NetworkDetection networkDetection;
    @BindView(R.id.percentage) EditText percentage;
    GroupPresenterImpl presenter;
    String admin_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group2);
        admin_id=  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Group");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        presenter=new GroupPresenterImpl(this);
        networkDetection = new NetworkDetection();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deptName=name.getText().toString().trim();
                String percent=percentage.getText().toString().trim();

                if (deptName.isEmpty())
                {
                    name.setError("Required");
                    name.requestFocus();
                    return;
                }
                if (percent.isEmpty())
                {
                    percentage.setError("Required");
                    percentage.requestFocus();
                    return;
                }

                add(deptName,percent);

            }
        });
    }

    public void add(String name,String percent)
    {
        if (networkDetection.isWifiAvailable(this) || networkDetection.isMobileNetworkAvailable(this)) {
            showProgressBar();
            presenter.addAll("add_customer_group",name,percent,admin_id);

        } else {
            Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onValidationFail(int type) {


    }

    @Override
    public void onLoad(GroupResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            closeProgressbar();
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
            finish();

        }else
        {
            closeProgressbar();
            showError(response.toString());
        }
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



}
