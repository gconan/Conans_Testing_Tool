/**
 * 
 */
package exterminator.utils;

/**
 * @author conangammel
 *
 */
public class TextBuilder{
	
	private StringBuilder builder;
	private String tab;
	private int tcount;

	/**
	 * The need for appending a new line at the end of each append forced this class
	 */
	public TextBuilder() {
		builder = new StringBuilder();
		tab = "";
		tcount=0;
	}
	
	public void appendln(String s){
		builder.append(s);
		builder.append("\n");
	}
	
	public void appendNew(String s){
		builder.append(tab);
		builder.append(s);
		builder.append("\n");
	}
	
	public void increaseTab(){
		tab+="\t";
		tcount++;
	}
	
	public void decreaseTab(){
		tab = "";
		tcount-=1;
		for(int i=0; i<tcount; i++){
			tab +=("\t");
		}
	}
	
	public String toString(){
		return builder.toString();
	}

}
