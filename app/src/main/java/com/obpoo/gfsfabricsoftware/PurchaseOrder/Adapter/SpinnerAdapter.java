package com.obpoo.gfsfabricsoftware.PurchaseOrder.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.user.datamodels.UserDetail;

import java.util.ArrayList;

/**
 * Created by PHD on 11/16/2018.
 */

public class SpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter{
    ArrayList<UserDetail> getUserList;
    Context context;

    public SpinnerAdapter(ArrayList<UserDetail> getUserList, Context context) {
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
            text=(TextView)LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item,parent,false);
        }
        text.setTextColor(Color.BLACK);
        text.setText(getUserList.get(position).getName());
        return text;
    }
}
