package com.diat;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.diat.audio.SoundEffect;

/**
 * Play sound using SoundPool
 * @Filename Fart.java
 * @author Victor_Chen1
 * @date Nov 7, 2011
 */
public class BrokenScreenInit extends Activity {

	public static final String TAG = "Tricky Expert";
	public static final int SOUND_NORMAL_FART = 1;
	public static final int SOUND_LONG_FART = 2;
	public static final int SOUND_JUICY_FART = 3;
	
	private Button normal_fart;
	private Button juicy_fart;
	private Button long_fart;
//	private Button start;
	private Button delay;
//	private Button cancel;
	private ImageView fartImages;
//	private AnimationDrawable fartAnimation;
	private SoundEffect sound;
	
	private Timer timer;
	private TimerTask task;
	private Handler timerHandler;

	private final Activity activity = this;
	private String delayTime;
	
	private final Handler mHandler = new MyHandler() ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initbrokenscreen);
		normal_fart = (Button) findViewById(R.id.normal_fart);
		juicy_fart = (Button) findViewById(R.id.juicy_fart);
		long_fart = (Button) findViewById(R.id.long_fart);
		
//		start = (Button) findViewById(R.id.start);
		delay = (Button) findViewById(R.id.delay);
		
//		fartImages = (ImageView) findViewById(R.id.fart_anim);
//		fartImages.setBackgroundResource(R.anim.firefox_animation);
//		fartAnimation = (AnimationDrawable) fartImages.getBackground();
		
		
//		sound = new SoundEffect(this);
//		sound.getSoundPool().setOnLoadCompleteListener(this);
//		sound.addSound(SOUND_NORMAL_FART, R.raw.normal_fart);
//		sound.addSound(SOUND_LONG_FART, R.raw.long_fart);
//		sound.addSound(SOUND_JUICY_FART, R.raw.juice_fart);

		//If there is a requirement that every different sound needs different delay time,
		//we can set each sound a timer to implement it.
		timer = new Timer();
		
		normal_fart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				timerHandler = new Handler() {
					public void handleMessage(Message msg) {
//						fartAnimation.start();
//						sound.playSound(SOUND_NORMAL_FART);
						gotoBrokenscreen();
					}
				};
//				fartAnimation.start();
				if(task == null){
//					sound.playSound(SOUND_NORMAL_FART);
					gotoBrokenscreen();
				}
				else{
					//schedule method in Timer can only execute one task for one time,
					//so we need to create another same task.
					task = new TimerTask(){
						@Override
						public void run() {
							Message message = new Message();
							message.what = Integer.parseInt(delayTime);
							timerHandler.sendMessage(message);
						}
					};
					timer.schedule(task, Integer.parseInt(delayTime)*1000);
				}
			}
		});

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
	
    public void gotoBrokenscreen(){
    	Intent intent = new Intent(this, Brokenscreen.class);
    	startActivity(intent);
    }
	
	
	@Override
	protected void onDestroy() {
//		sound.getSoundPool().release();
//		sound.getSoundPool().stop(sound.getPlaying());
		super.onDestroy();
	}
	
	private class MyHandler extends Handler{
		@SuppressWarnings("unused")
		public void handlerMessage(Message msg){
//			sound.playSound(msg.what);
			gotoBrokenscreen();
		}
	}
//	/**
//	 * The below described issue is still not resolved.
//	 * 11-08 15:47:56.402: ERROR/MP3Extractor(34): Unable to resync. Signalling end of stream.
//	 * 11-08 15:47:57.882: WARN/SoundPool(2076):   sample 4 not READY
//	 */
//	public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
//		Message msg = mHandler.obtainMessage(sound.getPlaying());
//		msg.arg1 = sampleId;
//		mHandler.sendMessage(msg);
//	}
}