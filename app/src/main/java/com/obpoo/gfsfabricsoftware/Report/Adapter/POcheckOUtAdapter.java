package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.CheckOUt.CheckOUtData;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/27/2019.
 */

public class POcheckOUtAdapter  extends RecyclerView.Adapter<POcheckOUtAdapter.ViewHolder> {
    ArrayList<CheckOUtData> checkInDataArrayList;
    Activity context;
    String baht = "\u0e3f";

    public POcheckOUtAdapter(ArrayList<CheckOUtData> checkInDataArrayList, Activity context) {
        this.checkInDataArrayList = checkInDataArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public POcheckOUtAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pocheckinadp,viewGroup,false);
        POcheckOUtAdapter.ViewHolder outADpview = new POcheckOUtAdapter.ViewHolder(view);
        return outADpview;
    }

    @Override
    public void onBindViewHolder(@NonNull final POcheckOUtAdapter.ViewHolder holder, int i) {
        holder.folding_cell_dsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.folding_cell_dsr.toggle(false);
            }
        });

        holder.type_in.setText(checkInDataArrayList.get(i).getType());
        holder.txn_in.setText(checkInDataArrayList.get(i).getNumber());
        holder.amount_in.setText(baht + checkInDataArrayList.get(i).getAppliedAmmount());
        holder.due_in.setText(checkInDataArrayList.get(i).getDueDate());

        holder.invoice_po_in_below.setText("RequestedOrder ID: #" + checkInDataArrayList.get(i).getPoId());
        holder.date_po_in_below.setText(checkInDataArrayList.get(i).getCreatedOn());

        holder.bundle_po_in_below.setText(checkInDataArrayList.get(i).getNumber());
        holder.total_po_in_below.setText(checkInDataArrayList.get(i).getFrom());
        holder.paid_po_in_below.setText(checkInDataArrayList.get(i).getType());
        holder.left_po_in_below.setText(baht + checkInDataArrayList.get(i).getAppliedAmmount());
        holder.type_po_in_below.setText(checkInDataArrayList.get(i).getBank());
        holder.term_po_in_below.setText(checkInDataArrayList.get(i).getChqNo());
        holder.due_po_in_below.setText("Due Date: " + checkInDataArrayList.get(i).getDueDate());
        holder.cpo_id_out.setText("RequestedOrder ID: #"+checkInDataArrayList.get(i).getPoId());
        holder.order_po_in_below.setText("Txn no:");
    }

    @Override
    public int getItemCount() {
        return checkInDataArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.folding_cell_dsr)
        FoldingCell folding_cell_dsr;
        @BindView(R.id.cus_in)
        TextView cus_in;
        @BindView(R.id.type_in)
        TextView type_in;
        @BindView(R.id.txn_in)
        TextView txn_in;
        @BindView(R.id.amount_in)
        TextView amount_in;
        @BindView(R.id.due_in)
        TextView due_in;

        @BindView(R.id.invoice_po_in_below)
        TextView invoice_po_in_below;
        @BindView(R.id.date_po_in_below)
        TextView date_po_in_below;
        @BindView(R.id.order_po_in_below)
        TextView order_po_in_below;
        @BindView(R.id.bundle_po_in_below)
        TextView bundle_po_in_below;
        @BindView(R.id.total_po_in_below)
        TextView total_po_in_below;
        @BindView(R.id.paid_po_in_below)
        TextView paid_po_in_below;
        @BindView(R.id.left_po_in_below)
        TextView left_po_in_below;
        @BindView(R.id.type_po_in_below)
        TextView type_po_in_below;
        @BindView(R.id.term_po_in_below)
        TextView term_po_in_below;
        @BindView(R.id.due_po_in_below)
        TextView due_po_in_below;
        @BindView(R.id.cpo_id_out)
        TextView cpo_id_out;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            cpo_id_out.setVisibility(View.VISIBLE);

        }
    }
    public void updateList(ArrayList<CheckOUtData> list){
        checkInDataArrayList = list;
        notifyDataSetChanged();
    }
}
