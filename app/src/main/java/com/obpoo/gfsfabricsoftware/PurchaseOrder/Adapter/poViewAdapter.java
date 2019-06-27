package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.POView;
import com.obpoo.gfsfabricsoftware.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 11/23/2018.
 */

public class poViewAdapter extends RecyclerView.Adapter<poViewAdapter.VViewHolder> implements poView {

    Context context;
    ArrayList<poDatum> poListData;
    poPresenterImpl presenter;

    public void updateList(ArrayList<poDatum> list){
        poListData = list;
        notifyDataSetChanged();
    }


    public poViewAdapter(Context context, ArrayList<poDatum> poListData) {
        this.context = context;
        this.poListData = poListData;
        presenter = new poPresenterImpl(this);

    }

    @NonNull
    @Override
    public poViewAdapter.VViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.confirm_po_adapter, parent, false);
        poViewAdapter.VViewHolder cmnArtViewHolder = new poViewAdapter.VViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull poViewAdapter.VViewHolder holder, final int i) {
        final poDatum index = poListData.get(i);
        holder.id.setText("#"+index.getId());
        holder.item.setText("Items: "+String.valueOf(index.getItems().size()));
        holder.factoryname.setText(index.getFactory());
        holder.status.setText(index.getStatusText());
        DateFormat inputFormatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = inputFormatter1.parse(index.getCreatedOn());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
        String output1 = outputFormatter1.format(date1);


        holder.date.setText(output1);
        if(index.getDelivery_date().equals("")){
            holder.deliver_date.setText("N/A");
        }
        else{
        holder.deliver_date.setText(index.getDelivery_date());}


        holder.viewPo_arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context,POView.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("POdata",index);
                in.putExtra("POdataIndex",i);
                context.startActivity(in);
            }
        });

        holder.poNumCM.setText(index.getPo_no());




    }

    @Override
    public int getItemCount() {
        return poListData.size();
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

    @Override
    public void onShowViewPO(poPOJO response) {

    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {

    }

    @Override
    public void onValidationfail(int type) {

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    class VViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.item)
        TextView item;
        @BindView(R.id.factoryname)
        TextView factoryname;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.deliver_date)
        TextView deliver_date;
        @BindView(R.id.viewPo_arr)
        RelativeLayout viewPo_arr;
        @BindView(R.id.poNumCM)
        TextView poNumCM;


        public VViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
