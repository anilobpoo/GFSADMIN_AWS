package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.UI.Bill_Invoice_Report;
import com.obpoo.gfsfabricsoftware.Report.UI.CustomerPending;
import com.obpoo.gfsfabricsoftware.Report.UI.CutStock;
import com.obpoo.gfsfabricsoftware.Report.UI.FabricOrderHistory;
import com.obpoo.gfsfabricsoftware.Report.UI.PoDeliveryDetails;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/19/2019.
 */

public class ReportMenuAdp extends RecyclerView.Adapter<ReportMenuAdp.ViewHolder> {

    ArrayList<String> reportMenus;
    Activity context;
    int[] report_icon;

    public ReportMenuAdp(ArrayList<String> reportMenus, Activity context,int[] report_icon) {
        this.reportMenus = reportMenus;
        this.context = context;
        this.report_icon=report_icon;
    }

    @NonNull
    @Override
    public ReportMenuAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.reportmenu_lay,parent,false);
        ReportMenuAdp.ViewHolder reportViewAdp = new ReportMenuAdp.ViewHolder(view);
        return reportViewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull final ReportMenuAdp.ViewHolder holder, final int i) {
        holder.menu_text.setText(reportMenus.get(i));
        holder.menu_text.setCompoundDrawablesWithIntrinsicBounds(report_icon[i],0, R.drawable.ic_right_arrow,0);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getMenutext = holder.menu_text.getText().toString();

                switch(i){
                    case 0:
                        Intent inBill = new Intent(context,Bill_Invoice_Report.class);
                        inBill.putExtra("ReportName", AppConstants.billReport);
                        context.startActivity(inBill);
                        break;
                    case 1:
                        context.startActivity(new Intent(context,CustomerPending.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context,CutStock.class));
                        break;
                    case 3:
                        Intent inSales = new Intent(context,Bill_Invoice_Report.class);
                        inSales.putExtra("ReportName", AppConstants.salesReport);
                        context.startActivity(inSales);
                        break;
                    case 4:
                        Intent inFA = new Intent(context,Bill_Invoice_Report.class);
                        inFA.putExtra("ReportName", AppConstants.fabricAnaluytics);
                        context.startActivity(inFA);
                        break;
                    case 5:
                        context.startActivity(new Intent(context,FabricOrderHistory.class));
                        break;
                    case 6:
                        Intent inob = new Intent(context,Bill_Invoice_Report.class);
                        inob.putExtra("ReportName", AppConstants.openBill);
                        context.startActivity(inob);
                        break;
                    case 7:
                        Intent inPR = new Intent(context,Bill_Invoice_Report.class);
                        inPR.putExtra("ReportName", AppConstants.paymentReceived);
                        context.startActivity(inPR);
                        break;
                    case 8:
                        context.startActivity(new Intent(context,PoDeliveryDetails.class));
                        break;
                    case 9:
                        Intent inpfl = new Intent(context,Bill_Invoice_Report.class);
                        inpfl.putExtra("ReportName", AppConstants.po_fabric_list_const);
                        context.startActivity(inpfl);
                        break;
                    case 10:
                        Intent inplf = new Intent(context,Bill_Invoice_Report.class);
                        inplf.putExtra("ReportName", AppConstants.po_left_overs);
                        context.startActivity(inplf);
                        break;
                    case 11:
                        Intent inpoCIN = new Intent(context,Bill_Invoice_Report.class);
                        inpoCIN.putExtra("ReportName", AppConstants.po_check_in);
                        context.startActivity(inpoCIN);
                        break;
                    case 12:
                        Intent inpoCout = new Intent(context,Bill_Invoice_Report.class);
                        inpoCout.putExtra("ReportName", AppConstants.pocheckOut);
                        context.startActivity(inpoCout);
                        break;

                    case 13:
                        Intent insf = new Intent(context,Bill_Invoice_Report.class);
                        insf.putExtra("ReportName", AppConstants.soldfabrics);
                        context.startActivity(insf);
                        break;


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return reportMenus.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.menu_text)
        TextView menu_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
