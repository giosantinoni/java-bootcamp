import javax.sound.sampled.Clip;

/*
 * To make a more complete implementation of the simple factory pattern.
 * Must create a WAV class, for example, that implements the operations of
 * an abstract class called Audio.
 * so it just remains to ask to the factory an audio.. and it returns us an WAV instance.
 * */

public class AudioFactory {
	private Clip wav;

	public Clip getAudio() {
		return wav;
	}

}
