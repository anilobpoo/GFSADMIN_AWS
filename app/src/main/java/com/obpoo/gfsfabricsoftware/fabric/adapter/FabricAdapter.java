package com.obpoo.gfsfabricsoftware.fabric.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsResponse;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsPresenterImpl;
import com.obpoo.gfsfabricsoftware.fabric.mvp.FabricsView;
import com.obpoo.gfsfabricsoftware.fabric.ui.EditFabric;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.CircleTransform;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import static com.obpoo.gfsfabricsoftware.utilities.Constants.NO_PIC;


public class FabricAdapter extends RecyclerView.Adapter<FabricAdapter.MyViewHolder> implements FabricsView{
    private Context context;
    private ArrayList<FabricsDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    FabricsPresenterImpl presenter;

    public void updateList(ArrayList<FabricsDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(FabricsResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            if (response.getMessage().toLowerCase().contains("deleted"))
            {
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        }else
            showError(response.getMessage());
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
        public TextView name,names,width,widths,comps,comp,article,articles,color,colors;
        public TextView cost_pr_mtr,cost_pr_yrd,sell_pr_mtr,sell_pr_yrd,min_stock_mtr,max_stock_mtr,min_stock_yrd,max_stock_yrd,desc;
        public TextView delete,edit;
        ImageView imageView1,imageView2;
        FoldingCell fc;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.fabname);
            names = view.findViewById(R.id.fabnames);
            width = view.findViewById(R.id.width);
            widths = view.findViewById(R.id.widths);
            comps = view.findViewById(R.id.comps);
            comp = view.findViewById(R.id.comp);
            article = view.findViewById(R.id.article);
            articles = view.findViewById(R.id.articles);
            color = view.findViewById(R.id.color);
            colors = view.findViewById(R.id.colors);
            imageView1 = view.findViewById(R.id.imageView1);
            imageView2 = view.findViewById(R.id.imageView2);

            cost_pr_mtr = view.findViewById(R.id.cost_pr_mtr);
            cost_pr_yrd = view.findViewById(R.id.cost_pr_yrd);
            sell_pr_mtr = view.findViewById(R.id.sell_pr_mtr);
            sell_pr_yrd = view.findViewById(R.id.sell_pr_yrd);
            min_stock_mtr = view.findViewById(R.id.min_stock_mtr);
            max_stock_mtr = view.findViewById(R.id.max_stock_mtr);
            min_stock_yrd = view.findViewById(R.id.min_stock_yrd);
            max_stock_yrd = view.findViewById(R.id.max_stock_yrd);
            delete = view.findViewById(R.id.delete);
            edit = view.findViewById(R.id.edit);
            fc = (FoldingCell) view.findViewById(R.id.folding_cell);


            desc = view.findViewById(R.id.desc);


        }
    }
    public FabricAdapter(Activity context, ArrayList<FabricsDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        presenter = new FabricsPresenterImpl(this);
    }

    @Override
    public FabricAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_fabric, parent, false);

        return new FabricAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FabricAdapter.MyViewHolder holder, final int position) {
        final FabricsDetail item = cartList.get(position);
        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fc.toggle(false);
            }
        });

        holder.name.setText(item.getFab_name());
        holder.names.setText(item.getFab_name());
        holder.color.setText(item.getColor_code());
        holder.colors.setText(item.getColor_code());
        holder.width.setText("Width: "+item.getWidth());
        holder.widths.setText("Width: "+item.getWidth());
        holder.article.setText(item.getArticleno());
        holder.articles.setText(item.getArticleno());
        holder.comp.setText(item.getComposition());
        holder.comps.setText(item.getComposition());
        holder.cost_pr_mtr.setText(item.getCost_pr_mtr());
        holder.cost_pr_yrd.setText(item.getCost_pr_yrd());
        holder.sell_pr_mtr.setText(item.getSell_pr_mtr());
        holder.sell_pr_yrd.setText(item.getSell_pr_yrd());
        holder.min_stock_mtr.setText(item.getMax_stock_mtr());
        holder.max_stock_mtr.setText(item.getMax_stock_mtr());
        holder.min_stock_yrd.setText(item.getMin_stock_yrd());
        holder.max_stock_yrd.setText(item.getMax_stock_yrd());
        String desc=item.getDescription();
        if (desc.equals("")||desc.isEmpty())
        {
            holder.desc.setText("No Description");

        }else
            holder.desc.setText(desc);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(item.getId(),position);
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, EditFabric.class);
                intent.putExtra("id",item.getId());
                intent.putExtra("name",item.getFab_name());
                intent.putExtra("image",item.getFab_img());
                intent.putExtra("color",item.getColor_code());
                intent.putExtra("colorId",item.getColors_id());
                intent.putExtra("article",item.getArticleno());
                intent.putExtra("articleId",item.getArticle_no_id());
                intent.putExtra("width",item.getWidth());
                intent.putExtra("cpm",item.getCost_pr_mtr());
                intent.putExtra("cpy",item.getCost_pr_yrd());
                intent.putExtra("spm",item.getSell_pr_mtr());
                intent.putExtra("spy",item.getSell_pr_yrd());
                intent.putExtra("mipm",item.getMin_stock_mtr());
                intent.putExtra("mipy",item.getMin_stock_yrd());
                intent.putExtra("mapy",item.getMax_stock_yrd());
                intent.putExtra("mapm",item.getMax_stock_mtr());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("mu",item.getMin_stock_user_mtr());
                intent.putExtra("my",item.getMin_stock_user_yrd());
                intent.putExtra("mfr",item.getPricefullrollmtrs());
                intent.putExtra("yfr",item.getPricefullroll());

             /*   intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());
                intent.putExtra("desc",item.getDescription());*/


                activity.startActivity(intent);
            }
        });
        String url = null;
        if (item.getFab_img().equals("images.png")||item.getFab_img().equals(""))
        {
            url=NO_PIC;
        }else
        {
            url="http://furnirworld.com/giovanifs/Uploads/Fabric/"+item.getFab_img();

        }


        Glide.with(activity).load(url)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(new CircleTransform(activity))
                .into(holder.imageView1);
        Glide.with(activity).load(url)
                .crossFade()
                .bitmapTransform(new CircleTransform(activity))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView2);





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

                        presenter.deletFabric("Delete_fabric",ids);
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


}

