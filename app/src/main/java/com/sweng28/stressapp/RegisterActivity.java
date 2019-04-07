package com.sweng28.stressapp;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.StringTokenizer;

public class RegisterActivity extends AppCompatActivity implements MessageResultReceiver.Receiver
{
	Button 	 sendButton;
	EditText nameBox;
	EditText usernameBox;
	EditText passwordBox;
	EditText confirmPasswordBox;
	TextView registrationFeedback;
	
	public MessageResultReceiver 	receiver;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		sendButton = findViewById(R.id.sendButton);
		nameBox = findViewById(R.id.nameBox);
		usernameBox = findViewById(R.id.usernameBox);
		passwordBox = findViewById(R.id.passwordBox);
		confirmPasswordBox = findViewById(R.id.confirmPasswordBox);
		registrationFeedback = findViewById(R.id.registrationFeedback);
		
		sendButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(!passwordBox.getText().toString().equals(confirmPasswordBox.getText().toString()))
				{
					Toast.makeText(getBaseContext(), "Make sure to enter the password correctly!", Toast.LENGTH_LONG).show();
					confirmPasswordBox.setText("");
				}
				else
				{
					initReceiver();
					new SendMessageAsync().execute(NetworkingConstants.REGISTRATION_REQ, usernameBox.getText().toString(), nameBox.getText().toString(), passwordBox.getText().toString());
				}
			}
		});
	}
	
	@Override
	public void onReceiveResult(int resultCode, Bundle result)
	{
		String message = result.getString("message");
		
		try
		{
			String flag = message.substring(1);
			if(flag.equals(NetworkingConstants.REGISTRATION_ACK))
			{
				Toast.makeText(getBaseContext(), "Registration complete!", Toast.LENGTH_LONG).show();
				StringTokenizer st = new StringTokenizer(message, NetworkingConstants.DELIMITER);
				String tmp = st.nextToken();
				int assignedClientID = -1;
				try
				{
					assignedClientID = Integer.parseInt(st.nextToken());
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);    //now the client has to log in, be it with the newly registered credentials or old
				intent.putExtra("assignedClientID", assignedClientID);
				finish();
				startActivity(intent);
			}
			else if(flag.equals(NetworkingConstants.REGISTRATION_NAK))
			{
				Toast.makeText(getBaseContext(), "Please choose a different username!", Toast.LENGTH_LONG).show();
			}
			else
			{
				Toast.makeText(getBaseContext(), "|"+ message.substring(1)+"|" + "Something went terribly wrong!", Toast.LENGTH_LONG).show();
				Log.i("1", "Unknown registration flag" + flag);
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

