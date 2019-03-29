package com.sweng28.stressapp;

import android.content.Context;

import java.util.ArrayList;

public class FeelGoodRoutine
{
	private ArrayList <FeelGoodRoutineEntry> feelGoodList;
	
	
	FeelGoodRoutine(Context context)
	{
		feelGoodList = new ArrayList<>();
		initDefaults(context);
		
	}
	
	private void initDefaults(Context context)
	{
		feelGoodList.add(new FeelGoodRoutineEntry("Pet dog", context, feelGoodList.size()*50));
		feelGoodList.add(new FeelGoodRoutineEntry("Have tea", context, feelGoodList.size()*50));
		feelGoodList.add(new FeelGoodRoutineEntry("Go for a walk", context, feelGoodList.size()*50));
		feelGoodList.add(new FeelGoodRoutineEntry("Meditation", context, feelGoodList.size()*50));
	}
	void addFeelGoodRoutineEntry(String name, Context context)
	{
		feelGoodList.add(new FeelGoodRoutineEntry(name, context, feelGoodList.size()*50));
	}
}
