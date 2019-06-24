package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 11/23/2018.
 */

public class poViewDetailsAdapter  extends RecyclerView.Adapter<poViewDetailsAdapter.VViewHolder> {

    Context context;
    ArrayList<poItem> poListData;

    public poViewDetailsAdapter(Context context, ArrayList<poItem> poListData) {
        this.context = context;
        this.poListData = poListData;

    }

    @NonNull
    @Override
    public poViewDetailsAdapter.VViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.poviewdetailslist, parent, false);
        poViewDetailsAdapter.VViewHolder cmnArtViewHolder = new poViewDetailsAdapter.VViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VViewHolder holder, int i) {


        holder.ArtNo.setText(poListData.get(i).getArtNo());
        holder.brandname.setText(poListData.get(i).getBrandName());
        holder.qty.setText(poListData.get(i).getQuantity());
        holder.status.setText(poListData.get(i).getStatusText());
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+poListData.get(i).getImg()).into(holder.image);

    }


    @Override
    public int getItemCount() {
        return poListData.size();
    }

    class VViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.artNo)
        TextView ArtNo;
        @BindView(R.id.brandname)
        TextView brandname;
        @BindView(R.id.qty)
        TextView qty;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.image)
        ImageView image;



        public VViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}