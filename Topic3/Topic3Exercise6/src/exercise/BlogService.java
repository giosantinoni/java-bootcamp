package exercise;

import java.util.List;

public class BlogService implements IBlogService {
	private IRecentEntriesList recentEntries;
	
	public BlogService() {
		recentEntries = new RecentEntriesList();
	}

	@Override
	public void setRecentEntries(IRecentEntriesList recentEntries) {
		this.recentEntries = recentEntries;		
	}

	@Override
	public void addNewEntry(String title, String body) {
		recentEntries.addNewEntry(new Entry(title, body));
	}

	@Override
	public void removeEntry(int index) {
		Entry currentEntry = recentEntries.getEntry(index);
		
		if (currentEntry != null)
			recentEntries.removeEntry(currentEntry);
	}

	@Override
	public void updateEntry(int index, String title, String body) {
		Entry entry = new Entry(title, body);
		recentEntries.updateEntry(index, entry);		
	}

	@Override
	public List<Entry> getRecentEntries() {
		return recentEntries.getList();
	}

}
