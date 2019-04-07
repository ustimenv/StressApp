package com.sweng28.stressapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FeelGoodRoutineScreen extends ScreenTemplate
{

//    private LinearLayout linearLayout;
    private FeelGoodRoutine feelGoodRoutine;
    private ArrayList<String> feelGoodRoutineList;
//    private Toolbar toolbar;
//    private DrawerLayout drawer;
//    private NavigationView navigationView;
    private FloatingActionButton faButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feelgood);
    
        
        linearLayout = findViewById(R.id.linearLayout_feelgood);
        toolbar = findViewById(R.id.toolbar_feelgood);
        faButton = findViewById(R.id.fab_feelgood);
        drawer = findViewById(R.id.drawer_layout_feelgood);
        navigationView = findViewById(R.id.nav_view_feelgood);
        
        feelGoodRoutine = new FeelGoodRoutine();
        feelGoodRoutine.addDefaults();
        this.drawFeelGoodList();

        setSupportActionBar(toolbar);
//        final EditText result = (EditText) findViewById(R.id.editTextResult);

        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getBaseContext());

                final EditText userInput = new EditText(getBaseContext());
                userInput.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialogBuilder.setView(userInput);
                alertDialogBuilder.setTitle("Add New Activity");
                // set dialog message
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String activity = userInput.getText().toString();
                                addFeelGoodEntry(activity);
                            }
                        });
                alertDialogBuilder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                //AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialogBuilder.show();

                //
            }
        });
        drawer.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

    }

    public void addFeelGoodEntry(String activity) {
        this.feelGoodRoutine.addFeelGoodRoutineEntry(activity);
        this.drawFeelGoodEntry(activity);
    }

    public void drawFeelGoodList() {
        for (String a : this.feelGoodRoutine.getFeelGoodList()) {
            this.drawFeelGoodEntry(a);
        }
    }

    private void drawFeelGoodEntry(String activity) {
        CheckBox entry = new CheckBox(getBaseContext());
        entry.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        entry.setChecked(true);
        entry.setText(activity);
        linearLayout.addView(entry);
    }
  
    
}