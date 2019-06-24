package com.obpoo.gfsfabricsoftware.cart.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartDetail;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartPresenterImpl;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.obpoo.gfsfabricsoftware.utilities.Constants.NO_PIC;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> implements CartView {
    private Context context;
    private ArrayList<CartDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    CartPresenterImpl presenter;
    String orderid,discount,currency;
    public static final String FSPIC = "http://furnirworld.com/giovanifs/Uploads/Fabric/";

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CartResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();

            if (response.getMessage().toLowerCase().contains("updated"))
            {
                Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
                if(activity instanceof IMethodCaller){
                    ((IMethodCaller)activity).yourDesiredMethod("updated");
                }
            }else if (response.getMessage().toLowerCase().contains("deleted"))
            {
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                if(activity instanceof IMethodCaller) {
                    ((IMethodCaller) activity).yourDesiredMethod("deleted");

                }
            }
            else
                Toast.makeText(context, response.getMessage(), Toast.LENGTH_SHORT).show();



        }else
        {
            hideDialog();
            showError(response.getMessage().toString());
        }
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
        public TextView cart_name,cart_qty,cart_price,total_price;
        ImageView thumbnail,remove;


        public MyViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.thumbnail);
            cart_name = view.findViewById(R.id.cart_name);
            remove = view.findViewById(R.id.remove);
            cart_qty = view.findViewById(R.id.cart_qty);
            cart_price = view.findViewById(R.id.cart_price);
            total_price = view.findViewById(R.id.total_price);


        }
    }


    public CartAdapter(Activity context, ArrayList<CartDetail> cartList, String orderid) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        this.orderid = orderid;
        networkDetection = new NetworkDetection();
        presenter = new CartPresenterImpl(this);
       // discount= PreferenceConnector.readString(activity, activity.getString(R.string.discount),"");
        currency= "THB";
    }

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);

        return new CartAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final CartAdapter.MyViewHolder holder, final int position) {
        final CartDetail item = cartList.get(position);


        String itemPrice = item.getActual_price();
        String subtotal = item.getSubtotal();
        String fabricNumber = item.getFab_name();
        String qty = item.getQuantity();
        holder.cart_qty.setText("Quantity:"+qty);
        holder.cart_price.setText(currency+" "+new DecimalFormat("#.##").format(Double.parseDouble((itemPrice))));
        holder.total_price.setText(currency+" "+new DecimalFormat("#.##").format(Double.parseDouble((subtotal))));
        holder.cart_price.setPaintFlags(holder.cart_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.cart_name.setText(fabricNumber);


        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item_id = item.getId();
                String qty = item.getQuantity();
                String fabprice=item.getSell_pr_mtr();
                String discount=item.getDiscount_for_user();

                showBottomSheetDialog(item_id,position,qty,fabprice,discount,holder);



            }
        });


        String image=item.getFab_img();
        String image_url1=FSPIC+image;
        if (image.equals("images.png"))
            Glide.with(activity).load(NO_PIC).into(holder.thumbnail);
        else
            Glide.with(activity)
                    .load(image_url1)
                    .into(holder.thumbnail);

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


    public void showBottomSheetDialog(final String id, final int position, final String qty, final String fabprice, final String discount, final CartAdapter.MyViewHolder viewHolder) {
        View view = activity.getLayoutInflater().inflate(R.layout.bottomlayout_cart_details, null);

        final BottomSheetDialog dialog = new BottomSheetDialog(activity);
        dialog.setContentView(view);
        LinearLayout preview = view.findViewById(R.id.preview);
        preview.setVisibility(View.VISIBLE);
        final EditText editUpdate=view.findViewById(R.id.editUpdate);
        final Button update=view.findViewById(R.id.update);
        editUpdate.setText(qty);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qty=editUpdate.getText().toString().trim();
                Double q=Double.parseDouble(qty);
                Double d=Double.parseDouble(discount);
                Double p=Double.parseDouble(fabprice);
                double disc=p*(d/100);
                double  subtotal=((p-disc)*q);
                double  actualprice=((p)*q);
                Log.e("actualprice",""+actualprice);
                Log.e("fabprice",""+fabprice);
                Log.e("subtotal",""+subtotal);
                Log.e("disc",""+disc);

                /*viewHolder.cart_qty.setText(""+q);
                viewHolder.cart_price.setText(""+actualprice);
                viewHolder.total_price.setText(""+subtotal);*/

                presenter.editItem("edit_item",id,qty,""+actualprice,""+subtotal);
                dialog.dismiss();

            }
        });

        LinearLayout edit = view.findViewById(R.id.delete);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(id,position);
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    private void open(final String ids, final int position) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(activity.getResources().getString(R.string.app_name));
        alertDialogBuilder
                .setMessage("Are you sure you want to delete?")
                .setCancelable(false)
                .setPositiveButton(activity.getResources().getString(R.string.Yes),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        presenter.delete("delete_item",String.valueOf(ids),"");
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

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}

