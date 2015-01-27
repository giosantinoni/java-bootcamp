package audioplayer.model;

import java.io.File;

import audioplayer.exceptions.MusicPlayerException;

public class MusicPlayerFacade implements IMusicPlayerFacade {
	private IMusicPlayer musicPlayer;
	private static final IMusicPlayerFacade instance = new MusicPlayerFacade();

	private MusicPlayerFacade() {
		musicPlayer = MusicPlayer.getInstance();
	}

	public static IMusicPlayerFacade getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayerFacade#playSong(java.lang.String)
	 */
	@Override
	public void playSong(String songName) throws MusicPlayerException {
		if (musicPlayer.getPlayerStatus() != MusicPlayer.PAUSED) {
			musicPlayer.close();
			musicPlayer.play(songName);
		} else
			musicPlayer.resume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayerFacade#stopSong()
	 */
	@Override
	public void stopSong() {
		musicPlayer.stop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayerFacade#pauseSong()
	 */
	@Override
	public void pauseSong() {
		musicPlayer.pause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayerFacade#getSongs()
	 */
	@Override
	public String[] getSongs() {
		return musicPlayer.getSongs();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayerFacade#setDirectory(java.io.File)
	 */
	@Override
	public void setDirectory(File dir) {
		musicPlayer.setDir(dir);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see audioplayer.model.IMusicPlayerFacade#getDirectoryPath()
	 */
	@Override
	public String getDirectoryPath() {
		return musicPlayer.getDir().toString();
	}

}
