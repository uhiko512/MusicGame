package tw.coder.uhiko.android.music;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound {
	private MediaPlayer mediaPlayer;	
	
	public Sound(Context context) {
		mediaPlayer = new MediaPlayer();
		
		try {
			mediaPlayer.setDataSource("/sdcard/MusicData.mp3");
			mediaPlayer.prepare();
			mediaPlayer.start();//*
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer media)	{
				media.release();
			}
		});	
	}

}
