package com.obpoo.gfsfabricsoftware.Article.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Composition.datamodels.ComposotionDetail;

import java.util.ArrayList;

/**
 * Created by PHD on 11/27/2018.
 */

public class CompositionSpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter{
    ArrayList<ComposotionDetail> getFabricTypeList;
    Context context;

    public CompositionSpinnerAdapter(ArrayList<ComposotionDetail> getFabricTypeList, Activity context) {
        this.getFabricTypeList = getFabricTypeList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return getFabricTypeList.size();
    }

    @Override
    public Object getItem(int position) {
        return getFabricTypeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView text;
        if(convertView != null){
            text =(TextView)convertView;
        }
        else{
            text=(TextView) LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item,parent,false);
        }
        text.setTextColor(Color.BLACK);
        text.setText(getFabricTypeList.get(position).getComposition());
        return text;
    }
}

