package com.example.david.timeline;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
//import devs.mulham.horizontalcalendar.HorizontalCalendar;
//import devs.mulham.horizontalcalendar.model.CalendarEvent;
//import devs.mulham.horizontalcalendar.utils.CalendarEventsPredicate;
//import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Timeline extends AppCompatActivity {
    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;
    TableLayout tableLayout;
    private SectionStatePagerAdapter mSectionStatePageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        mSectionStatePageAdapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        tableLayout=(TableLayout)findViewById(R.id.table_layout);
        tableLayout.setColumnStretchable(0,true);
        tableLayout.setColumnStretchable(1,true);
        tableLayout.setColumnStretchable(2,true);

        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                setmViewPager(0);
            }
        });
    }
    private void setupViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UserInput(),"UI");
        viewPager.setAdapter(adapter);
    }
    public void setmViewPager(int one){
        mViewPager.setCurrentItem(one);
    }
}
