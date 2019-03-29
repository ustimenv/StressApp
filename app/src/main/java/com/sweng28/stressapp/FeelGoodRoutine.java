package com.sweng28.stressapp;

import android.content.Context;

import java.util.ArrayList;

public class FeelGoodRoutine
{
	private ArrayList <FeelGoodRoutineEntry> feelGoodList;
	private static final int PADDING_CONSTANT = 50;
	
	FeelGoodRoutine(Context context)
	{
		feelGoodList = new ArrayList<>();
		initDefaults(context);
		
	}
	
	private void initDefaults(Context context)
	{
		feelGoodList.add(new FeelGoodRoutineEntry("Pet dog", context, feelGoodList.size()*PADDING_CONSTANT));
		feelGoodList.add(new FeelGoodRoutineEntry("Have tea", context, feelGoodList.size()*PADDING_CONSTANT));
		feelGoodList.add(new FeelGoodRoutineEntry("Go for a walk", context, feelGoodList.size()*PADDING_CONSTANT));
		feelGoodList.add(new FeelGoodRoutineEntry("Meditation", context, feelGoodList.size()*PADDING_CONSTANT));
	}
	void addFeelGoodRoutineEntry(String name, Context context)
	{
		feelGoodList.add(new FeelGoodRoutineEntry(name, context, feelGoodList.size()*PADDING_CONSTANT));
	}

	void removeFeelGoodRoutineEntry(FeelGoodRoutineEntry feelGoodRoutineEntry, Context context)
	{
		if this.feelGoodList.contains(feelGoodRoutineEntry)
		{
			int index = this.feelGoodList.indexOf(feelGoodRoutineEntry)
			this.feelGoodList.remove(feelGoodRoutineEntry);
			for (int i=index; i<this.feelGoodList.size(); i++)
			{
				FeelGoodRoutineEntry f = this.feelGoodList.get(i);
				f.move(i*PADDING_CONSTANT)
			}
		}
		return;
	}
}
