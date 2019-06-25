package com.obpoo.gfsfabricsoftware.Report.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemEasyReport extends BaseActivity {
    @BindView(R.id.allSo_rv)
    RecyclerView allSo_rv;
    @BindView(R.id.progress_allso)
    ProgressBar progress_allso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_so);
        ButterKnife.bind(this);
    }
}
