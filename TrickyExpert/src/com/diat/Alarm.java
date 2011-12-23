package com.diat;

import java.util.Timer;
import java.util.TimerTask;

import com.diat.audio.SoundEffect;
import com.diat.utils.TimerUtility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Alarm extends Activity implements SoundPool.OnLoadCompleteListener{

	
	public static final String TAG = "Tricky Expert";
	public static final int SOUND_NORMAL_ALARM = 1;
	public static final int SOUND_LONG_ALARM = 2;
	public static final int SOUND_JUICY_ALARM = 3;
	
	private Button normal_alarm;
	private Button juicy_alarm;
	private Button long_alarm;

	private Button delay;

	private ImageView alarmImages;
	private AnimationDrawable alarmAnimation;
	private SoundEffect sound;
	
	private TimerUtility tm;
	private TimerTask task;
//	private Handler timerHandler;

	private final Activity activity = this;
	private int delayTime = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	
		setContentView(R.layout.alarm);
		normal_alarm = (Button) findViewById(R.id.normal_alarm);
		juicy_alarm = (Button) findViewById(R.id.juicy_alarm);
		long_alarm = (Button) findViewById(R.id.long_alarm);

		delay = (Button) findViewById(R.id.delay);
		alarmImages = (ImageView) findViewById(R.id.alarm_anim);
		alarmImages.setBackgroundResource(R.anim.alarm_animation);
		alarmAnimation = (AnimationDrawable) alarmImages.getBackground();
		
		
		sound = new SoundEffect(this);
		sound.getSoundPool().setOnLoadCompleteListener(this);
		sound.addSound(SOUND_NORMAL_ALARM, R.raw.normal_alarm);
		sound.addSound(SOUND_LONG_ALARM, R.raw.long_alarm);
		sound.addSound(SOUND_JUICY_ALARM, R.raw.juicy_alarm);
		
		//If there is a requirement that every different sound needs different delay time,
		//we can set each sound a timer to implement it.
		
		normal_alarm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				timerHandler = new Handler() {
//					public void handleMessage(Message msg) {
////						fartAnimation.start();
//						sound.playSound(SOUND_NORMAL_ALARM);
//					}
//				};
				alarmAnimation.start();
				if(delayTime == 0){
					sound.playSound(SOUND_NORMAL_ALARM);
				}
				else{
					//schedule method in Timer can only execute one task for one time,
					//so we need to create another same task.
					task = new TimerTask(){
						@Override
						public void run() {
							sound.playSound(SOUND_NORMAL_ALARM);
						}
					};
					
					tm = new TimerUtility(delayTime, task);
//					timer.schedule(task, delayTime*1000);
					tm.schedule();
				}
			}
		});
		
		juicy_alarm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				timerHandler = new Handler() {
//					public void handleMessage(Message msg) {
////						fartAnimation.start();
//						sound.playSound(SOUND_JUICY_ALARM);
//					}
//				};
				alarmAnimation.start();
				if(delayTime == 0){
					sound.playSound(SOUND_JUICY_ALARM);
				}
				else{
					task = new TimerTask(){
						@Override
						public void run() {
							sound.playSound(SOUND_JUICY_ALARM);
						}
					};
					tm = new TimerUtility(delayTime, task);
//					timer.schedule(task, delayTime*1000);
					tm.schedule();
				}
			}
		});
		
		long_alarm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				timerHandler = new Handler() {
//					public void handleMessage(Message msg) {
////						fartAnimation.start();
//						sound.playSound(SOUND_LONG_ALARM);
//					}
//				};
				alarmAnimation.start();
				if(delayTime == 0){
					sound.playSound(SOUND_LONG_ALARM);
				}
				else{
					task = new TimerTask(){
						@Override
						public void run() {
							sound.playSound(SOUND_LONG_ALARM);
						}
					};
					tm = new TimerUtility(delayTime, task);
//					timer.schedule(task, delayTime*1000);
					tm.schedule();
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
	
	
	
	protected void onDestroy() {
		sound.getSoundPool().release();
		sound.getSoundPool().stop(sound.getPlaying());
		super.onDestroy();
	}
	
//	private class AlarmHandler extends Handler{
//		@SuppressWarnings("unused")
//		public void handlerMessage(Message msg){
//			sound.playSound(msg.what);
//		}
//	}
	/**
	 * The below described issue is still not resolved.
	 * 11-08 15:47:56.402: ERROR/MP3Extractor(34): Unable to resync. Signalling end of stream.
	 * 11-08 15:47:57.882: WARN/SoundPool(2076):   sample 4 not READY
	 */
	public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
//		Message msg = mHandler.obtainMessage(sound.getPlaying());
//		msg.arg1 = sampleId;
//		mHandler.sendMessage(msg);
	}

}
