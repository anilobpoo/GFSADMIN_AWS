package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemEasyAdp extends RecyclerView.Adapter<ItemEasyAdp.Viewholder> {
    ArrayList<SoldFabricsData> soldFabricsDataArrayList ;
    Activity context;

    public ItemEasyAdp(ArrayList<SoldFabricsData> soldFabricsDataArrayList, Activity context) {
        this.soldFabricsDataArrayList = soldFabricsDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemEasyAdp.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_easy_adp,viewGroup,false);
        ItemEasyAdp.Viewholder item_viewHold = new  ItemEasyAdp.Viewholder(view);
        return item_viewHold;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemEasyAdp.Viewholder holder, int i) {
        SoldFabricsData index = soldFabricsDataArrayList.get(i);
        holder.is_id.setText("#"+index.getId());
        holder.is_status.setText(index.getStatusText());
        holder.isfabname.setText(index.getFabName());
        holder.is_qr.setText("Qrcode:"+index.getQrcode());
        holder.isqty.setText(index.getQuantity());
        holder.isqtytype.setText(index.getQtyType());
        holder.iscutt.setText(index.getCuttingBy());


    }

    @Override
    public int getItemCount() {
        return soldFabricsDataArrayList.size();
    }
    class Viewholder extends RecyclerView.ViewHolder{
        @BindView(R.id.is_id)
        TextView is_id;
        @BindView(R.id.is_status)
        TextView is_status;
        @BindView(R.id.isfabname)
        TextView isfabname;
        @BindView(R.id.is_qr)
        TextView is_qr;
        @BindView(R.id.isqty)
        TextView isqty;
        @BindView(R.id.isqtytype)
        TextView isqtytype;
        @BindView(R.id.iscutt)
        TextView iscutt;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
