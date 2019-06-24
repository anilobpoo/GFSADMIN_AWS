package com.obpoo.gfsfabricsoftware.Dashboard.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.PoList;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 1/16/2019.
 */

public class Adapter_Dash extends RecyclerView.Adapter<Adapter_Dash.ViewHolder>{
    Activity context;
    ArrayList<PoList> getPOList = new ArrayList<>();
    String baht ="\u0e3f";

    public Adapter_Dash(Activity context, ArrayList<PoList> getPOList) {
        this.context = context;
        this.getPOList = getPOList;
    }

    @NonNull
    @Override
    public Adapter_Dash.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.dash_polist, parent, false);
        Adapter_Dash.ViewHolder dashAdp = new Adapter_Dash.ViewHolder(view);
        return dashAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Dash.ViewHolder holder, int i) {
        holder.po_id.setText("#"+getPOList.get(i).getId());
        holder.po_vendor.setText(getPOList.get(i).getVendorno());
        holder.po_status.setText(getPOList.get(i).getStatusText());
        holder.po_budget.setText(baht+getPOList.get(i).getBudget());

    }

    @Override
    public int getItemCount() {
        return getPOList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.po_id)
        TextView po_id;
        @BindView(R.id.po_vendor)
        TextView po_vendor;
        @BindView(R.id.po_status)
        TextView po_status;
        @BindView(R.id.po_budget)
        TextView po_budget;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
