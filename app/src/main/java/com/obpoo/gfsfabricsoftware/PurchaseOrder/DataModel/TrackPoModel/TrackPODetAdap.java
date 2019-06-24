package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.vision.text.Text;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackPODetAdap extends RecyclerView.Adapter<TrackPODetAdap.ViewHolder> {
    ArrayList<TrackPODetItems> trackPODetDataArrayList ;
    Activity context;

    public TrackPODetAdap(ArrayList<TrackPODetItems> trackPODetDataArrayList, Activity context) {
        this.trackPODetDataArrayList = trackPODetDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackpodetlay,viewGroup,false);
        ViewHolder view_hold = new ViewHolder(view);
        return view_hold;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        TrackPODetItems index = trackPODetDataArrayList.get(i);
       
        holder.artno_color_tpo.setText(index.getArtNo()+"-"+index.getColorCode());
        holder.status_tpo.setText(index.getStatusText());
        holder.brand_tpo.setText(index.getBrandName());
        holder.price_tpo.setText(index.getCostPrice());
        holder.pend_tpo.setText(index.getPendingQty());
        holder.extra_tpo.setText(index.getExtraQty());
        holder.r_qty_tpo.setText(index.getQtyOnContract());
        holder.qty_tpo.setText(index.getQuantity());




    }

    @Override
    public int getItemCount() {
        return trackPODetDataArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.artno_color_tpo)
        TextView artno_color_tpo;
        @BindView(R.id.status_tpo)
        TextView status_tpo;
        @BindView(R.id.brand_tpo)
        TextView brand_tpo;
        @BindView(R.id.price_tpo)
        TextView price_tpo;
        @BindView(R.id.pend_tpo)
        TextView pend_tpo;
        @BindView(R.id.extra_tpo)
        TextView extra_tpo;
        @BindView(R.id.r_qty_tpo)
        TextView r_qty_tpo;
        @BindView(R.id.qty_tpo)
        TextView qty_tpo;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
