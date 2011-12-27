package com.diat;

import com.diat.audio.SoundEffect;

import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;

public class Brokenscreen extends Activity {


	private SoundEffect soundManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		soundManager = new SoundEffect(this);
		setContentView(R.layout.brokenscreen);
	}
	
	@Override
	protected void onDestroy() {
		soundManager.getSoundPool().release();
		soundManager.getSoundPool().stop(soundManager.getPlaying());
		super.onDestroy();
	}
	
	public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
	}

}
