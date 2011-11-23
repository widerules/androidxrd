package com.diat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class CountActivity extends Activity {

	private int delaySeconds;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.countback);
		TextView countback = (TextView) findViewById(R.id.countback);
		TextView fartname = (TextView) findViewById(R.id.count_fart_name);
		TextView hint = (TextView) findViewById(R.id.count_hint);
		
		Intent intent = getIntent();
		int m = 0;
		this.delaySeconds = intent.getIntExtra("DelayTime",m);
		
		Handler handler = new Handler();
		
	}

	private class MyHandler extends Handler implements Runnable{

		@Override
		public void run() {
			if(delaySeconds > 0){
				
			}
			
			if(delaySeconds == 0){
				
			}
		}
	}
}
