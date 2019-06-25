package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AddFabricOrdersSO;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderStatusRes;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersDetail;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.MyOrdersResponse;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersPresenterImpl;
import com.obpoo.gfsfabricsoftware.salesorder.mvp.MyOrdersView;
import com.obpoo.gfsfabricsoftware.salesorder.ui.PreviewFabrics;
import com.obpoo.gfsfabricsoftware.salesorder.ui.SOorderDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;


public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyViewHolder> implements MyOrdersView {
    private Context context;
    private ArrayList<MyOrdersDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    MyOrdersPresenterImpl presenter;

    public void updateList(ArrayList<MyOrdersDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(MyOrdersResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();

        }else
        {
            hideDialog();
            showError(response.getMessage().toString());
        }
    }

    @Override
    public void onAllSO(AllOrderRes response) {

    }

    @Override
    public void onAllSoStatus(AllOrderStatusRes response) {

    }

    @Override
    public void onAddFabricsSO(AddFabricOrdersSO response) {

    }

    @Override
    public void showDialog() {
        showProgressBar();
    }

    @Override
    public void hideDialog() {
        closeProgressbar();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Log.i("orderAdpErr",message);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView ordernum,advance,date,leftover,total,fabrics,delete, customername, customerphonenum;
        /*ImageView imageView2;
        FoldingCell fc;*/

        public MyViewHolder(View view) {
            super(view);
            ordernum = view.findViewById(R.id.ordernum);
            advance = view.findViewById(R.id.advance);
            date = view.findViewById(R.id.date);
            leftover = view.findViewById(R.id.leftover);
            total = view.findViewById(R.id.total);
            fabrics = view.findViewById(R.id.fabrics);
            delete = view.findViewById(R.id.delete);
            customername = view.findViewById(R.id.customerName);
            customerphonenum = view.findViewById(R.id.customerPhone);
            //fc = (FoldingCell) view.findViewById(R.id.folding_cell);
        }
    }


    public MyOrdersAdapter(Activity context, ArrayList<MyOrdersDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter = new MyOrdersPresenterImpl(this);

    }

    @Override
    public MyOrdersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_myorders, parent, false);

        return new MyOrdersAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyOrdersAdapter.MyViewHolder holder, final int position) {
        final MyOrdersDetail item = cartList.get(position);
      /*  holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fc.toggle(false);
            }
        });*/


        String dates=item.getOrderdate();
        String[] splited = dates.split("\\s+");

        holder.ordernum.setText("#"+item.getOrderQr());
        holder.date.setText(splited[0]);
        holder.advance.setText("THB "+item.getAdvance());
        holder.leftover.setText("THB "+item.getLeftover());
        holder.total.setText("THB "+item.getOrderTotal());
        holder.fabrics.setText("View");
        String customer_status =item.getCustomerDetails().getStatus();
        Log.i("status_adapter",item.getCustomerDetails().getStatus());
        if(customer_status.equals("true")){
        holder.customerphonenum.setText(item.getCustomerDetails().getData().get(0).getCustomer_name());
        Log.i("Name_adapter",item.getCustomerDetails().getData().get(0).getCustomer_name());
        }

       // holder.customername.setText(item.getCustomer_details().getData().getCustomer_name());
        holder.customername.setText("Status: "+ item.getStatusText());

        holder.fabrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=item.getId();
               /* Intent intent=new Intent(activity, PreviewFabrics.class);
                intent.putExtra("id",id);
                activity.startActivity(intent);*/
               Intent in = new Intent(activity, SOorderDetails.class);
               in.putExtra(AppConstants.orderSoDetails,item);
               activity.startActivity(in);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=item.getId();
            }
        });


    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }


    public void showProgressBar() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(activity, activity.getResources().getString(R.string.loading_please_wait));
        } else {
            closeProgressbar();
            progressDialog = null;
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(activity, activity.getResources().getString(R.string.loading_please_wait));
        }
    }

    public void closeProgressbar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


}

