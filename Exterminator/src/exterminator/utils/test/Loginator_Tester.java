package exterminator.utils.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exterminator.utils.Loginator;

public class Loginator_Tester {

	public File file;
	public String fileName = "LoginatorTesterFile";
	public Loginator logger;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		logger = new Loginator(fileName);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleLog() {
		String s = "this is working!";
		logger.log(s);
		logger.close();
		assertTrue(fileContains(s));
	}
	
	@Test
	public void testBasicLogging(){
		
	}
	
	
	
	
	
	
	
	
	public boolean fileContains(String s){
		Scanner reader = null;
		try {
			reader = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			return false;
		}
		
		boolean exists = false;
		
		while(reader.hasNextLine()){
			
			exists |= reader.nextLine().equals(s);
			
		}
		reader.close();
		return exists;
	}

}
