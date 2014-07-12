package tw.coder.uhiko.android.music;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.util.Log;

public class Track extends Data_Track implements Drawer {
	
	@Override
	public void draw(Canvas canvas) {		
		for(int i = 0; i < 3; i++) {
			Rect temp = new Rect(trackX[i], 0, trackX[i] + trackWidth, ViewSize.getHeight());
			
			canvas.drawRect(temp, paintTrack);
		}		
	}
}
