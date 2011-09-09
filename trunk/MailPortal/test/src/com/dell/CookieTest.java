package src.com.dell;

import com.dell.CookieHandler;

import android.test.AndroidTestCase;
import android.util.Log;

public class CookieTest extends AndroidTestCase{
	
	public static final String TAG = "Dell Mail Portal -> Cookie Test...";
	
	public void testDeleteRow(){
		CookieHandler ch = new CookieHandler();
		ch.createTable();
		CookieHandler.mDatabase.execSQL("delete from cookies where name = 'DellMail'");
		Log.i(TAG, "Delete Successful...");
	}

	public void testEncrypt(){
		String str1 = "617369612D706163696669632A2A446179627265616B31";
		String str2 = "617369612D706163696669635C766963746F725F6368656E312A2A446179627265616B31";
		CookieHandler ch = new CookieHandler();
		Log.i(TAG,ch.unencryptCookie(str1));
		Log.i(TAG,ch.unencryptCookie(str2));
	}
}
