package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TS_MoveInOut_scan;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocDataDetails;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/28/2019.
 */

public class TransferScanAdp extends RecyclerView.Adapter<TransferScanAdp.ViewHolder> {

    private Activity context;
    private ArrayList<DocDataDetails> docDataDetails;
    private static DecimalFormat df2;
    private ListItemClickListener listItemClickListener;

    public TransferScanAdp(ArrayList<DocDataDetails> docDataDetails, TS_MoveInOut_scan context, ListItemClickListener listItemClickListener) {
        this.docDataDetails = docDataDetails;
        this.context = context;
        this.listItemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public TransferScanAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ts_fabric_scan_inout, viewGroup, false);
        TransferScanAdp.ViewHolder tsScanViewADp = new TransferScanAdp.ViewHolder(view);
        df2 = new DecimalFormat("#.##");
        return tsScanViewADp;
    }

    @Override
    public void onBindViewHolder(@NonNull final TransferScanAdp.ViewHolder holder, final int i) {

        holder.fab_tsf.setText("Fabric Name: " + docDataDetails.get(i).getFabName());
        holder.unique_tsf.setText("Fabric No:" + docDataDetails.get(i).getUniqueCode());
        holder.from_tsf.setText("Baikorn: " + docDataDetails.get(i).getBaikonNo());
        holder.zone_tsf.setText("Transfer From: " + docDataDetails.get(i).getFromWareNo());
        holder.shelf_tsf.setText("Transfer To: " + docDataDetails.get(i).getToWareNo());
        holder.remain_mtr_tv.setText("Remain(mtr): " + docDataDetails.get(i).getRemain());
        Double remail_yard = Double.valueOf((Double.valueOf(docDataDetails.get(i).getRemain()) * 1.09));
        holder.remain_yard_tv.setText("Remain(yard): " + df2.format(remail_yard));
        if (docDataDetails.get(i).getStatus().equals("0")) {
            holder.scan_check.setClickable(true);

        }
        if (docDataDetails.get(i).isCheckScan()) {
            holder.scan_check.setChecked(true);
        }

        holder.scan_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.scan_check.isChecked()) {
                    listItemClickListener.onItemClick(v, docDataDetails.get(i).getId(),"add");
                } else {
                    listItemClickListener.onItemClick(v, docDataDetails.get(i).getId(),"remove");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return docDataDetails.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fab_tsf)
        TextView fab_tsf;
        @BindView(R.id.unique_tsf)
        TextView unique_tsf;
        @BindView(R.id.from_tsf)
        TextView from_tsf;
        @BindView(R.id.remain_mtr_tv)
        TextView remain_mtr_tv;
        @BindView(R.id.remain_yard_tv)
        TextView remain_yard_tv;
        @BindView(R.id.zone_tsf)
        TextView zone_tsf;
        @BindView(R.id.shelf_tsf)
        TextView shelf_tsf;
        @BindView(R.id.scan_check)
        CheckBox scan_check;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void removeItem(int position) {
        Log.i("RemovecheckedItem", position + "");
        docDataDetails.get(position).setCheckScan(false);
        notifyItemRemoved(position);
    }

    public interface ListItemClickListener {
        void onItemClick(View view, String id,String status);
    }
}
