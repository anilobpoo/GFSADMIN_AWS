package com.obpoo.gfsfabricsoftware.collections.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.collections.datamodel.CollectionDatum;
import com.obpoo.gfsfabricsoftware.collections.datamodel.Transactions;
import com.obpoo.gfsfabricsoftware.collections.ui.CollectionsDeliveries;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsDelAdapter extends RecyclerView.Adapter<CollectionsDelAdapter.ViewHolder> {
    Context context;
    ArrayList<CollectionDatum> data;
    List<Transactions> transactions = new ArrayList<>();
    CollectionINDAdapter adapter;
    Double total_collections = 0.0 ;

    public CollectionsDelAdapter(CollectionsDeliveries collectionsDeliveries, ArrayList<CollectionDatum> data) {
        context = collectionsDeliveries;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.collections_del_adapter, viewGroup, false);
        ViewHolder rootView = new ViewHolder(view);
        return rootView;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        transactions = data.get(i).getTransactions();

        viewHolder.piclup_guy.setText("Pickup Guy:"+data.get(i).getPickupGuy());
        for (int j = 0; j < transactions.size(); j++) {
            total_collections = total_collections + (Double.parseDouble(transactions.get(j).getAppliedAmmount()));
        }
        viewHolder.total_collection.setText("Total Collection:"+total_collections);

        adapter = new CollectionINDAdapter(context, transactions);
        viewHolder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycler_view)
        RecyclerView recyclerView;
        @BindView(R.id.piclup_guy)
        TextView piclup_guy;
        @BindView(R.id.total_collection)
        TextView total_collection;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
