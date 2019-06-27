package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.FabricAddOrderSO;
import com.obpoo.gfsfabricsoftware.salesorder.ui.SOorderDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFabSalesOrder extends RecyclerView.Adapter<AddFabSalesOrder.ViewHolder> {
    ArrayList<AddReserveDet> addReserveDetArrayList;
    Activity context;
    FabricAddOrderSO fabI;
    ArrayList<CustomersDetail> customerList;
    public AddFabSalesOrder(ArrayList<AddReserveDet> addReserveDetArrayList, Activity context, FabricAddOrderSO fabI,ArrayList<CustomersDetail> customerList) {
        this.addReserveDetArrayList = addReserveDetArrayList;
        this.context = context;
        this.fabI=fabI;
        this.customerList=customerList;
    }

    @NonNull
    @Override
    public AddFabSalesOrder.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.addfabric_contractrequest,viewGroup,false);
        AddFabSalesOrder.ViewHolder view_fabAdd = new AddFabSalesOrder.ViewHolder(view);
        return view_fabAdd;
    }

    @Override
    public void onBindViewHolder(@NonNull final AddFabSalesOrder.ViewHolder holder, int i) {
       final  AddReserveDet index = addReserveDetArrayList.get(i);
        ArrayAdapter<CustomersDetail> customer_adapter = new ArrayAdapter<CustomersDetail>(context,android.R.layout.simple_spinner_dropdown_item,customerList);
        customer_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.customer.setAdapter(customer_adapter);

        holder.article_fab.setText(index.getFabName());
        holder.brand_fab.setText(index.getBrand());
        holder.content_fab.setText(index.getComposition());



    }

    @Override
    public int getItemCount() {
        return addReserveDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.customer)
        Spinner customer;
        @BindView(R.id.article_fab)
        TextView article_fab;
        @BindView(R.id.brand_fab)
        TextView brand_fab;
        @BindView(R.id.fab_qty_mtr)
        TextView fab_qty_mtr;
        @BindView(R.id.fab_qty_yard)
        TextView fab_qty_yard;
        @BindView(R.id.add_fabric_item)
        Button add_fabric_item;
        @BindView(R.id.content_fab)
        TextView content_fab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
