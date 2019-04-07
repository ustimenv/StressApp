package com.sweng28.stressapp;

import java.util.ArrayList;

public class FeelGoodRoutine_BackEnd
{


    private ArrayList<String> feelGoodList;
    public static String[] defaults = {"Pet dog","Have tea","Go for a walk","Meditation"};

    FeelGoodRoutine_BackEnd()
    {
        feelGoodList = new ArrayList<>();
        addDefaults();


    }

    void addDefaults()
    {
        for (String a : defaults)
        {
            feelGoodList.add(a);
        }
    }

    ArrayList<String> getFeelGoodList()
    {
        return this.feelGoodList;
    }
    void addFeelGoodRoutineEntry(String activity)
    {
        feelGoodList.add(activity);
    }

    void removeFeelGoodRoutineEntry(String activity)
    {
        if(this.feelGoodList.contains(activity))
        {
            this.feelGoodList.remove(activity);
        }
    }
}
