package com.obpoo.gfsfabricsoftware.group.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupDetail;
import com.obpoo.gfsfabricsoftware.group.datamodels.GroupResponse;
import com.obpoo.gfsfabricsoftware.group.mvp.GroupPresenterImpl;
import com.obpoo.gfsfabricsoftware.group.mvp.GroupView;
import com.obpoo.gfsfabricsoftware.group.ui.EditGroup;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;


public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> implements GroupView{
    private Context context;
    private ArrayList<GroupDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    String tag="0";
    GroupPresenterImpl presenter;
    String admin_id;
    public void updateList(ArrayList<GroupDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,percent;
        public Button delete;
        public Button edit;
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            percent = view.findViewById(R.id.percentage);
            delete = view.findViewById(R.id.delete);
            edit = view.findViewById(R.id.edit);

        }
    }
    public GroupAdapter(Activity context, ArrayList<GroupDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter=new GroupPresenterImpl(this);
        admin_id=  PreferenceConnector.readString(activity, activity.getString(R.string.admin_id),"");
    }

    @Override
    public GroupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_group, parent, false);

        return new GroupAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final GroupAdapter.MyViewHolder holder, final int position) {
        final GroupDetail item = cartList.get(position);


        String name = item.getName();
        holder.name.setText(name);
        holder.percent.setText(item.getDiscount_per()+"%");
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=item.getId();
                open(id,position);
            }
        });

       holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(activity, EditGroup.class);
                intent.putExtra("id",item.getId());
                intent.putExtra("name",item.getName());
                intent.putExtra("percent",item.getDiscount_per());
                activity.startActivity(intent);

            }
        });
    }




    @Override
    public int getItemCount() {
        return cartList.size();
    }






    private void open(final String ids,final  int position) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(activity.getResources().getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder
                .setMessage("Are you sure you want to delete?")
                .setCancelable(false)
                .setPositiveButton(activity.getResources().getString(R.string.Yes),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        presenter.delete("delete_customer_group",ids,"del");
                        cartList.remove(position);
                        notifyDataSetChanged();
                        notifyItemRemoved(position);

                    }
                })
                .setNegativeButton(activity.getResources().getString(R.string.No),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }



    public void showProgressBar() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(activity, activity.getResources().getString(R.string.loading_please_wait));
        } else {
            closeProgressbar();
            progressDialog = null;
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(activity, activity.getResources().getString(R.string.loading_please_wait));
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
    public void onLoad(GroupResponse response) {

        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            closeProgressbar();

            if (response.getMessage().toLowerCase().contains("added"))
            {

                Toast.makeText(activity, response.getMessage(), Toast.LENGTH_SHORT).show();
                showProgressBar();


            }else
            {
                Toast.makeText(activity, response.getMessage(), Toast.LENGTH_SHORT).show();
            }



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

