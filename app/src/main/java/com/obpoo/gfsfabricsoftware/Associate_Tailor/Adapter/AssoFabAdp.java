package com.obpoo.gfsfabricsoftware.Associate_Tailor.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricData;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP.ATpresenterImpl;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP.ATview;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.UI.AssociateFabrics;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.UI.AssociateTailorProfile;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssoFabAdp extends RecyclerView.Adapter<AssoFabAdp.ViewHolder> implements ATview {
    ArrayList<AssoFabricData> assoFabricData;
    Activity context;
    String store_url;
    private PopupWindow mPopupWindow;
    ATpresenterImpl presenter;

    public void updateList(ArrayList<AssoFabricData> temp){
        assoFabricData=temp;
        notifyDataSetChanged();
    }

    public AssoFabAdp(ArrayList<AssoFabricData> assoFabricData, Activity context,String store_url) {
        this.assoFabricData = assoFabricData;
        this.context = context;
        this.store_url=store_url;
        presenter= new ATpresenterImpl(this);
    }

    @NonNull
    @Override
    public AssoFabAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.associate_fabric_adp_lay,viewGroup,false);
        AssoFabAdp.ViewHolder viewAdp = new AssoFabAdp.ViewHolder(view);
        return viewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull AssoFabAdp.ViewHolder holder, final int i) {

        Picasso.with(context).load("http://furnirworld.com/gfsnew/Uploads/Fabric/"+assoFabricData.get(i).getFabImg()).into(holder.fab_asso_image);
        Log.i("AssoFabImage","http://furnirworld.com/gfsnew/Uploads/Fabric"+assoFabricData.get(i).getFabImg());
        holder.fab_name_asso.setText(assoFabricData.get(i).getFabName());
        holder.qty_asso_fab.setText("QTY: "+assoFabricData.get(i).getQuantity());
        holder.email_asso_fab.setText("Email: "+assoFabricData.get(i).getTailorEmail());
        holder.orderdate_asso.setText(assoFabricData.get(i).getCreatedOn());
        switch(assoFabricData.get(i).getAssociateStatus()){
            case "1": holder.asso_status.setText("Associated");
            break;
        }
        switch(assoFabricData.get(i).getApproveStatus()){
            case "0":  holder.appro_status.setText("Not Approved");
            break;
            case "1":  holder.appro_status.setText("Approved");
                break;
            case "2":  holder.appro_status.setText("Rejected");
                break;
        }

        holder.show_asso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, AssociateTailorProfile.class);
                in.putExtra("AssociateProfile",assoFabricData.get(i).getTailorInfo());
                in.putExtra("AssociateFrom","FABRICREQUEST");
                context.startActivity(in);
            }
        });
        holder.change_asso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View popupView = inflater.inflate(R.layout.associate_tailor_ac_rej,null);
                mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }


                // mPopupWindow.showAtLocation(holder.popupPlace, Gravity.CENTER,0,0);
                mPopupWindow.showAsDropDown(v,0,0);

                View container = mPopupWindow.getContentView().getRootView();
                if(container != null) {
                    WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
                    WindowManager.LayoutParams p = (WindowManager.LayoutParams)container.getLayoutParams();
                    p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                    p.dimAmount = 0.30f;
                    if(wm != null) {
                        wm.updateViewLayout(container, p);
                    }
                }

                Button update_act =(Button)popupView.findViewById(R.id.update_act);
                Button cancel_act=(Button)popupView.findViewById(R.id.cancel_act);
                final RadioGroup rg =(RadioGroup)popupView.findViewById(R.id.radioGroup);


                update_act.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedAct = rg.getCheckedRadioButtonId();
                        String act_val = "0";
                        String act_act="";
                        RadioButton rb=(RadioButton)popupView.findViewById(selectedAct);
                        if(rb.getText().equals("Accept")){
                            act_val="1";
                            act_act="approve";
                        }
                        if(rb.getText().equals("Reject")){
                            act_val="0";
                            act_act="rejected";

                        }
                presenter.sendFabChangeStatus("take_action",assoFabricData.get(i).getId(),act_act,store_url);

                    }
                });

                cancel_act.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopupWindow.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return assoFabricData.size();
    }

    @Override
    public void ATretriveData(ATresponse response) {

    }

    @Override
    public void associateActicity(AssociateActivity response) {

    }

    @Override
    public void assoFabrics(AssoFabricResponse response) {

    }

    @Override
    public void changeFabURL(AssociateFabricChangeURL response) {

    }

    @Override
    public void changeFabricStatus(AssociateFabircChangeRes response) {
        Log.i("AssociateFabirc",response.getMessage());
        if(response.getStatus().equals("success")){
            Toast.makeText(context,response.getMessage(),Toast.LENGTH_SHORT).show();
            Intent in = new Intent(context, AssociateFabrics.class);
            context.startActivity(in);
        }

    }

    @Override
    public void changeTailorRequest(AssociateActivity response) {

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

    class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.fab_asso_image)
        ImageView fab_asso_image;
        @BindView(R.id.fab_name_asso)
        TextView fab_name_asso;
        @BindView(R.id.qty_asso_fab)
        TextView qty_asso_fab;
        @BindView(R.id.email_asso_fab)
        TextView email_asso_fab ;
        @BindView(R.id.orderdate_asso)
        TextView orderdate_asso;
        @BindView(R.id.asso_status)
        TextView asso_status ;
        @BindView(R.id.appro_status)
        TextView appro_status ;
        @BindView(R.id.show_asso)
        Button show_asso;
        @BindView(R.id.change_asso)
        Button change_asso;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }}
