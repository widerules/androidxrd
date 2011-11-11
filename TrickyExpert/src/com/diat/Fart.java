package com.diat;

import java.util.Timer;
import java.util.TimerTask;

import com.diat.audio.SoundEffect;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.media.SoundPool;

/**
 * Play sound using SoundPool
 * @Filename Fart.java
 * @author Victor_Chen1
 * @date Nov 7, 2011
 */
public class Fart extends Activity implements SoundPool.OnLoadCompleteListener{

	public static final String TAG = "Tricky Expert";
	
	private Button normal_fart;
	private Button juicy_fart;
	private Button long_fart;
//	private Button start;
	private Button delay;
//	private Button cancel;
	private ImageView fartImages;
	private AnimationDrawable fartAnimation;
	private SoundEffect sf;
	
	private Timer timer;
	private TimerTask task;
	private Handler timerHandler;

	private final Activity activity = this;
	private String delayTime;
	
	private final Handler mHandler = new MyHandler() ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fart);
		normal_fart = (Button) findViewById(R.id.normal_fart);
		juicy_fart = (Button) findViewById(R.id.juicy_fart);
		long_fart = (Button) findViewById(R.id.long_fart);
//		start = (Button) findViewById(R.id.start);
		delay = (Button) findViewById(R.id.delay);
		fartImages = (ImageView) findViewById(R.id.fart_anim);
		fartImages.setBackgroundResource(R.anim.firefox_animation);
		fartAnimation = (AnimationDrawable) fartImages.getBackground();
		
		
		sf = new SoundEffect(this);
		sf.getSoundPool().setOnLoadCompleteListener(this);
		
		timer = new Timer();
		timerHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				fartAnimation.start();
				sf.jucieFart();
			}
		};
		
		normal_fart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				fartAnimation.start();
				sf.normalFart();
			}
		});
		
		juicy_fart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				fartAnimation.start();
				sf.jucieFart();
			}
		});
		
		long_fart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				fartAnimation.start();
				sf.longFart();
			}
		});
		
		delay.setOnClickListener(new View.OnClickListener() {
			@Override
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
						timer.schedule(task, Integer.parseInt(delayTime)*1000);
					}
				});
				builder.setNegativeButton(R.string.cancel, null);
				builder.show();
			}
		});
	}
	@Override
	protected void onDestroy() {
		sf.getSoundPool().release();
		sf.getSoundPool().stop(sf.getPlaying());
		super.onDestroy();
	}
	
	private class MyHandler extends Handler{
		@SuppressWarnings("unused")
		public void handlerMessage(Message msg){
			sf.playSound(msg.what);
		}
	}
	/**
	 * The below described issue is still not resolved.
	 * 11-08 15:47:56.402: ERROR/MP3Extractor(34): Unable to resync. Signalling end of stream.
	 * 11-08 15:47:57.882: WARN/SoundPool(2076):   sample 4 not READY
	 */
	@Override
	public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
		Message msg = mHandler.obtainMessage(sf.getPlaying());
		msg.arg1 = sampleId;
		mHandler.sendMessage(msg);
	}
}