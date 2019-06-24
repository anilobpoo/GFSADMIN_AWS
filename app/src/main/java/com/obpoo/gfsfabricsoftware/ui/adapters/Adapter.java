package com.obpoo.gfsfabricsoftware.ui.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.obpoo.gfsfabricsoftware.Article.UI.Stock;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.UI.AssignDelivery_Act;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.UI.CommonArticleGroup;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorView;
import com.obpoo.gfsfabricsoftware.color.ui.ColorType;
import com.obpoo.gfsfabricsoftware.fabric.ui.ViewFabrics;
import com.obpoo.gfsfabricsoftware.ui.activities.master.Composition;
import com.obpoo.gfsfabricsoftware.customertype.ui.CustomerType;
import com.obpoo.gfsfabricsoftware.fabrictype.ui.FabricType;
import com.obpoo.gfsfabricsoftware.group.ui.Group;
import com.obpoo.gfsfabricsoftware.minmax.ui.MinMax;
import com.obpoo.gfsfabricsoftware.ui.activities.master.article.Articles;
import com.obpoo.gfsfabricsoftware.bank.ui.Bank;
import com.obpoo.gfsfabricsoftware.customers.ui.Customers;
import com.obpoo.gfsfabricsoftware.ui.activities.master.Department;
import com.obpoo.gfsfabricsoftware.user.ui.User;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.vendortype.ui.Vendor;
import com.obpoo.gfsfabricsoftware.shop.ui.Shops;
import com.obpoo.gfsfabricsoftware.vendors.ui.Vendors;
import com.obpoo.gfsfabricsoftware.warehouse.ui.Warehouse;
import com.obpoo.gfsfabricsoftware.utilities.SettingsItem;


import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements ColorView{

    private Context mContext;
    private List<SettingsItem> albumList;
    private Dialog progressDialog;
    ColorPresenterImpl presenter;


    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(ColorResponse response) {


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
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView thumbnail;

    public MyViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }

}

    public Adapter(Context mContext, List<SettingsItem> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        presenter=new ColorPresenterImpl(this);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_setting, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        SettingsItem album = albumList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==0)
                {
                    // mContext.startActivity(new Intent(mContext,ShelfAssignment.class));
                     mContext.startActivity(new Intent(mContext,Shops.class));

                }
                if (position==1)
                {
                    mContext.startActivity(new Intent(mContext,Department.class));                }

                if (position==2)
                {
                    mContext.startActivity(new Intent(mContext,CustomerType.class));
                }
                if (position==3)
                {
                    mContext.startActivity(new Intent(mContext,Vendor.class));
                }

                  if (position==4)
                {
                    mContext.startActivity(new Intent(mContext,Customers.class));
                }
                if (position==5)
                {
                    mContext.startActivity(new Intent(mContext,Vendors.class));
                }
                if (position==6)
                {
                    mContext.startActivity(new Intent(mContext,Warehouse.class));
                }
                if (position==7)
                {
                    mContext.startActivity(new Intent(mContext,Bank.class));
                }
                if (position==8)
                {
                    mContext.startActivity(new Intent(mContext,FabricType.class));
                }
                if (position==9)
                {
                    mContext.startActivity(new Intent(mContext,MinMax.class));
                }
                if (position==10)
                {
                    mContext.startActivity(new Intent(mContext,Composition.class));
                }if (position==11)
                {
                    Intent intent=new Intent(mContext,ColorType.class);
                    mContext.startActivity(intent);
                }
                if (position==12)
                {

                    mContext.startActivity(new Intent(mContext,Articles.class));
                }
                if (position==13)
                {
                    mContext.startActivity(new Intent(mContext,Group.class));
                }
                if (position==14)
                {
                    mContext.startActivity(new Intent(mContext,ViewFabrics.class));
                }
                if (position==15)
                {
                    mContext.startActivity(new Intent(mContext,Stock.class));
                }
                if (position==16)
                {
                    mContext.startActivity(new Intent(mContext,CommonArticleGroup.class));
                }

                if (position==17)
                {
                    mContext.startActivity(new Intent(mContext,User.class));
                }
                if (position==18)
                {
                    mContext.startActivity(new Intent(mContext,AssignDelivery_Act.class));
                }


            }
        });



    }

    public void showProgressBar() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(mContext, mContext.getResources().getString(R.string.loading_please_wait));
        } else {
            closeProgressbar();
            progressDialog = null;
            progressDialog = DialogUtils.getDialogUtilsInstance().progressDialog(mContext, mContext.getResources().getString(R.string.loading_please_wait));
        }
    }

    public void closeProgressbar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}