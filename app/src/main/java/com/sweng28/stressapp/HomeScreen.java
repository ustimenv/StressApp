package com.sweng28.stressapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class HomeScreen extends ScreenTemplate
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		toolbar = findViewById(R.id.toolbar_home);
		setSupportActionBar(toolbar);
		linearLayout = findViewById(R.id.linearLayout_home);
		fab =  findViewById(R.id.fab_home);
		drawer = findViewById(R.id.drawer_layout_home);
		navigationView = (NavigationView) findViewById(R.id.nav_view_home);
		
		FloatingActionButton fab = findViewById(R.id.fab_home);

		setSupportActionBar(toolbar);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				//Snackbar.make(view, "Editing the Feel-good routine", Snackbar.LENGTH_LONG).setAction("Action", null).show();
				Intent i = new Intent(HomeScreen.this, FeelGoodRoutineScreen.class);
//				i.putExtra("fgl", feelGoodRoutine);
				startActivity(i);
			}
		});
		drawer.bringToFront();
		toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		navigationView.setNavigationItemSelectedListener(this);
		navigationView.bringToFront();
		
	}
	
	
	private void addFeelGoodRoutineEntry()
	{
		CheckBox entry = new CheckBox(this);
		entry.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));

		entry.setText("Woop woop");
		linearLayout.addView(entry);

//		EditText activity;
//		Button newChat = new Button(this);
//		newChat.setLayoutParams(new Relativelayout.LayoutParams(
//				Relativelayout.LayoutParams.MATCH_PARENT,
//				Relativelayout.LayoutParams.MATCH_PARENT));
//
//		newChat.setText(chatNameStr + assignedClientID);
//
//		Relativelayout.addView(newChat);
	}

}
