package exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecentFileListTest {

	@Test
	public void testIsEmpty() {
		IRecentFileList fileList = new RecentFileList();
		
		boolean isEmpty = fileList.isEmpty();
		
		assertEquals(true, isEmpty);
	}
	
	@Test
	public void testFileAdded() {
		IRecentFileList fileList = new RecentFileList();
		String fileName = "file1";
		
		fileList.openFile(fileName);
		
		boolean exists = fileList.checkIfExists(fileName);
		
		assertEquals(true, exists);
	}
	
	@Test
	public void testFileAlreadyOpen() {
		IRecentFileList fileList = new RecentFileList();
		String fileName = "file1";
		
		fileList.openFile(fileName);
		fileList.openFile("file2");
		fileList.openFile("file3");
		fileList.openFile("file4");
		fileList.openFile(fileName);
		
		String fileName2 = fileList.getFile(3);
		
		assertEquals(fileName, fileName2);
	}
	
	@Test
	public void testFullFileList() {
		IRecentFileList fileList = new RecentFileList();
		
		fileList.openFile("file1");
		fileList.openFile("file2");
		fileList.openFile("file3");
		fileList.openFile("file4");
		fileList.openFile("file5");
		fileList.openFile("file6");
		fileList.openFile("file7");
		fileList.openFile("file8");
		fileList.openFile("file9");
		fileList.openFile("file10");
		fileList.openFile("file11");
		fileList.openFile("file12");
		fileList.openFile("file13");
		fileList.openFile("file14");
		fileList.openFile("file15");
		fileList.openFile("file16");
		
		String fileName = fileList.getFile(0);
		
		assertEquals("file2", fileName);
	}

}
