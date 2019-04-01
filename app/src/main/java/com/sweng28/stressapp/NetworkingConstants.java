package com.sweng28.stressapp;

public abstract class NetworkingConstants
{
	public final static String DELIMITER		 = String.valueOf(new Character((char)176));//separate distinct units of data within the message
	public final static String INTERNAL_ERROR    = String.valueOf(new Character((char)177));//hopefully never appears
	public final static String DATA_RECEIVED_ACK = String.valueOf(new Character((char)178));//confirm client successfully transmitted their data
	public final static String END   			 = String.valueOf(new Character((char)179));//end of transmission
	
	//May receive
	
	public final static String REGISTRATION_REQ  = String.valueOf(new Character((char)180));//client wishes to create a profile
	public final static String LOGIN_REQ 	     = String.valueOf(new Character((char)181));//client is attempting to log in
	
	
	public final static String FRIEND_ADD		 = String.valueOf(new Character((char)182));//user sends a friend a request
	public final static String FRIEND_ACK    	 = String.valueOf(new Character((char)183));//user accepts friend's request
	public final static String FRIEND_NAK    	 = String.valueOf(new Character((char)184));//user rejects friend's request
	public final static String FRIEND_DEL        = String.valueOf(new Character((char)185));//user removes friend
	public final static String FRIEND_REQ_CANC   = String.valueOf(new Character((char)186));//a user wishes to cancel a previously sent friend request
	
	
	//May send/////////////////////////////////////////////////////////////////////////////////////////////////////
	public final static String REGISTRATION_ACK  = String.valueOf(new Character((char)188));//profile created
	public final static String REGISTRATION_NAK = String.valueOf(new Character((char)189));//profile not created
	
	public final static String LOGIN_ACK 		 = String.valueOf(new Character((char)190));//logged in successfully
	public final static String LOGIN_NAK 		 = String.valueOf(new Character((char)191));//login failed
	
	
	public final static String FRIEND_ADD_REQUEST   	= String.valueOf(new Character((char)192));//tell a friend that user wishes to be friends with them
	public final static String FRIEND_REQUEST_ACCEPTED  = String.valueOf(new Character((char)193));//tell friend user accepted their friend request
	public final static String FRIEND_REQUEST_DENIED	= String.valueOf(new Character((char)194));//tell user they were rejected
	public final static String FRIEND_REMOVE        	= String.valueOf(new Character((char)195));//tell the friend user removed them
	public final static String FRIEND_REQUEST_CANCEL    = String.valueOf(new Character((char)196));//tell a friend that the user changed their mind???????????
	
	public final static String GOAL_ADD			= String.valueOf(new Character((char)197));//user adds a new goal
	public final static String GOAL_DEL			=String.valueOf(new Character((char)199));//user removes an existing goal
	
	public final static Character FLUSH_DATA_REQ 	 = (char)187;//request the server to transmit any data it has not already
	
	
	//Friend status codes
	public final static int FRIEND_NOT = 0;				//not friend?????
	public final static int FRIEND_NORMAL = 1;			//full on friend
	public final static int FRIEND_REQUEST_SENT = 2;	//user is waiting to be accepted
	public final static int FRIEND_REQUEST_RECEIVED = 3;//user may now accept friend request
	
	
	
}
