package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poDatum;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.UI.ViewDetails;
import com.obpoo.gfsfabricsoftware.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmPOAdapter extends RecyclerView.Adapter<ConfirmPOAdapter.ViewHolder> {
    Activity context;
    String tag = "";
    ArrayList<poDatum> data;


    public ConfirmPOAdapter(Activity context, ArrayList<poDatum> data) {
        this.data = data;
        this.context = context;
    }

    public ConfirmPOAdapter(Activity applicationContext, ArrayList<poDatum> data, String poorder) {
        this.data = data;
        this.context = applicationContext;
        this.tag = poorder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.confirm_po_adapter, viewGroup, false);
        ConfirmPOAdapter.ViewHolder root = new ConfirmPOAdapter.ViewHolder(view);
        return root;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final ArrayList<poItem> items = data.get(i).getItems();
        int itmsize = items.size();

        if (tag.equals("poorder")) {
            viewHolder.indc.setVisibility(View.VISIBLE);
            viewHolder.price_img.setVisibility(View.VISIBLE);
            viewHolder.price.setVisibility(View.VISIBLE);
            viewHolder.go.setVisibility(View.GONE);
            Log.i("PREVNOtes",data.get(i).getNotes());
            viewHolder.indc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent in = new Intent(context, ViewDetails.class);
                    in.putExtra("id", data.get(i).getId());
                    in.putExtra("tag", tag);
                    in.putExtra("factory", viewHolder.factoryname.getText());
                    in.putExtra("status", viewHolder.status.getText());
                    in.putExtra("date", viewHolder.date.getText());
                    in.putExtra("deliver_date", viewHolder.deliver_date.getText());
                    in.putExtra("staf", data.get(i).getStaff());
                    in.putExtra("cc_mail", data.get(i).getCcEmail());
                    in.putExtra("PREVNOTES", data.get(i).getNotes());

//                    in.putExtra("cash", data.get(i).get());
                    in.putParcelableArrayListExtra("item", items);

                    context.startActivity(in);
                }
            });

        }

        viewHolder.id.setText("#" + data.get(i).getId());
        viewHolder.factoryname.setText(data.get(i).getFactory());
        viewHolder.status.setText(data.get(i).getStatusText());
        viewHolder.poNumCM.setText(data.get(i).getPo_no());
        viewHolder.item.setText("Item:" + itmsize);
        try {
            viewHolder.date.setText(new SimpleDateFormat("dd-MMM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(data.get(i).getCreatedOn())));
            if (data.get(i).getDelivery_date().equals("")) {
                viewHolder.deliver_date.setText("N/A");
            } else {
                viewHolder.deliver_date.setText(new SimpleDateFormat("dd-MMM-yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(data.get(i).getDelivery_date())));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.item.setText("Item:" + itmsize);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, ViewDetails.class);
                in.putExtra("id", data.get(i).getId());
                in.putExtra("tag", tag);
                in.putExtra("factory", viewHolder.factoryname.getText());
                in.putExtra("status", viewHolder.status.getText());
                in.putExtra("date", viewHolder.date.getText());
                in.putExtra("deliver_date", viewHolder.deliver_date.getText());
                in.putExtra("staf", data.get(i).getStaff());
                in.putExtra("cc_mail", data.get(i).getCcEmail());
                in.putExtra("PREVNOTES", data.get(i).getNotes());
                in.putParcelableArrayListExtra("item", items);
                context.startActivity(in);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateList(ArrayList<poDatum> temp) {
        this.data = temp;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.item)
        TextView item;
        @BindView(R.id.factoryname)
        TextView factoryname;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.deliver_date)
        TextView deliver_date;
        @BindView(R.id.indc)
        CardView indc;
        @BindView(R.id.price_img)
        ImageView price_img;
        @BindView(R.id.go)
        ImageView go;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.poNumCM)
        TextView poNumCM;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
