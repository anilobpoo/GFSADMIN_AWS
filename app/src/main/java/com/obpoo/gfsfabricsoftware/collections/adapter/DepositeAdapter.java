package com.obpoo.gfsfabricsoftware.collections.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obpoo.gfsfabricsoftware.R;

public class DepositeAdapter extends RecyclerView.Adapter<DepositeAdapter.ViewHolder> {
    Context context;
    public DepositeAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.deposite_adapter,viewGroup,false);
        DepositeAdapter.ViewHolder rootView = new DepositeAdapter.ViewHolder(view);
        return rootView;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
