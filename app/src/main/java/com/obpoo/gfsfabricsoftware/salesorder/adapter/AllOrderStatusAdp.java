package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOCusAdp;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AddFabricOrdersSO;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllORderStatusData;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderSOData;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersPresenterImpl;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersView;
import com.obpoo.gfsfabricsoftware.salesorder.ui.AllSO;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllOrderStatusAdp extends RecyclerView.Adapter<AllOrderStatusAdp.ViewHolder> implements MyOrdersView {
    ArrayList<AllORderStatusData> allORderStatusDataArrayList;
    Activity context;
    MyOrdersPresenterImpl presenter;

    public AllOrderStatusAdp(ArrayList<AllORderStatusData> allORderStatusDataArrayList, Activity context) {
        this.allORderStatusDataArrayList = allORderStatusDataArrayList;
        this.context = context;
        presenter = new MyOrdersPresenterImpl(this);
    }

    @NonNull
    @Override
    public AllOrderStatusAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.trackpocuslay,viewGroup,false);
        AllOrderStatusAdp.ViewHolder viewtrackCuspo = new AllOrderStatusAdp.ViewHolder(view);
        return viewtrackCuspo;
    }

    @Override
    public void onBindViewHolder(@NonNull AllOrderStatusAdp.ViewHolder holder, final  int i) {
        holder.cus_name_track_po_.setText(allORderStatusDataArrayList.get(i).getStatusText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPassAllOrderselectedStatus("filter",allORderStatusDataArrayList.get(i).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return allORderStatusDataArrayList.size();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MyOrdersResponse response) {

    }

    @Override
    public void onAllSO(AllOrderRes response) {
        Log.i("AllOrderSelectedRes",response.getMessage());
        if(response.getStatus().equals("success")){
            ArrayList<AllOrderSOData> allOrderSODataArrayList = response.getData();
            Intent in = new Intent(context, AllSO.class);
            in.putParcelableArrayListExtra(AppConstants.salesAllOrderSelectedStatsuRes,allOrderSODataArrayList);
            context.setResult(AppConstants.salesORderAllActIN,in);
            context.finish();
        }

    }

    @Override
    public void onAllSoStatus(AllOrderStatusRes response) {

    }

    @Override
    public void onAddFabricsSO(AddFabricOrdersSO response) {

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

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cus_name_track_po_)
        TextView cus_name_track_po_;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
