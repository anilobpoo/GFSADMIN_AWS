package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails.PoDetailsRespoDet;
import com.obpoo.gfsfabricsoftware.Report.UI.PoDeliverydetItems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/22/2019.
 */

public class PoDetailsAdapter extends RecyclerView.Adapter<PoDetailsAdapter.ViewHolder> {
    ArrayList<PoDetailsRespoDet> poDetailsRespoDetArrayList;
    Activity context;
    String formattedDate;
    String remain_delay;



    public PoDetailsAdapter(ArrayList<PoDetailsRespoDet> poDetailsRespoDetArrayList, Activity context) {
        this.poDetailsRespoDetArrayList = poDetailsRespoDetArrayList;
        this.context = context;
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("d/M/yyyy");
        formattedDate = df.format(c.getTime());
        Log.i("hello","hello");
    }

    @NonNull
    @Override
    public PoDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.podeliverydetailsadp,viewGroup,false);
        PoDetailsAdapter.ViewHolder podetadpView = new PoDetailsAdapter.ViewHolder(view);
        return podetadpView;
    }

    @Override
    public void onBindViewHolder(@NonNull PoDetailsAdapter.ViewHolder holder, final int i) {
        holder.oid_pod.setText("#"+poDetailsRespoDetArrayList.get(i).getId());
        holder.staffname_pod.setText(poDetailsRespoDetArrayList.get(i).getStaff());
        holder.factory_pod.setText(poDetailsRespoDetArrayList.get(i).getFactory());
        if(poDetailsRespoDetArrayList.get(i).getCcEmail().equals("")){
            holder.email_pod.setText("Not Available");
        }else{
        holder.email_pod.setText(poDetailsRespoDetArrayList.get(i).getCcEmail());}
        holder.items_pod.setText("Item: "+String.valueOf(poDetailsRespoDetArrayList.get(i).getItems().size()));
        if(poDetailsRespoDetArrayList.get(i).getDeliveryDate().equals("")){
            holder.delstatus_pod.setText("Not Available");
        }
        else{
        holder.delstatus_pod.setText(poDetailsRespoDetArrayList.get(i).getDeliveryDate());
        }

        if(poDetailsRespoDetArrayList.get(i).getDeliveryDate().equals("")){

            holder.del_status_pod.setText("Status: Status Not Available");
        }
        else{
          long getdiffDate=  getDaysBetweenDates(formattedDate,poDetailsRespoDetArrayList.get(i).getDeliveryDate());
          System.out.println("getDaysBetweenDates"+getdiffDate);
          if(getdiffDate>0){
              holder.del_status_pod.setTextColor(context.getResources().getColor(R.color.green_500));
              holder.del_status_pod.setText("Status: "+String.valueOf(getdiffDate)+" Days Remain to Deliver");
              remain_delay="Status: "+String.valueOf(getdiffDate)+" Days Remain to Deliver";
          }
          if(getdiffDate<0){

              holder.del_status_pod.setTextColor(context.getResources().getColor(R.color.red_500));
              holder.del_status_pod.setText("Status: Delivery Delayed by "+String.valueOf(getdiffDate).replace("-","")+" days");
              remain_delay="Status: Delivery Delayed by "+String.valueOf(getdiffDate).replace("-","")+" days";
          }
        }

        holder.status_pod.setText(poDetailsRespoDetArrayList.get(i).getStatusText());
        holder.date_pod.setText(poDetailsRespoDetArrayList.get(i).getCreatedOn());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, PoDeliverydetItems.class);
                in.putExtra("PODETAILITEMS",poDetailsRespoDetArrayList);
                in.putExtra("INDEXITEMS",i);
                in.putExtra("REMAINDELAY",remain_delay);

                context.startActivity(in);
            }
        });




    }

    @Override
    public int getItemCount() {
        return poDetailsRespoDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.oid_pod)
        TextView oid_pod;
        @BindView(R.id.staffname_pod)
        TextView staffname_pod;
        @BindView(R.id.factory_pod)
        TextView factory_pod;
        @BindView(R.id.email_pod)
        TextView email_pod;
        @BindView(R.id.items_pod)
        TextView items_pod;
        @BindView(R.id.delstatus_pod)
        TextView delstatus_pod;
        @BindView(R.id.del_status_pod)
        TextView del_status_pod;
        @BindView(R.id.status_pod)
        TextView status_pod;
        @BindView(R.id.date_pod)
        TextView date_pod;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public static long getDaysBetweenDates(String Start, String end){
        String dateFormat = "d/M/yyyy";
        SimpleDateFormat date_Format = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        Date startDate, endDate;
        long numberOfDays = 0;
        try {
            startDate = date_Format.parse(Start);
            endDate = date_Format.parse(end);
            numberOfDays = getUnitBetweenDates(startDate, endDate, TimeUnit.DAYS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numberOfDays;
    }

    private static long getUnitBetweenDates(Date startDate, Date endDate, TimeUnit unit) {
        long timeDiff = endDate.getTime() - startDate.getTime();
        return unit.convert(timeDiff, TimeUnit.MILLISECONDS);
    }

    public void updateList(ArrayList<PoDetailsRespoDet> list){
        poDetailsRespoDetArrayList=list;
        notifyDataSetChanged();

    }


}
