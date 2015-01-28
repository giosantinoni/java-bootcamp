package exercise;

import java.util.ArrayList;
import java.util.List;

public class RecentFileList implements IRecentFileList {
	private List<String> list;
	private final int MAXIMUM_SIZE = 15;
	
	public RecentFileList() {
		list = new ArrayList<String>();
	}

	@Override
	public boolean isEmpty() {		
		return list.isEmpty();
	}

	@Override
	public void openFile(String fileName) {
		if (list.contains(fileName))
			list.remove(fileName);
		else if (list.size() == MAXIMUM_SIZE)
			list.remove(0);
		list.add(fileName);
	}

	@Override
	public boolean checkIfExists(String fileName) {		
		return list.contains(fileName);
	}

	@Override
	public String getFile(int index) {
		return list.get(index);
	}

}
