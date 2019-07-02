package com.obpoo.gfsfabricsoftware.salesorder.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.POCreateAddCustomerinAddFab;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveDet;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.FabricAddOrderSO;
import com.obpoo.gfsfabricsoftware.salesorder.ui.SOorderDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFabSalesOrder extends RecyclerView.Adapter<AddFabSalesOrder.ViewHolder> {
    ArrayList<AddReserveDet> addReserveDetArrayList;
    Activity context;
    FabricAddOrderSO fabI;
    ArrayList<CustomersDetail> customerList;
    Map<Integer, Integer> mSpinnerSelectedItem = new HashMap<Integer, Integer>();
    String getCustomer,getCID;
    public AddFabSalesOrder(ArrayList<AddReserveDet> addReserveDetArrayList, Activity context, FabricAddOrderSO fabI,ArrayList<CustomersDetail> customerList) {
        this.addReserveDetArrayList = addReserveDetArrayList;
        this.context = context;
        this.fabI=fabI;
        this.customerList=customerList;

        PreferenceConnector.saveArraylistofObjectsForFab(customerList,AppConstants.selectcustomerforPOinaddfab,context);
    }

    @NonNull
    @Override
    public AddFabSalesOrder.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.addfabric_contractrequest,viewGroup,false);
        AddFabSalesOrder.ViewHolder view_fabAdd = new AddFabSalesOrder.ViewHolder(view);
        return view_fabAdd;
    }

    @Override
    public void onBindViewHolder(@NonNull final AddFabSalesOrder.ViewHolder holder, final int i) {
       final  AddReserveDet index = addReserveDetArrayList.get(i);

        ArrayAdapter<CustomersDetail> customer_adapter = new ArrayAdapter<CustomersDetail>(context,android.R.layout.simple_spinner_dropdown_item,customerList);
        customer_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.customer.setAdapter(customer_adapter);

        holder.customer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                Log.i("SpinnerSelected",getCustomer);
                mSpinnerSelectedItem.put(i, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(mSpinnerSelectedItem.containsKey(i)){
            int spin_Cus_pos= mSpinnerSelectedItem.get(i);
            holder.customer.setSelection(spin_Cus_pos);
            //getCustomer=parent.getItemAtPosition(position).toString();

        }
        holder.article_fab.setText(index.getFabName());
        holder.brand_fab.setText(index.getBrand());
        holder.content_fab.setText(index.getComposition());

        holder.add_fabric_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.fab_qty_mtr.getText().length()>0){

                    if(mSpinnerSelectedItem.containsKey(i)){
                        int spin_Cus_pos= mSpinnerSelectedItem.get(i);
                        holder.customer.setSelection(spin_Cus_pos);
                        //getCustomer=parent.getItemAtPosition(position).toString();
                        getCustomer=customerList.get(spin_Cus_pos).getCustomerName();
                        getCID=customerList.get(spin_Cus_pos).getId();
                    }

                    index.setQty(holder.fab_qty_mtr.getText().toString());
                    fabI.AddFabricsBelowI(new poItem(index.getBrand(),index.getArticleno(),index.getQty(),index.getComposition(),getCustomer,getCID,""),"");
                }
            }
        });

        holder.fab_qty_mtr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                holder.fab_qty_yard.setText(String.format("%.2f",Double.valueOf(s.toString())*1.09));
            }
        });


        holder.text_sel_po_cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, POCreateAddCustomerinAddFab.class);
                //in.putParcelableArrayListExtra(AppConstants.selectcustomerforPOinaddfab,customerList);
                in.putExtra(AppConstants.selctedindexofabric,i);

                ((Activity) context).startActivityForResult(in,AppConstants.passcustomerforfabric);

            }
        });
       // Log.i("Icustomer",index.getCustomer());
        if(index.getCustomer()!= null &&!index.getCustomer().equals("")){
            Log.i("Icustomer",index.getCustomer());
            holder.text_sel_po_cus.setText(index.getCustomer());

        }



    }

    @Override
    public int getItemCount() {
        return addReserveDetArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.customer)
        Spinner customer;
        @BindView(R.id.article_fab)
        TextView article_fab;
        @BindView(R.id.brand_fab)
        TextView brand_fab;
        @BindView(R.id.fab_qty_mtr)
        TextView fab_qty_mtr;
        @BindView(R.id.fab_qty_yard)
        TextView fab_qty_yard;
        @BindView(R.id.add_fabric_item)
        Button add_fabric_item;
        @BindView(R.id.content_fab)
        TextView content_fab;
        @BindView(R.id.text_sel_po_cus)
        TextView text_sel_po_cus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
