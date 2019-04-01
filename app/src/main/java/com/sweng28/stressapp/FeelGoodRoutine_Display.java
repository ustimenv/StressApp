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

public class FeelGoodRoutine_Display extends AppCompatActivity {
    private ListView listView;
    private ListNormalAdapter listNormalAdapter;
    private ListCustomizedAdapter listCustomizedAdapter;
    private FeelGoodRoutine_Editor editor;
    private int selectedPosition = -1;
    private boolean isCustomizedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feelgoodroutine_display);
        initControls();
    }
    private void initControls() {
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (isCustomizedList) {
                    selectedPosition = i;
                    listCustomizedAdapter.notifyDataSetChanged();
                }
                Toast.makeText(FeelGoodRoutine_Display.this, "You have selected [" + mobileArray[i] + "]", Toast.LENGTH_SHORT).show();
            }
        });
        listNormalAdapter = new ListNormalAdapter(mobileArray);
        listCustomizedAdapter = new ListCustomizedAdapter(mobileArray);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getBoolean("isNormalList")) {
                listView.setAdapter(listNormalAdapter);
                isCustomizedList = false;
            } else {
                isCustomizedList = true;
                listView.setAdapter(listCustomizedAdapter);
            }
        }
    }
    public class ListNormalAdapter extends BaseAdapter {
        private final String[] mobileNames;
        private LayoutInflater inflater;

        public ListNormalAdapter(String[] strings) {
            this.mobileNames = strings;
            inflater = getLayoutInflater();
        }

        @Override
        public int getCount() {
            return mobileNames.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
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
            holder.textName.setText(mobileNames[position]);
            return convertView;
        }

        public class ViewHolder {
            private TextView textName;
        }
    }
}