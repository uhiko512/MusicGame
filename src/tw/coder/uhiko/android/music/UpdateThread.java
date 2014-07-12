package tw.coder.uhiko.android.music;

import android.os.Handler;

public class UpdateThread extends Thread {
	private Thread thread;
	private Target target;
	private TimerThread timerThread;
	private DataProcess dataProcess;		
	private ScoreLevel scoreLevel;
	private Buttom buttom;
	private int time;
	private Handler handler = new Handler();
	
	public int getTime() {
		return time;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public UpdateThread(Target target, TimerThread timerThread, DataProcess dataProcess, ScoreLevel scoreLevel, Buttom buttom) {
		this.target = target;
		this.timerThread = timerThread;
		this.dataProcess = dataProcess;			
		this.scoreLevel = scoreLevel;
		this.buttom = buttom;
		time = 30;
		thread = new Thread();
	}
	
    @Override
	public void run() {			
		scoreLevel.isMiss(target);
        
		scoreLevel.getScoreLevelAnimation().animate();		
		buttom.getButtomAnimation().animate();
		
		
		
		if(timerThread.getCurrentTime() >= (dataProcess.getTarget(target.getIndex()) - (buttom.getButtomCY() / target.getSpeed()) * time)) {      	
        	target.addTarget(dataProcess);	                        	         	
        }   			
		
		target.plusTargetDistance();
			
		handler.postDelayed(this, time);
	}
}
