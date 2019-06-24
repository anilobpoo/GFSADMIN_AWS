package com.obpoo.gfsfabricsoftware.Stock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.CustomerResVRespoDet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/12/2019.
 */

public class CustomerReserveAdapter extends RecyclerView.Adapter<CustomerReserveAdapter.ViewHolder> {
    ArrayList<CustomerResVRespoDet> customerResVRespoDetArrayList;
    Activity context;

    public CustomerReserveAdapter(ArrayList<CustomerResVRespoDet> customerResVRespoDetArrayList, Activity context) {
        this.customerResVRespoDetArrayList = customerResVRespoDetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerReserveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.customerreserve, parent, false);
        CustomerReserveAdapter.ViewHolder delViewHolder = new CustomerReserveAdapter.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerReserveAdapter.ViewHolder holder, int i) {
        holder.reserve_cr.setText(customerResVRespoDetArrayList.get(i).getReserve());
        holder.cr_name.setText(customerResVRespoDetArrayList.get(i).getCustomerName());
        holder.cr_fabrics.setText(customerResVRespoDetArrayList.get(i).getFabName());
        holder.cr_bundles.setText(customerResVRespoDetArrayList.get(i).getUnicode());
        holder.cr_date.setText(customerResVRespoDetArrayList.get(i).getCreatedOn());


    }

    @Override
    public int getItemCount() {
        return customerResVRespoDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.reserve_cr)
        TextView reserve_cr;
        @BindView(R.id.cr_name)
        TextView cr_name;
        @BindView(R.id.cr_fabrics)
        TextView cr_fabrics;
        @BindView(R.id.cr_bundles)
        TextView cr_bundles;
        @BindView(R.id.cr_date)
        TextView cr_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
