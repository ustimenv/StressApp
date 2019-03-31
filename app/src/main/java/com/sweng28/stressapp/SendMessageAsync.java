package com.sweng28.stressapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SendMessageAsync extends AsyncTask<String, Void, Void>
{
	@Override
	protected Void doInBackground(String... args)
	{
//		final String SERVER_IP = "192.168.0.192";
//		final String SERVER_IP = "10.1.19.47";
		final String SERVER_IP = "192.168.43.16";
//		final String SERVER_IP = "169.254.9.190";
//		final String SERVER_IP = "213.233.150.51";
//		final String SERVER_IP = "10.0.2.2";
		final int SERVER_PORT = 50000;
		
		try(Socket socket = new Socket(InetAddress.getByName(SERVER_IP), SERVER_PORT);
			PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))))
		{
			StringBuilder message = new StringBuilder();
			for(String s : args)
			{
				message.append(s).append(NetworkingConstants.DELIMITER);
			}
			message.append(NetworkingConstants.END);
			Log.i("1", "Sends from " + socket.getLocalPort() + " to " + socket.getPort());
			writer.write(message.toString());
			writer.flush();
		}catch(Exception e)
		{
			Log.e("In async", e.getMessage());
		}
		return null;
	}
}

