package audioplayer.model;

import java.io.File;

import audioplayer.exceptions.MusicPlayerException;

public interface IMusicPlayer {

	public final static int NOTSTARTED = 0;
	public final static int PLAYING = 1;
	public final static int PAUSED = 2;
	public final static int FINISHED = 3;

	/**
	 * Starts playback (resumes if paused)
	 */
	public abstract void play(String songName) throws MusicPlayerException;

	/**
	 * Pauses playback. Returns true if new state is PAUSED.
	 */
	public abstract boolean pause();

	/**
	 * Resumes playback. Returns true if the new state is PLAYING.
	 */
	public abstract boolean resume();

	/**
	 * Stops playback. If not playing, does nothing
	 */
	public abstract void stop();

	/**
	 * Closes the player, regardless of current state.
	 */
	public abstract void close();

	public abstract int getPlayerStatus();

	public abstract void setPlayerStatus(int playerStatus);

	public abstract void newPlayer(String input) throws MusicPlayerException;

	public abstract String[] getSongs();

	public abstract File getDir();

	public abstract void setDir(File dir);

}