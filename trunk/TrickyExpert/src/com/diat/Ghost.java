package com.diat;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ghost extends Activity {

	public static final String TAG = "Tricky Expert";
	
	private Button start;
	private Button delay;
	
	private Activity activity = this;
	
	private int delayTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ghost);
		start = (Button) findViewById(R.id.ghost_start);
		delay = (Button) findViewById(R.id.ghost_delay);
		
		start.setOnClickListener(new View.OnClickListener() {
			Intent intent = new Intent(activity, GhostShow.class);
			@Override
			public void onClick(View v) {
				Long currentTime = System.currentTimeMillis();
				if(delayTime == 0){
			    	startActivity(intent);
				}
				else{
//					task = new TimerTask(){
//						@Override
//						public void run() {
//							startActivity(intent);
//						}
//					};
//					
//					tm = new TimerUtility(delayTime, task);
//					tm.schedule();
					
					Intent in = new Intent(activity,AlarmReceiver.class);
					PendingIntent pIntent = PendingIntent.getBroadcast(activity, 0, in, 0);
					AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
					am.set(AlarmManager.RTC_WAKEUP, (currentTime + delayTime*1000L), pIntent); 

					Intent intent1 = new Intent(Intent.ACTION_MAIN);  
					intent1.addCategory(Intent.CATEGORY_HOME);  
					intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
					startActivity(intent1); 
				}
			}
		});
		
		delay.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				LayoutInflater inflater = getLayoutInflater();
				final View dialog = inflater.inflate(R.layout.fartdelay, null);
				final EditText seconds = (EditText) dialog.findViewById(R.id.delay_edit);
				seconds.setText(String.valueOf(delayTime));
				AlertDialog.Builder builder = new Builder(activity);
				builder.setTitle(R.string.selfdefined_delay);
				builder.setView(dialog);
				builder.setPositiveButton(R.string.submit,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						//there is a exception here if user leave the edit field blank and click OK. still unresolved.
						if(seconds.getText() == null || seconds.getText().toString() == null){
							delayTime = 0;
						}
						else{
							delayTime = Integer.parseInt(seconds.getText().toString());
						}
						Log.i(TAG, "Get the delay time from Dialog..." + seconds.getText().toString());
						
//						if(task != null){
//							task.cancel();
//						}
//						task = new TimerTask(){
//
//							@Override
//							public void run() {
//								Message message = new Message();
//								message.what = Integer.parseInt(delayTime);
//								timerHandler.sendMessage(message);
//							}
//							
//						};
					}
				});
				builder.setNegativeButton(R.string.cancel, null);
				builder.show();
			}
		});
	}

}
