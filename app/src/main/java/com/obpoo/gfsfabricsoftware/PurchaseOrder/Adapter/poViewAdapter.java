package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;

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
        View view = LayoutInflater.from(context).inflate(R.layout.po_folding_view, parent, false);
        poViewAdapter.VViewHolder cmnArtViewHolder = new poViewAdapter.VViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull poViewAdapter.VViewHolder holder, final int i) {
        holder.factory.setText(poListData.get(i).getFactory());
        holder.bn.setText(poListData.get(i).getBrandName());
        holder.staff.setText(poListData.get(i).getStaff());
        holder.staffEmail.setText(poListData.get(i).getCcEmail());
        holder.status.setText(poListData.get(i).getStatusText());
        holder.orderId_po.setText("#"+poListData.get(i).getId());
        holder.item_count_po.setText(String.valueOf(poListData.get(i).getItems().size()));


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context,POView.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("POdata",poListData);
                in.putExtra("POdataIndex",i);
                context.startActivity(in);


            }
        });

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
        @BindView(R.id.factory)
        TextView factory;
        @BindView(R.id.bn)
        TextView bn;
        @BindView(R.id.staff)
        TextView staff;
        @BindView(R.id.staffEmail)
        TextView staffEmail;
        @BindView(R.id.view_poitems)
        TextView view;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.orderId_po)
        TextView orderId_po;
        @BindView(R.id.item_count_po)
        TextView item_count_po;
        @BindView(R.id.date_time)
        TextView date_time;


        public VViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
