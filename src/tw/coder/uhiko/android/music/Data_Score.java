package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.Log;

public class Data_Score {
	protected Paint paintScore;
	protected int scoreX, scoreY;
	protected int totalScore, displayScore;
	
	public Data_Score() {
		scoreX = ViewSize.getSizeScaling(320 - 70, 'w');
		scoreY = ViewSize.getSizeScaling(20, 'h');
		totalScore = 0;
		displayScore = 0;		
		
		paintScore = new Paint();
		paintScore.setColor(0xffcccccc);
		paintScore.setAntiAlias(true);
		paintScore.setStyle(Style.FILL);
		paintScore.setTextAlign(Align.RIGHT);
		paintScore.setTextSize(ViewSize.getSizeScaling(20, 'h'));
	}

}
