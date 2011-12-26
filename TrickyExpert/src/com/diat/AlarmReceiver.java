package com.diat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 
 * @author Victor
 *
 */
public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Intent i = new Intent(arg0, GhostShow.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		arg0.startActivity(i);
//		arg0.startService(new Intent(arg0,GhostService.class));
	}

}
