package com.diat;

import com.diat.adapter.FartAdapter;
import com.diat.audio.SoundEffect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class CountActivity extends Activity {

	public static final String TAG = "Tricky Expert";
	
	private int delaySeconds;
	private int soundID;
	private String fartname;
	
	private TextView countbackview;
	private TextView fartnameview;
	private TextView hintview;
	
	private Activity activity = this;
	private Handler handler;
	private Runnable updateThread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.countback);
		countbackview = (TextView) findViewById(R.id.countback);
		fartnameview = (TextView) findViewById(R.id.count_fart_name);
		hintview = (TextView) findViewById(R.id.count_hint);
		
		Intent intent = getIntent();
		int m = 0;
		this.delaySeconds = intent.getIntExtra("DelayTime",m);
		this.soundID = intent.getIntExtra("SoundID", m);
		this.fartname = intent.getStringExtra("FartName");
		this.countbackview.setText(String.valueOf(delaySeconds));
		this.fartnameview.setText(fartname);
		
		Log.i(TAG, "Delay Seconds = " + String.valueOf(delaySeconds));
		Log.i(TAG, "Fart Name = " + fartname);
		Log.i(TAG, "Sound ID = " + String.valueOf(soundID));
		
		Handler localHandler1 = new Handler();
		this.handler = localHandler1;
		Runnable local1 = new Runnable(){
			@Override
			public void run() {
				SoundEffect localSoundManager = FartAdapter.soundManager;
				CountActivity localAcitivity = (CountActivity) activity;
				if(delaySeconds >= 0){
					countbackview.setText(String.valueOf(delaySeconds));
				}
				
				if(delaySeconds == 0){
					localSoundManager.playSound(soundID);
				}
//				
				int count = delaySeconds - 1;
				delaySeconds = count;
				if(delaySeconds < 0){
//					Intent intent = new Intent(localAcitivity, Fart.class);
//			    	startActivity(intent);
			    	activity.finish();
				}
				else{
					Handler innerHandler = handler;
					Runnable innerRunnable  = updateThread;
					innerHandler.postDelayed(innerRunnable, 1000L);
				}
			}
			
		};
		this.updateThread = local1;
		
		Handler localHandler2 = this.handler;
	    Runnable localRunnable = this.updateThread;
	    localHandler2.post(localRunnable);
	    return;
	}
}
