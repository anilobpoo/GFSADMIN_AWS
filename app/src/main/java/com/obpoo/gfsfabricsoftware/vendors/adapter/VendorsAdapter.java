package com.obpoo.gfsfabricsoftware.vendors.adapter;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsDetail;
import com.obpoo.gfsfabricsoftware.vendors.datamodels.VendorsResponse;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsPresenterImpl;
import com.obpoo.gfsfabricsoftware.vendors.mvp.VendorsView;
import com.obpoo.gfsfabricsoftware.vendors.ui.UpdateVendor;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;


public class VendorsAdapter extends RecyclerView.Adapter<VendorsAdapter.MyViewHolder> implements VendorsView{
    private Context context;
    private ArrayList<VendorsDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    VendorsPresenterImpl presenter;

    public void updateList(ArrayList<VendorsDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(VendorsResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
        }else
            showError(response.getMessage());

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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,address,tel,fax,email,type,shortName,names,numbers,types;
        public Button delete,edit;
        //ImageView options;
        FoldingCell fc;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            fc = (FoldingCell) view.findViewById(R.id.folding_cell);
            address = view.findViewById(R.id.address);
            types = view.findViewById(R.id.types);
            numbers = view.findViewById(R.id.numbers);
            names = view.findViewById(R.id.names);
            type = view.findViewById(R.id.type);
            email = view.findViewById(R.id.email);
            tel = view.findViewById(R.id.phone);
            shortName = view.findViewById(R.id.number);
            edit = view.findViewById(R.id.edit);
            delete = view.findViewById(R.id.delete);
          //  fax = view.findViewById(R.id.fax);
            //options = view.findViewById(R.id.options);


        }
    }
    public VendorsAdapter(Activity context, ArrayList<VendorsDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter = new VendorsPresenterImpl(this);
    }

    @Override
    public VendorsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_cell, parent, false);

        return new VendorsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VendorsAdapter.MyViewHolder holder, final int position) {
        final VendorsDetail item = cartList.get(position);


        String address = item.getAddress()+", "+item.getCountry()+", "+item.getZipcode();
        holder.name.setText(item.getVendor());
        holder.names.setText(item.getVendor());
        // attach click listener to folding cell
        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fc.toggle(false);
            }
        });
        holder.address.setText(address)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ;
      //  holder.fax.setText(item.getFax());
        holder.tel.setText(item.getTelephone());
        holder.email.setText(item.getEmail());
        holder.type.setText(item.getName());
        holder.types.setText(item.getName());
        holder.shortName.setText("#"+item.getVendorno());
        holder.numbers.setText("#"+item.getVendorno());

        holder.tel.setLinkTextColor(Color.BLUE);holder.email.setLinkTextColor(Color.BLUE);
        holder.tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + item.getTelephone()));
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
                open(item.getVendorID(),position);
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, UpdateVendor.class);
                intent.putExtra("id",item.getVendorID());
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

                        presenter.delete("delete_vendor",String.valueOf(ids),"delete_vendor");
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

    private void send() {
        if(activity instanceof IMethodCaller){
            Log.e("tse","s");
            ((IMethodCaller)activity).yourDesiredMethod("deleted");
        }

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

