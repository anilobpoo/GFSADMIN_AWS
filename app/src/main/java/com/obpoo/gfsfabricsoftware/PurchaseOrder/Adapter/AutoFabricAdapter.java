package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.fabric.datamodels.FabricsDetail;

import java.util.ArrayList;

/**
 * Created by PHD on 11/29/2018.
 */

public class AutoFabricAdapter extends ArrayAdapter<FabricsDetail> {

    Context context;
    int resource, textViewResourceId;
    ArrayList<FabricsDetail> items, tempItems, suggestions;

    public AutoFabricAdapter(Context context, int resource, int textViewResourceId,  ArrayList<FabricsDetail> items) {
        super(context, resource, textViewResourceId, items);
        this.context = context;
        this.resource = resource;
        this.textViewResourceId = textViewResourceId;
        this.items = items;
        tempItems = new ArrayList<FabricsDetail>(items); // this makes the difference.
        suggestions = new ArrayList<FabricsDetail>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.autocompletefabric, parent, false);
        }
        FabricsDetail people = items.get(position);
        if (people != null) {
            TextView lblName = (TextView) view.findViewById(R.id.lbl_fabric);
            if (lblName != null)
                lblName.setText(people.getFab_name());
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    /**
     * Custom Filter implementation for custom suggestions we provide.
     */
    Filter nameFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            String str = ((FabricsDetail) resultValue).getFab_name();
            return str;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (FabricsDetail people : tempItems) {
                    if (people.getFab_name().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        suggestions.add(people);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<FabricsDetail> filterList = (ArrayList<FabricsDetail>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (FabricsDetail people : filterList) {
                    add(people);
                    notifyDataSetChanged();
                }
            }
        }
    };
}
