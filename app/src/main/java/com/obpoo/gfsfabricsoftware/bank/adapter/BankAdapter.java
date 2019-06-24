package com.obpoo.gfsfabricsoftware.bank.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankDetail;
import com.obpoo.gfsfabricsoftware.bank.datamodels.BankResponse;
import com.obpoo.gfsfabricsoftware.bank.mvp.BankPresenterImpl;
import com.obpoo.gfsfabricsoftware.bank.mvp.BankView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;


public class BankAdapter extends RecyclerView.Adapter<BankAdapter.MyViewHolder> implements BankView{
    private Context context;
    private ArrayList<BankDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    BankPresenterImpl presenter;


    public void updateList(ArrayList<BankDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(BankResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            if (response.getMessage().toLowerCase().contains("deleted"))
            {
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }else
            showError(response.getMessage());
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
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public Button delete;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            delete = view.findViewById(R.id.delete);

        }
    }
    public BankAdapter(Activity context, ArrayList<BankDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter=new BankPresenterImpl(this);

    }

    @Override
    public BankAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bank, parent, false);

        return new BankAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BankAdapter.MyViewHolder holder, final int position) {
        final BankDetail item = cartList.get(position);


        String name = item.getBankname();
        holder.name.setText(name);
        holder.delete.setText("Edit");
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String del=holder.delete.getText().toString().toLowerCase();
                if (del.equals("edit"))
                {
                    holder.delete.setText("Save");
                    holder.name.setEnabled(true);
                    holder.name.setText("");
                    holder.name.append(item.getBankname());
                    holder.name.requestFocus();


                }else if (del.equals("save"))
                {
                    String name=holder.name.getText().toString().toLowerCase();
                    holder.delete.setText("Edit");
                    holder.name.setEnabled(false);
                    showProgressBar();
                    presenter.update("update",name,item.getId());

                }
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

