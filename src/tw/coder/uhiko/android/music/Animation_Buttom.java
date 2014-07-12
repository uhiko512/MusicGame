package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Animation_Buttom {
	private Paint animation[];
	private int radius[];
	private int alpha[];
	private int circleWidth;
	private boolean start[];
	
	public void setStart(boolean state, int i) {
		start[i] = state;
	}
	
	public boolean[] isStart() {
		return start;
	}
	
	public Paint[] getPaint() {
		return animation;
	}

	public int[] getRadius() {
		return radius;
	}
	
	public int getCircleWidth() {
		return circleWidth;
	}	
	
	
	public void animate() {	
		
		for(int i = 0; i < 3; i++) {
			if(start[i]) {
				radius[i] += ViewSize.getSizeScaling(3, 'w');
				alpha[i] -= 24;
				animation[i].setAlpha(alpha[i]);
				
				if(alpha[i] < 0) {
					start[i] = false;				
					radius[i] = 0;
					alpha[i] = 128;
				}
			} 
		}
	}
	
	public Animation_Buttom() {
		start = new boolean[3];
		radius = new int[3];
		alpha = new int[3];
		
		animation = new Paint[3];
		
		for(int i = 0; i < 3; i++) {
			start[i] = false;
			radius[i] = 0;
			alpha[i] = 128;
			circleWidth = ViewSize.getSizeScaling(5, 'w');
		
			animation[i] = new Paint();
			animation[i].setColor(0xffffffff);
			animation[i].setAlpha(alpha[i]);
			animation[i].setAntiAlias(true);
			animation[i].setStyle(Style.STROKE);
			animation[i].setStrokeWidth(circleWidth);
		}
		
	}
}
