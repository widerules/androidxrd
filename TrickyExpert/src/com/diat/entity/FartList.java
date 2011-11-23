package com.diat.entity;

import java.util.ArrayList;
import java.util.List;

import com.diat.R;

/**
 * A List for storing fart information.
 * @author Victor
 *
 */
public class FartList {

	public List<Sound> getFartList(){
		List<Sound> fartList = new ArrayList<Sound>();
		Sound fart1 = new Sound(R.id.normal_fart, "普通青年");
		fartList.add(fart1);
		Sound fart2 = new Sound(R.id.juicy_fart, "文艺青年");
		fartList.add(fart2);
		Sound fart3 = new Sound(R.id.long_fart, "傻逼青年");
		fartList.add(fart3);
		return fartList;
	}
	
	public static List<Sound> getFartListEn(){
		List<Sound> fartList = new ArrayList<Sound>();
		Sound fart1 = new Sound(R.id.normal_fart, "Normal Youth");
		fartList.add(fart1);
		Sound fart2 = new Sound(R.id.juicy_fart, "Art Youth");
		fartList.add(fart2);
		Sound fart3 = new Sound(R.id.long_fart, "Stupid Youth");
		fartList.add(fart3);
		return fartList;
	}
	
	public static String[] getItemString(){
		String[] arrayOfString = new String[3];
		arrayOfString[0] = "普通青年";
		arrayOfString[1] = "文艺青年";
		arrayOfString[2] = "傻逼青年";
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
