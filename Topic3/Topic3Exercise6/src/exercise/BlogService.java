package exercise;

import java.util.ArrayList;
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
	public void addNewEntry(String title, String body, String tag) {
		recentEntries.addNewEntry(new Entry(title, body, tag));
	}

	@Override
	public void removeEntry(int index) {
		Entry currentEntry = recentEntries.getEntry(index);
		
		if (currentEntry != null)
			recentEntries.removeEntry(currentEntry);
	}

	@Override
	public void updateEntry(int index, String title, String body, String tag) {
		Entry entry = new Entry(title, body, tag);
		recentEntries.updateEntry(index, entry);		
	}

	@Override
	public List<Entry> getRecentEntries() {
		return recentEntries.getList();
	}

	@Override
	public List<String> getTagList() {
		List<String> tagList = new ArrayList<String>();
		
		for (Entry entry: getRecentEntries())
			tagList.add(entry.getTag());
		
		return tagList;
	}

	@Override
	public Entry getEntryByTag(String tag) {		
		return recentEntries.getEntryByTag(tag);
	}

}
