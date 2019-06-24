package com.obpoo.gfsfabricsoftware.Report.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Report.DataModel.POLeftOver_Model.POLeftOverData;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/26/2019.
 */

public class POleftAdapter extends RecyclerView.Adapter<POleftAdapter.ViewHolder> {
    ArrayList<POLeftOverData> poLeftOverData;
    Activity context;

    public POleftAdapter(ArrayList<POLeftOverData> poLeftOverData, Activity context) {
        this.poLeftOverData = poLeftOverData;
        this.context = context;
    }

    @NonNull
    @Override
    public POleftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.poleftoveradp,viewGroup,false);
        POleftAdapter.ViewHolder poviewAdp = new POleftAdapter.ViewHolder(view);
        return poviewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull final  POleftAdapter.ViewHolder holder, int i) {
        holder.folding_cell_dsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.folding_cell_dsr.toggle(false);
            }
        });
        holder.invoice_po_left_above.setText("Invoice: "+poLeftOverData.get(i).getInvoiceNo());

        holder.invoice_po_left_below.setText("Invoice: "+poLeftOverData.get(i).getInvoiceNo());
        holder.date_po_left_above.setText(poLeftOverData.get(i).getCreated());
        holder.date_po_left_below.setText(poLeftOverData.get(i).getCreated());

        holder.order_po_left_below.setText("OrderNo: #"+poLeftOverData.get(i).getPoId());
        holder.bundle_po_left_below.setText("Bundle No: "+poLeftOverData.get(i).getBundleNo());
        holder.article_po_left_below.setText("Article: "+poLeftOverData.get(i).getArticleNo());
        holder.color_po_left_below.setText("Color Code: "+poLeftOverData.get(i).getColorCode());
        holder.baikon_po_left_above.setText(poLeftOverData.get(i).getBaikonNo());
        holder.baikon_po_left_below.setText("Baikon No: "+poLeftOverData.get(i).getBaikonNo());
        holder.cartons_po_left_above.setText(poLeftOverData.get(i).getNoOfCarton());
        holder.total_po_left_below.setText("THB "+poLeftOverData.get(i).getSumTotal());
        holder.paid_po_left_below.setText("THB "+poLeftOverData.get(i).getDeposit());
        holder.left_po_left_above.setText("THB "+poLeftOverData.get(i).getRemain());
        holder.left_po_left_below.setText("THB "+poLeftOverData.get(i).getRemain());
        holder.type_po_left_below.setText(poLeftOverData.get(i).getType());
        holder.term_po_left_below.setText(poLeftOverData.get(i).getTerm());
        holder.due_po_left_below.setText("Due Date: "+poLeftOverData.get(i).getDueDate());
        holder.delivery_po_left_above.setText(poLeftOverData.get(i).getDeliveryDate());
        holder.delivery_po_left_below.setText("Delivery Date: "+poLeftOverData.get(i).getDeliveryDate());
        holder.carton_po_left_below.setText("Cartons: "+poLeftOverData.get(i).getNoOfCarton());






    }

    @Override
    public int getItemCount() {
        return poLeftOverData.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.invoice_po_left_above)
        TextView invoice_po_left_above ;
        @BindView(R.id.date_po_left_above)
        TextView date_po_left_above;
        @BindView(R.id.left_po_left_above)
        TextView left_po_left_above ;
        @BindView(R.id.baikon_po_left_above)
        TextView baikon_po_left_above;
        @BindView(R.id.cartons_po_left_above)
        TextView cartons_po_left_above;
        @BindView(R.id.delivery_po_left_above)
        TextView delivery_po_left_above;

        @BindView(R.id.invoice_po_left_below)
        TextView invoice_po_left_below;
        @BindView(R.id.date_po_left_below)
        TextView date_po_left_below ;
        @BindView(R.id.order_po_left_below)
        TextView order_po_left_below;
        @BindView(R.id.article_po_left_below)
        TextView article_po_left_below;
        @BindView(R.id.baikon_po_left_below)
        TextView baikon_po_left_below;
        @BindView(R.id.carton_po_left_below)
        TextView carton_po_left_below;
        @BindView(R.id.bundle_po_left_below)
        TextView bundle_po_left_below;
        @BindView(R.id.color_po_left_below)
        TextView color_po_left_below;
        @BindView(R.id.total_po_left_below)
        TextView total_po_left_below;
        @BindView(R.id.paid_po_left_below)
        TextView paid_po_left_below;
        @BindView(R.id.left_po_left_below)
        TextView left_po_left_below ;
        @BindView(R.id.type_po_left_below)
        TextView type_po_left_below;
        @BindView(R.id.due_po_left_below)
        TextView due_po_left_below ;
        @BindView(R.id.delivery_po_left_below)
        TextView delivery_po_left_below;
        @BindView(R.id.term_po_left_below)
        TextView term_po_left_below;

        @BindView(R.id.folding_cell_dsr)
        FoldingCell folding_cell_dsr;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void updateList(ArrayList<POLeftOverData> list){
        poLeftOverData = list;
        notifyDataSetChanged();
    }
}
