package audioplayer.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import audioplayer.exceptions.MusicPlayerException;

public class MusicPlayer {
	private static final MusicPlayer instance = new MusicPlayer();
	
	public final static int NOTSTARTED = 0;
	public final static int PLAYING = 1;
	public final static int PAUSED = 2;
	public final static int FINISHED = 3;

	// the player actually doing all the work
	private Player player;

	// locking object used to communicate with player thread
	private final Object playerLock = new Object();

	// status variable what player thread is doing/supposed to do
	private int playerStatus = NOTSTARTED;
	
	private File dir;
	
	private MusicPlayer() {}
	
	public static MusicPlayer getInstance() {
		return instance;
	}

	/**
	 * Starts playback (resumes if paused)
	 */
	public void play() throws MusicPlayerException {
		synchronized (playerLock) {
			switch (playerStatus) {
			case NOTSTARTED:
				final Runnable r = new Runnable() {
					public void run() {
						playInternal();
					}
				};
				final Thread t = new Thread(r);
				t.setDaemon(true);
				t.setPriority(Thread.MAX_PRIORITY);
				playerStatus = PLAYING;
				t.start();
				break;
			case PAUSED:
				resume();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Pauses playback. Returns true if new state is PAUSED.
	 */
	public boolean pause() {
		synchronized (playerLock) {
			if (playerStatus == PLAYING) {
				playerStatus = PAUSED;
			}
			return playerStatus == PAUSED;
		}
	}

	/**
	 * Resumes playback. Returns true if the new state is PLAYING.
	 */
	public boolean resume() {
		synchronized (playerLock) {
			if (playerStatus == PAUSED) {
				playerStatus = PLAYING;
				playerLock.notifyAll();
			}
			return playerStatus == PLAYING;
		}
	}

	/**
	 * Stops playback. If not playing, does nothing
	 */
	public void stop() {
		synchronized (playerLock) {
			playerStatus = FINISHED;
			playerLock.notifyAll();
		}
	}

	private void playInternal() {
		while (playerStatus != FINISHED) {
			try {
				if (!player.play(1)) {
					break;
				}
			} catch (final JavaLayerException e) {
				break;
			}
			// check if paused or terminated
			synchronized (playerLock) {
				while (playerStatus == PAUSED) {
					try {
						playerLock.wait();
					} catch (final InterruptedException e) {
						// terminate player
						break;
					}
				}
			}
		}
		close();
	}

	/**
	 * Closes the player, regardless of current state.
	 */
	public void close() {
		synchronized (playerLock) {
			playerStatus = FINISHED;
		}
		try {
			player.close();
		} catch (final Exception e) {
			// ignore, we are terminating anyway
		}
	}

	public int getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(int playerStatus) {
		this.playerStatus = playerStatus;
	}
	
	public void newPlayer(String input) throws MusicPlayerException  {
		
		try {
			playerStatus = NOTSTARTED;
			player = new Player(new FileInputStream(dir + "/" + input));
		} catch (JavaLayerException | FileNotFoundException e) {
			throw new MusicPlayerException(e.getMessage());
		}
	}
	
	public String[] getSongs() {
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {				
				return name.endsWith(".mp3");
			}
		};
		return dir.list(filter);
	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}
}
