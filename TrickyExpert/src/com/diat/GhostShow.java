package com.diat;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class GhostShow extends Activity {

	public static final String TAG = "Tricky Expert";
	
	private MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ghostpic);
		player = MediaPlayer.create(this, R.raw.ghost_scream);
		player.start();
	}

	@Override
    protected void onDestroy(){
    	super.onDestroy();
    	if(player != null){
			try{
				player.release();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
    }
}
