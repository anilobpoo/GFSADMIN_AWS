package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
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
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareDet;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/12/2019.
 */

public class TransferWareWareAdp extends RecyclerView.Adapter<TransferWareWareAdp.ViewHolder>{
    Activity context;
    ArrayList<TransferWareWareDet> get_fabricPendingWareWareDet;
    public static ArrayList<CheckModel> checkModelArrayList = new ArrayList<>();
    public static String fabId_pass ;
    Spinner  ts_to;
    Button ts_transfer;
    String getSelctedTransfer;

    public TransferWareWareAdp(ArrayList<TransferWareWareDet> get_fabricPendingWareWareDet, Activity context, Spinner ts_to, Button ts_transfer, String getSelctedTransfer) {
        this.context = context;
        this.get_fabricPendingWareWareDet = get_fabricPendingWareWareDet;
        this.ts_to=ts_to;
        this.ts_transfer=ts_transfer;
        this.getSelctedTransfer=getSelctedTransfer;
        Log.i("getSelctedTransfer",getSelctedTransfer);
        ts_to.setEnabled(true);
        ts_transfer.setEnabled(true);
        ts_transfer.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @NonNull
    @Override
    public TransferWareWareAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pending_fab_det, parent, false);
        TransferWareWareAdp.ViewHolder fabricAdp = new TransferWareWareAdp.ViewHolder(view);
        return fabricAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull final TransferWareWareAdp.ViewHolder holder, int i) {
        fabId_pass=get_fabricPendingWareWareDet.get(i).getId();
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE + get_fabricPendingWareWareDet.get(i).getFabImg()).into(holder.ts_img);
        holder.ts_order.setText("OrderId: "+get_fabricPendingWareWareDet.get(i).getOid());
        holder.ts_fabtxt.setText("Fabric: "+get_fabricPendingWareWareDet.get(i).getFabName());
        holder.ts_qty.setText("Qty: "+get_fabricPendingWareWareDet.get(i).getQtyFinal());
        holder.ts_status.setText("Status: "+get_fabricPendingWareWareDet.get(i).getStatus());
        holder.ts_date.setText("Date: "+get_fabricPendingWareWareDet.get(i).getCreatedOn());

        final TransferWareWareDet dataPos = get_fabricPendingWareWareDet.get(i);

        holder.ts_check.setTag(i);
        holder.ts_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)holder.ts_check.getTag();
                if(holder.ts_check.isSelected()){
                    holder.ts_check.setSelected(false);
                    int showIndex = getIndex(String.valueOf(pos));
                    checkModelArrayList.remove(showIndex);

                }
                else{
                    holder.ts_check.setSelected(true);

                    checkModelArrayList.add(new CheckModel(pos,true,dataPos.getId(),
                            dataPos.getOid(),dataPos.getFabId(),dataPos.getQtyFinal(),dataPos.getCreatedOn(),
                            dataPos.getStatus(),dataPos.getFactoryId(),dataPos.getFabName(),dataPos.getFabImg(),
                            dataPos.getSellPrMtr(),dataPos.getPoSatatus(),dataPos.getWareId(),dataPos.getWarehouseName(),holder.customer_qty.getText().toString()));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return get_fabricPendingWareWareDet.size();
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


            if(getSelctedTransfer.equals(AppConstants.ware_ware)){
                customer_qty.setVisibility(View.GONE);
                ts_check.setVisibility(View.GONE);

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
