package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField.dynamicField_changeD;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.POAdd;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * Created by PHD on 1/11/2019.
 */

public class FabricItemsAdapter extends RecyclerView.Adapter<FabricItemsAdapter.ViewHolder> {
    Activity context;
    ArrayList<FabricsDetail> getFabricList;
    ArrayList<CustomersDetail> customerList;
    ArrayList<dynamicField_changeD> addItemList = new ArrayList<>();
    String getSelctedCustomer;

    public FabricItemsAdapter(Activity context, ArrayList<FabricsDetail> getFabricList, ArrayList<CustomersDetail> customerList) {
        this.context = context;
        this.getFabricList = getFabricList;
        this.customerList=customerList;

    }

    @NonNull
    @Override
    public FabricItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.addfabric_contractrequest, parent, false);
        FabricItemsAdapter.ViewHolder fabricAdp = new FabricItemsAdapter.ViewHolder(view);
        return fabricAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull final FabricItemsAdapter.ViewHolder holder,final int i) {
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+getFabricList.get(i).getFab_img()).into(holder.fab_image);
        holder.content_fab.setText(getFabricList.get(i).getComposition());
        holder.article_fab.setText(getFabricList.get(i).getArticleno());
        ArrayAdapter<CustomersDetail> customer_adapter = new ArrayAdapter<CustomersDetail>(context,android.R.layout.simple_spinner_dropdown_item,customerList);
        customer_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.customer.setAdapter(customer_adapter);
        holder.add_fabric_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemList.add(new dynamicField_changeD(getFabricList.get(i).getFab_img(),
                        getFabricList.get(i).getComposition(),
                        getFabricList.get(i).getArticleno(),
                        getSelctedCustomer,
                        holder.fab_qty_mtr.getText().toString(),
                        holder.fab_qty_yard.getText().toString(),holder.brand_fab.getText().toString()));
                Intent in = new Intent(context, POAdd.class);
                in.putExtra("getItemList",addItemList);
                in.putExtra("mediateVIA","Adapter");
                context.setResult(2,in);
                context.finish();

            }
        });
      /*  holder.fab_qty_mtr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                holder.fab_qty_yard.setText(String.valueOf(Float.parseFloat(s.toString())*1.1));
            }
        });

        holder.fab_qty_yard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    holder.fab_qty_mtr.setText(String.valueOf(Float.parseFloat(s.toString())/1.1));
            }
        });*/




    }

    @Override
    public int getItemCount() {
        return getFabricList.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.fab_image)
        ImageView fab_image;
        @BindView(R.id.content_fab)
        TextView content_fab;
        @BindView(R.id.customer)
        Spinner customer;
        @BindView(R.id.brand_fab)
        EditText brand_fab;
        @BindView(R.id.fab_qty_mtr)
        EditText fab_qty_mtr;
        @BindView(R.id.fab_qty_yard)
        EditText fab_qty_yard;
        @BindView(R.id.add_fabric_item)
        Button add_fabric_item;
        @BindView(R.id.article_fab)
        TextView article_fab;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @OnItemSelected(R.id.customer)
        public void onCustomer(int position){
            getSelctedCustomer = customerList.get(position).getCustomerName();
            Toast.makeText(context,getSelctedCustomer,Toast.LENGTH_SHORT).show();

        }
    }
    class MeterTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }


}
