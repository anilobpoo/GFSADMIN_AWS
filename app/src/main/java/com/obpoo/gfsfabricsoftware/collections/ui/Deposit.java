package com.obpoo.gfsfabricsoftware.collections.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import com.obpoo.gfsfabricsoftware.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Deposit extends AppCompatActivity {

    @BindView(R.id.card2)
    CardView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        ButterKnife.bind(this);
    }
}
