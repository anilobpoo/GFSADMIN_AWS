package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderItemDet;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SO_order_det_fab_adp extends RecyclerView.Adapter<SO_order_det_fab_adp.ViewHolder> {
    ArrayList<AllOrderItemDet> itemDetailsses;
    Activity context;

    public SO_order_det_fab_adp(ArrayList<AllOrderItemDet> itemDetailsses, Activity context) {
        this.itemDetailsses = itemDetailsses;
        this.context = context;
    }

    @NonNull
    @Override
    public SO_order_det_fab_adp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.so_order_det_fab,viewGroup,false);
        SO_order_det_fab_adp.ViewHolder fab_view_so_det = new  SO_order_det_fab_adp.ViewHolder (view);
        return fab_view_so_det;
    }

    @Override
    public void onBindViewHolder(@NonNull SO_order_det_fab_adp.ViewHolder holder, int i) {
        holder.fab_name_so_order_det.setText(itemDetailsses.get(i).getFabName());
        holder.price_fab_so_order_det.setText(itemDetailsses.get(i).getActualPrice());
        holder.mtr_so_order_det.setText("Qty(Mtr): "+itemDetailsses.get(i).getQuantity());
        holder.yard_so_order_det.setText("Qty(yard): "+String.valueOf(Integer.valueOf(itemDetailsses.get(i).getQuantity())*1.09));


    }

    @Override
    public int getItemCount() {
        return itemDetailsses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fab_name_so_order_det)
        TextView fab_name_so_order_det;
        @BindView(R.id.price_fab_so_order_det)
        TextView price_fab_so_order_det;
        @BindView(R.id.mtr_so_order_det)
        TextView mtr_so_order_det;
        @BindView(R.id.yard_so_order_det)
        TextView yard_so_order_det;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
