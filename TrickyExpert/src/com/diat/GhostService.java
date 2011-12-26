package com.diat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GhostService extends Service {

	public void onCreate(){
		 Intent intent = new Intent();
		 intent.setClass(this, GhostShow.class);
		 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 startActivity(intent);
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
