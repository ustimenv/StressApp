package com.sweng28.stressapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.StringTokenizer;

public class LoginActivity extends Activity implements MessageResultReceiver.Receiver
{
	Button 	 						sendButton;
	EditText 						usernameBox;
	EditText 						passwordBox;
	TextView 						loginMessageBox;
	Button 			 				registerButton;
	public MessageResultReceiver 	receiver;
	private int						assignedClientID = -1;
	SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		
		sendButton = findViewById(R.id.sendButton);
		usernameBox = findViewById(R.id.usernameBox);
		passwordBox = findViewById(R.id.passwordBox);
		loginMessageBox = findViewById(R.id.loginMessageBox);
		registerButton = findViewById(R.id.registerButton);
		
		prefs = getApplicationContext().getSharedPreferences("ChatPreferences", MODE_PRIVATE);
		
		
		sendButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				initReceiver();										//start listening for the response
				Toast.makeText(getBaseContext(), "Logging in...", Toast.LENGTH_LONG).show();
				SharedPreferences.Editor editor = prefs.edit();		//remember some of the login details to simplify the procedure for next launch
				editor.putInt("ID", assignedClientID);
				editor.apply();
				new SendMessageAsync().execute(String.valueOf(NetworkingConstants.LOGIN_REQ), usernameBox.getText().toString(), passwordBox.getText().toString(), String.valueOf(assignedClientID));
			}
		});
		registerButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(getBaseContext(), "Lets register!", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	protected void onStart()
	{
		super.onStart();
		
		assignedClientID = prefs.getInt("ID", -1);						//retrieve previous session's login details
		assignedClientID = getIntent().getIntExtra("assignedClientID", assignedClientID);		//if the client had previosouly registered as a new user, overwrite the shared preferences field
	}
	@Override
	public void onReceiveResult(int resultCode, Bundle result)
	{
		String message = result.getString("message");//feedback from the server
		Log.d("1", "Message"+message+">>");
		try
		{
			String flag = message.substring(1);
			if(flag.equals(NetworkingConstants.LOGIN_ACK))
			{
				Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
				finish();
				startActivity(intent);
			}
			else if(flag.equals(NetworkingConstants.LOGIN_NAK))
			{
				Toast.makeText(getBaseContext(), "Wrong username or password", Toast.LENGTH_LONG).show();
			}
			else
			{
				Log.i("1", "Unknown login flag" + flag);
			}
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
	}
	private void initReceiver()
	{
		receiver = new MessageResultReceiver(new Handler());
		receiver.setReceiver(this);
		Intent intent = new Intent(this, ReceiverService.class);
		intent.putExtra("receiver", receiver);
		startService(intent);
	}
}
