package exterminator;

import java.util.Scanner;

import commandLineInterface.Courier;
import commandLineInterface.UsableInCLI;

public class FileProcessor implements UsableInCLI{
	
	
	public FileProcessor(){
	}
	
	public void quit(){
		System.out.println("IT WORKS!!!\n"+this.hashCode()+"\n");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(input.toUpperCase());
	}

	@Override
	public void initialize(Courier cli) {
		cli.setCommandFunction("quit", this::quit);
	}



}
