package com.obpoo.gfsfabricsoftware.ui.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.UI.AssociateMenu;
import com.obpoo.gfsfabricsoftware.Dashboard.UI.HomeFrag;
import com.obpoo.gfsfabricsoftware.Dashboard.UI.StockArticleFrag;
import com.obpoo.gfsfabricsoftware.PUG.UI.listMap;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.PO;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.UI.ReportMenus;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TransferStockAct;
import com.obpoo.gfsfabricsoftware.collections.ui.CollectionsDetails;
import com.obpoo.gfsfabricsoftware.salesorder.ui.MyOrders;
import com.obpoo.gfsfabricsoftware.salesorder.ui.SOMenu;
import com.obpoo.gfsfabricsoftware.utilities.CircleTransform;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;
import java.util.List;

import static com.obpoo.gfsfabricsoftware.utilities.Constants.FSPIC;
import static com.obpoo.gfsfabricsoftware.utilities.Constants.NO_PIC;

public class HomeActivity extends AppCompatActivity {

    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private static final String urlNavHeaderBg = "https://api.androidhive.info/images/nav-menu-header-bg.jpg";
    //private static final String urlNavHeaderBg = "http://furnirworld.com/images/logo.png";
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> menu = new ArrayList<>();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayAdapter mStringAdaptor;
    String name, email, admin_id, profile_pic;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        requestStoragePermission();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Dashboard");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Fragment fragment = new HomeFrag();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        txtName = (TextView) findViewById(R.id.name);
        txtWebsite = (TextView) findViewById(R.id.website);
        LinearLayout clickLayout = (LinearLayout) findViewById(R.id.clickLayout);
        clickLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Home.this, EditProfile.class));
            }
        });
        imgNavHeaderBg = (ImageView) findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) findViewById(R.id.img_profile);
        admin_id = PreferenceConnector.readString(getApplicationContext(), getString(R.string.admin_id), "");
        name = PreferenceConnector.readString(getApplicationContext(), getString(R.string.name), "");
        email = PreferenceConnector.readString(getApplicationContext(), getString(R.string.email), "");
        profile_pic = PreferenceConnector.readString(getApplicationContext(), getString(R.string.profile_pic), "");
        menu = PreferenceConnector.getArrayList(getString(R.string.previledges), HomeActivity.this);

        loadNavHeader();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        list.add("Home");
        for (int i = 0; i < menu.size(); i++) {
            list.add(menu.get(i));
        }
        list.add("Pickup Guy");
        list.add("Logout");

        mStringAdaptor = new ArrayAdapter<String>(this, R.layout.drawer_list_item, list);
        mDrawerList.setAdapter(mStringAdaptor);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = String.valueOf(parent.getItemAtPosition(position)).toLowerCase();
                if (name.equals("master")) {
                    Toast.makeText(HomeActivity.this, name, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, MasterActivity.class));
                }
                if (name.equals("stock")) {
                    Toast.makeText(HomeActivity.this, name, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, StockActivityMain.class));
                }
                if (name.equals("logout")) {
                    showLogoutAlertDialog();
                }

                if (name.equals("purchase order")) {
                    startActivity(new Intent(HomeActivity.this, PO.class));
                }

                if (name.equals("sale orders")) {
                  //  startActivity(new Intent(HomeActivity.this, MyOrders.class));
                    startActivity(new Intent(HomeActivity.this, SOMenu.class));
                }
                if (name.equals("pickup guy")) {
                    startActivity(new Intent(HomeActivity.this, listMap.class));
                }
                if (name.equals("home")) {
                    Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                }
                if (name.equals("transfer stock")) {
                    startActivity(new Intent(HomeActivity.this, TransferStockAct.class));
                }
                if (name.equals("report")) {
                    startActivity(new Intent(HomeActivity.this, ReportMenus.class));
                }
                if (name.equals("associate tailors")) {
                    startActivity(new Intent(HomeActivity.this, AssociateMenu.class));
                }
                if (name.equals("collections")) {
                    startActivity(new Intent(HomeActivity.this, CollectionsDetails.class));
                }


            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        setupDrawer();


        //TabLayout tabLayout =(TabLayout)toolbar.findViewById(R.id.tablayout);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setTabTextColors(getResources().getColor(R.color.red_500), getResources().getColor(R.color.green_500));

        TabLayout.Tab homeTab = tabLayout.newTab();
        homeTab.setText("HOME");
        tabLayout.addTab(homeTab);

        TabLayout.Tab stockAlertTab = tabLayout.newTab();
        stockAlertTab.setText("STOCK\nALERT");
        tabLayout.addTab(stockAlertTab);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFrag();

                        break;
                    case 1:
                        fragment = new StockArticleFrag();
                        break;

                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item);
    }


    private void setupDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Home");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    private void loadNavHeader() {
        txtName.setText(name);
        txtWebsite.setText(email);
        String imageUrl;

        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);


        if (profile_pic.equals("images.png") || profile_pic.equals(""))
            imageUrl = NO_PIC;
        else
            imageUrl = FSPIC + profile_pic;


        Glide.with(this).load(imageUrl)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void requestStoragePermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            //Toast.makeText(getApplicationContext(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
                        }
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    private void showLogoutAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        alertDialogBuilder.setTitle(getResources().getString(R.string.app_name));
        alertDialogBuilder.setMessage("Are you sure you want to Log out?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                logoutFromApplication();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void logoutFromApplication() {
        PreferenceConnector.clearData(this);
        goToLoginScreen();
    }

    private void goToLoginScreen() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(loginIntent);
    }


}
