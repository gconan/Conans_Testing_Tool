package commandLineInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Courier{

	private String welcomeText;
	private String helpText;
	private Map<String, Runnable> commandToMethod;
	private Scanner scan;
	
	public Courier(){
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(System.in);
	}
	
	public Courier(String welcome){
		this.welcomeText = welcome;
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(System.in);
	}
	
	public Courier(String welcome, String help){
		this.welcomeText = welcome;
		this.helpText = help;
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(System.in);
	}
	
	public Courier(InputStream input, PrintStream output){
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(input);
		System.setOut(output);
	}
	
	
	public void setInputStream(InputStream input){
		try{
			scan.close();
		}catch(IllegalStateException e){
			//already closed
		}
		
		scan = new Scanner(input);
	}
	
	/**
	 * Sets the output stream to the given print stream
	 * returns false if a security exception is thrown
	 * @param output
	 * @return
	 */
	public boolean setOutput(PrintStream output){
		try{
			System.setOut(output);
		}catch(SecurityException e){
			return false;
		}
		return true;
	}
	
	public void print(String s){
		System.out.print(s);
	}
	
	public void println(String s){
		System.out.println(s);
	}
	
	public void setCommandFunction(String command, Runnable function){
		this.commandToMethod.put(command, function);				
	}
	
	public void printAndReadCommand(String s){
		System.out.print(s);
		String command = scan.nextLine();
		processCommand(command);
	}
	
	public void printlnAndReadCommand(String s){
		System.out.println(s);
		String command = scan.nextLine();
		processCommand(command);
	}
	
	private void processCommand(String command){
		Scanner commandScan = new Scanner(command);
		String cmd = commandScan.next();
		ArrayList<String> parameters = new ArrayList<String>();
		
		while(commandScan.hasNext()){
			parameters.add(commandScan.next());
		}
		commandScan.close();
		
		try{
			this.commandToMethod.get(cmd).run();
		}catch(Exception e){
			
		}
		
	}
	
	public void welcome(){
		System.out.println(this.welcomeText);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
