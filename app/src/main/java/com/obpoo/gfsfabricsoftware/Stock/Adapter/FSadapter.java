package com.obpoo.gfsfabricsoftware.Stock.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.AddReserveCheckModel;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabSearchResDet;
import com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel.FabricSearchStock;
import com.obpoo.gfsfabricsoftware.utilities.AppConstants;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 2/5/2019.
 */

public class FSadapter extends RecyclerView.Adapter<FSadapter.ViewHolder> {
    ArrayList<FabSearchResDet> fabSearchResDetArrayList;
    ArrayList<FabricSearchStock> get_fabricSearchStockArrayList;
   public static ArrayList<AddReserveCheckModel> addReserveCheckModelArrayList = new ArrayList<>();
    Activity context;
    String identity;

    public FSadapter(ArrayList<FabSearchResDet> fabSearchResDetArrayList, Activity context,String identity) {
        this.fabSearchResDetArrayList = fabSearchResDetArrayList;
        this.context = context;
        get_fabricSearchStockArrayList = fabSearchResDetArrayList.get(0).getStock();
        this.identity=identity;


    }

    @NonNull
    @Override
    public FSadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewstock_fabricsearch, parent, false);
        FSadapter.ViewHolder delViewHolder = new FSadapter.ViewHolder(view);
        return delViewHolder;
    }

    @Override
    public void onBindViewHolder(final FSadapter.ViewHolder holder, final int i) {

        double remain_dob = Double.parseDouble(get_fabricSearchStockArrayList.get(i).getRemain());

        if(identity.equals(AppConstants.AddReserveFabricCheck)){
            holder.fabric_fs.setVisibility(View.GONE);
            holder.stock_check.setVisibility(View.VISIBLE);

            if(remain_dob<0){
                Log.i("remainDOB",remain_dob+"");
                get_fabricSearchStockArrayList.remove(i);
            }

        }
        if(identity.equals(AppConstants.ViewStockWZS)){
            holder.fabric_fs.setVisibility(View.VISIBLE);
            holder.fabric_fs.setText("Fabric: " + fabSearchResDetArrayList.get(0).getFabName());
            holder.stock_check.setVisibility(View.GONE);
        }



        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fc.toggle(false);
            }
        });
        holder.packetnum_fs.setText("Packet: " + get_fabricSearchStockArrayList.get(i).getUniqueCode());
        holder.packetnum_fold.setText("Packet: " + get_fabricSearchStockArrayList.get(i).getUniqueCode());


        holder.fabric_fold.setText("Fabric: " + fabSearchResDetArrayList.get(0).getFabName());
        holder.remain.setText("Remain: " + get_fabricSearchStockArrayList.get(i).getRemain());
        holder.remain_fold.setText("Remain: " + get_fabricSearchStockArrayList.get(i).getRemain());
        holder.reserve.setText("Reserve: " + get_fabricSearchStockArrayList.get(i).getReserve());
        holder.reserve_fold.setText("Reserve: " + get_fabricSearchStockArrayList.get(0).getReserve());
        holder.total_fs.setText("Total: " + get_fabricSearchStockArrayList.get(i).getTotal());
        holder.total_fold.setText("Total: " + get_fabricSearchStockArrayList.get(i).getTotal());


        holder.no_fs.setText("No: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getShopNo());
        holder.name_fs.setText("Name: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getShopname());
        holder.name_ws_fs.setText("Name: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getWarehouseName());
        holder.no_ws_fs.setText("No: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getWarehouseNo());
        holder.zone_name_fs.setText("Name: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getZoneId());
        holder.zone_no_fs.setText("No: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getZoneId());
        holder.shelve_name_fs.setText("No: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getUnqScanCode());
        holder.shelve_no_fs.setText("No: " + get_fabricSearchStockArrayList.get(i).getLocation().get(0).getShelveName());

        if ((Double.parseDouble(get_fabricSearchStockArrayList.get(i).getRemain()) < 0)) {
            int getProgress = 0;
            holder.progress_fold.setProgress(getProgress);
            holder.progress_fs.setProgress(getProgress);
        }
        else{
            float getProgress = (Float.parseFloat(get_fabricSearchStockArrayList.get(i).getRemain()) / Float.parseFloat(get_fabricSearchStockArrayList.get(i).getTotal())) * 100;
            holder.progress_fold.setProgress((int)getProgress);
            holder.progress_fs.setProgress((int)getProgress);
        }

        holder.stock_check.setTag(i);
        holder.stock_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)holder.stock_check.getTag();
                if(holder.stock_check.isSelected()){
                    holder.stock_check.setSelected(false);
                    int showIndex = getIndex(String.valueOf(pos));
                    addReserveCheckModelArrayList.remove(showIndex);

                }
                else{
                    holder.stock_check.setSelected(true);
                    addReserveCheckModelArrayList.add(new AddReserveCheckModel(
                            get_fabricSearchStockArrayList.get(i).getUniqueCode(),get_fabricSearchStockArrayList.get(i).getRemain()));


                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return get_fabricSearchStockArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.folding_cell_fs)
        FoldingCell fc;
        @BindView(R.id.packetnum_fs)
        TextView packetnum_fs;
        @BindView(R.id.artno_fs)
        TextView artno;
        @BindView(R.id.colorcode_fs)
        TextView colorcode;
        @BindView(R.id.remain_fs)
        TextView remain;
        @BindView(R.id.reserve_fs)
        TextView reserve;
        @BindView(R.id.total_fs)
        TextView total_fs;


        @BindView(R.id.packetnum_fold)
        TextView packetnum_fold;
        @BindView(R.id.artno_fold)
        TextView artno_fold;
        @BindView(R.id.colorcode_fold)
        TextView colorcode_fold;
        @BindView(R.id.remain_fold)
        TextView remain_fold;
        @BindView(R.id.reserve_fold)
        TextView reserve_fold;
        @BindView(R.id.total_fold)
        TextView total_fold;
        @BindView(R.id.progress_fold)
        ProgressBar progress_fold;
        @BindView(R.id.progress_fs)
        ProgressBar progress_fs;

        @BindView(R.id.shop)
        TextView shop;
        @BindView(R.id.name_fs)
        TextView name_fs;
        @BindView(R.id.no_fs)
        TextView no_fs;
        @BindView(R.id.warehouse_fs)
        TextView warehouse_fs;
        @BindView(R.id.name_ws_fs)
        TextView name_ws_fs;
        @BindView(R.id.no_ws_fs)
        TextView no_ws_fs;
        @BindView(R.id.zone_fs)
        TextView zone_fs;
        @BindView(R.id.zone_name_fs)
        TextView zone_name_fs;
        @BindView(R.id.zone_no_fs)
        TextView zone_no_fs;
        @BindView(R.id.shelve_fs)
        TextView shelve_fs;
        @BindView(R.id.shelve_no_fs)
        TextView shelve_no_fs;
        @BindView(R.id.shelve_name_fs)
        TextView shelve_name_fs;

        @BindView(R.id.fabric_fold)
        TextView fabric_fold;
        @BindView(R.id.fabric_fs)
        TextView fabric_fs;


        @BindView(R.id.stock_check)
        CheckBox stock_check;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public int getIndex(String itemName) {
        for (int i = 0; i < addReserveCheckModelArrayList.size(); i++) {
            AddReserveCheckModel auction = addReserveCheckModelArrayList.get(i);
            if (itemName.equals(String.valueOf(auction.getUniqueCode()))) {
                return i;
            }
        }

        return -1;
    }
}
