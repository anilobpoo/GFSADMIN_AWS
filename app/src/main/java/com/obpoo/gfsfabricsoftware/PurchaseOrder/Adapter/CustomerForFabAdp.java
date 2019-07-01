package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.CustomerSelForFabMod;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerForFabAdp extends RecyclerView.Adapter<CustomerForFabAdp.ViewHolder> {
    ArrayList<CustomersDetail> customerList;
    Activity context;
    CustomerSelForFabMod customerSelForFabMod;

    public CustomerForFabAdp(ArrayList<CustomersDetail> customerList, Activity context, CustomerSelForFabMod customerSelForFabMod) {
        this.customerList = customerList;
        this.context = context;
        this.customerSelForFabMod=customerSelForFabMod;
    }

    @NonNull
    @Override
    public CustomerForFabAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackpocuslay,viewGroup,false);
        CustomerForFabAdp.ViewHolder cus_viewHolder = new CustomerForFabAdp.ViewHolder(view);
        return cus_viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerForFabAdp.ViewHolder holder, final  int i) {
        holder.customer.setText(customerList.get(i).getCustomerName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerSelForFabMod.onCustomerSelForFabMod(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public void updateFilterData(ArrayList<CustomersDetail> temp) {
        this.customerList=customerList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cus_name_track_po_)
        TextView customer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
