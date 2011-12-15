package com.diat;


import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Brokenscreen extends Activity {


	private final Handler mHandler = new MyHandler() ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
//		
		setContentView(R.layout.brokenscreen);
//		normal_fart = (Button) findViewById(R.id.normal_fart);
//		juicy_fart = (Button) findViewById(R.id.juicy_fart);
//		long_fart = (Button) findViewById(R.id.long_fart);
////		start = (Button) findViewById(R.id.start);
//		delay = (Button) findViewById(R.id.delay);
//		fartImages = (ImageView) findViewById(R.id.fart_anim);
//		fartImages.setBackgroundResource(R.anim.firefox_animation);
//		fartAnimation = (AnimationDrawable) fartImages.getBackground();
//		
//		
//		sound = new SoundEffect(this);
//		sound.getSoundPool().setOnLoadCompleteListener(this);
//		sound.addSound(SOUND_NORMAL_FART, R.raw.normal_fart);
//		sound.addSound(SOUND_LONG_FART, R.raw.long_fart);
//		sound.addSound(SOUND_JUICY_FART, R.raw.juice_fart);
//		
//		//If there is a requirement that every different sound needs different delay time,
//		//we can set each sound a timer to implement it.
//		timer = new Timer();
//		
//		normal_fart.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				timerHandler = new Handler() {
//					public void handleMessage(Message msg) {
////						fartAnimation.start();
//						sound.playSound(SOUND_NORMAL_FART);
//					}
//				};
//				fartAnimation.start();
//				if(task == null){
//					sound.playSound(SOUND_NORMAL_FART);
//				}
//				else{
//					//schedule method in Timer can only execute one task for one time,
//					//so we need to create another same task.
//					task = new TimerTask(){
//						@Override
//						public void run() {
//							Message message = new Message();
//							message.what = Integer.parseInt(delayTime);
//							timerHandler.sendMessage(message);
//						}
//					};
//					timer.schedule(task, Integer.parseInt(delayTime)*1000);
//				}
//			}
//		});
//		
//		juicy_fart.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				timerHandler = new Handler() {
//					public void handleMessage(Message msg) {
////						fartAnimation.start();
//						sound.playSound(SOUND_JUICY_FART);
//					}
//				};
//				fartAnimation.start();
//				if(task == null){
//					sound.playSound(SOUND_JUICY_FART);
//				}
//				else{
//					task = new TimerTask(){
//						@Override
//						public void run() {
//							Message message = new Message();
//							message.what = Integer.parseInt(delayTime);
//							timerHandler.sendMessage(message);
//						}
//					};
//					timer.schedule(task, Integer.parseInt(delayTime)*1000);
//				}
//			}
//		});
//		
//		long_fart.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				timerHandler = new Handler() {
//					public void handleMessage(Message msg) {
////						fartAnimation.start();
//						sound.playSound(SOUND_LONG_FART);
//					}
//				};
//				fartAnimation.start();
//				if(task == null){
//					sound.playSound(SOUND_LONG_FART);
//				}
//				else{
//					task = new TimerTask(){
//						@Override
//						public void run() {
//							Message message = new Message();
//							message.what = Integer.parseInt(delayTime);
//							timerHandler.sendMessage(message);
//						}
//					};
//					timer.schedule(task, Integer.parseInt(delayTime)*1000);
//				}
//			}
//		});
//		
//		delay.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				LayoutInflater inflater = getLayoutInflater();
//				final View dialog = inflater.inflate(R.layout.fartdelay, null);
//				final EditText seconds = (EditText) dialog.findViewById(R.id.delay_edit);
//				AlertDialog.Builder builder = new Builder(activity);
//				builder.setTitle(R.string.selfdefined_delay);
//				builder.setView(dialog);
//				builder.setPositiveButton(R.string.submit,
//				new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog, int whichButton) {
//						delayTime = seconds.getText().toString();
//						Log.i(TAG, "Get the delay time from Dialog...");
//						
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
//					}
//				});
//				builder.setNegativeButton(R.string.cancel, null);
//				builder.show();
//			}
//		});		
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
		}
	}
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
	
	
//	@Override
//	public void onAttachedToWindow() {
//		this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
//		super.onAttachedToWindow();
//	}
//	@Override
//	public void onBackPressed() {
//	return;
//	}
	
}
