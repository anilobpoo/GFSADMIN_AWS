package com.obpoo.gfsfabricsoftware.Stock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.StockInDetails;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 1/29/2019.
 */

public class WzsStockAdp extends RecyclerView.Adapter<WzsStockAdp.ViewHolder> {
    ArrayList<StockInDetails> stockInDetailsArrayList;
    Activity context;

    public WzsStockAdp( Activity context,ArrayList<StockInDetails> stockInDetailsArrayList) {
        Log.i("sizesdkjsfg",stockInDetailsArrayList.size()+"");

        this.stockInDetailsArrayList = stockInDetailsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public WzsStockAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewstocknav, parent, false);
        WzsStockAdp.ViewHolder delViewHolder = new WzsStockAdp.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WzsStockAdp.ViewHolder holder, int i) {
        Log.i("sizesdkjsfggh",stockInDetailsArrayList.size()+"");
        holder.packetnum.setText("Packet: "+ stockInDetailsArrayList.get(i).getUniqueCode());
//        holder.artno.setText("Art No: "+stockInDetailsArrayList.get(i).getArticleNo() );
//        holder.colorcode.setText("Color Code: "+stockInDetailsArrayList.get(i).getColorCode() );
        holder.remain.setText("Remain: "+stockInDetailsArrayList.get(i).getRemain() );
        holder.reserve.setText("Reserve: "+stockInDetailsArrayList.get(i).getReserve() );
        holder.total.setText("Total: "+stockInDetailsArrayList.get(i).getTotal() );

    }

    @Override
    public int getItemCount() {
        return stockInDetailsArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.packetnum)
        TextView packetnum;
        @BindView(R.id.artno)
        TextView artno;
        @BindView(R.id.colorcode)
        TextView colorcode;
        @BindView(R.id.remain)
        TextView remain;
        @BindView(R.id.reserve)
        TextView reserve;
        @BindView(R.id.total)
        TextView total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
