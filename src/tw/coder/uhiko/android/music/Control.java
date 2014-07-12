package tw.coder.uhiko.android.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Control extends SurfaceView implements SurfaceHolder.Callback, Runnable {
	private SurfaceHolder surfaceHolder;
	private Thread thread;	
	private Canvas canvas;	
	private Handler handler = new Handler();
	
	protected Track track;
	protected Buttom buttom;
	protected Score score;
	protected Target target;
	protected MassageBar massageBar;
	protected RangeCheck rangeCheck;
	protected ScoreLevel scoreLevel;		
	protected DataProcess dataProcess;
	protected Sound sound;
	protected TimerThread timerThread;
	protected UpdateThread updateThread;	
	
	
	public Control(Context context, AttributeSet attrs) {
		super(context, attrs);
		thread = new Thread(this);
		surfaceHolder = this.getHolder();
		surfaceHolder.addCallback(this);		
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		ViewSize.setSize(this.getWidth(), this.getHeight());		
		initView();
		thread.start();
		timerThread.start();
		updateThread.start();		
    }
	
	private void initView() {
		track = new Track();
		buttom = new Buttom();				
		target = new Target();
		massageBar = new MassageBar();
		rangeCheck = new RangeCheck();
		scoreLevel = new ScoreLevel();		
		dataProcess = new DataProcess(target.getSpeed(), 30, buttom.getButtomCY());
		sound = new Sound(getContext());
		timerThread = new TimerThread();
		score = new Score();
		updateThread = new UpdateThread(target, timerThread, dataProcess, scoreLevel, buttom);	    
	}
	
	// ---[Draw]---------------
	
	private void draw() {
		try {
            canvas = surfaceHolder.lockCanvas();
            
            canvas.drawColor(0xff00aeef);
            track.draw(canvas);
            buttom.draw(canvas);
    		target.draw(canvas);
    		massageBar.draw(canvas);
    		score.draw(canvas);
    		scoreLevel.draw(canvas);   
    		
    		
    		
    		/*Paint paintScore = new Paint();
    		paintScore.setColor(0xffcccccc);
    		paintScore.setAntiAlias(true);
    		paintScore.setStyle(Style.FILL);
    		paintScore.setTextAlign(Align.LEFT);
    		paintScore.setTextSize(20);
    		  		
    		canvas.drawText(String.format("%d", timerThread.getCurrentTime()), 20, 20, paintScore);*/
    		
    		
		} catch (Exception ex) {
        } finally {
            if (canvas != null) {
            	surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
	}
	
	// ---[SurfaceViewThread]---------------	
	public void run() {       		
	    draw();
	    
	    handler.postDelayed(this, 1000/60); 
    }
	
	// ---[Touch]---------------
	private int leftIndex = -1, middleIndex = -1, rightIndex = -1;
	
	public boolean onTouchEvent(MotionEvent event) {
		int action = (event.getAction() & MotionEvent.ACTION_MASK);
		int currentIndex;
		int level[] = new int[3];
		boolean touchRange[] = new boolean[3];
		boolean buttomRange[] = new boolean[3];
		
		try {
			switch (action) {
				case MotionEvent.ACTION_DOWN:					
				case MotionEvent.ACTION_POINTER_DOWN:					
					currentIndex = event.getPointerId(( event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT );
					
					for(int i = 0; i < 3; i++) {
						level[i] = scoreLevel.levelStratify(target.getLatestThreeDistance(), i);
						touchRange[i] = rangeCheck.isTouchRange(event.getX(currentIndex), event.getY(currentIndex), i);
						buttomRange[i] = rangeCheck.isButtomRange(target.getLatestThreeDistance(), i);						
					}					
					
					
					if(leftIndex == -1) {	
						
						if(touchRange[0]) {
							buttom.getButtomAnimation().setStart(true, 0);
							
							if(touchRange[0] && buttomRange[0]) {
								scoreLevel.setLevel(level[0]);
								score.plusScore(level[0]);
								scoreLevel.plusCombo();
								target.enptyTargetListField(target.getLatestThreeField()[0]);
								target.resetLatestThreeDistance(0);
								
								scoreLevel.getScoreLevelAnimation().setStart(true);															
								
								leftIndex = currentIndex;
							}
						}
					}
					
					if(middleIndex == -1) {	
						
						if(touchRange[1]) {
							buttom.getButtomAnimation().setStart(true, 1);
							
							if(touchRange[1] && buttomRange[1]) {
								scoreLevel.setLevel(level[1]);
								score.plusScore(level[1]);
								scoreLevel.plusCombo();
								target.enptyTargetListField(target.getLatestThreeField()[1]);
								target.resetLatestThreeDistance(1);
								
								scoreLevel.getScoreLevelAnimation().setStart(true);															
								
								middleIndex = currentIndex;
							}
						}
					}
					
					if(rightIndex == -1) {
						if(touchRange[2]) {
							buttom.getButtomAnimation().setStart(true, 2);
							
							if(touchRange[2] && buttomRange[2]) {
								scoreLevel.setLevel(level[2]);
								score.plusScore(level[2]);
								scoreLevel.plusCombo();
								target.enptyTargetListField(target.getLatestThreeField()[2]);
								target.resetLatestThreeDistance(2);
								
								scoreLevel.getScoreLevelAnimation().setStart(true);															
								
								rightIndex = currentIndex;
							}
						}
					}
					
					break;
					
				case MotionEvent.ACTION_UP:					
				case MotionEvent.ACTION_POINTER_UP:					
					currentIndex = event.getPointerId(( event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT );
					
					if(leftIndex == currentIndex) {						
						
						leftIndex = -1;
					}
					if(middleIndex == currentIndex) {						
					    					    
					    middleIndex = -1;
					}
					if(rightIndex == currentIndex) {							
												
						rightIndex = -1;						
					}

					break;
			}			
		} catch (RuntimeException ex) {}	
		
		return true;
	}
	
	// -------------------------
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
    }
	
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }
}
interface Drawer {
	public void draw(Canvas canvas);
}

