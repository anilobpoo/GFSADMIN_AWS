package com.obpoo.gfsfabricsoftware.collections.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.DepositeResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.Transactions;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsPresenterImpl;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsView;
import com.obpoo.gfsfabricsoftware.collections.ui.OrderDetailsInvoice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionINDAdapter extends RecyclerView.Adapter<CollectionINDAdapter.VIewHolder> implements CollectionsView {

    List<Transactions> transactions;
    ArrayList<InvoiceDatum> invoiceData;
    ArrayList<InvoiceDatum> selected_invoiceData;
    Context context;
    String supervisor, cashier, ass_supervior;
    CollectionsPresenterImpl presenter;
    String date, tag = "";

    public CollectionINDAdapter(Context context, List<Transactions> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public VIewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.collection_inner_adapter, viewGroup, false);
        VIewHolder rootView = new VIewHolder(view);
        presenter = new CollectionsPresenterImpl(this);
        return rootView;
    }

    @Override
    public void onBindViewHolder(@NonNull VIewHolder vIewHolder, final int i) {

            vIewHolder.paymode_value.setText(transactions.get(i).getFrom());
            vIewHolder.paytype_value.setText(transactions.get(i).getType());
            vIewHolder.collection_value.setText(transactions.get(i).getAppliedAmmount());

            if (transactions.get(i).getSvConfirm().equals("2")) {
                supervisor = "Verified";
            } else {
                supervisor = "Not Verified";
            }
            if (transactions.get(i).getCashConfirm().equals("2")) {
                cashier = "Verified";
            } else {
                cashier = "Not Verified";
            }
            if (transactions.get(i).getAsvConfirm().equals("2")) {
                ass_supervior = "Verified";
            } else {
                ass_supervior = "Not Verified";
            }
            try {
                vIewHolder.ddate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(transactions.get(i).getCreatedOn())));

            } catch (ParseException e) {
                e.printStackTrace();
            }
            vIewHolder.supervisor.setText(supervisor);
            vIewHolder.casheier.setText(cashier);
            vIewHolder.as_supervisor.setText(ass_supervior);
            vIewHolder.go_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(transactions.get(i).getCreatedOn()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    presenter.viewInvoice(date, "single_day_collection", transactions.get(i).getPickUpGuy());

                }
            });


    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CollectionsDResponse response) {
    }

    @Override
    public void onInvoiceLoad(CollectionInvoiceResponse response) {
        if (response.getStatus().equals("success")) {
            Log.i("statuss",response.getStatus());
            invoiceData = response.getData();
            Intent intent = new Intent(context, OrderDetailsInvoice.class);
            intent.putExtra("data", invoiceData);
            context.startActivity(intent);
        }
    }

    @Override
    public void onDepositeLoad(DepositeResponse response) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }


    class VIewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.paymode_value)
        TextView paymode_value;
        @BindView(R.id.paytype_value)
        TextView paytype_value;
        @BindView(R.id.collection_value)
        TextView collection_value;
        @BindView(R.id.ddate)
        TextView ddate;
        @BindView(R.id.supervisor)
        TextView supervisor;
        @BindView(R.id.casheier)
        TextView casheier;
        @BindView(R.id.ass_supervisor)
        TextView as_supervisor;
        @BindView(R.id.go_next)
        ImageView go_next;
        @BindView(R.id.submit_card)
        CardView submit_card;
        @BindView(R.id.border)
        ImageView border;
        @BindView(R.id.sup_enable)
        SwitchCompat sup_enable;
        @BindView(R.id.cha_enable)
        SwitchCompat cha_enable;
        @BindView(R.id.ass_enable)
        SwitchCompat ass_enable;


        public VIewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
