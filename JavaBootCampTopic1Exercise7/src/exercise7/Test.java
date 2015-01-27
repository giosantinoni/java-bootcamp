package exercise7;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Test {

	public static void main(String[] args){
		
		AudioPlayer ap = new AudioPlayer();
		String filePath = "C:/Sounds/Ring05.wav";
		//System.out.println(filePath);
		
		
		
		// Load Audio File
		try {
			ap.load(filePath);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Play Audio File
		try {
			ap.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
