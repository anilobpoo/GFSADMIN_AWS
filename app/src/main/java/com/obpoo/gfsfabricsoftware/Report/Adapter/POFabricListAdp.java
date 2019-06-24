package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List.PO_fabric_response_details;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/26/2019.
 */

public class POFabricListAdp extends RecyclerView.Adapter<POFabricListAdp.ViewHolder> {
    ArrayList<PO_fabric_response_details> po_fabric_response_details;
    Activity context;

    public POFabricListAdp(ArrayList<PO_fabric_response_details> po_fabric_response_details, Activity context) {
        this.po_fabric_response_details = po_fabric_response_details;
        this.context = context;
    }

    @NonNull
    @Override
    public POFabricListAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.podeldetailitems,viewGroup,false);
        POFabricListAdp.ViewHolder polistviewAdp = new POFabricListAdp.ViewHolder(view);
        return polistviewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull POFabricListAdp.ViewHolder holder, int i) {
        holder.fabname_podi.setText("#"+po_fabric_response_details.get(i).getFabId());
        holder.mtr_podi .setText("Fabric:  "+po_fabric_response_details.get(i).getFabName());
        holder.price_podi .setText("Qty(Mtr) "+po_fabric_response_details.get(i).getQtyFinal());
        holder.status_podi .setText(po_fabric_response_details.get(i).getPoSatatus());
        holder.extraqty_podi .setText(po_fabric_response_details.get(i).getCreatedOn());
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+po_fabric_response_details.get(i).getFabImg()).into(holder.fabimage_podi);

    }

    @Override
    public int getItemCount() {
        return po_fabric_response_details.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fabname_podi)
        TextView fabname_podi ;
        @BindView(R.id.mtr_podi)
        TextView mtr_podi ;
        @BindView(R.id.price_podi)
        TextView price_podi ;
        @BindView(R.id.status_podi)
        TextView status_podi ;
        @BindView(R.id.penqty_podi)
        TextView penqty_podi ;
        @BindView(R.id.extraqty_podi)
        TextView extraqty_podi ;
        @BindView(R.id.fabimage_podi)
        ImageView fabimage_podi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            penqty_podi.setVisibility(View.INVISIBLE);
        }
    }

    public void updateList(ArrayList<PO_fabric_response_details> list){
        po_fabric_response_details = list;
        notifyDataSetChanged();
    }
}
