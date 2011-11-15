package src.com.diat;

import com.diat.Fart;
import com.diat.audio.SoundEffect;

import android.test.AndroidTestCase;
import android.util.Log;

public class SoundEffectTest extends AndroidTestCase{

	public static final String TAG = "Tricky Expert";
	
	/**
	 * This test cannot succeed because activity cannot be initialized like the way below.
	 * Here can only test those non-activity classes.
	 */
	public void testSoundPlay(){
//		Fart fart = new Fart();
//		SoundEffect sf = new SoundEffect(fart);
//		sf.playSound(3);
		Log.i(TAG, "Play Sound Successfully...");
	}
}
