package com.diat.entity;

import java.util.ArrayList;
import java.util.List;

import com.diat.R;

/**
 * A List for storing fart sound.
 * @author Victor
 *
 */
public class FartList {

	public static List<Sound> getFartList(){
		List<Sound> fartList = new ArrayList<Sound>();
		Sound fart1 = new Sound(1, "普通青年", R.raw.normal_fart);
		fartList.add(fart1);
		Sound fart2 = new Sound(2, "速战速决", R.raw.fastshoot);
		fartList.add(fart2);
		Sound fart3 = new Sound(3, "文艺青年", R.raw.juice_fart);
		fartList.add(fart3);
		Sound fart4 = new Sound(4, "机车小子", R.raw.motorcycle);
		fartList.add(fart4);
		Sound fart5 = new Sound(5, "213青年", R.raw.long_fart);
		fartList.add(fart5);
		Sound fart6 = new Sound(6, "有恃无恐", R.raw.fearless);
		fartList.add(fart6);
		Sound fart7 = new Sound(7, "爆竹声声", R.raw.firecracker);
		fartList.add(fart7);
		Sound fart8 = new Sound(8, "分而治之", R.raw.repressed);
		fartList.add(fart8);
		Sound fart9 = new Sound(9, "青蛙王子", R.raw.froggy);
		fartList.add(fart9);
		Sound fart10 = new Sound(10, "淑女风范", R.raw.ladystyle);
		fartList.add(fart10);
		return fartList;
	}
	
	public static List<Sound> getFartListEn(){
		List<Sound> fartList = new ArrayList<Sound>();
		Sound fart1 = new Sound(1, "Normal Youth", R.raw.normal_fart);
		fartList.add(fart1);
		Sound fart2 = new Sound(2, "Fast Fart", R.raw.fastshoot);
		fartList.add(fart2);
		Sound fart3 = new Sound(3, "Art Youth", R.raw.juice_fart);
		fartList.add(fart3);
		Sound fart4 = new Sound(4, "Motor Boy", R.raw.motorcycle);
		fartList.add(fart4);
		Sound fart5 = new Sound(5, "Stupid Youth", R.raw.long_fart);
		fartList.add(fart5);
		Sound fart6 = new Sound(6, "Fearless", R.raw.fearless);
		fartList.add(fart6);
		Sound fart7 = new Sound(7, "Firecracker", R.raw.firecracker);
		fartList.add(fart7);
		Sound fart8 = new Sound(8, "Repressed", R.raw.repressed);
		fartList.add(fart8);
		Sound fart9 = new Sound(9, "Froggy", R.raw.froggy);
		fartList.add(fart9);
		Sound fart10 = new Sound(10, "Ladystyle", R.raw.ladystyle);
		fartList.add(fart10);
		return fartList;
	}
	
	public static String[] getItemString(){
		String[] arrayOfString = new String[10];
		arrayOfString[0] = "普通青年";
		arrayOfString[1] = "速战速决";
		arrayOfString[2] = "文艺青年";
		arrayOfString[3] = "机车小子";
		arrayOfString[4] = "213青年";
		arrayOfString[5] = "有恃无恐";
		arrayOfString[6] = "爆竹声声";
		arrayOfString[7] = "分而治之";
		arrayOfString[8] = "青蛙王子";
		arrayOfString[9] = "淑女风范";
		return arrayOfString;
	}
	
	public static String[] getItemStringEn(){
		String[] arrayOfString = new String[10];
		arrayOfString[0] = "Normal Youth";
		arrayOfString[1] = "Fast Fart";
		arrayOfString[2] = "Art Youth";
		arrayOfString[3] = "Motor Boy";
		arrayOfString[4] = "Stupid Youth";
		arrayOfString[5] = "Fearless";
		arrayOfString[6] = "Firecracker";
		arrayOfString[7] = "Repressed";
		arrayOfString[8] = "Froggy";
		arrayOfString[9] = "Ladystyle";
		return arrayOfString;
	}
	
	public static int[] getSounds(){
		return new int[]{1,2,3,4,5,6,7,8,9,10};
	}
}
