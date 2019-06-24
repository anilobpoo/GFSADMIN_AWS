package com.obpoo.gfsfabricsoftware.user.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;

import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.user.apapter.UsersAdapter;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserDetail;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.user.mvp.UserPresenterImpl;
import com.obpoo.gfsfabricsoftware.user.mvp.UserView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class User extends BaseActivity implements UserView {


    @BindView(R.id.recycleviewuser)
    RecyclerView recyclerView;


    private NetworkDetection networkDetection;


    UserPresenterImpl presenter;
    private Dialog progressDialog;


    private UsersAdapter mAdapter;

    ArrayList<UserDetail> cartList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        presenter = new UserPresenterImpl(this);
        networkDetection = new NetworkDetection();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        //ButterKnife.bind(getActivity());
        recyclerView =findViewById(R.id.recycleviewuser);
        ImageView add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1 = new Intent(getApplicationContext(),AddUser.class);
                startActivity(in1);
            }
        });
        presenter.viewAll("view_all");
        // viewCompositionList();

        EditText etSearch = findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (cartList != null) {
                    filter(editable.toString());
                }

            }
        });

    }



    void filter(String text) {
        ArrayList<UserDetail> temp = new ArrayList();
        for (UserDetail d : cartList) {
            if (d.getName().toLowerCase().contains(text.toLowerCase())||d.getEmail().toLowerCase().contains(text.toLowerCase())||d.getPhone().toLowerCase().contains(text.toLowerCase()) ) {
                temp.add(d);
            }
        }
        mAdapter.updateList(temp);
    }




    public void showProgressBar() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(getApplicationContext(), getString(R.string.loading_please_wait));
        } else {
            closeProgressbar();
            progressDialog = null;
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(getApplicationContext(), getString(R.string.loading_please_wait));
        }
    }

    public void closeProgressbar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void viewUserList(UserResponse response) {

        Log.e("Response",response.toString());
        Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();


        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            ArrayList<UserDetail> listdata = response.getDetail();
            cartList = listdata;
            mAdapter = new UsersAdapter(this, listdata);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
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

        Log.e("Response",message);
        //Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }
}
