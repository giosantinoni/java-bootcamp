package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

import exercise.BlogService;
import exercise.Entry;
import exercise.IBlogService;
import exercise.IRecentEntriesList;

public class BlogServiceTest {
	private IBlogService blogService;
	private IRecentEntriesList recentEntriesMock;
	private Entry entry1;
	private Entry entry2;

	@Before
	public void setUp() throws Exception {
		blogService = new BlogService();
		recentEntriesMock = Mockito.mock(IRecentEntriesList.class);
		entry1 = new Entry("title1", "body1");
		entry2 = new Entry("title2", "body2");
		
		Mockito.when(recentEntriesMock.getEntry(0)).thenReturn(entry1);
		Mockito.when(recentEntriesMock.getList()).thenReturn(Arrays.asList(entry1, entry2));
	}

	@Test
	public void testAddNewEntry() {
		blogService.setRecentEntries(recentEntriesMock);
		
		blogService.addNewEntry("title", "body");
		
		Mockito.verify(recentEntriesMock).addNewEntry(Mockito.any(Entry.class));
	}
	
	@Test
	public void testRemoveEntry() {		
		blogService.setRecentEntries(recentEntriesMock);
		
		blogService.removeEntry(0);
		
		Mockito.verify(recentEntriesMock).removeEntry(Mockito.any(Entry.class));
	}
	
	@Test
	public void testUpdateEntry() {		
		blogService.setRecentEntries(recentEntriesMock);
		
		blogService.updateEntry(1, "title", "body - changed");
		
		Mockito.verify(recentEntriesMock).updateEntry(Mockito.any(Integer.class), Mockito.any(Entry.class));
	}
	
	@Test
	public void testShowRecentEntries() {		
		blogService.setRecentEntries(recentEntriesMock);
		
		List<Entry> recentEntries = blogService.getRecentEntries();
		
		Mockito.verify(recentEntriesMock).getList();
		
		assertEquals(Arrays.asList(entry1, entry2), recentEntries);
	}

}
