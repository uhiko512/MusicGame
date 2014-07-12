package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Data_Buttom extends Data_Track {
	protected Paint paintButtom;	
	protected int buttomExternalRadius;
	protected int buttomInternalRadius;
	protected int buttomCircleWidth;
	protected int buttomCenterX[], buttomCenterY;
	
	public Data_Buttom() {
		buttomExternalRadius = ViewSize.getSizeScaling(35, 'w');
		buttomInternalRadius = ViewSize.getSizeScaling(22, 'w');
		buttomCircleWidth = ViewSize.getSizeScaling(2, 'w');
				
		buttomCenterX = new int[3];
		for(int i = 0; i < 3; i++) {
			buttomCenterX[i] = trackX[i] + trackWidth / 2;				
		}			
		
		buttomCenterY = ViewSize.getHeight() - ViewSize.getSizeScaling(50, 'h');
		
		
		paintButtom = new Paint();
		paintButtom.setColor(0xff00aeef);
		paintButtom.setAntiAlias(true);
		paintButtom.setStyle(Style.STROKE);
		paintButtom.setStrokeWidth(buttomCircleWidth);
	}
}
