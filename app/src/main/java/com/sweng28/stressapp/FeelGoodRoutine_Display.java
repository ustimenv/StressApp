package com.sweng28.stressapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FeelGoodRoutine_Display extends BaseAdapter {
    private ArrayList<String> activities;
    private LayoutInflater inflater;

    public FeelGoodRoutine_Display(ArrayList<String> activities) {
        this.activities = activities;
        //inflater = getLayoutInflater();
    }

    @Override
    public int getCount() {
        return this.activities.size();
    }

    @Override
    public Object getItem(int i) {
        return this.activities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.feelgoodroutine_display_row, null);
            holder.textName = (TextView) convertView.findViewById(R.id.textName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textName.setText(this.activities.get(position));
        return convertView;
    }

    public class ViewHolder {
        private TextView textName;
    }

}