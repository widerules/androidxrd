package com.dell;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DellEmailActivity extends Activity {
	
	final Activity activity = this;
	
	private WebView myWebView;
	private Handler handler = new Handler();
	
    /** Called when the activity is first created. */
    @SuppressWarnings("unused")
	private int getScale(){
        Display display        = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
        int width = display.getWidth(); 
        WebView myWebView = (WebView) findViewById(R.id.webView1);
        int PIC_WIDTH= myWebView.getRight()-myWebView.getLeft();
        Double val = new Double(width)/new Double(PIC_WIDTH);
        val = val * 100d;
        return val.intValue();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the BACK key and if there's history
    	myWebView = (WebView) findViewById(R.id.webView1);
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the BACK key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dell_mail);
        myWebView = (WebView) findViewById(R.id.webView1);
        myWebView.setPadding(0, 0, 0, 0);
        myWebView.setInitialScale(60);
        
        
        /**
         * To bind the JavaScript Class which will be used. 
         */
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new SetContextJavascript(this, handler), "setContextJavascript");

        myWebView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				activity.setTitle("Loading...");
				activity.setProgress(newProgress*100);
				if(newProgress == 100){
					activity.setTitle(R.string.dellmail);
				}
			}
        		
        });
            
        myWebView.loadUrl("file:///android_asset/dellmail.html");
    }
}