package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TS_MoveInOut_scan;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TransferStockIn;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_data;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/28/2019.
 */

public class TransferStockAdp extends RecyclerView.Adapter<TransferStockAdp.ViewHolder>{
    ArrayList<Ts_data> ts_dataArrayList;
    Activity context;
    String getSelectedTransferMEnu;

    public TransferStockAdp(ArrayList<Ts_data> ts_dataArrayList, Activity context,String getSelectedTransferMEnu) {
        this.ts_dataArrayList = ts_dataArrayList;
        this.context = context;
        this.getSelectedTransferMEnu=getSelectedTransferMEnu;
    }

    @NonNull
    @Override
    public TransferStockAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.reportmenu_lay,viewGroup,false);
        TransferStockAdp.ViewHolder tsViewAdp = new TransferStockAdp.ViewHolder(view);
        return tsViewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull TransferStockAdp.ViewHolder holder, final int i) {
        holder.menu_text.setText(ts_dataArrayList.get(i).getDocument());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getSelectedTransferMEnu.equals(AppConstants.tran_stock)){
                Intent in = new Intent(context, TS_MoveInOut_scan.class);
                in.putExtra("tsFabricArray",ts_dataArrayList);
                in.putExtra("index_ts_fabric",i);
                context.startActivity(in);}
                if(getSelectedTransferMEnu.equals(AppConstants.tran_stockIn)){
                    Intent in = new Intent(context, TransferStockIn.class);
                    in.putExtra("tsFabricArray",ts_dataArrayList);
                    in.putExtra("index_ts_fabric",i);
                    context.startActivity(in);}


            }
        });

    }

    @Override
    public int getItemCount() {
        return ts_dataArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.menu_text)
        TextView menu_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
