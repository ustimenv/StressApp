package com.sweng28.stressapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ScreenTemplate extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
	protected DrawerLayout drawer;
	protected LinearLayout linearLayout;
	protected FloatingActionButton fab;
	protected NavigationView navigationView;
	protected ActionBarDrawerToggle toggle;
	protected Toolbar toolbar;
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
		if(id == R.id.nav_feelgood) {
			Intent intent = new Intent(this, FeelGoodRoutineScreen.class);
			startActivity(intent);
		}
		else if (id == R.id.nav_goals) {
			Intent intent = new Intent(this, Goals.class);
			startActivity(intent);
		}
		else if (id == R.id.nav_schedule) {
			Intent intent = new Intent(this, Schedule.class);
			startActivity(intent);
		}
		else if (id == R.id.nav_login) {
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		}
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
