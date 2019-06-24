package com.obpoo.gfsfabricsoftware.shelfassignment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.FabricItem;
import com.obpoo.gfsfabricsoftware.utilities.CustomProgress;

import java.util.List;


public class BundleAdapter extends RecyclerView.Adapter<BundleAdapter.MyViewHolder>{
    private Context context;
    private List<FabricItem> cartList;
    Activity activity;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView unique_id,article_no,meters,yards,colors,pcsno,bkno,ctno,po,noofcarton;
        CustomProgress customProgress;

        public MyViewHolder(View view) {
            super(view);
            unique_id = view.findViewById(R.id.unique_id);
            article_no = view.findViewById(R.id.article_no);
            meters = view.findViewById(R.id.meters);
            yards = view.findViewById(R.id.yards);
            pcsno = view.findViewById(R.id.pcsno);
            colors = view.findViewById(R.id.colors);
            ctno = view.findViewById(R.id.ctno);
            bkno = view.findViewById(R.id.bkno);
            po = view.findViewById(R.id.po);
            noofcarton = view.findViewById(R.id.noofcarton);

        }
    }
    public BundleAdapter(Activity context, List<FabricItem> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;


    }

    @Override
    public BundleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bundle, parent, false);

        return new BundleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BundleAdapter.MyViewHolder holder, final int position) {
        final FabricItem item = cartList.get(position);


        String name = item.getArticleno().toUpperCase();
        holder.article_no.setText(name);
        holder.unique_id.setText(item.getUnique_id().toUpperCase());
        holder.meters.setText("MTRS# "+item.getMeters());
        holder.yards.setText("YARD# "+item.getYard());
        holder.colors.setText("COL# "+item.getColor());
        holder.pcsno.setText("Pcsno#"+item.getPcsno());
        holder.bkno.setText("BK# "+item.getBkno());
        holder.ctno.setText("CT/NO- ");
        holder.po.setText("PONO# "+item.getPono());
        holder.noofcarton.setText("# OF CARTON-"+item.getCartonnumber());

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


}

