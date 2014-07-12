package tw.coder.uhiko.android.music;

import java.util.Timer;

import android.os.Handler;
import android.util.Log;

public class TimerThread extends Thread{	
	private long spend, start;
	private Handler handlerTime = new Handler();
	
	
	public long getCurrentTime() {
		return spend;
	}
	
	public TimerThread() {			
		start = System.currentTimeMillis();
	}
	
	@Override
	public void run() {		
		spend = System.currentTimeMillis() - start;
		
		handlerTime.postDelayed(this, 1);		
	}
}
