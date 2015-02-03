package exercise;

import java.util.List;

public interface IRecentEntriesList {

	boolean isEmpty();

	void setList(List<Entry> list);

	void addNewEntry(Entry entry);

	void removeEntry(Entry entry);

	Entry getEntry(int index);

	boolean contains(Entry entry);

	void updateEntry(int index, Entry entry);

	List<Entry> getList();
	
	Entry getEntryByTag(String tag);

}
