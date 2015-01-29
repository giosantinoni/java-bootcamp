package exercise;

import java.util.ArrayList;
import java.util.List;

public class RecentEntriesList implements IRecentEntriesList {
	private List<Entry> list;
	private final int MAXIMUM_SIZE = 10;

	public RecentEntriesList() {
		list = new ArrayList<Entry>();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void setList(List<Entry> list) {
		this.list = list;
	}

	@Override
	public void addNewEntry(Entry entry) {
		if (list.contains(entry))
			list.remove(entry);
		else if (list.size() == MAXIMUM_SIZE)
			list.remove(0);
		list.add(entry);
	}

	@Override
	public void removeEntry(Entry entry) {
		if (list.contains(entry))
			list.remove(entry);
		else
			throw new RuntimeException();
	}

	@Override
	public Entry getEntry(int index) {
		return list.get(index);
	}

	@Override
	public boolean contains(Entry entry) {
		return list.contains(entry);
	}

	@Override
	public void updateEntry(int index, Entry entry) {
		list.set(index, entry);
	}

	@Override
	public List<Entry> getList() {
		return list;
	}

}
