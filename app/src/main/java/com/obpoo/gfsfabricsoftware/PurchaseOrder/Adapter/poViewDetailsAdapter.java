package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 11/23/2018.
 */

public class poViewDetailsAdapter  extends RecyclerView.Adapter<poViewDetailsAdapter.VViewHolder> {

    Context context;
    ArrayList<poItem> podataList;

    public poViewDetailsAdapter(Context context, ArrayList<poItem> podataList) {
        this.context = context;
        this.podataList = podataList;

    }

    @NonNull
    @Override
    public poViewDetailsAdapter.VViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pomc_detail, parent, false);
        poViewDetailsAdapter.VViewHolder cmnArtViewHolder = new poViewDetailsAdapter.VViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VViewHolder holder, final int i) {
        poItem index = podataList.get(i);
        holder.fab_name_so_order_det.setText(index.getArtNo()+"-"+index.getColorCode());
        if(index.getStatusText() == null ||index.getStatusText().equals("")){
            holder.yard_so_order_det.setVisibility(View.GONE);
            holder.delete_cmo.setVisibility(View.VISIBLE);
        }
        else{
        holder.yard_so_order_det.setText(index.getStatusText());}
        holder.price_fab_so_order_det.setText("Brand: "+index.getBrandName());
        if(index.getCostPrice() == null){
            holder.mtr_so_order_det.setText("Composition: "+index.getColorCode());
        }
        else{
        holder.mtr_so_order_det.setText("Price: "+index.getCostPrice());}
        holder.cus_mco.setText("Customer:"+index.getCustomerName());
        holder.qty_mtr_mco.setText("Qty(Mtr): "+index.getQuantity());

        holder.qtyy_mco.setText("Qty(yard): "+String.format("%.2f",Double.valueOf(index.getQuantity())*1.09));

        holder.delete_cmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                podataList.remove(i);
                notifyDataSetChanged();
            }
        });




    }


    @Override
    public int getItemCount() {
        return podataList.size();
    }

    class VViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fab_name_so_order_det)
        TextView fab_name_so_order_det;
        @BindView(R.id.yard_so_order_det)
        TextView yard_so_order_det;
        @BindView(R.id.price_fab_so_order_det)
        TextView price_fab_so_order_det;
        @BindView(R.id.mtr_so_order_det)
        TextView mtr_so_order_det;
        @BindView(R.id.cus_mco)
        TextView cus_mco;
        @BindView(R.id.qtyy_mco)
        TextView qtyy_mco;
        @BindView(R.id.qty_mtr_mco)
        TextView qty_mtr_mco;
        @BindView(R.id.delete_cmo)
        ImageView delete_cmo;



        public VViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}