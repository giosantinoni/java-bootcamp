package audioplayer.model;

import java.io.File;

import audioplayer.exceptions.MusicPlayerException;

public interface IMusicPlayerFacade {

	public abstract void playSong(String songName) throws MusicPlayerException;

	public abstract void stopSong();

	public abstract void pauseSong();

	public abstract String[] getSongs();

	public abstract void setDirectory(File dir);

	public abstract String getDirectoryPath();

}