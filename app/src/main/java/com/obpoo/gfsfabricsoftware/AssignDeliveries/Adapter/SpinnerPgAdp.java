package com.obpoo.gfsfabricsoftware.AssignDeliveries.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel.PGresponseList;

import java.util.ArrayList;

/**
 * Created by PHD on 1/5/2019.
 */

public class SpinnerPgAdp extends BaseAdapter implements android.widget.SpinnerAdapter{
    ArrayList<PGresponseList> getUserList;
    Context context;

    public SpinnerPgAdp(ArrayList<PGresponseList> getUserList, Context context) {
        this.getUserList = getUserList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return getUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return getUserList.get(position);
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
        text.setBackgroundColor(Color.WHITE);
        text.setText(getUserList.get(position).getName());
        return text;
    }
}

