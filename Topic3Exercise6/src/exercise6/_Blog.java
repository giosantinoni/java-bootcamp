package exercise6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _Blog {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending");
	}

	@Test
	public void test() {
		//Creating a Blong and some entries
		Blog blog = new Blog();
		Entry e1 = new Entry("Entry 1 Title","Entry 1 body","Entry 1 Tag");
		Entry e2 = new Entry("Entry 2 Title","Entry 2 body","Entry 2 Tag");
		Entry e3 = new Entry("Entry 3 Title","Entry 3 body","Entry 3 Tag");
		Entry e4 = new Entry("Entry 4 Title","Entry 4 body","Entry 4 Tag");
		Entry e5 = new Entry("Entry 5 Title","Entry 5 body","Entry 5 Tag");
		Entry e6 = new Entry("Entry 6 Title","Entry 6 body","Entry 6 Tag");
		Entry e7 = new Entry("Entry 7 Title","Entry 7 body","Entry 7 Tag");
		
		// posting entries
		blog.post(e1);
		blog.post(e2);
		blog.post(e3);
		blog.post(e4);
		blog.post(e5);
		blog.post(e6);
		blog.post(e7);
		
		//showing recent entries
		blog.recentEntryList.Show();
		
		// showing all entries' tags
		blog.showAllTags();
		
		e3.setTag("Entry 1 new Tag");
		e4.setTag("Entry 1 new Tag");
		e5.setTag("Entry 1 new Tag");
		
		// updating entries
		blog.update(e3);
		blog.update(e4);
		blog.update(e5);
		
		//blog.delete("Title");
		
		blog.recentEntryList.Show();
		//showing entries with an specific tag
		blog.entrySearch("Entry 1 new Tag");
		
	}

}
