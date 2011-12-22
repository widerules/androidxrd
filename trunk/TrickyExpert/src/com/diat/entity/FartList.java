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
		Sound fart2 = new Sound(2, "文艺青年", R.raw.juice_fart);
		fartList.add(fart2);
		Sound fart3 = new Sound(3, "SB青年", R.raw.long_fart);
		fartList.add(fart3);
		return fartList;
	}
	
	public static List<Sound> getFartListEn(){
		List<Sound> fartList = new ArrayList<Sound>();
		Sound fart1 = new Sound(1, "Normal Youth", R.raw.normal_fart);
		fartList.add(fart1);
		Sound fart2 = new Sound(2, "Art Youth", R.raw.juice_fart);
		fartList.add(fart2);
		Sound fart3 = new Sound(3, "Stupid Youth", R.raw.long_fart);
		fartList.add(fart3);
		return fartList;
	}
	
	public static String[] getItemString(){
		String[] arrayOfString = new String[3];
		arrayOfString[0] = "普通青年";
		arrayOfString[1] = "文艺青年";
		arrayOfString[2] = "SB青年";
		return arrayOfString;
	}
	
	public static String[] getItemStringEn(){
		String[] arrayOfString = new String[3];
		arrayOfString[0] = "normal youth";
		arrayOfString[1] = "art youth";
		arrayOfString[2] = "stupid youth";
		return arrayOfString;
	}
	
	public static int[] getSounds(){
		return new int[]{
			R.id.normal_fart,
			R.id.juicy_fart,
			R.id.long_fart
		};
	}
}
