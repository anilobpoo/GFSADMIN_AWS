package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsItems;
import com.obpoo.gfsfabricsoftware.Report.UI.ViewDetailsReportPO;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewDetailsItemAdapter extends RecyclerView.Adapter<ViewDetailsItemAdapter.ViewHolder> {
    Context context;
    ArrayList<poItem> item;

    public ViewDetailsItemAdapter(Context context, ArrayList<poItem> item) {
        this.context = context;
        this.item = item;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewdetailsitemadp, viewGroup, false);
        ViewDetailsItemAdapter.ViewHolder rootview = new ViewDetailsItemAdapter.ViewHolder(view);
        return rootview;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.item_id.setText(item.get(i).getArtNo()+item.get(i).getColorCodeId());
        viewHolder.brand.setText("Brand:"+item.get(i).getBrandName());
        viewHolder.price.setText("Price:"+item.get(i).getCostPrice());
        viewHolder.item_status.setText(item.get(i).getStatusText().toUpperCase());
        viewHolder.qnty.setText("Qty(meter):"+item.get(i).getQuantity());
        viewHolder.rqstd_qnty.setText("RQSTD-Qty(meter):"+item.get(i).getQtyOnContract());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView item_img;
        @BindView(R.id.item_id)
        TextView item_id;
        @BindView(R.id.brand)
        TextView brand;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.qnty)
        TextView qnty;
        @BindView(R.id.rqstd_qnty)
        TextView rqstd_qnty;
        @BindView(R.id.item_status)
        TextView item_status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
