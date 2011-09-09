package com.dell;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

/**
 * @Filename CookieHandler.java
 * @author Victor_Chen1
 * @date Sep 5, 2011
 */
public class CookieHandler extends Activity {

	public static final String TAG = "Dell Mail Portal -> Cookie Test...";
	
	/**
	 * I really don't know what to set here. If set url to https://mymail.dell.com,then cannot get my cookies.
	 */
	public final String URL = "https://mymail.dell.com/OWA";
	public static SQLiteDatabase mDatabase = null;
	
	private static final String DATABASE_FILE = "webview.db";
	private static final String DATABASE_PATH = "data/data/com.dell/databases/";
	private static final String COOKIES_NAME_COL = "name";
	private static final String COOKIES_VALUE_COL = "value";
	private static final String COOKIES_DOMAIN_COL = "domain";
	private static final String COOKIES_PATH_COL = "path";
	private static final String COOKIES_EXPIRES_COL = "expires";
	private static final String COOKIES_SECURE_COL = "secure";
	
	/**
	 * Read all cookies from 
	 * @param url
	 */
	public String readCookie(){
		
		createTable();
		
		String query = "select * from cookies where name = 'DellMail'";
		Cursor cursor = mDatabase.rawQuery(query, null);
		String cookieVal = null;
		if(cursor.moveToFirst() != false){
			//Here as by default there is only one cookie record named "DellMail" in DB, so only retrieve the first value.
			int index = cursor.getColumnIndex("value");
			cookieVal = cursor.getString(index);
			Log.i(TAG, cookieVal);
		}
		cursor.close();
		mDatabase.close();
		return cookieVal;
		
//		try{
//			DefaultHttpClient httpclient =new DefaultHttpClient();
//			HttpGet httpget = new HttpGet(url);
//			HttpResponse response = httpclient.execute(httpget);
//			HttpEntity entity = response.getEntity();
//			List<Cookie> cookies = httpclient.getCookieStore().getCookies();
//			if(entity != null){
//				entity.consumeContent();
//			}
//			if(cookies.isEmpty()){
//				Log.d(TAG, "No Cookies found...");
//				return null;
//			}
//			else{
//				for(int i = 0; i < cookies.size(); i++){
//					Log.d(TAG, cookies.get(i).getDomain());
//					Log.d(TAG, cookies.get(i).getName());
//					Log.d(TAG, cookies.get(i).getPath());
//					Log.d(TAG, cookies.get(i).getValue());
//					Log.d(TAG, cookies.get(i).toString());
//					
//					if(cookies.get(i).getName().equals("DellMail")){
//						return cookies.get(i);
//					}
//				}
//			}
//			httpclient.getConnectionManager().shutdown();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	 }
	
	/**
	 * Create a Table named 'cookies' in webview DB. However, there is already a table in webview DB named cookies which created by system by default.
	 * So the code block below is commented.  
	 */
	public void createTable(){
		mDatabase = SQLiteDatabase.openOrCreateDatabase(DATABASE_PATH + DATABASE_FILE, null);
		if(mDatabase != null){
			mDatabase.execSQL("CREATE TABLE IF NOT EXISTS cookies "
					+ " (_id INTEGER PRIMARY KEY, "
					+ COOKIES_NAME_COL + " TEXT, " + COOKIES_VALUE_COL
					+ " TEXT, " + COOKIES_DOMAIN_COL + " TEXT, "
					+ COOKIES_PATH_COL + " TEXT, " + COOKIES_EXPIRES_COL
					+ "INTEGER, " + COOKIES_SECURE_COL + " INTEGER" + ");"); 
			mDatabase.execSQL("CREATE INDEX IF NOT EXISTS cookiesIndex ON "+ "cookies" + "(path)");
		}
	}
	
	/**
	 * Write cookies to table 'cookies' in  DB 'webview'.
	 */
	public void writeCookie(String cookieString){
		ContentValues acookie = new ContentValues();
		acookie.put(COOKIES_DOMAIN_COL, "mymail.dell.com");
		acookie.put(COOKIES_PATH_COL, "/OWA");
		acookie.put(COOKIES_NAME_COL, "DellMail");
		
		String encryptCookie = encryptCookie(cookieString);
		acookie.put(COOKIES_VALUE_COL, encryptCookie);
		
		String existCookie = readCookie();
		//To place this line of code here is so important. As in the last of readCookie(), database connection is closed, 
		//so here we need to explicitly open the database connection. 
		createTable();
		if(existCookie == null){
			mDatabase.insert("cookies", null, acookie);
		}
		else{
			//Since program designed to write cookie into DB every time we click Sign-in. 
			//So here need a statement to tell whether username or password is the same with existing ones or not.
			//Here another assertion is that one machine only set cookie for one person. In the future we can enhance it for 
			//multiple people in the same machine. 
			if(!encryptCookie.equals(existCookie)){
				mDatabase.update("cookies", acookie, "name='DellMail'", null);
			}
		}
		mDatabase.close();
	}

	/**
	 * Here we need to encrypt cookie value to avoid plain-text to be displayed.
	 * Here I only transfer string into hex code. Later in the future we can choose a better encrypt method.
	 * @param cookieString
	 */
	public String encryptCookie(String cookieString){
		return stringToHex(cookieString);
	}
	
	public String unencryptCookie(String cookieString){
		return hexToString(cookieString);
	}
	
	/**
	 * Simple encode cookie value string to hex string to avoid plain-text.
	 * @param str
	 * @return
	 */
	public String stringToHex(String str){
		byte[] b = str.getBytes();
		String hexStr = "";
		for(int i = 0; i < b.length; i++){
			String hex = Integer.toHexString(b[i] & 0xFF);
		    if (hex.length() == 1) {
		        hex = "0" + hex;
		    }
		    hexStr += hex.toUpperCase(); 
		}
		Log.d(TAG, "Hex String: " + hexStr);
		return hexStr;
	}
	
	/**
	 * Decode hex string into normal string.
	 * @param hexStr
	 * @return
	 */
	public String hexToString(String hexStr){
		int len = hexStr.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
		data[i / 2] = (byte) ((Character.digit(hexStr.charAt(i), 16) << 4) + Character.digit(hexStr.charAt(i + 1), 16));
		}
		String str = new String(data);
		Log.d(TAG, "String:" + str);
		return str;
	}

}
