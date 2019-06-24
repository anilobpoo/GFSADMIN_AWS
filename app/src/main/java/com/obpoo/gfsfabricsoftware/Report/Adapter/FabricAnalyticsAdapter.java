package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.FabricAnalytics.FabricAnalyticsDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PHD on 2/20/2019.
 */

public class FabricAnalyticsAdapter extends RecyclerView.Adapter<FabricAnalyticsAdapter.ViewHolder> {
    ArrayList<FabricAnalyticsDetails> fabricAnalyticsDetailsArrayList;
    Activity context;

    public FabricAnalyticsAdapter(ArrayList<FabricAnalyticsDetails> fabricAnalyticsDetailsArrayList, Activity context) {
        this.fabricAnalyticsDetailsArrayList = fabricAnalyticsDetailsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public FabricAnalyticsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fabricanlyticsadp,viewGroup,false);
        FabricAnalyticsAdapter.ViewHolder  fabricAdp = new FabricAnalyticsAdapter.ViewHolder(view);
        return fabricAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull FabricAnalyticsAdapter.ViewHolder holder, int i) {
        holder.fabname_fa.setText(fabricAnalyticsDetailsArrayList.get(i).getFabName());
        holder.stock_fa.setText(fabricAnalyticsDetailsArrayList.get(i).getStock());
        holder.sold_fa.setText(fabricAnalyticsDetailsArrayList.get(i).getSold());
        holder.created_fa.setText(fabricAnalyticsDetailsArrayList.get(i).getCreated());
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+fabricAnalyticsDetailsArrayList.get(i).getFabImg()).into(holder.fabimage_fa);

    }

    @Override
    public int getItemCount() {
        return fabricAnalyticsDetailsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fabimage_fa)
        CircleImageView fabimage_fa;
        @BindView(R.id.fabname_fa)
        TextView fabname_fa ;
        @BindView(R.id.stock_fa)
        TextView stock_fa;
        @BindView(R.id.sold_fa)
        TextView sold_fa;
        @BindView(R.id.created_fa)
        TextView created_fa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void updateList(ArrayList<FabricAnalyticsDetails> list){
        fabricAnalyticsDetailsArrayList = list;
        notifyDataSetChanged();
    }
}
