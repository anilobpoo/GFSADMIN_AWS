package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_fabric;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/28/2019.
 */

public class TransferScanAdp extends RecyclerView.Adapter<TransferScanAdp.ViewHolder> {
    ArrayList<Ts_fabric> ts_fabricArrayList;
    Activity context;

    public TransferScanAdp(ArrayList<Ts_fabric> ts_fabricArrayList, Activity context) {
        this.ts_fabricArrayList = ts_fabricArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TransferScanAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ts_fabric_scan_inout,viewGroup,false);
        TransferScanAdp.ViewHolder tsScanViewADp = new TransferScanAdp.ViewHolder(view);
        return tsScanViewADp;
    }

    @Override
    public void onBindViewHolder(@NonNull TransferScanAdp.ViewHolder holder, int i) {
        holder.fab_tsf.setText("Fabric: "+ts_fabricArrayList.get(i).getFabName());
        holder.unique_tsf.setText("#"+ts_fabricArrayList.get(i).getUniqueCode());
        holder.from_tsf.setText("From Warehouse: "+ts_fabricArrayList.get(i).getFromWarehouse());
        holder.to_tsf.setText("To Warehouse: "+ts_fabricArrayList.get(i).getToWarehouse());
        holder.zone_tsf.setText("From Zone: "+ts_fabricArrayList.get(i).getZone());
        holder.shelf_tsf.setText("From Shelf: "+ts_fabricArrayList.get(i).getShelf());

        if(ts_fabricArrayList.get(i).isCheckScan()){
            holder.scan_check.setChecked(true);

        }

    }

    @Override
    public int getItemCount() {
        return ts_fabricArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fab_tsf)
        TextView fab_tsf;
        @BindView(R.id.unique_tsf)
        TextView unique_tsf;
        @BindView(R.id.from_tsf)
        TextView from_tsf;
        @BindView(R.id.to_tsf)
        TextView to_tsf;
        @BindView(R.id.zone_tsf)
        TextView zone_tsf;
        @BindView(R.id.shelf_tsf)
        TextView shelf_tsf;
        @BindView(R.id.scan_check)
        CheckBox scan_check;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void removeItem(int position){
        Log.i("RemovecheckedItem",position+"");
        ts_fabricArrayList.get(position).setCheckScan(false);

        ts_fabricArrayList.remove(ts_fabricArrayList.get(position));
        notifyItemRemoved(position);
        notifyItemChanged(position,ts_fabricArrayList.size());



    }
}
