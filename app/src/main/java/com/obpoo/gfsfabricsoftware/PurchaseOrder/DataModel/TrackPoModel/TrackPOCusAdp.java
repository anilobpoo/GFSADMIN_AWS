package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.TrackPODet;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackPOCusAdp extends RecyclerView.Adapter<TrackPOCusAdp.ViewHolder> implements poView {
    ArrayList<TrackPObyCusData> trackPObyCusDataArrayList;
    Activity context;
    poPresenterImpl presenter;
    ProgressBar progress_trackPODet;

    public void updateFilterData( ArrayList<TrackPObyCusData> list){
        this.trackPObyCusDataArrayList=list;
        notifyDataSetChanged();
    }

    public TrackPOCusAdp(ArrayList<TrackPObyCusData> trackPObyCusDataArrayList, Activity context,ProgressBar progress_trackPODet) {
        this.trackPObyCusDataArrayList = trackPObyCusDataArrayList;
        this.context = context;
        this.progress_trackPODet=progress_trackPODet;
        presenter = new poPresenterImpl(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackpocuslay,viewGroup,false);
        ViewHolder viewtrackCuspo = new ViewHolder(view);
        return viewtrackCuspo;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final  int i) {


        holder.cus_name_track_po_.setText(trackPObyCusDataArrayList.get(i).getCustomerName());
        holder.constr_trackPOCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTrackPODet(trackPObyCusDataArrayList.get(i).getId(),"view_by_customer");

            }
        });



    }

    @Override
    public int getItemCount() {
        return trackPObyCusDataArrayList.size();
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
        Log.i("TrackPODetRes",response.getMessage());
        if(response.getStatus().equals("success")){
            ArrayList<TrackPODetData> trackPODetDataArrayList = response.getData();
            Intent in = new Intent(context, TrackPODet.class);
            in.putParcelableArrayListExtra(AppConstants.trackPOCusDet,trackPODetDataArrayList);
            context.startActivity(in);
        }

    }

    @Override
    public void onModifyNotes(ModifyNotes response) {

    }

    @Override
    public void showDialog() {
        progress_trackPODet.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progress_trackPODet.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cus_name_track_po_)
        TextView cus_name_track_po_;
        @BindView(R.id.constr_trackPOCus)
        ConstraintLayout constr_trackPOCus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
