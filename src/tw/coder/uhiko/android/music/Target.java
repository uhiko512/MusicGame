package tw.coder.uhiko.android.music;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.Region.Op;
import android.util.Log;

public class Target extends Data_Target implements Drawer {
	
	public int getSpeed() {
		return targetSpeed;
	}
	
	public int getIndex() {
		return targetIndex;
	}
	
	public int[] getLatestThreeField() {		
		return latestThreeField;
	}
	
	public int[] getLatestThreeDistance() {
		for(int j = 0; j < 12; j += 4) {		
			for(int i = 0; i < targetListDistance.length(); i += 12) {
	    		String temp = targetListField.substring((j / 4) + (i / 4), ((j / 4) + 1) + (i / 4));            		
	    		
	    		if(Integer.valueOf(temp) == 1) { 	    				    				
    				latestThreeDistance[j / 4] = Integer.valueOf(targetListDistance.substring(j + i, (j + 4) + i));	    				
    				latestThreeField[j / 4] = (j / 4) + (i / 4);  				
    				
    				break;	    			
	    		}
	    	} 
		} 
		
		return latestThreeDistance;
	}
	
	public void enptyTargetListField(int num) {
		targetListField = targetListField.substring(0, num) + 0 + targetListField.substring(num + 1);
	}
	
	public void resetLatestThreeDistance(int index) {
		latestThreeDistance[index] = 0;		
	}
	
	public void plusTargetDistance() {		
		for(int i = 0; i < targetListDistance.length(); i += 4) {
    		String temp = targetListField.substring(0 + (i / 4), 1 + (i / 4));            		
    		
    		if(Integer.valueOf(temp) == 1) {
    			if(Integer.valueOf(targetListDistance.substring(0 + i, 4 + i)) <= ViewSize.getHeight() + buttomExternalRadius) {
	    			temp = targetListDistance.substring(0 + i, 4 + i);
	    			temp = temp.replaceFirst(temp, String.format("%04d", Integer.valueOf(temp) + targetSpeed));
	    			
	    			targetListDistance = targetListDistance.substring(0, 0 + i) + temp + targetListDistance.substring(4 + i);	    			
    			}
    		}
    	}
	}	
		
	public void addTarget(DataProcess dataProcess) {
		
		if(dataProcess.addTargetField(targetIndex) != null) {
        	targetListField += dataProcess.addTargetField(targetIndex);      	
        	targetListDistance += dataProcess.addTargetDistance(targetIndex);        	
        	targetIndex++;
        	
		}
	}
	
	
	@Override
	public void draw(Canvas canvas) {		
		int buttomRadiusDifference = buttomExternalRadius - buttomInternalRadius;
		
		for(int i = 0; i < targetListDistance.length(); i += 4) {			
			String temp = targetListField.substring(0 + (i / 4), 1 + (i / 4));	
				
			if(Integer.valueOf(temp) == 1) {
				temp = targetListDistance.substring(0 + i, 4 + i);
				
				if(Integer.valueOf(temp) <= ViewSize.getHeight() + buttomExternalRadius) {					
					canvas.drawCircle(buttomCenterX[(i / 4) - 3 * (i / 12)], Integer.valueOf(temp), buttomInternalRadius + buttomRadiusDifference / 2, paintTarget);
				}				
			}			
		}
		
	}	
}
