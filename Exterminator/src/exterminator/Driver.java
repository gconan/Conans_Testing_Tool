package exterminator;

import commandLineInterface.Courier;

public class Driver {
	public static Courier cli = new Courier();
	
	public static void main(String[]args){
		FileProcessor fp = new FileProcessor();
		fp.initialize(cli);
		cli.printAndReadCommand("Try it...");
		
	}

}
