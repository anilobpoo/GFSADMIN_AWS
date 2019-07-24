package com.obpoo.gfsfabricsoftware.TransferStock.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.TransferStockMoveINOUT;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.Ts_Mainactivity;
import com.obpoo.gfsfabricsoftware.TransferStock.Activity.WareHouseToWareHouse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID.FabricPendingOIDRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.PendingOrderRes;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.StockDocumentResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferResponse;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.DocumentData;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock.Ts_Response;
import com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferWareWareRes;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsPresenterImpl;
import com.obpoo.gfsfabricsoftware.TransferStock.MVP.TsView;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 3/1/2019.
 */

public class TsMenuAdp extends RecyclerView.Adapter<TsMenuAdp.ViewHolder> implements TsView {
    ArrayList<String> main_transfer_spin;
    Activity context;
    TsPresenterImpl presenter;

    public TsMenuAdp(ArrayList<String> main_transfer_spin, Activity context) {
        this.main_transfer_spin = main_transfer_spin;
        this.context = context;
        presenter = new TsPresenterImpl(this);

    }

    @NonNull
    @Override
    public TsMenuAdp.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.reportmenu_lay, viewGroup, false);
        TsMenuAdp.ViewHolder tsViewAdp = new TsMenuAdp.ViewHolder(view);
        return tsViewAdp;
    }

    @Override
    public void onBindViewHolder(@NonNull TsMenuAdp.ViewHolder holder, final int i) {
        holder.menu_text.setText(main_transfer_spin.get(i));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 0:
                        Intent inout = new Intent(context, TransferStockMoveINOUT.class);
                        inout.putExtra("getSelectedTransferVal", AppConstants.tran_stock);
                        context.startActivity(inout);
                        break;
                    case 1:
                        Intent inin = new Intent(context, TransferStockMoveINOUT.class);
                        inin.putExtra("getSelectedTransferVal", AppConstants.tran_stockIn);
                        context.startActivity(inin);
                        break;
                    case 2:
                        Intent in1 = new Intent(context, Ts_Mainactivity.class);
                        in1.putExtra("getSelectedTransferVal", main_transfer_spin.get(i));
                        context.startActivity(in1);
                        break;
                    case 3:
                        Intent in2 = new Intent(context, Ts_Mainactivity.class);
                        in2.putExtra("getSelectedTransferVal", main_transfer_spin.get(i));
                        context.startActivity(in2);
                        break;
                    case 4:
                        Intent in3 = new Intent(context, Ts_Mainactivity.class);
                        in3.putExtra("getSelectedTransferVal", main_transfer_spin.get(i));
                        context.startActivity(in3);
                        break;
                    case 5:
                     presenter.onViewStockDoc("stock_documents");
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return main_transfer_spin.size();
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
        if (response.getStatus().equals("success")) {
            ArrayList<StockDocData> data = new ArrayList<>();
            data = response.getData();
            Intent in = new Intent(context, WareHouseToWareHouse.class);
            in.putParcelableArrayListExtra("data", data);
            context.startActivity(in);
        }
    }

    @Override
    public void onSelectDocView(DocumentData response) {

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

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.menu_text)
        TextView menu_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
