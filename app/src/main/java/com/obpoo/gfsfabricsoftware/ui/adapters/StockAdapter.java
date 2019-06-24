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

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.Activity.CustomerReserve;
import com.obpoo.gfsfabricsoftware.Stock.Activity.ViewStock;
import com.obpoo.gfsfabricsoftware.color.datamodels.ColorResponse;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorPresenterImpl;
import com.obpoo.gfsfabricsoftware.color.mvp.ColorView;
import com.obpoo.gfsfabricsoftware.shelfassignment.ui.MoveFabrics;
import com.obpoo.gfsfabricsoftware.shelfassignment.ui.ShelfAssignmentNew;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.SettingsItem;

import java.util.List;


public class StockAdapter extends RecyclerView.Adapter<StockAdapter.MyViewHolder> implements ColorView{

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

    public StockAdapter(Context mContext, List<SettingsItem> albumList) {
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
      //  Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setImageResource(album.getThumbnail());
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==0)
                {
                    // mContext.startActivity(new Intent(mContext,ShelfAssignment.class));
                     mContext.startActivity(new Intent(mContext,ShelfAssignmentNew.class));

                }
                if (position==1)
                {
                    mContext.startActivity(new Intent(mContext,MoveFabrics.class));
                }
                if (position==2){
                    Toast.makeText(mContext,"ViewStock",Toast.LENGTH_SHORT).show();
                    mContext.startActivity(new Intent(mContext,ViewStock.class));
                }
                if(position==3){
                    mContext.startActivity(new Intent(mContext,CustomerReserve.class));
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