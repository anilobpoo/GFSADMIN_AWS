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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.salesorder.ui.SOorderDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFabSalesOrder extends RecyclerView.Adapter<AddFabSalesOrder.ViewHolder> {
    ArrayList<AddReserveDet> addReserveDetArrayList;
    Activity context;

    public AddFabSalesOrder(ArrayList<AddReserveDet> addReserveDetArrayList, Activity context) {
        this.addReserveDetArrayList = addReserveDetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AddFabSalesOrder.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.onaddfabricsoorder,viewGroup,false);
        AddFabSalesOrder.ViewHolder view_fabAdd = new AddFabSalesOrder.ViewHolder(view);
        return view_fabAdd;
    }

    @Override
    public void onBindViewHolder(@NonNull final AddFabSalesOrder.ViewHolder holder, int i) {
       final  AddReserveDet index = addReserveDetArrayList.get(i);
        holder.fab_nam_soAdd.setText(index.getFabName());
        holder.comp_so_add.setText(index.getComposition());
        holder.qty_mtr_addFab_so.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0){
                    Double yard = Double.valueOf(s.toString())*1.09;
                    holder.qty_yard_addfab_so.setText(String.valueOf(yard));
                }

            }
        });

        holder.addbu_soorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.qty_mtr_addFab_so.getText().toString().length()>0){

                Intent in = new Intent(context, SOorderDetails.class);
                in.putExtra("ORDERFABRIC",index);
                in.putExtra("FABSOORDERQTY",holder.qty_mtr_addFab_so.getText().toString());
                context.setResult(AppConstants.addfanricSOorders,in);
                context.finish();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return addReserveDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fab_nam_soAdd)
        TextView fab_nam_soAdd;
        @BindView(R.id.comp_so_add)
        TextView comp_so_add;
        @BindView(R.id.qty_mtr_addFab_so)
        EditText qty_mtr_addFab_so;
        @BindView(R.id.qty_yard_addfab_so)
        TextView qty_yard_addfab_so;
        @BindView(R.id.addbu_soorder)
        Button addbu_soorder;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
