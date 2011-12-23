package com.diat.adapter;

import java.util.List;

import com.diat.CountActivity;
import com.diat.Fart;
import com.diat.R;
import com.diat.audio.SoundEffect;
import com.diat.entity.FartList;
import com.diat.entity.Sound;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class FartAdapter extends BaseAdapter {

	public static SoundEffect soundManager = null;
	private Button button;
	private Context context;

	private List<Sound> fartList;
	private int delaytime;
	private Fart fart;
//	private String locale;
	
	public FartAdapter(Context paramContext, String paramString)
	{
		this.context = paramContext;
		this.fart = (Fart) paramContext;
	    soundManager = new SoundEffect(paramContext);
	    if (paramString.equals("CN"))
	    {
	      List<Sound> localList1 = FartList.getFartList();
	      this.fartList = localList1;
//	      soundManager.initSounds(paramContext);
	    }
	    else{
	    	List<Sound> localList2 = FartList.getFartListEn();
		    this.fartList = localList2;
	    }
	    for (int i = 1; ; i++)
	    {
	      int j = this.fartList.size();
	      if (i > j)
	      {
	        return;
	      }
	      SoundEffect localSoundManager = soundManager;
	      List<Sound> localList3 = this.fartList;
	      int k = i - 1;
	      int m = localList3.get(k).getSoundID();
	      int r = localList3.get(k).getResourceID();
	      localSoundManager.addSound(m, r);
	    }
	}
	@Override
	public int getCount() {
		return this.fartList.size();
	}

	@Override
	public Object getItem(int position) {
		return Integer.valueOf(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Button localButton1 = null;
//	    if (convertView == null)
//	    {
	      Context localContext = this.context;
	      localButton1 = new Button(localContext);
//	    }
	    for (this.button = localButton1; ; this.button = (Button) convertView)
	    {
	      this.button.setBackgroundResource(R.drawable.buttun_b);
	      Button localButton2 = this.button;
	      final String str = ((Sound)this.fartList.get(position)).getSoundName();
	      final int id = ((Sound)this.fartList.get(position)).getSoundID();
	      localButton2.setText(str);
	      this.button.setTextColor(-1);
//	      Button localButton3 = this.button;
//	      bTouchListener localbTouchListener = new bTouchListener();
//	      localButton3.setOnTouchListener(localbTouchListener);
	      final int pos = position;
	      Button localButton4 = this.button;
	      localButton4.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				SoundEffect localSoundManager = FartAdapter.soundManager;
//			    int i = pos;
//			    int j;
//			    j++;
				int delaySeconds = fart.getDelayTime();
				if(delaySeconds > 0){
					Intent intent = new Intent();
					intent.putExtra("DelayTime", delaySeconds);
					intent.putExtra("SoundID", id);
					intent.putExtra("FartName", str);
					intent.setClass(fart, CountActivity.class);
					fart.startActivity(intent);
				}
				else{
					localSoundManager.playSound(pos + 1);
				}
			}
	    	  
	      });
	      return this.button;
//	      Button localButton5 = (Button)convertView;
	    }
	}
	
//	class bTouchListener implements View.OnTouchListener
//	{
//		@Override
//		public boolean onTouch(View v, MotionEvent event) {
//			int i = 2130837512;
//			switch (event.getAction())
//			{
//				case 2:
//				default:
//				case 0:
//				case 1:
//				case 3:
//			}
//			while (true)
//			{
//				return (Boolean) null;
////				v.setBackgroundResource(2130837513);
////				continue;
////				v.setBackgroundResource(i);
////				continue;
////				v.setBackgroundResource(i);
//			}
//		}
//	}

}
