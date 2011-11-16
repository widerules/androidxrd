package com.diat.audio;

import android.media.MediaPlayer;

/**
 * Use Media Player to play big sound effects and also files on SDCard.
 * Please override onDestroy method to kill Media Player in your activity.
 * @Filename LongSoundEffect.java
 * @author Victor_Chen1
 * @date Nov 14, 2011
 */
public class LongSoundEffect {

	public static final String TAG = "Tricky Expert";
	
	public static final String DEFAULT_AUDIO_PATH = "/mnt/sdcard/Cant_Take_My_Eyes_Off_You.mp3";
	private MediaPlayer mediaPlayer;
	private int playbackPosition = 0;
	
	public LongSoundEffect() {
		this.mediaPlayer = new MediaPlayer();
	}
	
	public void playAudio(String url) throws Exception{
		if(mediaPlayer.isPlaying()){
			mediaPlayer.stop();
			mediaPlayer.start();
		}
		mediaPlayer.setDataSource(url);
		mediaPlayer.prepare();
		mediaPlayer.start();
	}
	
	public void pauseAudio(){
		if(mediaPlayer != null){
			playbackPosition = mediaPlayer.getCurrentPosition();
			mediaPlayer.pause();
		}
	}
	
	public void resumeAudio(){
		if(mediaPlayer != null && !mediaPlayer.isPlaying()){
			mediaPlayer.seekTo(playbackPosition);
			mediaPlayer.start();
		}
	}
	
	public void killMediaPlayer(){
		if(mediaPlayer != null){
			try{
				mediaPlayer.release();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
