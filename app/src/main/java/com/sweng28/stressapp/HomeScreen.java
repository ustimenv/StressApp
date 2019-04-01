package com.sweng28.stressapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.InputType;
import android.view.LayoutInflater;
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
	final Context context = this;
	private FeelGoodRoutine_BackEnd feelGoodRoutineBackEnd;
	private FeelGoodRoutine_Editor feelGoodRoutineEditor;
	private FeelGoodRoutine_Display feelGoodRoutineDisplay;
	private LinearLayout linearLayout;
	private FloatingActionButton faButton;
	private DrawerLayout drawer;
	NavigationView navigationView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		linearLayout = findViewById(R.id.linearLayout);
		faButton =  findViewById(R.id.fab);
		drawer = findViewById(R.id.drawer_layout);
		navigationView = (NavigationView) findViewById(R.id.nav_view);
		
		this.feelGoodRoutineBackEnd = new FeelGoodRoutine_BackEnd();
		this.feelGoodRoutineEditor = new FeelGoodRoutine_Editor(this.feelGoodRoutineBackEnd, this.linearLayout, getBaseContext());
		this.feelGoodRoutineDisplay = new FeelGoodRoutine_Display(this.feelGoodRoutineEditor);


		setSupportActionBar(toolbar);
		//final EditText result = (EditText) findViewById(R.id.editTextResult);

		faButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				//System.out.println("homeScreen onClick");
				Intent editorScreen = new Intent(HomeScreen.this, FeelGoodRoutine_Editor.class);
				startActivity(editorScreen);
			}
		});
		
		drawer.bringToFront();
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		navigationView.setNavigationItemSelectedListener(this);

		navigationView.bringToFront();
		
	}

/*	public void onCheckboxChecked(View view)
	{
		boolean checked = ((CheckBox) view).isChecked();
		switch (view.getId())
		{
		
		}
	} */
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
		
		if (id == R.id.nav_camera)
		{
			// Handle the camera action
		}
		else if (id == R.id.nav_gallery)
		{
		
		}
		else if (id == R.id.nav_slideshow)
		{
		
		}
		else if (id == R.id.nav_manage)
		{
		
		}
		else if (id == R.id.nav_share)
		{
		
		}
		else if (id == R.id.nav_send)
		{
			Intent intent = new Intent(HomeScreen.this, LoginActivity.class);
			startActivity(intent);
		}
		
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
	
}
