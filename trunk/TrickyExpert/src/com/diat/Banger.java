package com.diat;

import android.app.Activity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Banger extends Activity{
	
	public static final String TAG = "Tricky Expert";
	public static final int SOUND_FIRST_BANGER = 1;
	public static final int SOUND_SECOND_BANGER = 2;
	public static final int SOUND_THIRD_BANGER = 3;
	
	private Button first_banger;
//	private Button second_banger;
//	private Button third_banger;

	private Button delay;

	private ImageView bangerImages;
	private AnimationDrawable bangerAnimation;
	private MediaPlayer sound;
	
	private Timer timer;
	private TimerTask task;
	private Handler timerHandler;

	private final Activity activity = this;
	private String delayTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.banger);
		first_banger = (Button) findViewById(R.id.first_banger);
//		second_banger = (Button) findViewById(R.id.second_banger);
//		third_banger = (Button) findViewById(R.id.third_banger);
//		
		delay = (Button) findViewById(R.id.delay);
		bangerImages = (ImageView) findViewById(R.id.banger_anim);
		bangerImages.setBackgroundResource(R.anim.banger_animation);
		bangerAnimation = (AnimationDrawable) bangerImages.getBackground();
		
		sound = MediaPlayer.create(this, R.raw.first_banger);
//		sound.addSound(SOUND_SECOND_BANGER, R.raw.second_banger);
//		sound.addSound(SOUND_THIRD_BANGER, R.raw.third_banger);
		
		//If there is a requirement that every different sound needs different delay time,
				//we can set each sound a timer to implement it.
				timer = new Timer();
				
				first_banger.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						if(task == null){
							bangerAnimation.start();
							sound.start();
							if(!sound.isPlaying()){
								//This did not work.
								bangerAnimation.setVisible(false, false);
							}
						}
						else{
							bangerAnimation.start();
							//schedule method in Timer can only execute one task for one time,
							//so we need to create another same task.
							task = new TimerTask(){
								@Override
								public void run() {
									bangerAnimation.start();
									sound.start();
									if(!sound.isPlaying()){
										bangerAnimation.setVisible(false, false);
									}
								}
							};
							timer.schedule(task, Integer.parseInt(delayTime)*1000);
						}
					}
				});
				
//				second_banger.setOnClickListener(new View.OnClickListener() {
//					public void onClick(View v) {
//						timerHandler = new Handler() {
//							public void handleMessage(Message msg) {
////								fartAnimation.start();
//								sound.playSound(SOUND_SECOND_BANGER);
//							}
//						};
//						//alarmAnimation.start();
//						if(task == null){
//							sound.playSound(SOUND_SECOND_BANGER);
//						}
//						else{
//							task = new TimerTask(){
//								@Override
//								public void run() {
//									Message message = new Message();
//									message.what = Integer.parseInt(delayTime);
//									timerHandler.sendMessage(message);
//								}
//							};
//							timer.schedule(task, Integer.parseInt(delayTime)*1000);
//						}
//					}
//				});
//				
//				third_banger.setOnClickListener(new View.OnClickListener() {
//					public void onClick(View v) {
//						timerHandler = new Handler() {
//							public void handleMessage(Message msg) {
////								fartAnimation.start();
//								sound.playSound(SOUND_THIRD_BANGER);
//							}
//						};
//						//alarmAnimation.start();
//						if(task == null){
//							sound.playSound(SOUND_THIRD_BANGER);
//						}
//						else{
//							task = new TimerTask(){
//								@Override
//								public void run() {
//									Message message = new Message();
//									message.what = Integer.parseInt(delayTime);
//									timerHandler.sendMessage(message);
//								}
//							};
//							timer.schedule(task, Integer.parseInt(delayTime)*1000);
//						}
//					}
//				});
//				
				delay.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						LayoutInflater inflater = getLayoutInflater();
						final View dialog = inflater.inflate(R.layout.fartdelay, null);
						final EditText seconds = (EditText) dialog.findViewById(R.id.delay_edit);
						AlertDialog.Builder builder = new Builder(activity);
						builder.setTitle(R.string.selfdefined_delay);
						builder.setView(dialog);
						builder.setPositiveButton(R.string.submit,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								delayTime = seconds.getText().toString();
								Log.i(TAG, "Get the delay time from Dialog...");
								
								if(task != null){
									task.cancel();
								}
								task = new TimerTask(){

									@Override
									public void run() {
										Message message = new Message();
										message.what = Integer.parseInt(delayTime);
										timerHandler.sendMessage(message);
									}
									
								};
							}
						});
						builder.setNegativeButton(R.string.cancel, null);
						builder.show();
					}
				});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(sound != null){
			try{
				sound.release();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	
}
