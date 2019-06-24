package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics.SoldFabricsData;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PHD on 2/27/2019.
 */

public class SoldFabricsAdapter extends RecyclerView.Adapter<SoldFabricsAdapter.ViewHolder> {
    ArrayList<SoldFabricsData> soldFabricsDataArrayList;
    Activity context;

    public SoldFabricsAdapter(ArrayList<SoldFabricsData> soldFabricsDataArrayList, Activity context) {
        this.soldFabricsDataArrayList = soldFabricsDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SoldFabricsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cutstockadp,viewGroup,false);
        SoldFabricsAdapter.ViewHolder soldviewAdp = new SoldFabricsAdapter.ViewHolder(view);
        return soldviewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull SoldFabricsAdapter.ViewHolder holder, int i) {
        holder.order_id.setText("Order Id: #"+soldFabricsDataArrayList.get(i).getOrderid());
        holder.fabName.setText("Fabric: "+soldFabricsDataArrayList.get(i).getFabName());
        holder.meter.setText("Qty(Mtr): "+soldFabricsDataArrayList.get(i).getQuantity());
        holder.mode.setText("Mode: "+soldFabricsDataArrayList.get(i).getPayMode());
        holder.total.setText(soldFabricsDataArrayList.get(i).getSubtotal());
        holder.discount.setText(soldFabricsDataArrayList.get(i).getDiscountForUser());
        holder.unique_sf.setText("Unique Id: "+soldFabricsDataArrayList.get(i).getQrcode());
        holder.date_sf.setText(soldFabricsDataArrayList.get(i).getCreatedOn());

        Double discountDoub= Double.parseDouble(soldFabricsDataArrayList.get(i).getSubtotal())*(Double.parseDouble(
                soldFabricsDataArrayList.get(i).getDiscountForUser())/100);
        holder.payable.setText(String.valueOf(discountDoub));

        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+soldFabricsDataArrayList.get(i).getFabImg()).into(holder.fabimage_cs);



    }

    @Override
    public int getItemCount() {
        return soldFabricsDataArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fabname_cs)
        TextView order_id;
        @BindView(R.id.fabunicode_cs)
        TextView fabName;
        @BindView(R.id.fabMtr_cs)
        TextView meter;
        @BindView(R.id.created_cs)
        TextView mode;
        @BindView(R.id.war_cs)
        TextView total;
        @BindView(R.id.zone_cs)
        TextView discount;
        @BindView(R.id.shelf_cs)
        TextView payable;
        @BindView(R.id.fabimage_cs)
        CircleImageView fabimage_cs;
        @BindView(R.id.lay_forsoldFsbrics)
        RelativeLayout lay_forsoldFsbrics;
        @BindView(R.id.unique_sf)
        TextView unique_sf;
        @BindView(R.id.date_sf)
        TextView date_sf;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            lay_forsoldFsbrics.setVisibility(View.VISIBLE);
        }
    }
    public void updateList(ArrayList<SoldFabricsData> list){
        soldFabricsDataArrayList = list;
        notifyDataSetChanged();
    }
}
