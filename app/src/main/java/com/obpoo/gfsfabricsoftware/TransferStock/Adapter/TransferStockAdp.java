package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TS_MoveInOut_scan;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TransferStockIn;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocDataDetails;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_data;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/28/2019.
 */

public class TransferStockAdp extends RecyclerView.Adapter<TransferStockAdp.ViewHolder> implements TsView {
    ArrayList<Ts_data> ts_dataArrayList;
    Activity context;
    String getSelectedTransferMEnu;
    ProgressBar progressBar;
    ImageView tranparent_bg;
    TsPresenterImpl presenter;
    String note, docid;

    public TransferStockAdp(ArrayList<Ts_data> ts_dataArrayList, Activity context, String getSelectedTransferMEnu, ProgressBar progress_bar, ImageView tranparent_bg) {
        this.ts_dataArrayList = ts_dataArrayList;
        this.context = context;
        this.getSelectedTransferMEnu = getSelectedTransferMEnu;
        this.progressBar = progress_bar;
        this.tranparent_bg = tranparent_bg;
    }

    @NonNull
    @Override
    public TransferStockAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.reportmenu_lay, viewGroup, false);
        TransferStockAdp.ViewHolder tsViewAdp = new TransferStockAdp.ViewHolder(view);
        presenter = new TsPresenterImpl(this);
        return tsViewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull TransferStockAdp.ViewHolder holder, final int i) {
        holder.menu_text.setText(ts_dataArrayList.get(i).getDocument());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSelectedTransferMEnu.equals(AppConstants.tran_stock)) {
                    note = ts_dataArrayList.get(i).getNote();
                    docid = ts_dataArrayList.get(i).getDocument();
                    presenter.onViewSelectDoc("view_all_by_doc_id", ts_dataArrayList.get(i).getId());
                }
                if (getSelectedTransferMEnu.equals(AppConstants.tran_stockIn)) {
                    Intent in = new Intent(context, TransferStockIn.class);
                    in.putExtra("tsFabricArray", ts_dataArrayList);
                    in.putExtra("index_ts_fabric", i);
                    context.startActivity(in);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return ts_dataArrayList.size();
    }

    @Override
    public void onGetPendingOrderIdResponse(PendingOrderRes response) {

    }

    @Override
    public void onGetFabricPendingRes(FabricPendingOIDRes response) {

    }

    @Override
    public void onTranferFabric(TransferResponse response) {

    }

    @Override
    public void onTransferWare(TransferWareWareRes response) {

    }

    @Override
    public void onPassWare(TransferResponse response) {

    }

    @Override
    public void onTransfer(Ts_Response response) {

    }

    @Override
    public void onTransferStockOut(TransferResponse response) {

    }

    @Override
    public void onStockDocView(StockDocumentResponse response) {

    }

    @Override
    public void onSelectDocView(DocumentData response) {
        ArrayList<DocDataDetails> docDataDetails;
        docDataDetails = response.getData();
        Intent in = new Intent(context, TS_MoveInOut_scan.class);
        in.putExtra("note", note);
        in.putExtra("doc", docid);
        in.putParcelableArrayListExtra("documentdata", docDataDetails);
        context.startActivity(in);
        progressBar.setVisibility(View.GONE);
        tranparent_bg.setVisibility(View.GONE);
    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
        tranparent_bg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.menu_text)
        TextView menu_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
