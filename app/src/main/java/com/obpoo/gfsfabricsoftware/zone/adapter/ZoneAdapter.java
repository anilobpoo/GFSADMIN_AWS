package com.obpoo.gfsfabricsoftware.zone.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.zone.datamodels.ZoneDetail;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.shelf.ui.Shelf;

import java.util.ArrayList;


public class ZoneAdapter extends RecyclerView.Adapter<ZoneAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<ZoneDetail> cartList;
    Activity activity;
    private Dialog progressDialog;
    String names,number,zones,warehouseId;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,zone;
        public Button delete;
        CardView linearLayout;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            zone = view.findViewById(R.id.zone);
            delete = view.findViewById(R.id.delete);
            linearLayout = view.findViewById(R.id.linearLayout);

        }
    }
    public ZoneAdapter(Activity context, ArrayList<ZoneDetail> cartList, String names, String number, String zones,String warehouseId) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        this.names = names;
        this.number = number;
        this.zones = zones;
        this.warehouseId = warehouseId;

    }

    @Override
    public ZoneAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_zone, parent, false);

        return new ZoneAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ZoneAdapter.MyViewHolder holder, final int position) {
        final ZoneDetail item = cartList.get(position);
        final String name = item.getShelfcount();
        holder.zone.setText(name);
        holder.name.setText("Zone-"+(position+1));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, Shelf.class);
                intent.putExtra("id",item.getId());
                intent.putExtra("zone",""+(position+1));
                intent.putExtra("name",names);
                intent.putExtra("number",number);
                intent.putExtra("warehouseId",warehouseId);
                activity.startActivity(intent);

            }
        });



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

