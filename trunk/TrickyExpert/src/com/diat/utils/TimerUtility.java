package com.diat.utils;

import java.util.Timer;
import java.util.TimerTask;

import com.diat.audio.SoundEffect;

/**
 * Schedule a timer task according to given parameters.
 * @author Victor
 *
 */
public class TimerUtility {

	private Timer timer = new Timer();;
	
	private TimerTask task = null;
	
	private int delaySeconds;
	
//	private SoundEffect soundManager;
	
	public TimerUtility(int delaySeconds, TimerTask task){
		this.delaySeconds = delaySeconds;
		this.task = task;
	}
	
//	private TimerTask getTimerTask(){
//		task = new TimerTask(){
//			@Override
//			public void run() {
//				soundManager.playSound(soundID);
//				// TODO Auto-generated method stub
//			}
//		};
//		return task;
//	}
	
	public void schedule(){
		//One task can only be scheduled one time,
		//so here we need to create a new task before schedule a new task.
//		getTimerTask();
		timer.schedule(task, delaySeconds*1000);
	}
}
