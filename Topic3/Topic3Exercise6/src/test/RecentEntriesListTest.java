package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import exercise.Entry;
import exercise.IRecentEntriesList;
import exercise.RecentEntriesList;

public class RecentEntriesListTest {
	private IRecentEntriesList entriesList;
	private List<Entry> mockedList;

	@Before
	public void setUp() {
		entriesList = new RecentEntriesList();
		mockedList = Mockito.mock(List.class);
	}

	@Test
	public void testIsEmpty() {
		boolean isEmpty = entriesList.isEmpty();

		assertEquals(true, isEmpty);
	}

	@Test
	public void testAddNewEntry() {
		entriesList.setList(mockedList);

		Entry entry = new Entry("title", "body");

		entriesList.addNewEntry(entry);

		Mockito.verify(mockedList).add(entry);
	}

	@Test
	public void testRemoveEntry() {
		Entry entry1 = new Entry("title1", "body1");
		Entry entry2 = new Entry("title2", "body2");

		entriesList.addNewEntry(entry1);
		entriesList.addNewEntry(entry2);

		entriesList.removeEntry(entry1);

		boolean result = entriesList.contains(entry1);

		assertEquals(false, result);
	}

	@Test
	public void testUpdateEntry() {
		Entry entry1 = new Entry("title1", "body1");

		entriesList.addNewEntry(entry1);

		String newBody = "body1 - updated";

		entry1 = entriesList.getEntry(0);
		entry1.setBody(newBody);
		entriesList.updateEntry(0, entry1);

		String result = entriesList.getEntry(0).getBody();

		assertEquals(newBody, result);
	}

	@Test
	public void testFullEntriesList() {
		Entry entry2 = new Entry("title2", "body2");

		entriesList.addNewEntry(new Entry("title1", "body1"));
		entriesList.addNewEntry(entry2);
		entriesList.addNewEntry(new Entry("title3", "body3"));
		entriesList.addNewEntry(new Entry("title4", "body4"));
		entriesList.addNewEntry(new Entry("title5", "body5"));
		entriesList.addNewEntry(new Entry("title6", "body6"));
		entriesList.addNewEntry(new Entry("title7", "body7"));
		entriesList.addNewEntry(new Entry("title8", "body8"));
		entriesList.addNewEntry(new Entry("title9", "body9"));
		entriesList.addNewEntry(new Entry("title10", "body10"));
		entriesList.addNewEntry(new Entry("title11", "body11"));

		Entry result = entriesList.getEntry(0);

		assertEquals(entry2, result);
	}

}
