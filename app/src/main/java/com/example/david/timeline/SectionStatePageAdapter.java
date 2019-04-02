package com.example.david.timeline;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;

class SectionStatePagerAdapter extends FragmentStatePagerAdapter{
    private final List<String> mFragmentTitleList=new ArrayList<>();
    private final List<Fragment>mFragmentList=new ArrayList<>();
    public SectionStatePagerAdapter(FragmentManager fm){
        super(fm);
    }
    public void addFragment(Fragment f,String title){
        mFragmentList.add(f);
        mFragmentTitleList.add(title);
    }
    @Override
    public Fragment getItem(int position){
        return mFragmentList.get(position);
    }
    public int getCount(){
        return mFragmentList.size();
    }
}
