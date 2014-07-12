package tw.coder.uhiko.android.music;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.Log;

public class Data_ScoreLevel extends Data_Buttom {
	protected Paint paintLevel;
	protected int level;
	protected int levelFontSize;
	protected int levelX, levelY;
	
	protected Paint paintCombo;
	protected int combo; 
	protected int comboFontSize;
	protected int comboX, comboY;
	
	public Data_ScoreLevel() {
		level = -1;
		levelFontSize = ViewSize.getSizeScaling(55, 'w');
		levelX = ViewSize.getWidth() / 2;
		levelY = ViewSize.getHeight() / 2 - ViewSize.getSizeScaling(50, 'h');	
		
		paintLevel = new Paint();
		paintLevel.setColor(0x95b6deff);
		paintLevel.setAntiAlias(true);
		paintLevel.setStyle(Style.FILL);
		paintLevel.setTextAlign(Align.CENTER);
		paintLevel.setTextSize(levelFontSize);		
		
		combo = -1;
		comboFontSize = ViewSize.getSizeScaling(30, 'w');
		comboX = levelX;
		comboY = ViewSize.getHeight() / 2 - ViewSize.getSizeScaling(10, 'h');
		
		
		paintCombo = new Paint();
		paintCombo.setColor(0x95b6deff);
		paintCombo.setAntiAlias(true);
		paintCombo.setStyle(Style.FILL);
		paintCombo.setTextAlign(Align.CENTER);
		paintCombo.setTextSize(comboFontSize);

	}
}
