package com.diat.entity;

/**
 * Entity class for Sound.
 * Dynamically show the fart name or other resources according to given sound ID.
 * @author Victor
 *
 */
public class Sound {

	private int soundID;
	
	private String soundName;

	
	public Sound(int soundID, String soundName) {
		super();
		this.soundID = soundID;
		this.soundName = soundName;
	}

	public int getSoundID() {
		return soundID;
	}

	public String getSoundName() {
		return soundName;
	}
}
