package com.sweng28.stressapp;

public class FeelGoodRoutineFrontEnd
{
    private class FeelGoodRoutineEntryFrontEnd
    {
        boolean isChecked;
        static final int PADDING_CONSTANT = 50;
        private FeelGoodRoutineEntryFrontEnd(int padding)
        {
            int paddingTotal = padding*PADDING_CONSTANT;
            checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(),
                    paddingTotal, paddingTotal);
		    checkBox.setOnClickListener(new View.OnClickListener() {
			    @Override
		        public void onClick(View view)
			    {
				    Snackbar.make(view, "Checkbox " + checkBox.getText() + " checked!", Snackbar.LENGTH_LONG)
					    .setAction("Action", null).show();
		        }
    	    });
        }
        private void moveEntry(int padding)
        {
            int paddingTotal = padding*PADDING_CONSTANT;
            checkBox.setPaddingRelative(checkBox.getCompoundPaddingStart(), checkBox.getCompoundPaddingTop(),
                    paddingTotal, paddingTotal);
        }
    }

    void addFeelGoodRoutineEntry()
    {

    }

    void removeFeelGoodRoutineEntry(int index)
    {
			for (int i=index; i<this.feelGoodList.size(); i++)
			{
				FeelGoodRoutineEntryFrontEnd f = this.feelGoodList.get(i);
				f.moveEntry(i);
			}
		}
    }
}