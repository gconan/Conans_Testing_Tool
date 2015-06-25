package exterminator;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import exterminator.utils.Loginator;
import exterminator.utils.TextBuilder;
import commandLineInterface.Courier;
import commandLineInterface.UsableInCLI;

public class FileProcessor implements UsableInCLI{
	
	private String fileName;
	private String loggedFile;
	
	public FileProcessor(){
		
	}
	
	public FileProcessor(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * 
	 * 
	 */
	public void addNodeLogging() throws Exception{
		if(fileName==null || fileName.equals("")) throw new Exception("FileProcessor's fileName has not been set");
		File orig = new File(fileName);
		File loggedFile = new File(fileName());
		
		Scanner reader = new Scanner(orig);
		FileWriter writer = new FileWriter(loggedFile);
		
		//MetaData stuff
		TextBuilder text = new TextBuilder();
		String line = "";
		writer.write("/**This File was created by Exterminator to log node coverage in your program when you run your test suite.*/");
		while(reader.hasNextLine()){
			line = reader.nextLine();
			if(line.contains("package")){
				text.appendln(line);
				text.appendNew("import Exterminator.exterminator.utils.Loginator;");
				//finish the imports
				while((line=reader.nextLine()).contains("import")){
					text.appendln(line);
				}
				break;
			}else{
				text.appendln(line);
			}
		}
		text.appendln(line);
		
	}
	
	

	@Override
	public void initialize(Courier cli) {
//		cli.setCommandFunction("quit", this::quit);
	}
	
	private String fileName(){
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.fileName.substring(0, this.fileName.indexOf(".")));
		builder.append("_withExterminatorLogging.java");
		
		this.loggedFile = builder.toString();
		
		return builder.toString();
	}
	
	public String getLoggedFileName(){
		return this.loggedFile;
	}



}
