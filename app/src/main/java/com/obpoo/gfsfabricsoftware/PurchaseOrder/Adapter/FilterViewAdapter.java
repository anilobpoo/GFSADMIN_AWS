package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.FilterDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.PoFilterResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.PoView;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.RequestedOrder;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterViewAdapter extends RecyclerView.Adapter<FilterViewAdapter.ViewHolder> implements PoView {
    ArrayList<FilterDatum> filterData;
    ArrayList<poDatum> selectData;
    Activity context;
    PoPresenterImpl presenter;
    String setStatusId;

    public FilterViewAdapter(ArrayList<FilterDatum> filterData, Activity context) {
        this.filterData = filterData;
        this.context = context;
        presenter = new PoPresenterImpl(this);
    }

    @NonNull
    @Override
    public FilterViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackpocuslay, viewGroup, false);
        FilterViewAdapter.ViewHolder rootView = new FilterViewAdapter.ViewHolder(view);
        return rootView;
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.cus_name_track_po_.setText(filterData.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatusId=filterData.get(i).getId();
                presenter.onVIewSelectFilter("filter",filterData.get(i).getId(),"1");
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterData.size();
    }

    @Override
    public void onShowViewPO(poPOJO response) {
        if (response.getStatus().equals("success")){
            selectData = response.getData();
            Intent in = new Intent(context, RequestedOrder.class);
            in.putParcelableArrayListExtra(AppConstants.slected_status_cm,selectData);
            in.putExtra("CMSTATUSID",setStatusId);
            context.setResult(AppConstants.cm_filter_status,in);
            context.finish();
        }
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

    @Override
    public void onModifyNotes(ModifyNotes response) {

    }

    @Override
    public void onShowFilter(PoFilterResponse response) {

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

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cus_name_track_po_)
        TextView cus_name_track_po_;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

