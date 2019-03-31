package com.sweng28.stressapp;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

public class FeelGoodRoutineEntry
{
	String activityName;
	boolean isChecked;
	
	//int viewID;
	
	FeelGoodRoutineEntry(String activityName, int paddingCounter)
	{
		this.activityName = activityName;
		
		
//		checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(),
//				paddingCounter, paddingCounter);
//		checkBox.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view)
//			{
//				Snackbar.make(view, "Checkbox " + checkBox.getText() + " checked!", Snackbar.LENGTH_LONG)
//						.setAction("Action", null).show();
//			}
//		});
	}

	protected void moveEntry(int paddingCounter)
	{
//		checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(),
//				paddingCounter, paddingCounter);
	}
}
