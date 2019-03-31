package com.sweng28.stressapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ReceiverService extends IntentService
{
	public ReceiverService() {
		super("ReceiverService");
	}

	@Override
	protected void onHandleIntent(Intent intent)
	{
		Socket s = null;
		String message = "$";
		ServerSocket serverSocket = null;
		InputStream is = null;
		ResultReceiver receiver=null;
		if(intent != null)
		{
			try
			{
				serverSocket = new ServerSocket(8080);
				s = serverSocket.accept();
				message = inputStreamToString(s.getInputStream());        //extract text message from received stream
				receiver = intent.getParcelableExtra("receiver");  //send back the data to the correct activity
				Bundle bundle = new Bundle();
				bundle.putString("message", message);
				receiver.send(0, bundle);
			} catch (Exception e)
			{
				Log.i("1", e.getMessage());
			}
			finally
			{
				try
				{
					s.close();
					serverSocket.close();
					is.close();
				}catch(Exception e)
				{
					Log.i("1", e.getMessage());
				}
			}
		}
	}
	public String inputStreamToString(InputStream is) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String tmp ="";
		while((tmp=br.readLine()) != null)
		{
			sb.append(tmp);
		}
		return sb.toString();
	}
	
}
