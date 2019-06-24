package com.obpoo.gfsfabricsoftware.Stock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.StockInDetails;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ViewStockDetails;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 1/29/2019.
 */

public class WzsAdapter extends RecyclerView.Adapter<WzsAdapter.ViewHolder> {
    ArrayList<ViewStockDetails> get_viewStockDetailsArrayList;
    ArrayList<StockInDetails> stockInDetailsArrayList  = new ArrayList<>();
    Activity context;
    WzsStockAdp adapter;
    String tag;

    public WzsAdapter( Activity context,ArrayList<ViewStockDetails> get_viewStockDetailsArrayList,ArrayList<StockInDetails> stockInDetailsArrayList,String tag) {
        this.get_viewStockDetailsArrayList = get_viewStockDetailsArrayList;
        this.stockInDetailsArrayList = stockInDetailsArrayList;
        this.context = context;
        this.tag = tag;
    }

    @NonNull
    @Override
    public WzsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewstockrecycle, parent, false);
        WzsAdapter.ViewHolder delViewHolder = new WzsAdapter.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WzsAdapter.ViewHolder holder, int i) {
        if (tag.equals("wz")){
            holder.shelve_text.setText("Shelve: "+get_viewStockDetailsArrayList.get(i).getShelfId());
            stockInDetailsArrayList= get_viewStockDetailsArrayList.get(i).getStock();
        }

        if(stockInDetailsArrayList.size()>0){
            Log.i("sizesdkjs",stockInDetailsArrayList.size()+"");
        adapter = new WzsStockAdp(context, stockInDetailsArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(adapter);
        }
        else{

        }

    }

    @Override
    public int getItemCount() {
        if(stockInDetailsArrayList.size()>0) {

            return (stockInDetailsArrayList == null) ? 0 : stockInDetailsArrayList.size();
        }
        return (stockInDetailsArrayList == null) ? 0 : stockInDetailsArrayList.size();

}
    class  ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.shelve_text)
        TextView shelve_text;
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
