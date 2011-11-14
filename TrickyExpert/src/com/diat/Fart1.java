package com.diat;


import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Unused.
 * Alternative way to play sound using MediaPlayer. Passed tests.
 * @Filename Fart1.java
 * @author Victor_Chen1
 * @date Nov 9, 2011
 */
public class Fart1 extends Activity{

	public static final String TAG = "Tricky Expert";
	
	private Button start;
	
	public static final int SOUND_NORMAL_FART = 1;
	public static final int SOUND_LONG_FART = 2;
	public static final int SOUND_JUICY_FART = 3;
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fart);
		start = (Button) findViewById(R.id.long_fart);
		
	    initMediaPlayer();
		
		start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				playSound();
			}
		});
	}
	
	public void handleControlButtonClick(){
    	if(!mp.isPlaying()){
			this.playSound();
		}else{
			this.stopSound();
		}
	}
	
	private void initMediaPlayer(){
		mp = MediaPlayer.create(this, R.raw.juice_fart);
		mp.setOnCompletionListener(new OnCompletionListener(){
			public void onCompletion(MediaPlayer player){
				releaseMediaPlayer();
			}
		});
	}
	
	private void playSound(){
    	releaseMediaPlayer();
    	initMediaPlayer();
    	mp.start();
	}
	
    private void stopSound(){
    	mp.stop();
    }
	
	private void releaseMediaPlayer(){
    	if(mp != null){
    		mp.release();
    		mp = null;
    	}
    }
	
	@Override
    protected void onDestroy(){
    	super.onDestroy();
    	releaseMediaPlayer();
    }
	
//	public void normalFart() {
//	    playSound(SOUND_NORMAL_FART);
//	}
//	public void longFart() {
//	    playSound(SOUND_LONG_FART);
//	}
//	public void juicyFart() {
//	    playSound(SOUND_JUICY_FART);
//	}
}
