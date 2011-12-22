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

	private int resourceID;
	
	public Sound(int soundID, String soundName, int resourceID) {
		super();
		this.soundID = soundID;
		this.soundName = soundName;
		this.resourceID = resourceID;
	}

	public int getSoundID() {
		return soundID;
	}

	public String getSoundName() {
		return soundName;
	}
	
	public int getResourceID(){
		return resourceID;
	}
}
