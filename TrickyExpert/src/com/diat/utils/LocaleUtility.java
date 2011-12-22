package com.diat.utils;

import android.content.Context;

/**
 * Utility to get the Locale of a computer.
 * @author Victor
 *
 */
public class LocaleUtility {

	public static final String TAG = "Tricky Expert";
	
	private Context context;
	
	private String locale;

	public LocaleUtility(Context context){
		this.context = context;
	}
	
	public String getLocale() {
		locale = context.getResources().getConfiguration().locale.getCountry();
		return locale;
	}
	
}
