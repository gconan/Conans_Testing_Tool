package commandLineInterface;

public interface UsableInCLI {
	
	/**
	 * add all of the methods/command pairs you wish the CLI to utilize. 
	 * Example: (cli.setCommandFunction("<cliCommand>", this::<methodName>))
	 * -where cliCommand is what the user will type in the CLI to invoke the method, methodName
	 * @param cli
	 */
	public void initialize(Courier cli);
	
}
