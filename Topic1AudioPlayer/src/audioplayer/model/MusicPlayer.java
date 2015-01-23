package audioplayer.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import audioplayer.exceptions.MusicPlayerException;

public class MusicPlayer implements IMusicPlayer {
	private static final IMusicPlayer instance = new MusicPlayer();

	// the player actually doing all the work
	private Player player;

	// locking object used to communicate with player thread
	private final Object playerLock = new Object();

	// status variable what player thread is doing/supposed to do
	private int playerStatus = NOTSTARTED;

	private File dir;

	private String currentSong;

	private MusicPlayer() {
	}

	public static IMusicPlayer getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#play()
	 */
	@Override
	public void play(String songName) throws MusicPlayerException {
		synchronized (playerLock) {
			newPlayer(songName);

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
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#pause()
	 */
	@Override
	public boolean pause() {
		synchronized (playerLock) {
			if (playerStatus == PLAYING) {
				playerStatus = PAUSED;
			}
			return playerStatus == PAUSED;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#resume()
	 */
	@Override
	public boolean resume() {
		synchronized (playerLock) {
			if (playerStatus == PAUSED) {
				playerStatus = PLAYING;
				playerLock.notifyAll();
			}
			return playerStatus == PLAYING;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#stop()
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#close()
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#getPlayerStatus()
	 */
	@Override
	public int getPlayerStatus() {
		return playerStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#setPlayerStatus(int)
	 */
	@Override
	public void setPlayerStatus(int playerStatus) {
		this.playerStatus = playerStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#newPlayer(java.lang.String)
	 */
	@Override
	public void newPlayer(String input) throws MusicPlayerException {

		try {
			playerStatus = NOTSTARTED;
			player = new Player(new FileInputStream(dir + "/" + input));
		} catch (JavaLayerException | FileNotFoundException e) {
			throw new MusicPlayerException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#getSongs()
	 */
	@Override
	public String[] getSongs() {
		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".mp3");
			}
		};
		return dir.list(filter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#getDir()
	 */
	@Override
	public File getDir() {
		return dir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayer#setDir(java.io.File)
	 */
	@Override
	public void setDir(File dir) {
		this.dir = dir;
	}
}
