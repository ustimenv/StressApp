package com.sweng28.stressapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

public class FeelGoodRoutine_Editor extends Activity implements NavigationView.OnNavigationItemSelectedListener
{
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    public LinearLayout linearLayout;
    public FeelGoodRoutine_BackEnd feelGoodRoutine;
    // public ArrayList<FeelGoodRoutine_Editor_Entry> feelGoodList_Checked;
    Context context;

    public FeelGoodRoutine_Editor(FeelGoodRoutine_BackEnd fgr, LinearLayout ll, Context c)
    {
        this.feelGoodRoutine = fgr;
        this.linearLayout = ll;
        this.context = c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        System.out.println("feelGoodRoutine_Editor onCreate");
        setContentView(R.layout.feelgoodroutine_edit_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        linearLayout = findViewById(R.id.linearLayout);
        FloatingActionButton faButton =  findViewById(R.id.fab_edit_feel_good_routine);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        System.out.println("feelGoodRoutine_Editor drawList");
        this.drawFeelGoodList();

        //setSupportActionBar(toolbar);
        //final EditText result = (EditText) findViewById(R.id.editTextResult);

        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                System.out.println("feelGoodRoutine_Editor faButton onClick");
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                final EditText userInput = new EditText(context);
                userInput.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialogBuilder.setView(userInput);
                alertDialogBuilder.setTitle("Add New Activity");
                // set dialog message
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int id) {
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

    public ArrayList<String> getFeelGoodRoutine()
    {
        return this.feelGoodRoutine.getFeelGoodList();
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
