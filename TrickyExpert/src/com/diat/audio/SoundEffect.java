package com.diat.audio;

import java.util.HashMap;

import com.diat.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

/**
 * Using SoundPool to implement sound play.
 * @Filename SoundEffect.java
 * @author Victor_Chen1
 * @date Nov 8, 2011
 */
public class SoundEffect {

	public static final String TAG = "Tricky Expert";
	
	public static final int SOUND_NORMAL_FART = 1;
	public static final int SOUND_LONG_FART = 2;
	public static final int SOUND_JUICY_FART = 3;
	
	private SoundPool soundPool;
	private HashMap<Integer, Integer> soundPoolMap;
	private Context context;
	private int playing;

	
	public SoundEffect(Context context) {
		this.context = context;
		soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
	    soundPoolMap = new HashMap<Integer, Integer>();
	    initSounds();
	}

	private void initSounds() {
	     soundPoolMap.put(SOUND_NORMAL_FART, soundPool.load(context, R.raw.normal_fart, 1));
	     soundPoolMap.put(SOUND_LONG_FART, soundPool.load(context, R.raw.long_fart, 1));
	     soundPoolMap.put(SOUND_JUICY_FART, soundPool.load(context, R.raw.juice_fart, 1));
	}

	public int playSound(int sound) {
	   
	    AudioManager mgr = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
	    float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
	    float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);   
	    float volume = streamVolumeCurrent / streamVolumeMax;

	    playing = soundPool.play(sound, volume, volume, 1, 0, 1f);
	    Log.i(TAG, "Can you hear the sound???");
	    return playing;
	}

	public void normalFart() {
	    playSound(SOUND_NORMAL_FART);
	}
	public void longFart() {
	    playSound(SOUND_LONG_FART);
	}
	public void jucieFart() {
	    playSound(SOUND_JUICY_FART);
	}

	
	public SoundPool getSoundPool(){
		return soundPool;
	}
	public int getPlaying(){
		return playing;
	}
}
