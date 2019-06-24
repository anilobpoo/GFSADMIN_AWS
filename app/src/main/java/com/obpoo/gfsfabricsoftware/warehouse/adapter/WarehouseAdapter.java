package com.obpoo.gfsfabricsoftware.warehouse.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseDetail;
import com.obpoo.gfsfabricsoftware.warehouse.ui.UpdateWarehouse;
import com.obpoo.gfsfabricsoftware.zone.ui.Zone;

import java.util.ArrayList;


public class WarehouseAdapter extends RecyclerView.Adapter<WarehouseAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<WarehouseDetail> cartList;
    Activity activity;

    public void updateList(ArrayList<WarehouseDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,location,shop,address,zone,warehouseno;
        public ImageView delete;
        CardView linearLayout;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            location = view.findViewById(R.id.location);
            address = view.findViewById(R.id.address);
            shop = view.findViewById(R.id.shop);
            delete = view.findViewById(R.id.delete);
            zone = view.findViewById(R.id.zone);
            warehouseno = view.findViewById(R.id.warehouseno);
            linearLayout = view.findViewById(R.id.linearLayout);

        }
    }
    public WarehouseAdapter(Activity context, ArrayList<WarehouseDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;

    }

    @Override
    public WarehouseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_warehouse, parent, false);

        return new WarehouseAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WarehouseAdapter.MyViewHolder holder, final int position) {
        final WarehouseDetail item = cartList.get(position);


        String name = item.getWarehouse_name();
        String loc = item.getLocality();
        String address = item.getAddress();
        if (loc.isEmpty()||loc.equals(""))
            loc="Not Given";
        if (address.isEmpty()||address.equals(""))
            address="Not Given";

        holder.warehouseno.setText("#"+item.getWarehouse_no());
        holder.zone.setText(item.getZonecount());
        holder.name.setText(name);
        holder.address.setText(address);
        holder.location.setText(loc);
        holder.shop.setText(item.getShopname());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(activity, UpdateWarehouse.class);
                intent.putExtra("id",item.getId());
                activity.startActivity(intent);

            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, Zone.class);
                intent.putExtra("id",item.getId());
                intent.putExtra("no",item.getWarehouse_no());
                intent.putExtra("name",item.getWarehouse_name());
                intent.putExtra("zone",item.getZonecount());
                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }




}

