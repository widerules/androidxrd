package src.com.diat;

import com.diat.Fart1;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * This class is used to test activity classes.
 * Alternative choice for activity test is to extends ActivityUnitTestCase which can 
 * provide a more infrastructure-dependent environment.
 * @Filename MediaPlayerActivityTest.java
 * @author Victor_Chen1
 * @date Nov 14, 2011
 */
public class MediaPlayerActivityTest extends
		ActivityInstrumentationTestCase2<Fart1> {

	private Fart1 fart1;
	private Button mStart;
	private Button mPause;
	private Button mResume;
	
	public MediaPlayerActivityTest() {
		super("com.diat.Fart1", Fart1.class);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	    setActivityInitialTouchMode(false);

	    fart1 = this.getActivity();
	    
	    mStart = (Button) fart1.findViewById(com.diat.R.id.start);
	    mPause = (Button) fart1.findViewById(com.diat.R.id.pause);
	    mResume = (Button) fart1.findViewById(com.diat.R.id.resume);
	}

	public void testPreconditions(){
		assertNotNull(fart1);
		assertNotNull(mStart);
		assertNotNull(mPause);
		assertNotNull(mResume);
	}
	
	public void testSubLaunch(){
		
//		getInstrumentation().runOnMainSync(new Runnable() {
//			 
//			@Override
//			public void run() {
//				mStart.requestFocus();
//				mStart.performClick();
//			}
//		});
//		
//		sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		getActivity().runOnUiThread(new Runnable() {
			 public void run() {
				 mStart.requestFocus();
				 mStart.performClick();
			 }
			 });
			 // wait for the request to go through
			 getInstrumentation().waitForIdleSync();
			 
			 assertTrue(mStart.isFocused());
	}
	
}
