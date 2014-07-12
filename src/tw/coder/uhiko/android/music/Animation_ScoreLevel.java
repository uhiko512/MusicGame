package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;

public class Animation_ScoreLevel{
	private Paint levelAnimation;
	private int levelFontSize;
	private int delay, fontSizePlus;
	private boolean start;	
	
	public Paint getPaint() {
		return levelAnimation;
	}
	
	public void setStart(boolean state) {
		start = state;
		fontSizePlus = ViewSize.getSizeScaling(32, 'w');
	}
	
	public boolean isStart() {
		return start;
	}
	
	public void animate() {
		if(start) {
			delay += 2;
			fontSizePlus -= ViewSize.getSizeScaling(8, 'w');		
			if(fontSizePlus > 0) {
				levelAnimation.setTextSize(levelFontSize + fontSizePlus);
			}
			
			if(delay > 50) {
				start = false;
				delay = 0;
				fontSizePlus = ViewSize.getSizeScaling(32, 'w');
			}
		}
	}
	
	public Animation_ScoreLevel() {
		start = false;
		delay = 0;
		levelFontSize = ViewSize.getSizeScaling(55, 'w');
		fontSizePlus = ViewSize.getSizeScaling(32, 'w');
		
		levelAnimation = new Paint();
		levelAnimation.setColor(0x95b6deff);
		levelAnimation.setAntiAlias(true);
		levelAnimation.setStyle(Style.FILL);
		levelAnimation.setTextAlign(Align.CENTER);
		levelAnimation.setTextSize(levelFontSize + fontSizePlus);
	}
}