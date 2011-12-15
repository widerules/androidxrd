package com.diat;

import com.diat.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Main page for Tricky Expert.
 * @Filename TrickyExpertActivity.java
 * @author Victor_Chen1
 * @date Nov 1, 2011
 */
public class TrickyExpertActivity extends Activity {
    
	private Button fart;
	private ImageButton banger;
	private Button alarm;
	private ImageButton brokenscreen;
	private ImageButton cockroach;
	private ImageButton ghost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        fart = (Button) findViewById(R.id.fart);
        banger = (ImageButton) findViewById(R.id.banger);
        alarm = (Button) findViewById(R.id.alarm);
        brokenscreen = (ImageButton) findViewById(R.id.brokenscreen);
        cockroach = (ImageButton) findViewById(R.id.cockroach);
        ghost = (ImageButton) findViewById(R.id.ghost);
        
        fart.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				gotoFart();
			}
		});
        
        banger.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				gotoBanger();
			}
		});
        
        alarm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				gotoAlarm();
			}
		});
        
        brokenscreen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				gotoBrokenscreen();
			}
		});
        
        cockroach.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				gotoCockroach();
			}
		});
        
        ghost.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//				gotoGhost();
			}
		});
    }
    
    public void gotoFart(){
    	Intent intent = new Intent(this, Fart.class);
    	startActivity(intent);
    }
    
    public void gotoAlarm(){
    	Intent intent = new Intent(this, Alarm.class);
    	startActivity(intent);
    }
    
    public void gotoBanger(){
    	Intent intent = new Intent(this, Banger.class);
    	startActivity(intent);
    }
    
    public void gotoBrokenscreen(){
    	Intent intent = new Intent(this, BrokenScreenInit.class);
    	startActivity(intent);
    }
    
    public void gotoCockroach(){
    	Intent intent = new Intent(this, Cockroach.class);
    	startActivity(intent);
    }
    
    public void gotoGhost(){
    	Intent intent = new Intent(this, Ghost.class);
    	startActivity(intent);
    }
}