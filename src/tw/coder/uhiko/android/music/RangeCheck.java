package tw.coder.uhiko.android.music;

public class RangeCheck extends Data_Buttom {	
	
	public boolean isTouchRange(float currentX, float currentY,  int i) {
		return Math.sqrt(Math.pow(currentX - buttomCenterX[i], 2) + Math.pow(currentY - buttomCenterY, 2)) <= buttomExternalRadius ? true : false;
	}
	
	public boolean isButtomRange(int[] latestThreeY, int i) {		
		return Math.abs(latestThreeY[i] - buttomCenterY) <= buttomExternalRadius ? true : false;
	}
}
