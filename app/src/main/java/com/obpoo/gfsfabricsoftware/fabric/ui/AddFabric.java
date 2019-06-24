package com.obpoo.gfsfabricsoftware.fabric.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockView;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ComposotionDetail;
import com.obpoo.gfsfabricsoftware.Composition.mvp.CompositionPresenterImpl;
import com.obpoo.gfsfabricsoftware.Composition.mvp.CompositionView;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorDetail;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorView;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorDetail;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricColorResponse;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsPresenterImpl;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsView;
import com.obpoo.gfsfabricsoftware.fabric.mvp.fabriccolor.FabricColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.fabric.mvp.fabriccolor.FabricColorView;
import com.obpoo.gfsfabricsoftware.ui.activities.BaseActivity;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.Config;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AddFabric extends BaseActivity implements FabricsView,StockView,CompositionView,ColorView,FabricColorView {
    FabricsPresenterImpl presenter;
    List<String> colorList,compList,articleList;
    CharSequence[] colors,comps,articles;
    List<String> colordesc =new ArrayList<>();

    ArrayList<StockDataResponse> stocklist=new ArrayList<>();
    ArrayList<ColorDetail> colorsList=new ArrayList<>();
    ArrayList<FabricColorDetail> fabricColorDetails=new ArrayList<>();
    ArrayList<ComposotionDetail> compsList=new ArrayList<>();
    String colorId,compId,tag="0",articleId;

    @BindView(R.id.name) EditText name;
    @BindView(R.id.comp) EditText comp;
    @BindView(R.id.article) EditText article;
    @BindView(R.id.color) EditText color;
    @BindView(R.id.width) EditText width;
    @BindView(R.id.costpermeter) EditText costpermeter;
    @BindView(R.id.costperyard) EditText costperyard;
    @BindView(R.id.sellpermeter) EditText sellpermeter;
    @BindView(R.id.sellperyard) EditText sellperyard;
    @BindView(R.id.minstockmtr) EditText minstockmtr;
    @BindView(R.id.minstockyard) EditText minstockyard;
    @BindView(R.id.maxstockmtr) EditText maxstockmtr;
    @BindView(R.id.maxstockyrd) EditText maxstockyrd;
    @BindView(R.id.userminyard) EditText userminyard;
    @BindView(R.id.userminmeter) EditText userminmeter;
    @BindView(R.id.desc) EditText desc;
    String mfullroleprices,yfullroleprices,monetonines,yonetonines,mtenandaboves,ytenandaboves;

    String names,compss,articless,colorss,widths,costpermeters,costperyards,sellpermeters,sellperyards,minstockmtrs,minstockyards,maxstockmtrs,maxstockyrds,descs;

    String userminyards,userminmeters;
    @BindView(R.id.copic1) ImageView imageView1;
    @BindView(R.id.copic2) ImageView imageView2;
    @BindView(R.id.copic3) ImageView imageView3;
    @BindView(R.id.articleOptions) ImageView articleOptions;
    @BindView(R.id.compOptions) ImageView compOptions;
    @BindView(R.id.colorOptions) ImageView colorOptions;
    @BindView(R.id.cup1) TextView cup1;
    @BindView(R.id.cup2) TextView cup2;
    @BindView(R.id.cup3) TextView cup3;
    @BindView(R.id.submit) TextView submit;
    @BindView(R.id.colorLayout)
    LinearLayout colorLayout;


    String filename1="images.png",filename2="images.png",filename3="images.png";
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;
    private Uri fileUri;
    private int PICK_IMAGE_REQUEST = 1;
    private String imagepath=null;
    private ProgressDialog dialog = null;
    StockPresenterImpl stockpresenter;
    ColorPresenterImpl colorPresenter;
    CompositionPresenterImpl compositionPresenter;
    FabricColorPresenterImpl fabricColorPresenter;

    @BindView(R.id.mfullroleprice) EditText mfullroleprice;
    @BindView(R.id.yfullroleprice) EditText yfullroleprice;
    @BindView(R.id.monetonine) EditText monetonine;
    @BindView(R.id.yonetonine) EditText yonetonine;
    @BindView(R.id.mtenandabove) EditText mtenandabove;
    @BindView(R.id.ytenandabove) EditText ytenandabove;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fabric);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Fabric");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        enableActionBar(true);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        presenter = new FabricsPresenterImpl(this);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag="1";
                gallery();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag="2";
                gallery();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag="3";
                gallery();
            }
        });
        stockpresenter = new StockPresenterImpl(this);
        compositionPresenter = new CompositionPresenterImpl(this);
        colorPresenter = new ColorPresenterImpl(this);
        fabricColorPresenter=new FabricColorPresenterImpl(this);

        colorList=new ArrayList<>();
        compList=new ArrayList<>();
        articleList=new ArrayList<>();
        articleOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                articleList.clear();
                stockpresenter.showResponse("viewall");
            }
        });
        colorOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                colorList.clear();
                colorPresenter.viewAll("view_all");
            }
        });

        compOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
                compList.clear();
                compositionPresenter.viewAll("view_all");
            }
        });

        fabricColorPresenter.viewAll("view_all");

        costpermeter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*1.09361;
                    costperyard.setText(""+result);


                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        costperyard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*0.9144;
                    //costpermeter.setText(""+result);


                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sellpermeter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*1.09361;
                    sellperyard.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sellperyard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*0.9144;
                   // sellpermeter.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        minstockmtr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*1.09361;
                    minstockyard.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        minstockyard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*0.9144;
                  //  minstockmtr.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        maxstockmtr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*1.09361;
                    maxstockyrd.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        userminmeter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*1.09361;
                    userminyard.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        maxstockyrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try {

                    double change= Double.valueOf(charSequence.toString());
                    double result=change*0.9144;
                   // maxstockmtr.setText(""+result);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                names=name.getText().toString().trim();
                compss=comp.getText().toString().trim();
                articless=article.getText().toString().trim();
                colorss=color.getText().toString().trim();
                widths=width.getText().toString().trim();
                costpermeters=costpermeter.getText().toString().trim();
                costperyards=costperyard.getText().toString().trim();
                sellpermeters=sellpermeter.getText().toString().trim();
                sellperyards=sellperyard.getText().toString().trim();
                minstockmtrs=minstockmtr.getText().toString().trim();
                minstockyards=minstockyard.getText().toString().trim();
                maxstockmtrs=maxstockmtr.getText().toString().trim();
                maxstockyrds=maxstockyrd.getText().toString().trim();
                descs=desc.getText().toString().trim();
                userminmeters=userminmeter.getText().toString().trim();
                userminyards=userminyard.getText().toString().trim();


                mfullroleprices=mfullroleprice.getText().toString().trim();
                monetonines=monetonine.getText().toString().trim();
                yonetonines=yonetonine.getText().toString().trim();
                mtenandaboves=mtenandabove.getText().toString().trim();
                yfullroleprices=yfullroleprice.getText().toString().trim();
                ytenandaboves=ytenandabove.getText().toString().trim();

                if (names.isEmpty())
                {
                    name.setError("Required");
                    name.requestFocus();
                    return;
                }

                if (articless.isEmpty())
                {
                    article.setError("Required");
                    article.requestFocus();
                    return;
                }

                if (colorss.isEmpty())
                {
                    color.setError("Required");
                    color.requestFocus();
                    return;
                }

                if (mfullroleprices.isEmpty())
                {
                    mfullroleprice.setError("Required");
                    mfullroleprice.requestFocus();
                    return;
                }

                if (yfullroleprices.isEmpty())
                {
                    yfullroleprice.setError("Required");
                    yfullroleprice.requestFocus();
                    return;
                }


                if (monetonines.isEmpty())
                {
                    monetonine.setError("Required");
                    monetonine.requestFocus();
                    return;
                }

                if (yonetonines.isEmpty())
                {
                    yonetonine.setError("Required");
                    yonetonine.requestFocus();
                    return;
                }

                if (mtenandaboves.isEmpty())
                {
                    mtenandabove.setError("Required");
                    mtenandabove.requestFocus();
                    return;
                }

                if (ytenandaboves.isEmpty())
                {
                    ytenandabove.setError("Required");
                    ytenandabove.requestFocus();
                    return;
                }

                if (widths.isEmpty())
                {
                    width.setError("Required");
                    width.requestFocus();
                    return;
                }


                if (costpermeters.isEmpty())
                {
                    costpermeter.setError("Required");
                    costpermeter.requestFocus();
                    return;
                }

                if (costperyards.isEmpty())
                {
                    costperyard.setError("Required");
                    costperyard.requestFocus();
                    return;
                }

                if (sellpermeters.isEmpty())
                {
                    sellpermeter.setError("Required");
                    sellpermeter.requestFocus();
                    return;
                }

                if (sellperyards.isEmpty())
                {
                    sellperyard.setError("Required");
                    sellperyard.requestFocus();
                    return;
                }

                if (minstockmtrs.isEmpty())
                {
                    minstockmtr.setError("Required");
                    minstockmtr.requestFocus();
                    return;
                }

                if (minstockyards.isEmpty())
                {
                    minstockyard.setError("Required");
                    minstockyard.requestFocus();
                    return;
                }

                if (maxstockmtrs.isEmpty())
                {
                    maxstockmtr.setError("Required");
                    maxstockmtr.requestFocus();
                    return;
                }

                if (maxstockyrds.isEmpty())
                {
                    maxstockyrd.setError("Required");
                    maxstockyrd.requestFocus();
                    return;
                }

                if (userminmeters.isEmpty())
                {
                    userminmeter.setError("Required");
                    userminmeter.requestFocus();
                    return;
                }


                if (userminyards.isEmpty())
                {
                    userminyard.setError("Required");
                    userminyard.requestFocus();
                    return;
                }

                if (descs.isEmpty())
                {
                    desc.setError("Required");
                    desc.requestFocus();
                    return;
                }


                presenter.addFabric("addFabric",filename1,filename2,filename3,names,articleId,widths,colorId,costpermeters,
                        costperyards,sellpermeters,sellperyards,minstockmtrs,minstockyards,maxstockmtrs,maxstockyrds,descs,colorList,
                        userminmeters,userminyards,yfullroleprices,yonetonines,ytenandaboves,mfullroleprices,monetonines,mtenandaboves);

            }
        });


    }



    @Override
    public void onValidationFail(int type) {

    }


    @Override
    public void onLoad(ColorResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            colorsList = response.getDetail();
            for (int i = 0; i < colorsList.size(); i++) {
                String name=colorsList.get(i).getColor_code();
                colorList.add(name);
            }
            colors();

        }else
        {
            hideDialog();
            showError(response.toString());
        }


    }

    @Override
    public void viewCompositionList(CompositionResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            compsList = response.getDetail();
            for (int i = 0; i < compsList.size(); i++) {
                String name=compsList.get(i).getComposition();
                compList.add(name);
            }
            comps();

        }else
        {
            hideDialog();
            showError(response.toString());
        }

    }

    @Override
    public void onLoad(FabricsResponse response) {

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
        showProgressBar();
    }

    @Override
    public void hideDialog() {
        closeProgressbar();
    }

    @Override
    public void showError(String message) {

    }

    private void doFileUpload(String ImagePath) {
        File file1 = null;
        String urlString = "http://furnirworld.com/giovanifs/api/upload.php";

        if (!(ImagePath.trim().equalsIgnoreCase("NONE"))) {
            file1 = new File(ImagePath);
        }
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(urlString);
            org.apache.http.entity.mime.MultipartEntity reqEntity = new org.apache.http.entity.mime.MultipartEntity();
            if (!(ImagePath.trim().equalsIgnoreCase("NONE"))) {
                org.apache.http.entity.mime.content.FileBody bin1 = new org.apache.http.entity.mime.content.FileBody(file1);
                reqEntity.addPart("uploaded_file", bin1);

            }


            reqEntity.addPart("upload_to", new StringBody("Fabric"));
            post.setEntity(reqEntity);
            HttpResponse response = client.execute(post);
            HttpEntity resEntity;
            resEntity = response.getEntity();
            final String response_str = EntityUtils.toString(resEntity);
            Log.e("RESPONSE", response_str);
            if (resEntity != null) {
                Log.i("RESPONSE", response_str);
                runOnUiThread(new Runnable() {
                    public void run() {
                        try {

                            JSONObject jobj = new JSONObject(response_str);
                            String imageUrl = jobj.getString("message");

                            if (tag.equals("1"))
                            {
                                filename1 = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
                                Log.e("filename1",filename1);
                            }else if (tag.equals("2"))
                            {
                                filename2 = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
                                Log.e("filename2",filename2);
                            }else if (tag.equals("3"))
                            {
                                filename3 = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
                                Log.e("filename3",filename3);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception ex) {
            Log.e("Debug", "error: " + ex.getMessage(), ex);
        }
    }


    public void gallery()
    {
        List<String> mAnimals = new ArrayList<String>();
        mAnimals.add("Camera");
        mAnimals.add("Gallery");

        final CharSequence[] Animals = mAnimals.toArray(new String[mAnimals.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setItems(Animals, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = Animals[item].toString();

                if(selectedText.equals("Camera"))
                {

                    captureImage();
                }
                if(selectedText.equals("Gallery"))
                {
                    showFileChooser();
                }


            }
        });
        //Create alert dialog object via builder
        AlertDialog alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }


    private void showFileChooser() {


        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);


    }



    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                Config.IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("ImageVideo", "Oops! Failed create "
                        + Config.IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");

        }  else {
            return null;
        }

        return mediaFile;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image


        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bitmap photo = (Bitmap) data.getData().getPath();

            Uri selectedImageUri = data.getData();
            Log.e("uri",""+selectedImageUri);
            if (selectedImageUri.getHost().contains("com.android.providers.media")) {
                @SuppressLint({"NewApi", "LocalSuppress"}) String wholeID = DocumentsContract.getDocumentId(selectedImageUri);
                // Split at colon, use second item in the array
                String id = wholeID.split(":")[1];

                String[] column = {MediaStore.Images.Media.DATA};

                // where id is equal to
                String sel = MediaStore.Images.Media._ID + "=?";

                try
                {
                    Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            column, sel, new String[]{id}, null);
                    int columnIndex = cursor.getColumnIndex(column[0]);

                    if (cursor.moveToFirst()) {
                        imagepath = cursor.getString(columnIndex);
                        Log.e("imagepath",imagepath);
                    }
                    cursor.close();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }else
            {
                imagepath = getPath(selectedImageUri);
                Log.e("imagepath",imagepath);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 3;
            Bitmap bitmap = BitmapFactory.decodeFile(imagepath,options);
            try {
                FileOutputStream out = new FileOutputStream(imagepath);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);

                if (tag.equals("1"))
                {
                    imageView1.setImageBitmap(bitmap);
                    cup1.setVisibility(View.GONE);
                }else if (tag.equals("2"))
                {
                    imageView2.setImageBitmap(bitmap);
                    cup2.setVisibility(View.GONE);
                }else if (tag.equals("3"))
                {
                    imageView3.setImageBitmap(bitmap);
                    cup3.setVisibility(View.GONE);
                }
                dialog = ProgressDialog.show(AddFabric.this, "", "Uploading file...", true);
                new Thread(new Runnable() {
                    public void run() {

                        doFileUpload(imagepath);
                        dialog.dismiss();

                    }
                }).start();



            } catch (Exception e) {
                e.printStackTrace();
            }



        }

        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                imagepath = fileUri.getPath();
                Log.e("Pth",imagepath);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;
                final Bitmap bitmap = BitmapFactory.decodeFile(imagepath, options);
                try {
                    FileOutputStream out = new FileOutputStream(imagepath);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, out);
                    if (tag.equals("1"))
                    {
                        imageView1.setImageBitmap(bitmap);
                        cup1.setVisibility(View.GONE);
                    }else if (tag.equals("2"))
                    {
                        imageView2.setImageBitmap(bitmap);
                        cup2.setVisibility(View.GONE);
                    }else if (tag.equals("3"))
                    {
                        imageView3.setImageBitmap(bitmap);
                        cup3.setVisibility(View.GONE);
                    }
                    dialog = ProgressDialog.show(AddFabric.this, "", "Uploading file...", true);
                    new Thread(new Runnable() {
                        public void run() {

                            doFileUpload(imagepath);
                            dialog.dismiss();

                        }
                    }).start();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }




            } else if (resultCode == RESULT_CANCELED) {

                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();

            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }

        }
    }


    public String getPath(Uri uri) {
        Cursor cursor = null;
        try {

            if ("content".equals(uri.getScheme())) {
                String[] projection = {MediaStore.Images.Media.DATA};
                cursor = getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            } else {
                return uri.getPath();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }

    @Override
    public void onGetResponse(String name, int drawable) {

    }

    @Override
    public void onShowStock(stockPOJO response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            stocklist = response.getData();
            for (int i = 0; i < stocklist.size(); i++) {
                String name=stocklist.get(i).getArticleno();
                articleList.add(name);
            }
            articles();

        }else
        {
            hideDialog();
            showError(response.toString());
        }
    }

    @Override
    public void onshowFabricType(fabricTypePOJO response) {

    }

    @Override
    public void onshowDeleteArticel(deletearticelPOJO response) {

    }

    public void articles()
    {
        articles = articleList.toArray(new String[articleList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Article Number");
        dialogBuilder.setItems(articles, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = articles[item].toString();
                articleId=getArticleID(item);
                article.setText(selectedText);
                Log.e("id",articleId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getArticleID(int position){
        String id="";
        try {
            id=stocklist.get(position).getId();
            yonetonine.setText(stocklist.get(position).getPrice1to9());
            monetonine.setText(stocklist.get(position).getPrice1to9mtrs());
            mfullroleprice.setText(stocklist.get(position).getPricefullrollmtrs());
            yfullroleprice.setText(stocklist.get(position).getPricefullroll());
            mtenandabove.setText(stocklist.get(position).getPrice10plusmtrs());
            ytenandabove.setText(stocklist.get(position).getPrice10plus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void colors()
    {

        colors = colorList.toArray(new String[colorList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Colors");
        dialogBuilder.setItems(colors, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = colors[item].toString();
                colorId=getColorId(item);
                color.setText(selectedText);
                Log.e("id",colorId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getColorId(int position){
        String id="";
        try {
            id=colorsList.get(position).getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void comps()
    {

        comps = compList.toArray(new String[compList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Choose Composition");
        dialogBuilder.setItems(comps, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = comps[item].toString();
                compId=getCompId(item);
                comp.setText(selectedText);
                Log.e("id",compId);
            }
        });
        AlertDialog alertDialogObject = dialogBuilder.create();
        alertDialogObject.show();
    }

    private String getCompId(int position){
        String id="";
        try {
            id=compsList.get(position).getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void onLoad(FabricColorResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            fabricColorDetails = response.getDetail();
            for (int i = 0; i < fabricColorDetails.size(); i++) {
                String color_code=fabricColorDetails.get(i).getColor_code();
                String colorName=fabricColorDetails.get(i).getColor_name();
                String id=fabricColorDetails.get(i).getId();
                fabricLayouts(color_code,colorName,id);

            }
        }
    }



    private void fabricLayouts(final String colorCodes, final String colorNames, final String id) {
        final LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.layout_color, null);

        ImageView colorCode = (ImageView)view.findViewById(R.id.colorCode);
        TextView colorName = (TextView)view.findViewById(R.id.colorName);
        final CheckBox shelve_name = (CheckBox) view.findViewById(R.id.checkBox);
        shelve_name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b)
                {
                    colordesc.add(id);
                    Log.e("colordesc",colordesc.toString());


                }else {

                    Iterator<String> myItr = colordesc.iterator();

                    while (myItr.hasNext()) {
                        String name = myItr.next();
                        if (name.equalsIgnoreCase(id)) {
                            myItr.remove();
                        }
                    }

                    Log.e("colordesc",colordesc.toString());
                }




               /* if (colordesc.size()>4)
                {

                }else
                {
                    Toast.makeText(AddFabric.this, "Maximum 5 colors can be added!", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        String cc="#"+colorCodes;
        int color = Color.parseColor(cc);
        ((GradientDrawable)colorCode.getBackground()).setColor(color);
        colorName.setText(colorNames);

        colorLayout.addView(view);

    }

    public int check(String id) {
        int j=0;
        for (int i = 0; i < colordesc.size(); i++) {
            try {
                if (colordesc.get(i).contains(id))
                    j=i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return j;

    }

}
