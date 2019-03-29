package com.sweng28.stressapp;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.CheckBox;

public class FeelGoodRoutineEntry
{
	String activityName;
	boolean isChecked;
	CheckBox checkBox;
	
	int viewID;
	FeelGoodRoutineEntry(String activityName, Context context, int paddingCounter)
	{
		this.activityName = activityName;
		checkBox = new CheckBox(context);
		checkBox.setText(activityName);
		
		checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(), paddingCounter, paddingCounter);
		checkBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Checkbox " + checkBox.getText() + " checked!", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
	}
}
