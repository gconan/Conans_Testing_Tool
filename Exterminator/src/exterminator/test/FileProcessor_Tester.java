package exterminator.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exterminator.FileProcessor;

public class FileProcessor_Tester {

	FileProcessor fp;
	String fileToBeProcessed = "test.java";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fp = new FileProcessor(fileToBeProcessed);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFileCreated() {
		try {
			fp.addNodeLogging();
		} catch (Exception e) {
			e.getMessage();
		}
		assertTrue((new File(fp.getLoggedFileName())).exists());
	}

}
