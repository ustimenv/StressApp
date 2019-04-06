package com.sweng28.stressapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class FeelGoodRoutine implements Parcelable
{

	public static final Parcelable.Creator<FeelGoodRoutine> CREATOR = new Parcelable.Creator<FeelGoodRoutine>(){
		public FeelGoodRoutine createFromParcel(Parcel in) {
			return new FeelGoodRoutine(in);
		}

		public FeelGoodRoutine[] newArray(int size) {
			return new FeelGoodRoutine[size];
		}
	};


	private ArrayList<String> feelGoodList;
	public static String[] defaults = {"Pet dog","Have tea","Go for a walk","Meditation"};

	FeelGoodRoutine()
	{
		feelGoodList = new ArrayList<>();
		addDefaults();
	}
	FeelGoodRoutine(Parcel in)
	{
		feelGoodList = in.readArrayList(null);
	}

	void addDefaults()
	{
		for (String a : defaults)
		{
			feelGoodList.add(a);
		}
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.feelGoodList);
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