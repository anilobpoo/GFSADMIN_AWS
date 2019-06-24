package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.CheckModel;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDdetail;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/8/2019.
 */

public class PendingFabricsAdp extends RecyclerView.Adapter<PendingFabricsAdp.ViewHolder> {
    ArrayList<FabricPendingOIDdetail> get_fabricPendingDet;
    Activity context;
    public static ArrayList<CheckModel> checkModelArrayList = new ArrayList<>();
    Spinner  ts_to;
    Button ts_transfer;
    String getSelctedTransfer;

    public PendingFabricsAdp(ArrayList<FabricPendingOIDdetail> get_fabricPendingDet, Activity context, Spinner ts_to, Button ts_transfer,String getSelctedTransfer) {
        this.get_fabricPendingDet = get_fabricPendingDet;
        this.context = context;
        this.ts_to=ts_to;
        this.ts_transfer=ts_transfer;
        this.getSelctedTransfer=getSelctedTransfer;
        Log.i("getSelctedTransfer",getSelctedTransfer);
    }

    @NonNull
    @Override
    public PendingFabricsAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pending_fab_det, parent, false);
        PendingFabricsAdp.ViewHolder fabricAdp = new PendingFabricsAdp.ViewHolder(view);
        return fabricAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull final PendingFabricsAdp.ViewHolder holder, int i) {
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE + get_fabricPendingDet.get(i).getFabImg()).into(holder.ts_img);
        holder.ts_order.setText("OrderId: "+get_fabricPendingDet.get(i).getOid());
        holder.ts_fabtxt.setText("Fabric: "+get_fabricPendingDet.get(i).getFabName());
        holder.ts_qty.setText("Qty: "+get_fabricPendingDet.get(i).getQtyFinal());
        holder.ts_status.setText("Status: "+get_fabricPendingDet.get(i).getStatus());
        holder.ts_date.setText("Date: "+get_fabricPendingDet.get(i).getCreatedOn());

       final FabricPendingOIDdetail dataPos = get_fabricPendingDet.get(i);

        holder.ts_check.setTag(i);
        holder.ts_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)holder.ts_check.getTag();
                if(holder.ts_check.isSelected()){
                    holder.ts_check.setSelected(false);
                    int showIndex = getIndex(String.valueOf(pos));
                    checkModelArrayList.remove(showIndex);
                    ts_to.setEnabled(false);
                    ts_transfer.setEnabled(false);
                    ts_transfer.setBackgroundColor(Color.GRAY);
                   holder.customer_qty.setEnabled(false);
                }
                else{
                    holder.ts_check.setSelected(true);
                    ts_to.setEnabled(true);
                    ts_transfer.setEnabled(true);
                    ts_transfer.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                    holder.customer_qty.setEnabled(true);
                    checkModelArrayList.add(new CheckModel(pos,true,dataPos.getId(),
                           dataPos.getOid(),dataPos.getFabId(),dataPos.getQtyFinal(),dataPos.getCreatedOn(),
                            dataPos.getStatus(),dataPos.getFactoryId(),dataPos.getFabName(),dataPos.getFabImg(),
                            dataPos.getSellPrMtr(),dataPos.getPoSatatus(),dataPos.getVendor(),dataPos.getCountry(),holder.customer_qty.getText().toString()));
                }

            }
        });




    }

    @Override
    public int getItemCount() {
        return get_fabricPendingDet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ts_img)
        ImageView ts_img;
        @BindView(R.id.ts_order)
        TextView ts_order;
        @BindView(R.id.ts_fabtxt)
        TextView ts_fabtxt;
        @BindView(R.id.ts_qty)
        TextView ts_qty;
        @BindView(R.id.ts_status)
        TextView ts_status;
        @BindView(R.id.ts_date)
        TextView ts_date;
        @BindView(R.id.ts_check)
        CheckBox ts_check;
        @BindView(R.id.customer_qty)
        EditText customer_qty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            if(getSelctedTransfer.equals(AppConstants.tran_ware)){
                customer_qty.setVisibility(View.GONE);
            }
            if(getSelctedTransfer.equals(AppConstants.tran_cust)){
                customer_qty.setEnabled(false);
            }

        }
    }

    public int getIndex(String itemName) {
        for (int i = 0; i < checkModelArrayList.size(); i++) {
            CheckModel auction = checkModelArrayList.get(i);
            if (itemName.equals(String.valueOf(auction.getPos()))) {
                return i;
            }
        }

        return -1;
    }

}
