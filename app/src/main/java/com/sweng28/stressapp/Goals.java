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
import android.widget.Toast;

import java.util.ArrayList;

public class Goals extends AppCompatActivity {
    private static final String TAG = "GoalActivity";
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals);
        mTaskListView = findViewById(R.id.list_todo);

        FloatingActionButton addGoal = findViewById(R.id.add_goal_fab);
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
                                Toast.makeText(Goals.this, "Add Goal: " + goalText, Toast.LENGTH_LONG).show();
                                /*
                                CODE TO ADD TASK TO DB
                                 */
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
        TextView taskTextView = parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        /*
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(TaskContract.TaskEntry.TABLE,
                TaskContract.TaskEntry.COL_TASK_TITLE + " = ?",
                new String[]{task});
        db.close();
        */
        updateUI();
    }


    private void updateUI() {

        ArrayList<String> taskList = new ArrayList<>();
        taskList.add("FOO");
        taskList.add("BAR");
        taskList.add("BINGO");
        taskList.add("CRAP");
        /*
        SQLiteDatabase db = mHelper.getReadableDatabase();

        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }
        */

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo,
                    R.id.task_title,
                    taskList);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }

        //cursor.close();
        //db.close();
    }
}
