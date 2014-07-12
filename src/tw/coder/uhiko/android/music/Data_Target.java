package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Data_Target extends Data_Buttom {
	protected Paint paintTarget;
	protected int targetIndex;
	protected int targetSpeed;
	protected int distanceValueDigit;
	protected int numberofFields;
	protected int latestThreeField[], latestThreeDistance[];
	protected String targetListField, targetListDistance;
	
	public Data_Target() {		
		targetIndex = 0;
		
		targetSpeed = 13;
		
		distanceValueDigit = 4;
		
		numberofFields = 3;
		
		latestThreeField = new int[3];
		latestThreeDistance = new int[3];	
		
		targetListField = "";
		targetListDistance = "";	
		
		
		paintTarget = new Paint();
		paintTarget.setColor(0xffd4dee2);
		paintTarget.setAntiAlias(true);
		paintTarget.setStyle(Style.STROKE);			
		paintTarget.setStrokeWidth(buttomExternalRadius - buttomInternalRadius);
	}

}
