package com.indoorlocation;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

class Connection implements Runnable{
	
	String TAG = "main Activity";
	Socket clientsocket = null;
	DataInputStream inputstream;
	BufferedReader inarduino = null;

	@Override
	public void run() {
		
		while(true){
			
			Log.d(TAG, "alive!");
			
			try{
				
				clientsocket = new Socket("192.168.1.20", 4444); //address, port
				
				inputstream = new DataInputStream(clientsocket.getInputStream());
				
				//create buffer data input
				inarduino = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				
				if(inarduino != null){
					Log.d(TAG, "FROM ARDUINO:" + inarduino.readLine());
				}
				
			}catch (UnknownHostException e){
				
	            Log.d(TAG, "Unknown Host");
	            e.printStackTrace();
				
			} catch (IOException e) {
				
	            Log.d(TAG, "Input Output Exception");
	            e.printStackTrace();
	            
			}finally{
				
				if(clientsocket != null){
					try {clientsocket.close();
					}catch (IOException e){
						e.printStackTrace();
					}	
				}
				if(inputstream != null){
					try{
						inputstream.close();
					}catch (IOException e){
						e.printStackTrace();
					}
				}
			}	
		}
	}
}