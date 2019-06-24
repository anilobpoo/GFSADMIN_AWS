package com.obpoo.gfsfabricsoftware.Dashboard.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.StockAlertData;
import com.obpoo.gfsfabricsoftware.Dashboard.UI.StockInStockOut;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PHD on 1/17/2019.
 */

public class Stock_article_adapter extends RecyclerView.Adapter<Stock_article_adapter.ViewHolder> {
    Activity context;
    ArrayList<StockAlertData> stockAlertList = new ArrayList<>();

    public Stock_article_adapter(Activity context, ArrayList<StockAlertData> stockAlertList) {
        this.context = context;
        this.stockAlertList = stockAlertList;
    }

    @NonNull
    @Override
    public Stock_article_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.stockalert_dash1, parent, false);
        Stock_article_adapter.ViewHolder saAdp = new Stock_article_adapter.ViewHolder(view);
        return saAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull Stock_article_adapter.ViewHolder holder, final int i) {
        if(stockAlertList.get(i).getFabImg().equals("")){

        }
        else {

            Picasso.with(context).load(AppConstants.FABRIC_IMAGE + stockAlertList.get(i).getFabImg()).into(holder.sa_img);
        }
        holder.sa_name.setText(stockAlertList.get(i).getFabName());
        holder.sa_composition.setText(stockAlertList.get(i).getComposition());
        holder.mss.setText(String.valueOf(Math.round(Float.parseFloat(stockAlertList.get(i).getMinStockMtr()))));
        holder.msu.setText(stockAlertList.get(i).getMinStockUserMtr());
        if(stockAlertList.get(i).getRemain()<0){
            holder.remain_sa.setText("0.0");
        }
        else{
        holder.remain_sa.setText(String.valueOf(stockAlertList.get(i).getRemain()));}

        holder.gtg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, StockInStockOut.class);
                in.putExtra("FABNAME_STOCK",stockAlertList.get(i).getFabName());
                in.putExtra("COMPOSITION_STOCK",stockAlertList.get(i).getComposition());
                in.putExtra("FABIMG_STOCK",stockAlertList.get(i).getFabImg());
                context.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.i(stockAlertList.size()+"","Page1");
        return stockAlertList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sa_img)
        CircleImageView sa_img;
        @BindView(R.id.sa_name)
        TextView sa_name;
        @BindView(R.id.sa_composition)
        TextView sa_composition;
        @BindView(R.id.gtg)
        ImageView gtg;
        @BindView(R.id.mss)
        TextView mss;
        @BindView(R.id.msu)
        TextView msu;
        @BindView(R.id.sa_remain)
        TextView remain_sa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
