package com.obpoo.gfsfabricsoftware.shop.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.others.http.shop.DeleteShopClient;
import com.obpoo.gfsfabricsoftware.shop.datamodels.ShopDetail;
import com.obpoo.gfsfabricsoftware.shop.ui.UpdateShop;
import com.obpoo.gfsfabricsoftware.utilities.Constants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.HttpReqResCallBack;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> implements HttpReqResCallBack{
    private Context context;
    private ArrayList<ShopDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;


    public void updateList(ArrayList<ShopDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,location,type,address;
        public ImageView delete;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);type = view.findViewById(R.id.shop);
            location = view.findViewById(R.id.location);address = view.findViewById(R.id.address);
            delete = view.findViewById(R.id.delete);

        }
    }
    public ShopAdapter(Activity context, ArrayList<ShopDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
    }

    @Override
    public ShopAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop, parent, false);

        return new ShopAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShopAdapter.MyViewHolder holder, final int position) {
        final ShopDetail item = cartList.get(position);


        String name = item.getName();
        holder.name.setText(name);
        holder.location.setText(item.getLocation());
        holder.type.setText(item.getTitle());
        holder.address.setText(item.getAddress());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog(item.getId(),position);



            }
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }






    private void deleteShopService(String id) {
        if (networkDetection.isWifiAvailable(activity) || networkDetection.isMobileNetworkAvailable((activity))) {
            //BaseActivity.showProgressBar();
            showProgressBar();
            Map<String, String> mapOfRequestParams = new HashMap<>();
            mapOfRequestParams.put(Constants.method, "delete_shop");
            mapOfRequestParams.put(Constants.id, id);
            DeleteShopClient deleteShopClient = new DeleteShopClient(activity);
            deleteShopClient.callBack = this;
            deleteShopClient.getJsonForType(mapOfRequestParams);

        } else {
            Toast.makeText(activity, activity.getString(R.string.network_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jsonResponseReceived(String jsonResponse, int statusCode, int requestType) {
        switch (requestType) {

            case Constants.DELETE_SHOP:
                Log.e("deleteShop", jsonResponse.toString());
                if (jsonResponse != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(jsonResponse);
                        String success = jsonObject.getString("status").toLowerCase();
                        if (success.equals("success")) {
                            Log.e("tess","Dess");
                            send();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(activity, activity.getString(R.string.status_error), Toast.LENGTH_SHORT).show();
                }
                closeProgressbar();
                break;

                default:
                break;

        }
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

                        deleteShopService(String.valueOf(ids));
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

    public void showBottomSheetDialog(final String id, final int position) {
        View view = activity.getLayoutInflater().inflate(R.layout.fragment_bottom_layout, null);

        final BottomSheetDialog dialog = new BottomSheetDialog(activity);
        dialog.setContentView(view);
        LinearLayout edit = view.findViewById(R.id.edit);
        LinearLayout delete = view.findViewById(R.id.delete);



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity, UpdateShop.class);
                intent.putExtra("id",id);
                activity.startActivity(intent);
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

