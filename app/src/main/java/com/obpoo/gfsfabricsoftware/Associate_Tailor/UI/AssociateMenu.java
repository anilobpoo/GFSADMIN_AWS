package com.obpoo.gfsfabricsoftware.Associate_Tailor.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.ui.activities.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssociateMenu extends BaseActivity {
    @BindView(R.id.tailor_req)
    TextView tailor_req;
    @BindView(R.id.fab_req)
    TextView fab_req;
    @BindView(R.id.cardview_asso_menu)
    CardView cardview_asso_menu;
    @BindView(R.id.cardview_asso_menu2)
    CardView cardview_asso_menu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associate_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Associate Tailor");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

    }
    @OnClick(R.id.cardview_asso_menu)
    public void  menu1Click(View view ){
        startActivity(new Intent(AssociateMenu.this, AssociateTailorMain.class));
        finish();
    }
    @OnClick(R.id.cardview_asso_menu2)
    public void  menu2Click(View view ){
        startActivity(new Intent(AssociateMenu.this, AssociateFabrics.class));
        finish();
    }
}
