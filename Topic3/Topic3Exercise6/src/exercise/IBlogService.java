package exercise;

import java.util.List;

public interface IBlogService {

	void setRecentEntries(IRecentEntriesList recentEntries);

	void addNewEntry(String title, String body);

	void removeEntry(int index);

	void updateEntry(int index, String title, String body);

	List<Entry> getRecentEntries();

}
