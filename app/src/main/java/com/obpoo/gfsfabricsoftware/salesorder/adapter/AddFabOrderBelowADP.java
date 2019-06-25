package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFabOrderBelowADP extends RecyclerView.Adapter<AddFabOrderBelowADP.ViewHolder> {
    ArrayList<AddReserveDet> addReserveDetArrayList;
    Activity context;

    public AddFabOrderBelowADP(ArrayList<AddReserveDet> addReserveDetArrayList,Activity context) {
        this.addReserveDetArrayList = addReserveDetArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public AddFabOrderBelowADP.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.addfabricbelow,viewGroup,false);
        AddFabOrderBelowADP.ViewHolder viewfab_below = new  AddFabOrderBelowADP.ViewHolder(view);

        return viewfab_below;
    }

    @Override
    public void onBindViewHolder(@NonNull AddFabOrderBelowADP.ViewHolder holder, int i) {
        holder.fabname_below.setText(addReserveDetArrayList.get(i).getFabName());
        holder.fabcomp_below.setText(addReserveDetArrayList.get(i).getComposition());
        holder.fabqtybelow.setText(addReserveDetArrayList.get(i).getQty());

    }

    @Override
    public int getItemCount() {
        return addReserveDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fabname_below)
        TextView fabname_below;
        @BindView(R.id.fabcomp_below)
        TextView fabcomp_below;
        @BindView(R.id.fabqtybelow)
        TextView fabqtybelow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
