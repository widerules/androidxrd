package com.dell;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;

/**
 * @Filename SetContextJavascript.java
 * @author Victor_Chen1
 * @date Sep 6, 2011
 */
public class SetContextJavascript {

	private WebView webview;
	private Handler handler;
	CookieHandler  chandler = new CookieHandler();
	
	public SetContextJavascript(Context context, Handler handler) {
		this.handler = handler;
		webview = (WebView) ((Activity)context).findViewById(R.id.webView1);
	}

	/**
	 * Pass the data to webview through this method.
	 */
	public void setData(){
		handler.post(new Runnable(){
			public void run(){
				/**
				 * Here to specify the function we want to invoke in JS.
				 */
				String userInfo = "";
				String cookieVal =  chandler.readCookie();
				if(cookieVal != null){
					userInfo = chandler.unencryptCookie(cookieVal);
					String url = "javascript:setUserNameAndPassword('" + userInfo + "')";
					webview.loadUrl(url);
				}
			}
		});
	}
	
	public void getData(final String username, final String password){
		handler.post(new Runnable(){
			public void run(){
				//write cookie into DB.
				chandler.writeCookie(username + "**" + password);
			}
		});
	}
}
