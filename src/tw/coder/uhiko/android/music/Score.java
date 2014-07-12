package tw.coder.uhiko.android.music;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Score extends Data_Score implements Drawer {	
	
	public void plusScore(int level) {
		
		switch (level) {
			case 0:
				totalScore += 500;
				break;
			case 1:
				totalScore += 350;
				break;
			case 2:
				totalScore += 155;
				break;
			case 3:
				totalScore += 55;
				break;			
		}
	}
	
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawText("Score:", scoreX, scoreY, paintScore);
		
		if(totalScore > displayScore) {
			displayScore += 7;
		}
			
		canvas.drawText(String.format("%d", displayScore), ViewSize.getWidth(), scoreY, paintScore);
	}
}
