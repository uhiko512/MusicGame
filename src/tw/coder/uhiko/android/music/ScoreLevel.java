package tw.coder.uhiko.android.music;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.Log;

public class ScoreLevel extends Data_ScoreLevel implements Drawer {
	private Animation_ScoreLevel scoreLevelAnimation = new Animation_ScoreLevel();	
	
	public void setLevel(int Level) {
		this.level = Level;
	}	
	
	public void resetCombo() {
		combo = -1;
	}
	
	public void plusCombo() {
		combo++;
	}
	
	public Animation_ScoreLevel getScoreLevelAnimation() {
		return scoreLevelAnimation;
	}
	
	public void isMiss(Target target) {
		for(int i = 0; i < 3; i++) {
			if(target.getLatestThreeDistance()[i] > ViewSize.getHeight() + buttomExternalRadius) {
				setLevel(4);				
				resetCombo();
				target.enptyTargetListField(target.getLatestThreeField()[i]);
				target.resetLatestThreeDistance(i);
				
				scoreLevelAnimation.setStart(true);				
			}
		}
	}	
	
	public int levelStratify(int[] latestThreeY, int i) {
		int range = Math.abs(latestThreeY[i] - buttomCenterY);
		
		if(range <= buttomExternalRadius * 0.2) {
			return 0;
		} else if(range <= buttomExternalRadius * 0.5) {
			return 1;
		} else if(range <= buttomExternalRadius * 0.8) {
			return 2;
		} else {
			return 3;
		}
	}
	

	@Override
	public void draw(Canvas canvas) {		
		if(scoreLevelAnimation.isStart()) {
			switch (level) {
				case 0:
					canvas.drawText("Prefact", levelX, levelY, scoreLevelAnimation.getPaint());
					break;
				case 1:
					canvas.drawText("Good", levelX, levelY, scoreLevelAnimation.getPaint());
					break;
				case 2:
					canvas.drawText("Cool", levelX, levelY, scoreLevelAnimation.getPaint());
					break;
				case 3:
					canvas.drawText("Bad", levelX, levelY, scoreLevelAnimation.getPaint());
					break;
				case 4:
					canvas.drawText("Miss", levelX, levelY, scoreLevelAnimation.getPaint());
					break;
			}
			
			if(combo > 0) {
				canvas.drawText(String.format("Combo %d", combo), comboX, comboY, paintCombo);
			}			
		}
	}
}
