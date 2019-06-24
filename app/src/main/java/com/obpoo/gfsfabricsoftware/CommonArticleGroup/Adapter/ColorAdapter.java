package com.obpoo.gfsfabricsoftware.CommonArticleGroup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel.StockDataResponse;
import com.obpoo.gfsfabricsoftware.Article.MVP.AdapterToActivityInterface;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by PHD on 11/20/2018.
 */

public class ColorAdapter extends BaseAdapter {
    Context context;
    ArrayList<StockDataResponse> colorList;
    LayoutInflater inflter;
    ArrayList<StockDataResponse> filterList;
    AdapterToActivityInterface aaInterface;
    List<String> getBackCheckedValuesInAdapter;

    public ColorAdapter(Context context, ArrayList<StockDataResponse> colorList, AdapterToActivityInterface aaInterface, List<String> getBackCheckedValuesInAdapter ) {
        this.context = context;
        this.colorList = colorList;
        inflter = (LayoutInflater.from(context));
        this.filterList = new ArrayList<StockDataResponse>();
        this.filterList.addAll(colorList);
        this.aaInterface = aaInterface;
        this.getBackCheckedValuesInAdapter=getBackCheckedValuesInAdapter;


    }

    @Override
    public int getCount() {
        return colorList.size();
    }

    @Override
    public Object getItem(int position) {
        return colorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.colorchecktextview, null);
        final CheckedTextView simpleCheckedTextView = (CheckedTextView) view.findViewById(R.id.checkedvalue);
        simpleCheckedTextView.setText(colorList.get(position).getArticleno());
        if(getBackCheckedValuesInAdapter!=null) {
           if(getBackCheckedValuesInAdapter.contains(colorList.get(position).getArticleno())) {
               simpleCheckedTextView.setChecked(true);
           }
        }
        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        colorList.clear();
        if (charText.length() == 0) {
            colorList.addAll(filterList);
        } else {
            for (StockDataResponse wp : filterList) {
                if (wp.getArticleno().toLowerCase(Locale.getDefault()).contains(charText)) {
                    colorList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}