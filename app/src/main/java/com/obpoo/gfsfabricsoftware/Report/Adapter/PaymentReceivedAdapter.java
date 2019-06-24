package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.PaymentsReceived.PaymentReceivedData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/21/2019.
 */

public class PaymentReceivedAdapter extends RecyclerView.Adapter<PaymentReceivedAdapter.ViewHolder> {
    ArrayList<PaymentReceivedData> paymentReceivedDataArrayList;
    Activity context;

    public PaymentReceivedAdapter(ArrayList<PaymentReceivedData> paymentReceivedDataArrayList, Activity context) {
        this.paymentReceivedDataArrayList = paymentReceivedDataArrayList;
        this.context = context;
    }

    @NonNull

    @Override
    public PaymentReceivedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.paymentreceivedadp,viewGroup,false);
        PaymentReceivedAdapter.ViewHolder payviewAdp = new PaymentReceivedAdapter.ViewHolder(view);
        return payviewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentReceivedAdapter.ViewHolder holder, int i) {
        holder.txn_pr.setText("Txn No: "+paymentReceivedDataArrayList.get(i).getNumber());
        if(paymentReceivedDataArrayList.get(i).getNumber().contains("CHQOUT")){
            holder.bank_pr.setVisibility(View.GONE);
            holder.cheque_pr.setVisibility(View.GONE);
            holder.due_pr.setVisibility(View.GONE);
            holder.linearLayout.setVisibility(View.GONE);

        }
        if(paymentReceivedDataArrayList.get(i).getBank().equals("")){
            holder.bank_pr.setVisibility(View.GONE);
        }
        if(paymentReceivedDataArrayList.get(i).getChqNo().equals("")){
            holder.cheque_pr.setVisibility(View.GONE);
        }
        if(paymentReceivedDataArrayList.get(i).getDueDate().equals("0000-00-00 00:00:00")){
            holder.due_pr.setVisibility(View.GONE);
        }
        if(paymentReceivedDataArrayList.get(i).getBank().equals("") &&paymentReceivedDataArrayList.get(i).getChqNo().equals("") && paymentReceivedDataArrayList.get(i).getDueDate().equals("0000-00-00 00:00:00")){
            holder.linearLayout.setVisibility(View.GONE);
        }

        else{
            holder.bank_pr.setVisibility(View.VISIBLE);
            holder.cheque_pr.setVisibility(View.VISIBLE);
            holder.due_pr.setVisibility(View.VISIBLE);
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.bank_pr.setText("Bank: "+paymentReceivedDataArrayList.get(i).getBank());
            holder.cheque_pr.setText("Cheque: "+paymentReceivedDataArrayList.get(i).getChqNo());
            holder.due_pr.setText("Due: "+paymentReceivedDataArrayList.get(i).getDueDate());
        }
        holder.invoice_pr.setText("From: "+paymentReceivedDataArrayList.get(i).getFrom());
        holder.type_pr.setText("Type:"+paymentReceivedDataArrayList.get(i).getType());
        holder.paid_pr.setText("Total Paid: "+paymentReceivedDataArrayList.get(i).getAppliedAmmount());

        holder.date_pr.setText(paymentReceivedDataArrayList.get(i).getCreatedOn());


    }

    @Override
    public int getItemCount() {
        return paymentReceivedDataArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txn_pr)
        TextView txn_pr;
        @BindView(R.id.invoice_pr)
        TextView invoice_pr;
        @BindView(R.id.type_pr)
        TextView type_pr ;
        @BindView(R.id.paid_pr)
        TextView paid_pr ;
        @BindView(R.id.bank_pr)
        TextView bank_pr ;
        @BindView(R.id.due_pr)
        TextView due_pr ;
        @BindView(R.id.cheque_pr)
        TextView cheque_pr;
        @BindView(R.id.date_pr)
        TextView date_pr;
        @BindView(R.id.linearLayout3)
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void updateList(ArrayList<PaymentReceivedData> list){
        paymentReceivedDataArrayList = list;
        notifyDataSetChanged();
    }
}
