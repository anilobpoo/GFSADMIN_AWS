package com.obpoo.gfsfabricsoftware.user.apapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserDetail;
import com.obpoo.gfsfabricsoftware.user.datamodels.UserResponse;
import com.obpoo.gfsfabricsoftware.user.mvp.UserView;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;

import java.util.ArrayList;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> implements UserView {
    private Context context;
    private ArrayList<UserDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;


    public void updateList(ArrayList<UserDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void viewUserList(UserResponse response) {

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
        public TextView name,address,tel,fax,email,type,shortName,edit,deletetxtvw;
        public Button delete;
        ImageView options,userImage;

        public MyViewHolder(View view) {
            super(view);
            edit = view.findViewById(R.id.edittxt);
            deletetxtvw = view.findViewById(R.id.deletetxt);
            name = view.findViewById(R.id.name);
            address = view.findViewById(R.id.address);
            type = view.findViewById(R.id.type);
            email = view.findViewById(R.id.email);
            tel = view.findViewById(R.id.tel);
            shortName = view.findViewById(R.id.group);
            fax = view.findViewById(R.id.fax);
            options = view.findViewById(R.id.options);
            // userImage = (ImageView) view.findViewById(R.id.userimage);


        }
    }


    public UsersAdapter(Activity context, ArrayList<UserDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final UserDetail item = cartList.get(position);
        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";

        //Picasso.with(context).load(imageUri).into(holder.userImage);

        String address = item.getDeptname()+", "+item.getCreated_by()+", "+item.getActive();
        holder.name.setText(item.getName());
        holder.address.setText(address);
        holder.fax.setText(item.getDeptname());
        holder.tel.setText(item.getPhone());
        holder.email.setText(item.getEmail());
        holder.type.setText(item.getDesignation());
        holder.shortName.setText(item.getPhone());
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog(item.getId(),item.getActive(),item.getName(),item.getEmail(),item.getDesignation(),item.getDeptname(),item.getPhone(),item.getPreviledges(),item.getProfile_pic(),position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }


    void open(final String ids,final  int position) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(activity.getResources().getString(R.string.app_name));

        // set dialog message
        alertDialogBuilder
                .setMessage("Are you sure you want to delete?")
                .setCancelable(false)
                .setPositiveButton(activity.getResources().getString(R.string.Yes),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        /*deleteShopService(String.valueOf(ids));
                        cartList.remove(position);
                        notifyDataSetChanged();
                        notifyItemRemoved(position);*/
                        Toast.makeText(context, "Coming soon!", Toast.LENGTH_SHORT).show();

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


    //showBottomSheetDialog(item.getId(),item.getActive(),item.getName(),item.getEmail(),item.getDesignation(),item.getDeptname(),item.getPhone(),item.getPreviledges(),item.getProfile_pic());

    public void showBottomSheetDialog(final String id, final String active,final String name,final String email,final String designation,final String deptname,final String phone,final ArrayList<String> priviliges, final String profilepic, final int position) {
        View view = activity.getLayoutInflater().inflate(R.layout.user_bottom_layout, null);

        final BottomSheetDialog dialog = new BottomSheetDialog(activity);
        dialog.setContentView(view);
        TextView uid,nametxt,activetxt,emailtxt,phonetxt,designationtxt,privilge,profile,dept,edit,delete;
        uid = (TextView)view.findViewById(R.id.user_id);
        nametxt = (TextView)view.findViewById(R.id.name);
        activetxt = (TextView)view.findViewById(R.id.active);
        emailtxt = (TextView)view.findViewById(R.id.email);
        phonetxt = (TextView)view.findViewById(R.id.phone);
        designationtxt = (TextView)view.findViewById(R.id.designation);
        privilge = (TextView)view.findViewById(R.id.previledges);
        profile = (TextView)view.findViewById(R.id.profile_pic);
        dept = (TextView)view.findViewById(R.id.deptname);

        uid.setText(id);
        nametxt.setText(name);
        activetxt.setText(active);
        emailtxt.setText(email);
        phonetxt.setText(phone);
        designationtxt.setText(designation);
        dept.setText(deptname);
        phonetxt.setText(phone);
        privilge.setText(priviliges.toString());
        profile.setText(profilepic);


       // LinearLayout edit = view.findViewById(R.id.edit);
        //LinearLayout delete = view.findViewById(R.id.delete);



      /*  edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity, User.class);
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
        });*/
        dialog.show();
    }

}

