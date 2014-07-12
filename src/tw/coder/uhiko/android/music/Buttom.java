package tw.coder.uhiko.android.music;

import android.graphics.Canvas;

public class Buttom extends Data_Buttom implements Drawer {
	private Animation_Buttom buttomAnimation = new Animation_Buttom();
	
	public Animation_Buttom getButtomAnimation() {
		return buttomAnimation;
	}
	
	public int getButtomRadius() {
		return buttomExternalRadius;
	}
	
	public int[] getButtomCX() {
		return buttomCenterX;
	}
	
	public int getButtomCY() {
		return buttomCenterY;
	}
	
	
	@Override
	public void draw(Canvas canvas) {		
		
		for(int i = 0; i < 3; i++) {
			if(buttomAnimation.isStart()[i]) {
				canvas.drawCircle(buttomCenterX[i], buttomCenterY, buttomExternalRadius + buttomAnimation.getRadius()[i] + buttomAnimation.getCircleWidth() / 2, buttomAnimation.getPaint()[i]);
			}
			canvas.drawCircle(buttomCenterX[i], buttomCenterY, buttomExternalRadius + buttomCircleWidth / 2, paintButtom);		
			canvas.drawCircle(buttomCenterX[i], buttomCenterY, buttomInternalRadius + buttomCircleWidth / 2, paintButtom);
		}
	}	
}
