package src.com.diat;

import com.diat.Fart;
import com.diat.audio.SoundEffect;

import android.test.AndroidTestCase;
import android.util.Log;

public class SoundEffectTest extends AndroidTestCase{

	public static final String TAG = "Tricky Expert";
	
	/**
	 * This test cannot succeed because cannot get Context of the application in test mode.
	 */
	public void testSoundPlay(){
		Fart fart = new Fart();
		SoundEffect sf = new SoundEffect(fart);
		sf.normalFart();
		Log.i(TAG, "Play Sound Successfully...");
	}
}
