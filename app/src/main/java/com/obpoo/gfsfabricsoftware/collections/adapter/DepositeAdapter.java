package com.obpoo.gfsfabricsoftware.collections.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeDatum;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DepositeAdapter extends RecyclerView.Adapter<DepositeAdapter.ViewHolder> {
    Context context;
    List<DepositeDatum> depositeData;

    public DepositeAdapter(Context applicationContext, List<DepositeDatum> depositeData) {
        context = applicationContext;
        this.depositeData = depositeData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.deposite_adapter, viewGroup, false);
        DepositeAdapter.ViewHolder rootView = new DepositeAdapter.ViewHolder(view);
        return rootView;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DepositeDatum data = depositeData.get(i);
        viewHolder.admin.setText(data.getAdminName());
        viewHolder.pg_name.setText(data.getPgName());
        viewHolder.deposite.setText(data.getAmount());
    }

    @Override
    public int getItemCount() {
        return depositeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.admin)
        TextView admin;
        @BindView(R.id.pg_name)
        TextView pg_name;
        @BindView(R.id.deposite)
        TextView deposite;
        @BindView(R.id.ddate)
        TextView ddate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
