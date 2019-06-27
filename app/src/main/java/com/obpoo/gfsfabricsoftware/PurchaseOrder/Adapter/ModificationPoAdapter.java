package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.AddPoPojo;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel.ModifyNotes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPOByCusRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel.TrackPODetRes;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.ConfirmPOResponse;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poItem;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel.poPOJO;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poPresenterImpl;
import com.obpoo.gfsfabricsoftware.PurchaseOrder.MVP.poView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModificationPoAdapter extends RecyclerView.Adapter<ModificationPoAdapter.ViewHolder> implements poView {
    Context context;
    ArrayList<poItem> items;
    poPresenterImpl presenter;
    int position;

    public ModificationPoAdapter(Context context, ArrayList<poItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.modifcatiopoadapter, viewGroup, false);
        ModificationPoAdapter.ViewHolder rootview = new ModificationPoAdapter.ViewHolder(view);
        presenter = new poPresenterImpl(this);

        return rootview;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        viewHolder.art_no.setText(items.get(i).getArtNo() + items.get(i).getColorCodeId());
        viewHolder.brand.setText("Brand:" + items.get(i).getBrandName());
        viewHolder.shiping_id.setText("ShipingID:" + items.get(i).getCostPrice());
        viewHolder.qnty_et.setText(items.get(i).getQuantity());
        viewHolder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = i;
                presenter.OnConfirmPO("edit_item", items.get(i).getId(), viewHolder.qnty_et.getText().toString(), "1");
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onShowViewPO(poPOJO response) {

    }

    @Override
    public void onShowAddPO(AddPoPojo response) {

    }

    @Override
    public void onConfirmPO(ConfirmPOResponse response) {
        if (response.getStatus().equals("success")) {
            items.remove(position);
            notifyDataSetChanged();
        }

    }

    @Override
    public void onValidationfail(int type) {

    }

    @Override
    public void onTrackPObyCustomer(TrackPOByCusRes response) {

    }

    @Override
    public void onTrackPOdetails(TrackPODetRes response) {

    }

    @Override
    public void onModifyNotes(ModifyNotes response) {

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

        @BindView(R.id.art_no)
        TextView art_no;
        @BindView(R.id.brand)
        TextView brand;
        @BindView(R.id.shiping_id)
        TextView shiping_id;
        @BindView(R.id.qnty_et)
        EditText qnty_et;
        @BindView(R.id.imageView10)
        ImageView delete;
        @BindView(R.id.update)
        ImageView update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
