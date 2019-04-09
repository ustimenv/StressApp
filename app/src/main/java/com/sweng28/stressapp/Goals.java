package com.sweng28.stressapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Goals extends ScreenTemplate
{
    private static final String TAG = "GoalActivity";
    private ListView mGoalListView;
    private ArrayAdapter<String> mAdapter;
    public ArrayList<String> goalList;
    private FloatingActionButton addGoal;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        mGoalListView = findViewById(R.id.list_goals);
        goalList = new ArrayList<>();
        addGoal = findViewById(R.id.add_goal_fab);
        toolbar = findViewById(R.id.toolbar_goals);
        setSupportActionBar(toolbar);
    
        drawer = findViewById(R.id.drawer_layout_goals);
        navigationView = findViewById(R.id.nav_view_goals);
        
        linearLayout = findViewById(R.id.linearLayout_goals);

        setSupportActionBar(toolbar);

    
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
                                TODO CODE TO ADD TASK TO DB
                                 */
                                goalList.add(goalText);
                                mAdapter.notifyDataSetChanged();
                                //updateUI();
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
        drawer.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
        updateUI();
    }
    
    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView goalTextView = parent.findViewById(R.id.goal_title);
        String goalText = String.valueOf(goalTextView.getText());
        Toast.makeText(Goals.this, "Remove Goal: " + goalText, Toast.LENGTH_LONG).show();
        goalList.remove(goalText);
        mAdapter.notifyDataSetChanged();
    }
    
    
    private void updateUI() {
        
        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_goal,
                    R.id.goal_title,
                    goalList);
            mGoalListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(goalList);
            mAdapter.notifyDataSetChanged();
        }
    }
}
