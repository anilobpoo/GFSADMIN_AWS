package com.obpoo.gfsfabricsoftware.Article.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.fabricTypePOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.deleteArticle.deletearticelPOJO;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.stockPOJO;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockPresenterImpl;
import com.obpoo.gfsfabricsoftware.Article.MVP.stock.StockView;
import com.obpoo.gfsfabricsoftware.Article.UI.ArticleEdit;
import com.obpoo.gfsfabricsoftware.Article.UI.Stock;
import com.obpoo.gfsfabricsoftware.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by obpoo on 11/14/2018.
 */

public class stockAdapter extends RecyclerView.Adapter<stockAdapter.StockViewHolder> implements StockView {
    Context context;
    ArrayList<StockDataResponse> userListResponseData;
    StockPresenterImpl presenter;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();


    public void updateList(ArrayList<StockDataResponse> list){
         userListResponseData = list;
        notifyDataSetChanged();
    }
    public stockAdapter(Context context, ArrayList<StockDataResponse> userListResponseData) {
        this.userListResponseData = userListResponseData;
        this.context = context;
        presenter = new StockPresenterImpl(this);

    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.stock_list_folding, parent, false);
        StockViewHolder usersViewHolder = new StockViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(final StockViewHolder holder, final int position) {


        // set the data
        holder.article_no.setText(userListResponseData.get(position).getArticleno());
        holder.fabric_type.setText(userListResponseData.get(position).getFabricTypeName());
        holder.article_nos.setText(userListResponseData.get(position).getArticleno());
        holder.fabric_types.setText(userListResponseData.get(position).getFabricTypeName());
        holder.composition.setText(userListResponseData.get(position).getComposition());
        holder.compositions.setText(userListResponseData.get(position).getComposition());
        holder.pattern.setText(userListResponseData.get(position).getPattern());
        holder.patterns.setText(userListResponseData.get(position).getPattern());
        holder.weave.setText(userListResponseData.get(position).getWeave());
        holder.weaves.setText(userListResponseData.get(position).getWeave());
        holder.Occassion.setText(userListResponseData.get(position).getOccassion());
        holder.threadCount.setText(userListResponseData.get(position).getThreadcount());
        holder.fullmeter.setText(userListResponseData.get(position).getPricefullrollmtrs());
        holder.fullyard.setText(userListResponseData.get(position).getPricefullroll());
        holder.abovemeter.setText(userListResponseData.get(position).getPrice10plusmtrs());
        holder.aboveyard.setText(userListResponseData.get(position).getPrice10plus());
        holder.belowmeter.setText(userListResponseData.get(position).getPrice1to9mtrs());
        holder.belowyard.setText(userListResponseData.get(position).getPrice1to9());



        if(userListResponseData.get(position).getNote()!=null)
        {
            if (userListResponseData.get(position).getNote().isEmpty()) {
                holder.note.setText("NOTE NOT AVAILABLE");
                holder.notes.setText("NOTE NOT AVAILABLE");
            }
            else{
                holder.note.setText(userListResponseData.get(position).getNote());
                holder.notes.setText(userListResponseData.get(position).getNote());
            }
        }



        System.out.println("getNote"+userListResponseData.get(position).getNote());

        holder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fc.toggle(false);
            }
        });


        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(context, ArticleEdit.class);
                in.putExtra("article_no",userListResponseData.get(position).getArticleno());
                in.putExtra("fabric_type",userListResponseData.get(position).getFabrictype());
                in.putExtra("note_article",userListResponseData.get(position).getNote());
                in.putExtra("article_id",userListResponseData.get(position).getId());
                in.putExtra("compositionType",userListResponseData.get(position).getComposition());

                in.putExtra("occassion",userListResponseData.get(position).getOccassion());
                in.putExtra("fullYards",userListResponseData.get(position).getPricefullroll());
                in.putExtra("till9_yard",userListResponseData.get(position).getPrice1to9());
                in.putExtra("above10_yd",userListResponseData.get(position).getPrice10plus());
                in.putExtra("fullmtrs",userListResponseData.get(position).getPricefullrollmtrs());
                in.putExtra("till9_mtrs",userListResponseData.get(position).getPrice1to9mtrs());
                in.putExtra("above10_mtrs",userListResponseData.get(position).getPrice10plusmtrs());
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
                ((Activity)context).finish();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                alertBuilder.setTitle("Delete Article No "+userListResponseData.get(position).getArticleno());
                alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.DeleteArticle("delete",userListResponseData.get(position).getId());


                    }
                });
                alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();



            }
        });



        // implement setONCLickListtener on itemView
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // display a toast with user name
//                Toast.makeText(context, userListResponseData.get(position).getArticleno(), Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
    }

    @Override
    public int getItemCount() {

        return userListResponseData.size(); // size of the list items
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
    public void onGetResponse(String name, int drawable) {

    }

    @Override
    public void onShowStock(stockPOJO response) {

    }

    @Override
    public void onshowFabricType(fabricTypePOJO response) {

    }

    @Override
    public void onshowDeleteArticel(deletearticelPOJO response) {
        Intent in = new Intent(context, Stock.class);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(in);
        ((Activity)context).finish();
    }


    class StockViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView article_no, fabric_type,note,article_nos, fabric_types,notes;
        @BindView(R.id.edit_article)
        Button edit;
        @BindView(R.id.delete_article)
        Button delete;
        @BindView(R.id.folding_cell_art)
        FoldingCell fc;
        @BindView(R.id.composition_s)
        TextView composition;
        @BindView(R.id.pattern_s)
        TextView pattern;
        @BindView(R.id.weave_s)
        TextView weave;
        @BindView(R.id.composition_ss)
        TextView compositions;
        @BindView(R.id.pattern_ss)
        TextView patterns;
        @BindView(R.id.weave_ss)
        TextView weaves;
        @BindView(R.id.occasiion_s)
        TextView Occassion;
        @BindView(R.id.threadCount_s)
        TextView threadCount;
        @BindView(R.id.fullmeter)
        TextView fullmeter;
        @BindView(R.id.fullyard)
        TextView fullyard;
        @BindView(R.id.abovemeter)
        TextView abovemeter;
        @BindView(R.id.aboveyard)
        TextView aboveyard;
        @BindView(R.id.belowmeter)
        TextView belowmeter;
        @BindView(R.id.belowyard)
        TextView belowyard;


        public StockViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            // get the reference of item view's
            article_no = (TextView) itemView.findViewById(R.id.article_no);
            fabric_type = (TextView) itemView.findViewById(R.id.fabric_type);
            note = (TextView) itemView.findViewById(R.id.note);
            article_nos = (TextView) itemView.findViewById(R.id.article_nos);
            fabric_types = (TextView) itemView.findViewById(R.id.fabric_types);
            notes = (TextView) itemView.findViewById(R.id.notes);



        }
    }




}
