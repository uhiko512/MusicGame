package tw.coder.uhiko.android.music;

import java.io.BufferedReader;
import java.io.FileReader;

import android.util.Log;

public class DataProcess {
	String musicData = "";			
	
	public int getTarget(int i) {
		
		if(i < musicData.length() / 13) {
			return Integer.valueOf(musicData.substring(4 + 13 * i, 10 + 13 * i));
		} else {
			return 0;
		}
	}
	
	public String addTargetField(int i) {
		
		if(i < musicData.length() / 13) {
			return musicData.substring(10 + (13 * i), 13 + (13 * i));
		} else {
			return null;
		}		
	}
	
	public String addTargetDistance(int i) {
		String temp = "";
		
		if(i < musicData.length() / 13) {
			for(int j = 0; j < 3; j++) {
				temp += ("000" + musicData.substring((10 + j) + (13 * i), (11 + j) + (13 * i)));
			}
			
			return temp;
		} else {
			return null;
		}		
	}
	
	public DataProcess(int speed, int time, int distance) {
		
		try {
			FileReader fileReader = new FileReader("/sdcard/MusicData.txt");		
			BufferedReader bufferedReader = new BufferedReader(fileReader);			
	        String temp;
        
	        do {
		        temp=bufferedReader.readLine();
		        musicData += temp;
	        } while(temp != null);
			
		} catch(Exception e) {
	        e.printStackTrace();
		}	
	}
}
