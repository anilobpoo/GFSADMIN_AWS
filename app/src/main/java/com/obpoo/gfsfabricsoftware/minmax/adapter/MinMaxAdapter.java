package com.obpoo.gfsfabricsoftware.minmax.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxDetail;
import com.obpoo.gfsfabricsoftware.minmax.datamodels.MinMaxResponse;
import com.obpoo.gfsfabricsoftware.minmax.mvp.MinMaxPresenterImpl;
import com.obpoo.gfsfabricsoftware.minmax.mvp.MinMaxView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;


public class MinMaxAdapter extends RecyclerView.Adapter<MinMaxAdapter.MyViewHolder> implements MinMaxView{
    private Context context;
    private ArrayList<MinMaxDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    String tag="0";
    MinMaxPresenterImpl presenter;
    public void updateList(ArrayList<MinMaxDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MinMaxResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            if (response.getMessage().toLowerCase().contains("deleted"))
            {
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }else
            showError(response.getMessage());
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
        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public Button delete;
        public Button edit;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            delete = view.findViewById(R.id.delete);
            edit = view.findViewById(R.id.edit);

        }
    }
    public MinMaxAdapter(Activity context, ArrayList<MinMaxDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter=new MinMaxPresenterImpl(this);
    }

    @Override
    public MinMaxAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_master, parent, false);

        return new MinMaxAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MinMaxAdapter.MyViewHolder holder, final int position) {
        final MinMaxDetail item = cartList.get(position);


        String name = item.getTitle();
        holder.name.setText(name);
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
                if (tag.equals("0"))
                {
                    tag="1";
                    holder.edit.setBackground(activity.getResources().getDrawable(R.drawable.save));
                    holder.name.setEnabled(true);
                    holder.name.setText("");
                    holder.name.append(item.getTitle());
                    holder.name.requestFocus();

                }else if (tag.equals("1"))
                {
                    tag="0";
                    holder.edit.setBackground(activity.getResources().getDrawable(R.drawable.edit));
                    String name=holder.name.getText().toString().toLowerCase();
                    holder.name.setEnabled(false);
                    showDialog();
                    presenter.update("updatemin_max",name,item.getId());
                }

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

                        presenter.del("delete_minmax",String.valueOf(ids),"delete_minmax","delete_minmax");
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
}

