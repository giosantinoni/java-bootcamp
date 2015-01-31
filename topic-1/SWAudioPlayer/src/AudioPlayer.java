import java.io.File;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer implements LineListener {
	private boolean playCompleted;
	private boolean isStopped;
	private boolean isPaused;
	private AudioFactory factory = new AudioFactory();
	private Clip audio = factory.getAudio();

	public void load(String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File audioFile = new File(audioFilePath);

		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

		AudioFormat format = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(Clip.class, format);

		audio = (Clip) AudioSystem.getLine(info);

		audio.addLineListener(this);

		audio.open(audioStream);
	}

	void play() throws IOException {

		audio.start();

		playCompleted = false;
		isStopped = false;

		while (!playCompleted) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
				if (isStopped) {
					audio.stop();
					break;
				}
				if (isPaused) {
					audio.stop();
				} else {
					System.out.println("!!!!");
					audio.start();
				}
			}
		}

		audio.close();

	}

	/**
	 * Stop playing back.
	 */
	public void stop() {
		isStopped = true;
	}

	public void pause() {
		isPaused = true;
	}

	public void resume() {
		isPaused = false;
	}

	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		if (type == LineEvent.Type.STOP) {
			System.out.println("STOP EVENT");
			if (isStopped || !isPaused) {
				playCompleted = true;
			}
		}
	}

	public Clip getAudioClip() {
		return audio;
	}
}