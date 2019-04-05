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

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
	private DrawerLayout drawer;
	NavigationView navigationView;
	private ListView feelGoodRoutineList;
	private ArrayAdapter<String> feelGoodAdapter;

	public static final String[] DEFAULTS = {"Pet dog","Have tea","Go for a walk","Meditation"};

	private ArrayList<String> feelGoodRoutine;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		drawer = findViewById(R.id.drawer_layout);
		navigationView = findViewById(R.id.nav_view);

		feelGoodRoutineList = findViewById(R.id.list_feel_good);


		FloatingActionButton fab = findViewById(R.id.fab);

		setSupportActionBar(toolbar);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Editing the Feel-good routine", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//
			}
		});
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		drawer.bringToFront();
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		NavigationView navigationView = findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
	
		feelGoodRoutine = new ArrayList<>();
		for (String a : DEFAULTS)
		{
			feelGoodRoutine.add(a);
		}

		updateFeelGood();
		navigationView.bringToFront();
		
	}

	public void updateFeelGood() {
		if (feelGoodAdapter == null) {
			feelGoodAdapter = new ArrayAdapter<>(this,
					R.layout.item_feel_good,
					R.id.feel_good_title,
					feelGoodRoutine);
			feelGoodRoutineList.setAdapter(feelGoodAdapter);
		} else {
			feelGoodAdapter.clear();
			feelGoodAdapter.addAll(feelGoodRoutine);
			feelGoodAdapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onBackPressed()
	{
		
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

}
