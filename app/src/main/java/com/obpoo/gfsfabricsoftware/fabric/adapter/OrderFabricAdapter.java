package com.obpoo.gfsfabricsoftware.fabric.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.cart.datamodels.CartResponse;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartPresenterImpl;
import com.obpoo.gfsfabricsoftware.cart.mvp.CartView;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.IMethodCaller;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.ramotion.foldingcell.FoldingCell;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.obpoo.gfsfabricsoftware.utilities.Constants.NO_PIC;


public class OrderFabricAdapter extends RecyclerView.Adapter<OrderFabricAdapter.MyViewHolder> implements CartView {
    private Context context;
    private ArrayList<FabricsDetail> cartList;
    Activity activity;
    private NetworkDetection networkDetection;
    private Dialog progressDialog;
    CartPresenterImpl presenter;
    String orderid,discount;
    public static final String FSPIC = "http://furnirworld.com/giovanifs/Uploads/Fabric/";


    public void updateList(ArrayList<FabricsDetail> list){
        cartList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(CartResponse response) {
        if (response.getStatus().equals(AppConstants.SUCCESS)) {
            hideDialog();
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
            if(activity instanceof IMethodCaller){
                ((IMethodCaller)activity).yourDesiredMethod("added");
            }

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
        public TextView name,names,width,widths,comps,comp,article,articles,color,colors;
        public TextView cost_pr_mtr,cost_pr_yrd,sell_pr_mtr,sell_pr_yrd,min_stock_mtr,max_stock_mtr,min_stock_yrd,max_stock_yrd,desc;
        public TextView select;
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
            desc = view.findViewById(R.id.desc);
            select = view.findViewById(R.id.select);
            fc = (FoldingCell) view.findViewById(R.id.folding_cell);
        }
    }


    public OrderFabricAdapter(Activity context, ArrayList<FabricsDetail> cartList, String orderid,String discount) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        this.orderid = orderid;
        this.discount = discount;
        networkDetection = new NetworkDetection();
        presenter = new CartPresenterImpl(this);
    }

    @Override
    public OrderFabricAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_order_fabrics, parent, false);

        return new OrderFabricAdapter.MyViewHolder(itemView);
    }


    public void checkAlert(final String item_id, final String actual_price, final String discount_for_user)
    {
        LayoutInflater li = LayoutInflater.from(activity);
        View promptsView = li.inflate(R.layout.alert, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setView(promptsView);
        //alertDialogBuilder.setTitle("Add Item");
        final EditText userInput = (EditText) promptsView.findViewById(R.id.edittTextDialogUserInput);
        userInput.setHint("Quantity");
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String number=userInput.getText().toString();

                                if (number.isEmpty())
                                {
                                    Toast.makeText(activity, "Add Quantity", Toast.LENGTH_SHORT).show();
                                }else
                                {
                                    double q=Double.parseDouble(number);
                                    double actual=q*Double.parseDouble(actual_price);

                                    double price=Double.parseDouble(actual_price);
                                    double disc=price*(Double.parseDouble(discount)/100);
                                    String subtotal=((Double.toString((price-disc)*q)));

                                    presenter.add("add_item",orderid,item_id,number,""+actual,discount_for_user,""+subtotal,"","");
                                }



                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }






    @Override
    public void onBindViewHolder(final OrderFabricAdapter.MyViewHolder holder, final int position) {
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
        holder.cost_pr_yrd.setText(""+new DecimalFormat("#.##").format(Double.parseDouble(item.getCost_pr_yrd())));
        holder.sell_pr_mtr.setText(item.getSell_pr_mtr());
        holder.sell_pr_yrd.setText(""+new DecimalFormat("#.##").format(Double.parseDouble(item.getSell_pr_yrd())));
        holder.min_stock_mtr.setText(item.getMax_stock_mtr());
        holder.max_stock_mtr.setText(item.getMax_stock_mtr());
        holder.min_stock_yrd.setText(""+new DecimalFormat("#.##").format(Double.parseDouble(item.getMin_stock_yrd())));
        holder.max_stock_yrd.setText(""+new DecimalFormat("#.##").format(Double.parseDouble(item.getCost_pr_yrd())));
        String desc=item.getDescription();
        if (desc.equals("")||desc.isEmpty())
        {
            holder.desc.setText("No Description");

        }else
            holder.desc.setText(desc);



        String url = null;
        if (item.getFab_img().equals("images.png")||item.getFab_img().equals(""))
        {
            url=NO_PIC;
        }else
        {
            url=FSPIC+item.getFab_img();

        }

        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=item.getId();
                String price=item.getSell_pr_mtr();
                checkAlert(id,price,discount);

                //    public void checkAlert(final String item_id, final String actual_price, final String discount_for_user, final String subtotal)
            }
        });

        Glide.with(activity).load(url)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView1);
        Glide.with(activity).load(url)
                .crossFade()
                //.bitmapTransform(new CircleTransform(activity))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView2);
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


}

