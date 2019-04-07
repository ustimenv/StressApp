package com.sweng28.stressapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

<<<<<<< HEAD
public class Goals extends AppCompatActivity {
    //private static final String TAG = "GoalActivity";
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> goalList;

=======
public class Goals extends ScreenTemplate
{
    private static final String TAG = "GoalActivity";
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;
    private FloatingActionButton addGoal;
    
>>>>>>> feelgood
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        mTaskListView = findViewById(R.id.list_goals);
<<<<<<< HEAD
        goalList = new ArrayList<>();

        FloatingActionButton addGoal = findViewById(R.id.add_goal_fab);
=======
        addGoal = findViewById(R.id.add_goal_fab);
        
>>>>>>> feelgood
        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        Goals.this
                );

                final EditText userInput = new EditText(Goals.this);
                userInput.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialogBuilder.setView(userInput);
                alertDialogBuilder.setTitle("Add New Goal");
                // set dialog message
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int id) {
                                String goalText = userInput.getText().toString();
                                //Toast.makeText(Goals.this, "Add Goal: " + goalText, Toast.LENGTH_LONG).show();
                                /*
                                TODO CODE TO ADD TASK TO DB
                                 */
                                goalList.add(goalText);
                            }
                        });
                alertDialogBuilder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // show it
                alertDialogBuilder.show();
            }
        });

        updateUI();
    }

    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView goalTextView = parent.findViewById(R.id.goal_title);
        String goalText = String.valueOf(goalTextView.getText());
        //Toast.makeText(Goals.this, "Remove Goal: " + goalText, Toast.LENGTH_LONG).show();
        goalList.remove(goalText);
        updateUI();
    }


    private void updateUI() {

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_goal,
                    R.id.goal_title,
                    goalList);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(goalList);
            mAdapter.notifyDataSetChanged();
        }

    }
}
