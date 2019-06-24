package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model.CustomerPendingDetails;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/20/2019.
 */

public class CustomerPendingAdapter extends RecyclerView.Adapter<CustomerPendingAdapter.ViewHolder> {
    ArrayList<CustomerPendingDetails> customerPendingDetailsArrayList;
    Activity context;

    public CustomerPendingAdapter(ArrayList<CustomerPendingDetails> customerPendingDetailsArrayList, Activity context) {
        this.customerPendingDetailsArrayList = customerPendingDetailsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerPendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.customerpendingadapterlay,viewGroup,false);
        CustomerPendingAdapter.ViewHolder cp_viewAdapter = new CustomerPendingAdapter.ViewHolder(view);
        return cp_viewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerPendingAdapter.ViewHolder holder, int i) {
        holder.cus_name_bi.setText("#"+customerPendingDetailsArrayList.get(i).getId());
        holder.vat_slip_bi.setText("Order Total: THB "+customerPendingDetailsArrayList.get(i).getOrderTotal());

        holder.vat_val_bi.setText("THB"+customerPendingDetailsArrayList.get(i).getVatAmount());
        holder.total_bi.setText("THB"+customerPendingDetailsArrayList.get(i).getPaybleAmount());
        holder.orderType_bi.setText("THB"+customerPendingDetailsArrayList.get(i).getLeftover());
        holder.delivery_bi.setText(customerPendingDetailsArrayList.get(i).getDeliveryType());
        holder.date_bi.setText("Mode:"+customerPendingDetailsArrayList.get(i).getPayMode());
        Double discountDoub= Double.parseDouble(customerPendingDetailsArrayList.get(i).getOrderTotal())*(Double.parseDouble(
                customerPendingDetailsArrayList.get(i).getDiscount())/100);
        holder.discount_bi.setText("THB"+String.valueOf(discountDoub));
        holder.date_cp.setText(customerPendingDetailsArrayList.get(i).getOrderdate());


    }

    @Override
    public int getItemCount() {
        return customerPendingDetailsArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cus_name_bi)
        TextView cus_name_bi;
        @BindView(R.id.vat_slip_bi)
        TextView vat_slip_bi;
        @BindView(R.id.vat_val_bi)
        TextView vat_val_bi;
        @BindView(R.id.discount_bi)
        TextView discount_bi;
        @BindView(R.id.total_bi)
        TextView total_bi;
        @BindView(R.id.orderType_bi)
        TextView orderType_bi;
        @BindView(R.id.delivery_bi)
        TextView delivery_bi;
        @BindView(R.id.date_bi)
        TextView date_bi;
        @BindView(R.id.amount_cp)
        EditText amount_cp;
        @BindView(R.id.pay_cp)
        Button pay_cp;
        @BindView(R.id.date_cp)
        TextView date_cp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }
    }
    public void updateList(ArrayList<CustomerPendingDetails> list){
        customerPendingDetailsArrayList = list;
        notifyDataSetChanged();
    }
}
