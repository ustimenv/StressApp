package com.example.david.timeline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity{
        ListView listView;
        List list=new ArrayList();
        ArrayAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
}
