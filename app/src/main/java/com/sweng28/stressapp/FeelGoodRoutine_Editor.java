package com.sweng28.stressapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FeelGoodRoutine_Editor
{
    private class FeelGoodRoutine_Editor_Entry
    {
        String activity;
        CheckBox checkBox;
        boolean isChecked;
        static final int PADDING_CONSTANT = 50;
        private FeelGoodRoutine_Editor_Entry(int padding)
        {
            int paddingTotal = padding*PADDING_CONSTANT;
            checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(),
                    paddingTotal, paddingTotal);
		    /*checkBox.setOnClickListener(new View.OnClickListener() {
			    @Override
		        public void onClick(View view)
			    {
				    Snackbar.make(view, "Checkbox " + checkBox.getText() + " checked!", Snackbar.LENGTH_LONG)
					    .setAction("Action", null).show();
		        }
    	    }); */
        }
        private void moveEntry(int padding)
        {
            int paddingTotal = padding*PADDING_CONSTANT;
            checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(),
                    paddingTotal, paddingTotal);
        }
    }

    public LinearLayout linearLayout;
    public FeelGoodRoutine_BackEnd feelGoodRoutine;
    public ArrayList<FeelGoodRoutine_Editor_Entry> feelGoodList_Checked;
    Context context;

    public FeelGoodRoutine_Editor(FeelGoodRoutine_BackEnd fgr, LinearLayout ll, Context c)
    {
        this.feelGoodRoutine = fgr;
        this.linearLayout = ll;
        this.context = c;
    }

    public void addFeelGoodEntry(String activity)
    {
        this.feelGoodRoutine.addFeelGoodRoutineEntry(activity);
        this.drawFeelGoodEntry(activity);
    }

    public void drawFeelGoodList()
    {
        for (String a : this.feelGoodRoutine.getFeelGoodList())
        {
            this.drawFeelGoodEntry(a);
        }
    }

    private void drawFeelGoodEntry(String activity)
    {
        CheckBox entry = new CheckBox(this.context);
        entry.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        entry.setChecked(true);
        entry.setText(activity);
        linearLayout.addView(entry);
    }
/*


    void removeFeelGoodRoutineEntry(int index)
    {
			for (int i=index; i<this.feelGoodList.size(); i++)
			{
                FeelGoodRoutineEntryFrontEnd f = this.feelGoodList.get(i);
                f.moveEntry(i);
            }
    }
*/
}
