package com.diat.audio;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

/**
 * Use SoundPool to implement playing short sound. Any sound track longer than 5 or 6 seconds 
 * should better use MediaPlayer to play.
 * @Filename SoundEffect.java
 * @author Victor_Chen1
 * @date Nov 8, 2011
 */
public class SoundEffect {

	public static final String TAG = "Tricky Expert";
	
	private SoundPool soundPool;
	private HashMap<Integer, Integer> soundPoolMap;
	private Context context;
	private int playing;

	
	public SoundEffect(Context context) {
		this.context = context;
		soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
	    soundPoolMap = new HashMap<Integer, Integer>();
	}


	/**
	 * Play the sound indicated by ID.
	 * @param soundID an unique sound identifier. 
	 * @return
	 */
	public int playSound(int soundID) {
	   
	    AudioManager mgr = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
	    float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
	    float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
	    float volume = streamVolumeCurrent / streamVolumeMax;

	    playing = soundPool.play(soundID, volume, volume, 1, 0, 1f);
	    Log.i(TAG, "Can you hear the sound???");
	    return playing;
	}
	
	public SoundPool getSoundPool(){
		return soundPool;
	}
	public int getPlaying(){
		return playing;
	}
	
	/**
	 * Add a sound into SoundPool.
	 * @param soundName an unique identifier to indicate a sound file, example SOUND_NORMAL_FART. 
	 * @param resourceID resource ID in R.java, example R.raw.normal_fart.
	 */
	public void addSound(int soundID, int resourceID){
		soundPoolMap.put(soundID,soundPool.load(context, resourceID, 1));
	}
}
