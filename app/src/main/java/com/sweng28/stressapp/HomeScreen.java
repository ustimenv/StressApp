package com.sweng28.stressapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
	private FeelGoodRoutine feelGoodRoutine;
	private FeelGoodRoutine_Editor feelGoodRoutineEditor;
	private LinearLayout linearLayout;
	private FloatingActionButton fab;
	private DrawerLayout drawer;
	NavigationView navigationView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		linearLayout = findViewById(R.id.linearLayout);
		fab =  findViewById(R.id.fab);
		drawer = findViewById(R.id.drawer_layout);
		navigationView = (NavigationView) findViewById(R.id.nav_view);

		feelGoodRoutine = new FeelGoodRoutine();
		feelGoodRoutineEditor = new FeelGoodRoutine_Editor(this.feelGoodRoutine, this);
		
		FloatingActionButton fab = findViewById(R.id.fab);

		setSupportActionBar(toolbar);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				//Snackbar.make(view, "Editing the Feel-good routine", Snackbar.LENGTH_LONG).setAction("Action", null).show();
				Intent i = new Intent(HomeScreen.this, FeelGoodRoutine_Editor.class);
				i.putExtra("fgl", feelGoodRoutine);
				startActivity(i);
			}
		});
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		drawer.bringToFront();
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		NavigationView navigationView = findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
	
		navigationView.bringToFront();
		
	}
	
	public void onCheckboxChecked(View view)
	{
		boolean checked = ((CheckBox) view).isChecked();
		switch (view.getId())
		{
		
		}
	}
	@Override
	public void onBackPressed()
	{
		
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item)
	{
		// Handle navigation view item clicks here.
		int id = item.getItemId();
		
		if (id == R.id.nav_goals) {
			Intent intent = new Intent(HomeScreen.this, Goals.class);
			startActivity(intent);
		}
		else if (id == R.id.nav_login) {
			Intent intent = new Intent(HomeScreen.this, LoginActivity.class);
			startActivity(intent);
		}
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
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
