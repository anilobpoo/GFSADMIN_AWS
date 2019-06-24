package com.obpoo.gfsfabricsoftware.color.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorDetail;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;


public class ColorTypeAdapter extends RecyclerView.Adapter<ColorTypeAdapter.MyViewHolder> implements ColorView{
    private Context context;
    private ArrayList<ColorDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    String tag="0";
    ColorPresenterImpl presenter;

    public void updateList(ArrayList<ColorDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ColorResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
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

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

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
    public ColorTypeAdapter(Activity context, ArrayList<ColorDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter=new ColorPresenterImpl(this);
    }

    @Override
    public ColorTypeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_master, parent, false);

        return new ColorTypeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ColorTypeAdapter.MyViewHolder holder, final int position) {
        final ColorDetail item = cartList.get(position);


        String name = item.getColor_code();
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
                    holder.name.append(item.getColor_code());
                    holder.name.requestFocus();

                }else if (tag.equals("1"))
                {
                    tag="0";
                    holder.edit.setBackground(activity.getResources().getDrawable(R.drawable.edit));
                    String name=holder.name.getText().toString().toLowerCase();
                    holder.name.setEnabled(false);
                    presenter.update("update_color",name,item.getId(),"update");
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

                        presenter.delete("delete_color",String.valueOf(ids));
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

    private void send() {
        if(activity instanceof IMethodCaller){
            Log.e("tse","s");
            ((IMethodCaller)activity).yourDesiredMethod("deleted");
        }

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

