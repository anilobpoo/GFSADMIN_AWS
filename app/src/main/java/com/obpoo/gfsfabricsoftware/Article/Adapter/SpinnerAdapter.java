package com.obpoo.gfsfabricsoftware.Article.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType.FabricTypePOJOArrayData;

import java.util.ArrayList;

/**
 * Created by obpoo on 11/16/2018.
 */

public class SpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter{
    ArrayList<FabricTypePOJOArrayData> getFabricTypeList;
    Context context;

    public SpinnerAdapter(ArrayList<FabricTypePOJOArrayData> getFabricTypeList, Activity context) {
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
            text=(TextView)LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item,parent,false);
        }
        text.setTextColor(Color.BLACK);
        text.setText(getFabricTypeList.get(position).getFabricType());
        return text;
    }
}
