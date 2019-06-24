package com.obpoo.gfsfabricsoftware.collections.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionInvoiceResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionsDResponse;
import com.obpoo.gfsfabricsoftware.collections.datamodel.InvoiceDatum;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsPresenterImpl;
import com.obpoo.gfsfabricsoftware.collections.mvp.CollectionsView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ODInvoiceAdapter extends RecyclerView.Adapter<ODInvoiceAdapter.ViewHolder> implements CollectionsView {
    Context context;
    ArrayList<InvoiceDatum> invoiceData;
    String supervisor, cashier, ass_supervior;
    String sup_val = "", cash_val = "", ass_sup_val = "";
    CollectionsPresenterImpl presenter;

    public ODInvoiceAdapter(Context applicationContext, ArrayList<InvoiceDatum> invoiceData) {
        context = applicationContext;
        this.invoiceData = invoiceData;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.od_invoice_adapter, viewGroup, false);
        ViewHolder rootview = new ViewHolder(view);
        presenter = new CollectionsPresenterImpl(this);
        return rootview;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder vIewHolder, final int i) {

        vIewHolder.paymode_value.setText(invoiceData.get(i).getFrom());
        vIewHolder.paytype_value.setText(invoiceData.get(i).getType());
        vIewHolder.collection_value.setText(invoiceData.get(i).getAppliedAmmount());
        sup_val = invoiceData.get(i).getSvConfirm();
        cash_val = invoiceData.get(i).getCashConfirm();
        ass_sup_val = invoiceData.get(i).getAsvConfirm();

        if (invoiceData.get(i).getSvConfirm().equals("2")) {
            vIewHolder.sup_enable.setChecked(true);
            vIewHolder.sup_enable.setClickable(false);
            supervisor = "Verified";
        } else if (invoiceData.get(i).getSvConfirm().equals("0")) {
            supervisor = "Not Verified";
            vIewHolder.sup_enable.setChecked(false);
        }

        if (invoiceData.get(i).getCashConfirm().equals("2")) {
            cashier = "Verified";
            vIewHolder.cha_enable.setChecked(true);
            vIewHolder.sup_enable.setClickable(false);
            vIewHolder.cha_enable.setClickable(false);
        } else if (invoiceData.get(i).getCashConfirm().equals("0")) {
            cashier = "Not Verified";
            vIewHolder.cha_enable.setChecked(false);

        }

        if (invoiceData.get(i).getAsvConfirm().equals("2")) {
            ass_supervior = "Verified";
            vIewHolder.ass_enable.setChecked(true);
            vIewHolder.sup_enable.setClickable(false);
            vIewHolder.cha_enable.setClickable(false);
            vIewHolder.ass_enable.setClickable(false);

        } else if (invoiceData.get(i).getAsvConfirm().equals("0")) {
            ass_supervior = "Not Verified";
            vIewHolder.ass_enable.setChecked(false);

        }

        try {
            vIewHolder.ddate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(invoiceData.get(i).getCreatedOn())));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        vIewHolder.supervisor.setText(supervisor);
        vIewHolder.casheier.setText(cashier);
        vIewHolder.as_supervisor.setText(ass_supervior);

        vIewHolder.sup_enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vIewHolder.sup_enable.setClickable(false);
                } else {
                    vIewHolder.supervisor.setText("Verified");
                    sup_val = "2";
                }
            }
        });
        vIewHolder.cha_enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vIewHolder.cha_enable.setClickable(false);
                    vIewHolder.sup_enable.setClickable(false);

                } else {
                    vIewHolder.supervisor.setText("Verified");
                    vIewHolder.casheier.setText("Verified");
                    sup_val = "1";
                    cash_val = "2";
                }
            }
        });
        vIewHolder.ass_enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vIewHolder.cha_enable.setClickable(false);
                    vIewHolder.sup_enable.setClickable(false);
                    vIewHolder.ass_enable.setClickable(false);

                } else {
                    vIewHolder.supervisor.setText("Verified");
                    vIewHolder.casheier.setText("Verified");
                    vIewHolder.as_supervisor.setText("Verified");
                    sup_val = "1";
                    cash_val = "1";
                    ass_sup_val = "2";
                }
            }
        });

        vIewHolder.submit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateInvoice("verify_day_collection", invoiceData.get(i).getId(), sup_val, cash_val, ass_sup_val);

            }
        });
    }

    @Override
    public int getItemCount() {
        return invoiceData.size();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CollectionsDResponse response) {

    }

    @Override
    public void onInvoiceLoad(CollectionInvoiceResponse response) {
        Log.i("statussupdate", response.getStatus());

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


    public class ViewHolder extends RecyclerView.ViewHolder {
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
