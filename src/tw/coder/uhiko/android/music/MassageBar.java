package tw.coder.uhiko.android.music;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;

public class MassageBar extends Data_MassageBar implements Drawer {
		
	@Override
	public void draw(Canvas canvas) {		
		Rect temp = new Rect(0, 0, ViewSize.getWidth(), massageBarHeight);
		
		canvas.drawRect(temp, paintMassageBar);		
	}
}
