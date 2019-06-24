package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.dynamicField.dynamicField;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 11/26/2018.
 */

public class PoAddAdapter extends RecyclerView.Adapter<PoAddAdapter.VViewHolder>{

    Context context;
    List<dynamicField> getAllValues;


    public PoAddAdapter(Context context,List<dynamicField> getAllValues) {
        this.context = context;
        this.getAllValues=getAllValues;


    }

    @NonNull
    @Override
    public PoAddAdapter.VViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.dynamicfield, parent, false);
        PoAddAdapter.VViewHolder cmnArtViewHolder = new PoAddAdapter.VViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VViewHolder holder, final int i) {


        holder.article.setText(getAllValues.get(i).getArticle_bean());
        holder.color.setText(getAllValues.get(i).getColor_bean());
        holder.qty.setText(getAllValues.get(i).getQty_bean()+" Mtrs    "+Double.parseDouble(getAllValues.get(i).getQty_bean())*1.094+" Yard"    );
        holder.fabName.setText(getAllValues.get(i).getFab_name());
        Log.e("BrandNameAdapter",getAllValues.get(i).getBrandname());
        holder.brandNAme.setText("   "+getAllValues.get(i).getBrandname());
        if(!getAllValues.get(i).getFab_image().equals("")){
            Picasso.with(context).load(AppConstants.FABRIC_IMAGE+getAllValues.get(i).getFab_image()).into(holder.fabImage);
        }


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getAllValues!=null){
                getAllValues.remove(i);
                notifyDataSetChanged();
                }
            }
        });
    }


    @Override
    public int getItemCount() {

        return getAllValues.size();
    }

    class VViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_spin_dyn)
        TextView article;
        @BindView(R.id.color_spin_dyn)
        TextView color;
        @BindView(R.id.quantity_dyn)
        TextView qty;
        @BindView(R.id.delete_button_dyn)
        ImageButton delete;
        @BindView(R.id.fabImageId)
        ImageView fabImage;
        @BindView(R.id.fabNameId)
        TextView fabName;
        @BindView(R.id.brandname)
        TextView brandNAme;


        public VViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
