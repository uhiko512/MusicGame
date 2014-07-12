package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;

public class Data_MassageBar {
	protected Paint paintMassageBar;
	protected int massageBarHeight;
	
	public Data_MassageBar() {
		massageBarHeight = ViewSize.getSizeScaling(25, 'h');
		
		paintMassageBar = new Paint();
		paintMassageBar.setColor(0xff464646);
		paintMassageBar.setStyle(Style.FILL);
	}
}
