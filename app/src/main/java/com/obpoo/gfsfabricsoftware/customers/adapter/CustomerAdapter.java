package com.obpoo.gfsfabricsoftware.customers.adapter;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersDetail;
import com.obpoo.gfsfabricsoftware.customers.datamodels.CustomersResponse;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersPresenterImpl;
import com.obpoo.gfsfabricsoftware.customers.mvp.CustomersView;
import com.obpoo.gfsfabricsoftware.customers.ui.UpdateCustomer;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;


public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> implements CustomersView{
    private Context context;
    private ArrayList<CustomersDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    CustomersPresenterImpl presenter;

    public void updateList(ArrayList<CustomersDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CustomersResponse response) {

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
        public TextView name,address,tel,fax,email,type,group,names,types,groups;
        public Button delete,edit;
        //ImageView options;
        FoldingCell fc;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            names = view.findViewById(R.id.names);
            delete = view.findViewById(R.id.delete);
            edit = view.findViewById(R.id.edit);
            address = view.findViewById(R.id.address);
            type = view.findViewById(R.id.type);
            types = view.findViewById(R.id.types);
            email = view.findViewById(R.id.email);
            tel = view.findViewById(R.id.tel);
            group = view.findViewById(R.id.group);
            groups = view.findViewById(R.id.groups);
            //fax = view.findViewById(R.id.fax);
         //   options = view.findViewById(R.id.options);
            fc = (FoldingCell) view.findViewById(R.id.folding_cell);



        }
    }
    public CustomerAdapter(Activity context, ArrayList<CustomersDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter = new CustomersPresenterImpl(this);
    }

    @Override
    public CustomerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_customer, parent, false);

        return new CustomerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomerAdapter.MyViewHolder holder, final int position) {
        final CustomersDetail item = cartList.get(position);
        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fc.toggle(false);
            }
        });

        String address = item.getAddress()+", "+item.getCountry()+", "+item.getZipcode();
        holder.name.setText(item.getCustomerName());
        holder.names.setText(item.getCustomerName());
        holder.address.setText(address);
//        holder.fax.setText(item.getFax());
        holder.tel.setText(item.getPhone());
        holder.email.setText(item.getEmail());
        holder.type.setText(item.getCustomerTypeName());
        holder.types.setText(item.getCustomerTypeName());
        holder.group.setText(item.getCustomerTypeName());
        holder.groups.setText(item.getCustomerTypeName());


        holder.tel.setLinkTextColor(Color.BLUE);holder.email.setLinkTextColor(Color.BLUE);

        holder.tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + item.getPhone()));
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                activity.startActivity(callIntent);

            }
        });


        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String to=item.getEmail();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, "");

                //need this to prompts email client only
                email.setType("message/rfc822");

                activity.startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(item.getId(),position);
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, UpdateCustomer.class);
                intent.putExtra("id",item.getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }






    private void open(final String ids,final  int position) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(activity.getResources().getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder
                .setMessage("Are you sure you want to delete?")
                .setCancelable(false)
                .setPositiveButton(activity.getResources().getString(R.string.Yes),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        presenter.del("delete_customer",String.valueOf(ids),"del");
                        cartList.remove(position);
                        notifyDataSetChanged();
                        notifyItemRemoved(position);


                    }
                })
                .setNegativeButton(activity.getResources().getString(R.string.No),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
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

    public void showBottomSheetDialog(final String id, final int position) {
        View view = activity.getLayoutInflater().inflate(R.layout.fragment_bottom_layout, null);

        final BottomSheetDialog dialog = new BottomSheetDialog(activity);
        dialog.setContentView(view);
        LinearLayout edit = view.findViewById(R.id.edit);
        LinearLayout delete = view.findViewById(R.id.delete);



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(id,position);
                dialog.dismiss();
                Log.e("id",id);

            }
        });
        dialog.show();
    }

}

