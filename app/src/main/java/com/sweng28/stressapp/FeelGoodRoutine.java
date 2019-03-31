package com.sweng28.stressapp;

import android.content.Context;

import java.util.ArrayList;

public class FeelGoodRoutine
{
	public class FeelGoodRoutineEntry
	{
		String activityName;
		FeelGoodRoutineEntry(String activityName) {
			this.activityName = activityName;
		}
	}


	private ArrayList<FeelGoodRoutineEntry> feelGoodList;
	public static String[] defaults = {"Pet dog","Have tea","Go for a walk","Meditation"};
	
	FeelGoodRoutine(Context context)
	{
		feelGoodList = new ArrayList<>();
		initDefaults();
		
	}
	
	void initDefaults()
	{
		for (String a : defaults)
		{
			feelGoodList.add(new FeelGoodRoutineEntry(a));
		}
	}

	void addFeelGoodRoutineEntry(String name)
	{
		feelGoodList.add(new FeelGoodRoutineEntry(name));
	}

	void removeFeelGoodRoutineEntry(FeelGoodRoutineEntry feelGoodRoutineEntry)
	{
		if(this.feelGoodList.contains(feelGoodRoutineEntry))
		{
			this.feelGoodList.remove(feelGoodRoutineEntry);
		}
	}
}
