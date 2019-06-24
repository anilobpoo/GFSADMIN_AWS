package com.obpoo.gfsfabricsoftware.CommonArticleGroup.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cunoraz.tagview.TagView;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticelPOJOdata;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtPresenterImpl;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup.cmnArtView;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.UI.AddCmnArtGroup;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.UI.CommonArticleGroup;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by obpoo on 11/19/2018.
 */

public class cmnArtAdapter extends RecyclerView.Adapter<cmnArtAdapter.cmnArtViewHolder> implements cmnArtView {
    Context context;
    ArrayList<cmnArticelPOJOdata> listResponse;
    cmnArtPresenterImpl presenter;
    String SimilarId;


    public cmnArtAdapter(Context context, ArrayList<cmnArticelPOJOdata> listResponse) {
        this.context = context;
        this.listResponse = listResponse;
        presenter = new cmnArtPresenterImpl(this);
        presenter.showCmnArticleGroup("view_all");
    }

    @NonNull
    @Override
    public cmnArtAdapter.cmnArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cmnartview, parent, false);
        cmnArtAdapter.cmnArtViewHolder cmnArtViewHolder = new cmnArtAdapter.cmnArtViewHolder(view);
        return cmnArtViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull cmnArtAdapter.cmnArtViewHolder holder, final int i) {


        holder.groupName.setText(listResponse.get(i).getGroupName());


        holder.qualityName.setText(listResponse.get(i).getQualityName());

        holder.qualityDesc.setText(listResponse.get(i).getQualityDescription());

        System.out.println(listResponse.get(i).getGroupName() + "values");


        String[] similarDataArray = null;
        try {
            if (listResponse.get(i).getSimillarArticleNo().equals(null)) {
                Toast.makeText(context, "null" + i, Toast.LENGTH_SHORT).show();

            } else {
                similarDataArray = listResponse.get(i).getSimillarArticleNo().toArray(new String[listResponse.get(i).getSimillarArticleNo().size()]);
                System.out.println(listResponse.get(i).getSimillarArticleNo());

                holder.tagview.addTags(similarDataArray);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.delete_cmnart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setTitle("Delete Article Group "+listResponse.get(i).getGroupName());
                    alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            presenter.deleteCmnArtGroup("delete", listResponse.get(i).getId());
                            System.out.println("Zero");


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


                } catch (Exception e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.edit_cmnArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(context, AddCmnArtGroup.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("Add_UPDATE_SimilarArticleIn", "UpdateSimilarArticle");
                in.putExtra("SimilarPosition", i);
                context.startActivity(in);
                ((Activity)context).finish();



            }
        });


    }

    @Override
    public int getItemCount() {
        return listResponse.size();
    }

    @Override
    public void onShowCmnArtGroup(cmnArticlePOJO response) {


    }

    @Override
    public void ondeleteCmnArtGroup(cmnArtdeletePOJO response) {
     System.out.println("sixteen");
        Intent in = new Intent(context, CommonArticleGroup.class);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(in);
        ((Activity)context).finish();



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

    class cmnArtViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.groupName)
        TextView groupName;
        @BindView(R.id.qualityName)
        TextView qualityName;
        @BindView(R.id.qualityDesc)
        TextView qualityDesc;
        @BindView(R.id.edit_cmnArt)
        Button edit_cmnArt;
        @BindView(R.id.delete_cmnart)
        Button delete_cmnart;
        @BindView(R.id.tagView)
        TagView tagview;


        public cmnArtViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
      /*  @OnClick(R.id.edit_cmnArt)
        public void onclick(){
            Toast.makeText(context,"Edit",Toast.LENGTH_SHORT).show();
            Intent in = new Intent(context,AddCmnArtGroup.class);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            in.putExtra("Add_UPDATE_SimilarArticleIn","UpdateSimilarArticle");
            in.putExtra("SimilarPosition",which);
            context.startActivity(in);


        }*/
    }
}
