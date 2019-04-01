package com.sweng28.stressapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Goals extends FragmentActivity implements NewGoalDialog.NewGoalDialogListener {
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
            public void onClick(View v) {
                showEditDialog();
            }
        });

        updateUI();
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        NewGoalDialog newGoalDialog = new NewGoalDialog();
        newGoalDialog.show(fm, "fragment_new_goal");
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        Toast.makeText(this, "Add Task: " + inputText, Toast.LENGTH_LONG).show();
        /*
        CODE TO ADD TASK TO DB
         */
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
