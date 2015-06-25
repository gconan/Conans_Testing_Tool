package commandLineInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Courier acts as a "middle man" between your application and the command line.
 * Setting up Courier properly allows your program to create a map of user commands linked 
 * to methods in your application.
 * @author conangammel
 *
 */
public class Courier{

	/**The text displayed at the start (or any time you call welcome())*/
	private String welcomeText;
	
	/**The text displayed when the command "help" is typed*/
	private String helpText;
	
	/**This map links input commands to methods in your application*/
	private Map<String, Runnable> commandToMethod;
	
	/**Scanner that reads input*/
	private Scanner scan;
	
	/**
	 * Default constructor: Initializes map and scanner.
	 */
	public Courier(){
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(System.in);
	}
	
	/**
	 * Constructor: Initializes map, welcome text, and scanner.
	 * @param welcome
	 */
	public Courier(String welcome){
		this.welcomeText = welcome;
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(System.in);
	}
	
	/**
	 * Constructor: Initializes map, welcome text, help text, and scanner.
	 * @param welcome
	 * @param help
	 */
	public Courier(String welcome, String help){
		this.welcomeText = welcome;
		this.helpText = help;
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(System.in);
	}
	
	/**
	 * Constructor: Default constructs but changes the in/out put of the Courier.
	 * @param input
	 * @param output
	 */
	public Courier(InputStream input, PrintStream output){
		this.commandToMethod = new HashMap<String, Runnable>();
		this.scan = new Scanner(input);
		System.setOut(output);
	}
	
	/**
	 * Sets the input stream for the scanner to read commands from.
	 * @param input
	 */
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
	
	/**
	 * Prints to the outputStream. No new line.
	 * @param s
	 */
	public void print(String s){
		System.out.print(s);
	}
	
	/**
	 * Prints to the outputStream. Includes a new line.
	 * @param s
	 */
	public void println(String s){
		System.out.println(s);
	}
	
	/**
	 * Key value pair: adds a command to the map which will call 
	 * the method provided when the command is seen at the input.
	 * @param command
	 * @param method
	 */
	public void setCommandFunction(String command, Runnable method){
		this.commandToMethod.put(command, method);				
	}
	
	/**
	 * Prints a prompt (no new line), reads the next line from the user, then processes the input
	 * @param s
	 */
	public void printAndReadCommand(String s){
		System.out.print(s);
		String command = scan.nextLine();
		processCommand(command);
	}
	
	/**
	 * Prints a prompt (with a new line), reads the next line from the user, then processes the input
	 * @param s
	 */
	public void printlnAndReadCommand(String s){
		System.out.println(s);
		String command = scan.nextLine();
		processCommand(command);
	}
	
	/**
	 * Takes in a line of text, reads the command, takes all other input as paramters
	 * @param command
	 */
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
	
	/**
	 * Prints the welcome text
	 */
	public void welcome(){
		System.out.println(this.welcomeText);
	}
	
	/**
	 * Prints the help text
	 */
	public void help(){
		System.out.println(this.helpText);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
