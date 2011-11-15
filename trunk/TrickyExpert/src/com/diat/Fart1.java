package com.diat;


import com.diat.audio.LongSoundEffect;

import android.app.Activity;
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
	private Button pause;
	private Button resume;
	
	private LongSoundEffect instance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fart1);
		start = (Button) findViewById(R.id.start);
		pause = (Button) findViewById(R.id.pause);
		resume = (Button) findViewById(R.id.resume);
		
		instance = new LongSoundEffect() ;
		
		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					instance.playAudio(LongSoundEffect.DEFAULT_AUDIO_PATH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		pause.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {				
				instance.pauseAudio();
			}
		});
		
		resume.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				instance.resumeAudio();
			}
		});
	}
	
	
	@Override
    protected void onDestroy(){
    	super.onDestroy();
    	instance.killMediaPlayer();
    }
	
}
