package com.obpoo.gfsfabricsoftware.shelfassignment.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.PacketDetails;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInDetail;
import com.obpoo.gfsfabricsoftware.shelfassignment.datamodels.StockInResponse;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInPresenterImpl;
import com.obpoo.gfsfabricsoftware.shelfassignment.mvp.StockInView;
import com.obpoo.gfsfabricsoftware.ui.activities.StockActivityMain;
import com.obpoo.gfsfabricsoftware.utilities.CustomProgress;
import com.obpoo.gfsfabricsoftware.utilities.DialogUtils;
import com.obpoo.gfsfabricsoftware.utilities.NetworkDetection;
import com.obpoo.gfsfabricsoftware.utilities.PreferenceConnector;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class StockInAdapter extends RecyclerView.Adapter<StockInAdapter.MyViewHolder> implements StockInView{
    private Context context;
    private List<StockInDetail> cartList;
    private ArrayList<PacketDetails> packetDetails;
    Activity activity;
    private NetworkDetection networkDetection;
    String admin_id;
    List<String> uniqueCodes=new ArrayList<>();
    private Dialog progressDialog;
    StockInPresenterImpl stockInPresenter;

    @Override
    public void onValidationFail(int type) {

    }

    @Override
    public void onLoad(StockInResponse response) {

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
        public CustomProgress customProgress;
        public TextView unique_id,article_no,meters,yards,colors,pcsno,bkno,ctno,po,noofcarton;
        CheckBox checkBox;

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
            customProgress = view.findViewById(R.id.customProgressShowProgress);
            checkBox = view.findViewById(R.id.checkBox);

        }
    }
    public StockInAdapter(Activity context, List<StockInDetail> cartList) {
        this.context = context;
        this.cartList = cartList;
        this.activity = context;
        networkDetection = new NetworkDetection();
        admin_id=  PreferenceConnector.readString(activity, activity.getString(R.string.admin_id),"");
        stockInPresenter=new StockInPresenterImpl(this);

    }

    @Override
    public StockInAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stockin, parent, false);

        return new StockInAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StockInAdapter.MyViewHolder holder, final int position) {

        try
        {
            final StockInDetail item = cartList.get(position);
            packetDetails=item.getPacket_details();
            PacketDetails details=packetDetails.get(0);
            Resources res = activity.getResources();
            double minValue=0;
            double currentValue=Double.parseDouble(item.getRemain());
            double maxValue=Double.parseDouble(item.getTotal());
            double percentage = ((currentValue - minValue) / (maxValue - minValue));
            int value=(int) ((currentValue - minValue) / (maxValue - minValue)*100);
            float f = (float)percentage;
            holder.customProgress.setMaximumPercentage(f);
            holder.customProgress.setPercentage(value);
            holder.customProgress.useRoundedRectangleShape(30.0f);
            double yards=Double.parseDouble(details.getNet_meters())*1.09361;

            if (value<25)
            {
                holder.customProgress.setProgressColor(res.getColor(R.color.red_500));
                holder.customProgress.setProgressBackgroundColor(res.getColor(R.color.red_200));
            }else {
                holder.customProgress.setProgressColor(res.getColor(R.color.green_500));
                holder.customProgress.setProgressBackgroundColor(res.getColor(R.color.green_200));
            }

            holder.customProgress.setShowingPercentage(true);

            holder.article_no.setText(details.getArticle_no());
            holder.unique_id.setText(details.getUnique_id().toUpperCase());
            holder.meters.setText("MTRS# "+details.getNet_meters());
            holder.yards.setText(""+new DecimalFormat("#.##").format(yards));
            holder.colors.setText("COL# "+details.getColor_code());
            holder.pcsno.setText("Pcsno#-");
            holder.bkno.setText("BK# "+details.getBaikon_no());
            holder.ctno.setText("CT/NO- ");
            holder.po.setText("PONO# "+details.getPo_id());
            holder.noofcarton.setText("# OF CARTON-"+details.getNo_of_carton());


        }catch (Exception e)
        {
            e.printStackTrace();
            activity.startActivity(new Intent(activity, StockActivityMain.class));


        }

       /* holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String id=item.getUnique_code();

                if (b)
                {
                    uniqueCodes.add(id);
                    if(activity instanceof IMethodCallers){
                        ((IMethodCallers)activity).yourDesiredMethod(uniqueCodes);
                    }
                }else
                {
                    int s=check(id);
                    uniqueCodes.remove(s);
                }

            }
        });*/


    }


    public int check(String id) {
        int j=0;
        for (int i=0; i < uniqueCodes.size(); i++) {
            try {
                if (id.equals(uniqueCodes.get(i))) {
                    j=i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;

    }

    @Override
    public int getItemCount() {
        try{
            return cartList.size();
        }catch (Exception e){
          activity.startActivity(new Intent(activity, StockActivityMain.class));
          return 1;
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


}

