package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Data_Track {
	protected Paint paintTrack;		
	protected int trackX[];
	protected int trackGap;
	protected int trackWidth;	
	
	public Data_Track() {
		trackGap = ViewSize.getSizeScaling(7, 'w');		
		trackWidth = ViewSize.getSizeScaling(87, 'w');
		
		trackX = new int[3];
		for(int i = 0; i < 3; i++) {
			trackX[i] = (ViewSize.getWidth() - trackWidth) / 2 + (trackWidth + trackGap) * (i - 1);
		}	
		
		
		paintTrack = new Paint();
		paintTrack.setColor(0xff2a596c);
		paintTrack.setStyle(Style.FILL);
	}
}
