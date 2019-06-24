package com.obpoo.gfsfabricsoftware.PUG.UI;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class listMap extends BaseActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pick up Guy");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);

        Fragment fragment =ListPUG.newInstance();
        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction().replace(R.id.frameLayout,fragment).commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment = ListPUG.newInstance();
                        break;
                    case 1:
                        //fragment = MapViewPUG.newInstance();
                        fragment = MapPUG.newInstance();
                        break;
                }
                FragmentManager ft = getSupportFragmentManager();
                ft.beginTransaction().replace(R.id.frameLayout,fragment).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
