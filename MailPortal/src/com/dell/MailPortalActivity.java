package com.dell;

import com.dell.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * @author Victor_Chen1
 * @date Aug 30, 2011
 */
public class MailPortalActivity extends Activity {
	
	private ImageButton dellmail;
	private ImageButton gmail;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dellmail = (ImageButton) findViewById(R.id.dellmail);
        gmail    = (ImageButton) findViewById(R.id.gmail);
        
        dellmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gotoDellmail();
			}
		});
        
        gmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gotoGmail();
			}
		});
    }
    
    public void gotoDellmail(){
    	Intent intent = new Intent(this, DellEmailActivity.class);
    	startActivity(intent);
    }
    
    public void gotoGmail(){
//    	Intent intent = new Intent(this, Gmail.class);
//    	startActivity(intent);
    }
}