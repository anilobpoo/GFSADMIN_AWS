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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/19/2019.
 */

public class BillInvoiceAdapter extends RecyclerView.Adapter<BillInvoiceAdapter.ViewHolder>{
    ArrayList<Bill_Invoice_Response> bill_invoice_responseArrayList;
    Activity context;



    public BillInvoiceAdapter(ArrayList<Bill_Invoice_Response> bill_invoice_responseArrayList, Activity context) {
        this.bill_invoice_responseArrayList = bill_invoice_responseArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BillInvoiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bill_invoice_rep_adp,viewGroup,false);
        BillInvoiceAdapter.ViewHolder billviewAdp = new BillInvoiceAdapter.ViewHolder(view);
        return billviewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull BillInvoiceAdapter.ViewHolder holder, int i) {
        holder.cus_name_bi.setText(bill_invoice_responseArrayList.get(i).getCustomerDetails().getData().getCustomerName());
        holder.vat_slip_bi.setText(bill_invoice_responseArrayList.get(i).getVatSlip());
        holder.status_bi.setText(bill_invoice_responseArrayList.get(i).getStatusText());
        holder.vat_val_bi.setText(bill_invoice_responseArrayList.get(i).getVatAmount());
        holder.total_bi.setText(bill_invoice_responseArrayList.get(i).getPaybleAmount());
        holder.orderType_bi.setText(bill_invoice_responseArrayList.get(i).getOrderType());
        holder.delivery_bi.setText(bill_invoice_responseArrayList.get(i).getDeliveryType());
        holder.date_bi.setText(bill_invoice_responseArrayList.get(i).getOrderdate());
       Double discountDoub= Double.parseDouble(bill_invoice_responseArrayList.get(i).getOrderTotal())*(Double.parseDouble(
                bill_invoice_responseArrayList.get(i).getDiscountPer())/100);
        holder.discount_bi.setText(String.valueOf(discountDoub));



    }

    @Override
    public int getItemCount() {
        return bill_invoice_responseArrayList.size();
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
