package com.sweng28.stressapp;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;


public class HomeScreen extends ScreenTemplate
{
	private ListView feelGoodRoutineList;
	
	FloatingActionButton fab;
	private ArrayAdapter<String> feelGoodAdapter;
	
	public static final String[] DEFAULTS = {"Pet dog","Have tea","Go for a walk","Meditation"};
	
	private ArrayList<String> feelGoodRoutine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		toolbar = findViewById(R.id.toolbar_home);
		setSupportActionBar(toolbar);

		drawer = findViewById(R.id.drawer_layout_home);
		navigationView = findViewById(R.id.nav_view_home);
		feelGoodRoutineList = findViewById(R.id.list_feel_good);


		fab = findViewById(R.id.fab_home);
		linearLayout = findViewById(R.id.linearLayout_home);
		fab =  findViewById(R.id.fab_home);
		

		setSupportActionBar(toolbar);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Editing the Feel-good routine", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//
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
	
		feelGoodRoutine = new ArrayList<>();
		for (String a : DEFAULTS)
		{
			feelGoodRoutine.add(a);
		}

//		updateFeelGood();
		navigationView.bringToFront();
		
	}

//	public void updateFeelGood() {
//		if (feelGoodAdapter == null) {
//			feelGoodAdapter = new ArrayAdapter<>(this,
//					R.layout.item_feel_good,
//					R.id.feel_good_title,
//					feelGoodRoutine);
//			feelGoodRoutineList.setAdapter(feelGoodAdapter);
//		} else {
//			feelGoodAdapter.clear();
//			feelGoodAdapter.addAll(feelGoodRoutine);
//			feelGoodAdapter.notifyDataSetChanged();
//		}
//	}

	@Override
	public void onBackPressed()
	{
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout_home);
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
