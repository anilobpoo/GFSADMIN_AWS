package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock.CutStockResponseDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PHD on 2/20/2019.
 */

public class CutStockAdapter extends RecyclerView.Adapter<CutStockAdapter.ViewHolder> {
    ArrayList<CutStockResponseDetails> cutStockResponseDetailsArrayList;
    Activity context;

    public CutStockAdapter(ArrayList<CutStockResponseDetails> cutStockResponseDetailsArrayList, Activity context) {
        this.cutStockResponseDetailsArrayList = cutStockResponseDetailsArrayList;
        this.context = context;
    }

    @NonNull

    @Override
    public CutStockAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cutstockadp,viewGroup,false);
        CutStockAdapter.ViewHolder cutViewAdp = new  CutStockAdapter.ViewHolder(view);
        return cutViewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull CutStockAdapter.ViewHolder holder, int i) {
        if((cutStockResponseDetailsArrayList.get(i).getFabName())!=null){
            holder.fabname_cs.setText(cutStockResponseDetailsArrayList.get(i).getFabName());

        }
        else{
            holder.fabname_cs.setText("N/A");
       }
        holder.fabunicode_cs.setText("UniCode: "+cutStockResponseDetailsArrayList.get(i).getUniqueCode());
        holder.fabMtr_cs.setText("Mtr: "+cutStockResponseDetailsArrayList.get(i).getRemain());
        holder.created_cs.setText(cutStockResponseDetailsArrayList.get(i).getCreated());
        holder.war_cs.setText(cutStockResponseDetailsArrayList.get(i).getLocation().getWarehouseName());
        holder.zone_cs.setText(cutStockResponseDetailsArrayList.get(i).getLocation().getZone());
        holder.shelf_cs.setText(cutStockResponseDetailsArrayList.get(i).getLocation().getShelveName());
        if((cutStockResponseDetailsArrayList.get(i).getFabImg())!=null){
            Picasso.with(context).load(AppConstants.FABRIC_IMAGE + cutStockResponseDetailsArrayList.get(i).getFabImg()).into(holder.fabimage_cs);
        }
        else {

        }
    }

    @Override
    public int getItemCount() {
        return cutStockResponseDetailsArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fabname_cs)
        TextView fabname_cs;
        @BindView(R.id.fabunicode_cs)
        TextView fabunicode_cs;
        @BindView(R.id.fabMtr_cs)
        TextView fabMtr_cs;
        @BindView(R.id.created_cs)
        TextView created_cs;
        @BindView(R.id.war_cs)
        TextView war_cs;
        @BindView(R.id.zone_cs)
        TextView zone_cs;
        @BindView(R.id.shelf_cs)
        TextView shelf_cs;
        @BindView(R.id.fabimage_cs)
        CircleImageView fabimage_cs;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void updateList(ArrayList<CutStockResponseDetails> list){
        cutStockResponseDetailsArrayList = list;
        notifyDataSetChanged();
    }
}
