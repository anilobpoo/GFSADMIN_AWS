package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model.Bill_Invoice_Response;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/20/2019.
 */

public class DailySalesAdapter extends RecyclerView.Adapter<DailySalesAdapter.ViewHolder> {
    ArrayList<Bill_Invoice_Response> bill_invoice_responseArrayList;
    Activity context;

    public DailySalesAdapter(ArrayList<Bill_Invoice_Response> bill_invoice_responseArrayList, Activity context) {
        this.bill_invoice_responseArrayList = bill_invoice_responseArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DailySalesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.daily_sales_report_adp,viewGroup,false);
        DailySalesAdapter.ViewHolder dailyviewAdp = new DailySalesAdapter.ViewHolder(view);
        return dailyviewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull final DailySalesAdapter.ViewHolder holder, int i) {

        holder.folding_cell_dsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.folding_cell_dsr.toggle(false);
            }
        });

        holder.cusname_dsr_below.setText(bill_invoice_responseArrayList.get(i).getCustomerDetails().getData().getCustomerName());
        holder.cusname_dsr_above.setText(bill_invoice_responseArrayList.get(i).getCustomerDetails().getData().getCustomerName());
        holder.slip_dsr_below.setText(bill_invoice_responseArrayList.get(i).getVatSlip());
        holder.slip_dsr_above.setText(bill_invoice_responseArrayList.get(i).getVatSlip());
        holder.total_dsr_below.setText(bill_invoice_responseArrayList.get(i).getOrderTotal());
        holder.total_dsr_above.setText(bill_invoice_responseArrayList.get(i).getOrderTotal());
        holder.status_dsr_below.setText(bill_invoice_responseArrayList.get(i).getStatusText());
        holder.status_dsr_above.setText(bill_invoice_responseArrayList.get(i).getStatusText());
        holder.created_dsr_above.setText(bill_invoice_responseArrayList.get(i).getOrderdate());
        holder.date_dsr_below.setText(bill_invoice_responseArrayList.get(i).getOrderdate());

        holder.vat_dsr_below.setText(bill_invoice_responseArrayList.get(i).getVatAmount());
        holder.pay_dsr_below.setText(bill_invoice_responseArrayList.get(i).getPaybleAmount());
        holder.advannce_dsr_below.setText("Advance: "+bill_invoice_responseArrayList.get(i).getAdvance());
        holder.leftover_dsr_below.setText("LeftOver: "+bill_invoice_responseArrayList.get(i).getLeftover());
        holder.ordertype_dsr_below.setText(bill_invoice_responseArrayList.get(i).getOrderType());
        holder.deliverytype_dsr_below.setText(bill_invoice_responseArrayList.get(i).getDeliveryType());
        holder.paymode_dsr_below.setText(bill_invoice_responseArrayList.get(i).getPayMode());

        Double discountDoub= Double.parseDouble(bill_invoice_responseArrayList.get(i).getOrderTotal())*(Double.parseDouble(
                bill_invoice_responseArrayList.get(i).getDiscountPer())/100);
        holder.dis_dsr_below.setText(String.valueOf(discountDoub));


    }

    @Override
    public int getItemCount() {
        return bill_invoice_responseArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cusname_dsr_below)
        TextView cusname_dsr_below;
        @BindView(R.id.slip_dsr_below)
        TextView slip_dsr_below ;
        @BindView(R.id.total_dsr_below)
        TextView total_dsr_below ;
        @BindView(R.id.status_dsr_below)
        TextView status_dsr_below;
        @BindView(R.id.date_dsr_below)
        TextView date_dsr_below;
        @BindView(R.id.vat_dsr_below)
        TextView vat_dsr_below;
        @BindView(R.id.dis_dsr_below)
        TextView dis_dsr_below;
        @BindView(R.id.pay_dsr_below)
        TextView pay_dsr_below ;
        @BindView(R.id.advannce_dsr_below)
        TextView advannce_dsr_below ;
        @BindView(R.id.leftover_dsr_below)
        TextView leftover_dsr_below;
        @BindView(R.id.ordertype_dsr_below)
        TextView ordertype_dsr_below;
        @BindView(R.id.deliverytype_dsr_below)
        TextView deliverytype_dsr_below;
        @BindView(R.id.paymode_dsr_below)
        TextView paymode_dsr_below;


        @BindView(R.id.cusname_dsr_above)
        TextView cusname_dsr_above ;
        @BindView(R.id.slip_dsr_above)
        TextView slip_dsr_above;
        @BindView(R.id.total_dsr_above)
        TextView total_dsr_above;
        @BindView(R.id.status_dsr_above)
        TextView status_dsr_above;
        @BindView(R.id.created_dsr_above)
        TextView created_dsr_above;

        @BindView(R.id.folding_cell_dsr)
        FoldingCell folding_cell_dsr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void updateList(ArrayList<Bill_Invoice_Response> list){
        bill_invoice_responseArrayList = list;
        notifyDataSetChanged();
    }
}
