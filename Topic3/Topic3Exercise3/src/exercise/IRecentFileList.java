package exercise;

public interface IRecentFileList {

	boolean isEmpty();

	void openFile(String fileName);

	boolean checkIfExists(String fileName);

	String getFile(int index);

}
