package tw.coder.uhiko.android.music;

public class ViewSize {	
	private static int width;
	private static int height;	
	
	public static int getSizeScaling(double value, char mode) {		
		if(mode == 'h') {
			return (int)((value / 480) * height);
		} else {			
			return (int)((value / 320) * width);
		}		
	}	

	public static int getWidth() {
		return width;
	}	

	public static int getHeight() {
		return height;
	}
	
	public static void setSize(int viewWidth, int viewHeight) {
		ViewSize.width = viewWidth;
		ViewSize.height = viewHeight;		
	}
}
