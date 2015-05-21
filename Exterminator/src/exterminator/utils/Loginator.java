package exterminator.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Named Loginator after the Terminator.
 * @author conangammel
 *
 */
public class Loginator {
	
	public PrintWriter LogFile;
	public String fileName;
	
	public Loginator(){
		this.fileName = "Exterminator_Log";
		try {
			this.LogFile = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			File file = new File(fileName);
			try {
				this.LogFile = new PrintWriter(fileName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public Loginator(String fileName){
		this.fileName = fileName;
		try {
			this.LogFile = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			File file = new File(fileName);
			try {
				this.LogFile = new PrintWriter(fileName);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void log(String msg){
		this.LogFile.print(msg);
	}
	
	public void close(){
		this.LogFile.close();
	}
}
