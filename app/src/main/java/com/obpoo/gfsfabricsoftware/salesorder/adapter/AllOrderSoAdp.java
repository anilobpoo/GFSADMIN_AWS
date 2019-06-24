package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSOData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllOrderSoAdp extends RecyclerView.Adapter<AllOrderSoAdp.ViewHolder> {
    ArrayList<AllOrderSOData> allOrderSODataArrayList;
    Activity context;

    public AllOrderSoAdp(ArrayList<AllOrderSOData> allOrderSODataArrayList, Activity context) {
        this.allOrderSODataArrayList = allOrderSODataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AllOrderSoAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.allordersoadp,viewGroup,false);
        AllOrderSoAdp.ViewHolder viewallso = new AllOrderSoAdp.ViewHolder(view);
        return viewallso;
    }

    @Override
    public void onBindViewHolder(@NonNull AllOrderSoAdp.ViewHolder holder, int i) {
        AllOrderSOData index = allOrderSODataArrayList.get(i);
        if(index.getCustomerDetails().getData().size()>0){
        holder.cus_name_bi.setText(index.getCustomerDetails().getData().get(0).getCustomerName());}
        holder.status_bi.setText(index.getStatusText());
        holder.vat_slip_bi.setText(index.getVatSlip());
        holder.vat_val_bi.setText(index.getVatAmount());
        holder.discount_bi.setText(index.getDiscount());
        holder.total_bi.setText(index.getPaybleAmount());
        holder.orderType_bi.setText(index.getOrderType());
        holder.delivery_bi.setText(index.getDeliveryType());
        DateFormat inputFormatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        try {
            date1 = inputFormatter1.parse(index.getOrderdate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
        String output1 = outputFormatter1.format(date1);

        holder.date_bi.setText(output1);
        holder.adv_so_all.setText("Advance: "+index.getAdvance());
        holder.left_so_all.setText("LeftOver: "+index.getLeftover());
        holder.orderTot_so_all.setText("OrderTotal: "+index.getOrderTotal());

        holder.item_so_allOrder.setText(index.getItemDetails().size()+"");






    }

    @Override
    public int getItemCount() {
        return allOrderSODataArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cus_name_bi)
        TextView cus_name_bi;
        @BindView(R.id.status_bi)
        TextView status_bi;
        @BindView(R.id.vat_slip_bi)
        TextView vat_slip_bi;
        @BindView(R.id.vat_val_bi)
        TextView vat_val_bi;
        @BindView(R.id.discount_bi)
        TextView discount_bi;
        @BindView(R.id.total_bi)
        TextView total_bi;
        @BindView(R.id.orderType_bi)
        TextView orderType_bi;
        @BindView(R.id.delivery_bi)
        TextView delivery_bi;
        @BindView(R.id.date_bi)
        TextView date_bi;
        @BindView(R.id.adv_so_all)
        TextView adv_so_all;
        @BindView(R.id.left_so_all)
        TextView left_so_all;
        @BindView(R.id.orderTot_so_all)
        TextView orderTot_so_all;
        @BindView(R.id.item_so_allOrder)
        TextView item_so_allOrder;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
