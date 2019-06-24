package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsItems;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/22/2019.
 */

public class PoDetailItemsAdap extends RecyclerView.Adapter<PoDetailItemsAdap.ViewHolder> {
    ArrayList<PoDetailsItems> poDetailsItemsArrayList;
    Activity context;

    public PoDetailItemsAdap(ArrayList<PoDetailsItems> poDetailsItemsArrayList, Activity context) {
        this.poDetailsItemsArrayList = poDetailsItemsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public PoDetailItemsAdap.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.podeldetailitems,viewGroup,false);
        PoDetailItemsAdap.ViewHolder podetviewadp = new PoDetailItemsAdap.ViewHolder(view);
        return podetviewadp;
    }

    @Override
    public void onBindViewHolder(@NonNull PoDetailItemsAdap.ViewHolder holder, int i) {
        holder.fabname_podi.setText(poDetailsItemsArrayList.get(i).getArtNo()+"-"+poDetailsItemsArrayList.get(i).getColorCode());
        holder.mtr_podi.setText("Qty(Mtr): "+poDetailsItemsArrayList.get(i).getQtyFinal());
        holder.price_podi.setText("Price: "+poDetailsItemsArrayList.get(i).getCostPrice());
        holder.status_podi.setText(poDetailsItemsArrayList.get(i).getStatusText());
        holder.penqty_podi.setText("Pending Qty:"+ poDetailsItemsArrayList.get(i).getPendingQty());
        holder.extraqty_podi.setText("Extra Qty:"+poDetailsItemsArrayList.get(i).getExtraQty());
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+poDetailsItemsArrayList.get(i).getImg()).into(holder.fabimage_podi);



    }

    @Override
    public int getItemCount() {
        return poDetailsItemsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fabname_podi)
        TextView fabname_podi ;
        @BindView(R.id.mtr_podi)
        TextView mtr_podi ;
        @BindView(R.id.price_podi)
        TextView price_podi ;
        @BindView(R.id.status_podi)
        TextView status_podi ;
        @BindView(R.id.penqty_podi)
        TextView penqty_podi ;
        @BindView(R.id.extraqty_podi)
        TextView extraqty_podi ;
        @BindView(R.id.fabimage_podi)
        ImageView fabimage_podi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
