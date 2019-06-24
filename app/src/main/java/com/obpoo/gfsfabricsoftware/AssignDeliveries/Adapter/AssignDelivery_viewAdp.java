package com.obpoo.gfsfabricsoftware.AssignDeliveries.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.AssignPgResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryData;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.DeliveryResponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponse;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponseList;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.MVP.AssignDeliveryView;
import com.obpoo.gfsfabricsoftware.AssignDeliveries.UI.DialogActivity_assign;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by PHD on 1/3/2019.
 */

public class AssignDelivery_viewAdp extends RecyclerView.Adapter<AssignDelivery_viewAdp.ViewHolder> implements AssignDeliveryView {
    Activity context;
    ArrayList<DeliveryResponse> deliveryResponses = new ArrayList<>();
    ArrayList<PGresponseList> pGresponseLists = new ArrayList<>();

    public void updateList(ArrayList<DeliveryResponse> list){
        deliveryResponses = list;
        notifyDataSetChanged();
    }

    public AssignDelivery_viewAdp(Activity context, ArrayList<DeliveryResponse> deliveryResponses,ArrayList<PGresponseList> pGresponseLists) {
        this.context = context;
        this.deliveryResponses = deliveryResponses;
        this.pGresponseLists = pGresponseLists;
    }

    @NonNull
    @Override
    public AssignDelivery_viewAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.delivery_assign, parent, false);
        AssignDelivery_viewAdp.ViewHolder delViewHolder = new AssignDelivery_viewAdp.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AssignDelivery_viewAdp.ViewHolder holder, int i) {
        holder.name_ad.setText(deliveryResponses.get(i).getCustomerDetails().getData().get(0).getCustomerName());
        if(deliveryResponses.get(i).getPacketDetails().getStatus().equals("true")) {
            holder.item_ad.setText(String.valueOf(deliveryResponses.get(i).getPacketDetails().getData().get(0).getPacketItems().size()));
        } holder.payDone_ad.setText(deliveryResponses.get(i).getOrderTotal());
        holder.payto_ad.setText(deliveryResponses.get(i).getLeftover());
        holder.date_time_ad.setText(deliveryResponses.get(i).getOrderdate());
        holder.order_ad.setText("#"+deliveryResponses.get(i).getId());

    }

    @Override
    public int getItemCount() {
        return deliveryResponses.size();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onShowViewDeliveries(DeliveryData response) {

    }

    @Override
    public void onShowAllPGList(PGresponse response) {

    }

    @Override
    public void onShowAssignPg(AssignPgResponse response) {

    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.name_ad)
        TextView name_ad;
        @BindView(R.id.item_ad)
        TextView item_ad;
        @BindView(R.id.payDone_ad)
        TextView payDone_ad;
        @BindView(R.id.payto_ad)
        TextView payto_ad;
        @BindView(R.id.date_time_ad)
        TextView date_time_ad;
        @BindView(R.id.date_time)
        TextView date_time;
        @BindView(R.id.order_ad)
        TextView order_ad;
        @BindView(R.id.pg_assign)
        TextView pg_assign;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @OnClick(R.id.pg_assign)
        public void OnPgassign(){
           // Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show();
            //showPgList(context);
            Log.i("check_list_1",pGresponseLists.get(0).getName());
            Intent in = new Intent(context, DialogActivity_assign.class);
            in.putExtra("ORDERID",deliveryResponses.get(0).getId());
            in.putExtra("PGRESPONSELIST",pGresponseLists);
            context.startActivity(in);

        }
    }

    private PopupWindow showPgList(Activity context) {
        try{
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.from(context).inflate(R.layout.pgassign_dialog,null);
            final PopupWindow optionspu = new PopupWindow(layout, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            optionspu.setFocusable(true);
            optionspu.showAtLocation(layout, Gravity.CENTER, 0, 0);
            Spinner pgList =(Spinner)layout.findViewById(R.id.pg_select);
            Button assign =(Button)layout.findViewById(R.id.assign);
            Button cancel=(Button)layout.findViewById(R.id.cancel);


            SpinnerPgAdp adapter = new SpinnerPgAdp(pGresponseLists,context);
            pgList.setAdapter(adapter);

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    optionspu.dismiss();
                }
            });
            return optionspu;
        }
        catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            Log.i(e.getMessage(),"dialogerror");
            return null;
        }
    }

    }

