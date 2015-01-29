package exercise;

import java.util.List;

public interface IBlogService {

	void setRecentEntries(IRecentEntriesList recentEntries);

	void addNewEntry(String title, String body, String tag);

	void removeEntry(int index);

	void updateEntry(int index, String title, String body, String tag);

	List<Entry> getRecentEntries();

	List<String> getTagList();
	
	Entry getEntryByTag(String tag);

}
