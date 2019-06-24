package com.obpoo.gfsfabricsoftware.Stock.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Activity.AddReserveFabricCheck;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/12/2019.
 */

public class AddReserveAdapterFabricAuto extends RecyclerView.Adapter<AddReserveAdapterFabricAuto.ViewHolder> {
    ArrayList<AddReserveDet> addReserveDetArrayList;
    Activity context;
    String customer_name,customer_id;

    public AddReserveAdapterFabricAuto( Activity context,ArrayList<AddReserveDet> addReserveDetArrayList,String customer_name,String customer_id) {
        this.addReserveDetArrayList = addReserveDetArrayList;
        this.context = context;
        this.customer_name=customer_name;
        this.customer_id=customer_id;
    }

    @NonNull
    @Override
    public AddReserveAdapterFabricAuto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.addreserveautofabric, parent, false);
        AddReserveAdapterFabricAuto.ViewHolder delViewHolder = new AddReserveAdapterFabricAuto.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddReserveAdapterFabricAuto.ViewHolder holder, final int i) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, AddReserveFabricCheck.class);
                in.putExtra("FABNAME_AR",addReserveDetArrayList.get(i).getFabName());
                in.putExtra("COMPOSITION_AR",addReserveDetArrayList.get(i).getComposition());
                in.putExtra("FABIMAGE_AR",addReserveDetArrayList.get(i).getFabImg());
                in.putExtra("CUSTOMER_NAME_AR",customer_name);
                in.putExtra("CUSTOMER_ID_AR",customer_id);
                context.startActivity(in);

            }
        });

        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+addReserveDetArrayList.get(i).getFabImg()).into(holder.ar_image);
        holder.ar_fabrics.setText(addReserveDetArrayList.get(i).getFabName());
        holder.ar_bundles.setText(addReserveDetArrayList.get(i).getComposition());

    }

    @Override
    public int getItemCount() {
        return addReserveDetArrayList.size();
    }
     class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ar_image)
         ImageView ar_image;
        @BindView(R.id.ar_fabrics)
         TextView ar_fabrics;
        @BindView(R.id.ar_bundles)
        TextView ar_bundles;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             ButterKnife.bind(this,itemView);
         }
     }
}
