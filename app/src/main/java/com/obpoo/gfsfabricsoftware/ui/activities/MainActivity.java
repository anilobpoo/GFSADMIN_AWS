package com.obpoo.gfsfabricsoftware.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;
import com.splunk.mint.Mint;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mint.initAndStartSession(this.getApplication(), "ae78050d");
        setContentView(R.layout.activity_main);
        enableActionBar(false);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        String storeId=  PreferenceConnector.readString(this, getString(R.string.admin_id),"");
        if (storeId.isEmpty())
        {
            Login();
        }else
        {
            HomeRun();
        }
    }

    public void Login()
    {
         /*
        /****** Create Thread that will sleep for 5 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(1*3000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),LoginActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }

                /*7977797370
                        150*/
            }
        };

        // start thread
        background.start();
    }


    public void HomeRun()
    {
         /*
        /****** Create Thread that will sleep for 5 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(1*3000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),HomeActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }
}
