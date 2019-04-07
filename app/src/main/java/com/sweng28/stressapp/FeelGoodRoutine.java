package com.sweng28.stressapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class FeelGoodRoutine
{
	private ArrayList<String> feelGoodList;
	public static String[] defaults = {"Pet dog","Have tea","Go for a walk","Meditation"};

	FeelGoodRoutine()
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
		if (!feelGoodList.contains(activity))
		{
			feelGoodList.add(activity);
			
		}
	}
	void removeFeelGoodRoutineEntry(String activity)
	{
		if(this.feelGoodList.contains(activity))
		{
			this.feelGoodList.remove(activity);
		}
	}
}