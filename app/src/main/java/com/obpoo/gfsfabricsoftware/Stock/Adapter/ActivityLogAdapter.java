package com.obpoo.gfsfabricsoftware.Stock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog.ActivityLogResDet;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/4/2019.
 */

public class ActivityLogAdapter extends RecyclerView.Adapter<ActivityLogAdapter.ViewHolder>{
    ArrayList<ActivityLogResDet> activityLogResDetArrayList;
    Activity context;

    public ActivityLogAdapter(ArrayList<ActivityLogResDet> activityLogResDetArrayList, Activity context) {
        this.activityLogResDetArrayList = activityLogResDetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ActivityLogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_log_stockview, parent, false);
        ActivityLogAdapter.ViewHolder delViewHolder = new ActivityLogAdapter.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityLogAdapter.ViewHolder viewHolder, int i) {
        viewHolder.al_fab_name.setText(activityLogResDetArrayList.get(i).getFabricDetails().getFabName());
        viewHolder.al_fab_id.setText(activityLogResDetArrayList.get(i).getBundleId());
        if(activityLogResDetArrayList.get(i).getAction().equals("stock_in")){
            viewHolder.al_action.setText("Stock In");
        }
        if(activityLogResDetArrayList.get(i).getAction().equals("stock_out")){
            viewHolder.al_action.setText("Stock Out");
            viewHolder.al_action.setBackgroundColor(context.getResources().getColor(R.color.red_500));
        }
        viewHolder.al_action_by.setText(activityLogResDetArrayList.get(i).getActionBy());
        viewHolder.al_date.setText(activityLogResDetArrayList.get(i).getUpdatedOn());
        viewHolder.al_qty.setText("Qty: "+activityLogResDetArrayList.get(i).getQuantity());
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+activityLogResDetArrayList.get(i).getFabricDetails().getFabImg()).into(viewHolder.al_fab_img);


    }

    @Override
    public int getItemCount() {
        return activityLogResDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.al_fab_img)
        ImageView al_fab_img;
        @BindView(R.id.al_fab_name)
        TextView al_fab_name;
        @BindView(R.id.al_fab_id)
        TextView al_fab_id;
        @BindView(R.id.al_action)
        TextView al_action;
        @BindView(R.id.al_action_by)
        TextView al_action_by;
        @BindView(R.id.al_date)
        TextView al_date;
        @BindView(R.id.al_qty)
        TextView al_qty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
