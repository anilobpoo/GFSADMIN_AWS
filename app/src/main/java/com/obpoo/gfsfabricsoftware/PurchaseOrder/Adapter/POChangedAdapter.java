package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField.dynamicField_changeD;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 11/26/2018.
 */

public class POChangedAdapter extends RecyclerView.Adapter<POChangedAdapter.VViewHolder>{

    Context context;
    List<dynamicField_changeD> getAllValues;


    public POChangedAdapter(Context context,List<dynamicField_changeD> getAllValues) {
        this.context = context;
        this.getAllValues=getAllValues;


    }

    @NonNull
    @Override
    public POChangedAdapter.VViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.dynamicfield, parent, false);
        POChangedAdapter.VViewHolder cmnArtViewHolder = new POChangedAdapter.VViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VViewHolder holder, final int i) {
        Picasso.with(context).load(AppConstants.FABRIC_IMAGE+getAllValues.get(i).getFabImage()).into(holder.fab_image);
        holder.content_fab.setText(getAllValues.get(i).getComposition());
        holder.customer_v.setText(getAllValues.get(i).getCustomer());
        holder.brand_v.setText(getAllValues.get(i).getArticle());
        holder.fab_qty_mtr_get_v.setText(getAllValues.get(i).getQty_mtr());
        holder.fab_qty_yard_get_v.setText(getAllValues.get(i).getGty_yard());
        holder.article_fab.setText(getAllValues.get(i).getArticle());
        holder.brand_v.setText(getAllValues.get(i).getBrand());



    }


    @Override
    public int getItemCount() {

        return getAllValues.size();
    }

    class VViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fab_image)
        ImageView fab_image;
        @BindView(R.id.content_fab)
        TextView content_fab;
        @BindView(R.id.customer_v)
        TextView customer_v;
        @BindView(R.id.brand_v)
        TextView brand_v;
        @BindView(R.id.fab_qty_mtr_get_v)
        TextView fab_qty_mtr_get_v;
        @BindView(R.id.fab_qty_yard_get_v)
        TextView fab_qty_yard_get_v;
        @BindView(R.id.article_fab)
        TextView article_fab;


        public VViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

