package com.obpoo.gfsfabricsoftware.shelf.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.shelf.datamodels.ShelfDetail;

import java.util.ArrayList;


public class ShelfAdapter extends RecyclerView.Adapter<ShelfAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ShelfDetail> cartList;
    Activity activity;
    private Dialog progressDialog;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,zone;
        public Button delete;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            zone = view.findViewById(R.id.zone);
            delete = view.findViewById(R.id.delete);

        }
    }
    public ShelfAdapter(Activity context, ArrayList<ShelfDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;

    }

    @Override
    public ShelfAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_zone, parent, false);

        return new ShelfAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ShelfAdapter.MyViewHolder holder, final int position) {
        final ShelfDetail item = cartList.get(position);
        String name = item.getShelve_name();
        holder.name.setText(name);
        holder.zone.setVisibility(View.GONE);




    }

    @Override
    public int getItemCount() {
        return cartList.size();
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

