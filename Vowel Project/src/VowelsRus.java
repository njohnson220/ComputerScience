import java.util.*;
import java.io.*;

public class VowelsRus {

	// variables necessary for file input
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static  BufferedReader reader;

	//  StringTokenizer variable used to separate line into different data elements
	private static StringTokenizer strTkn;

	//program variables to hold data
	private static String line,word,suffix;
	private static int num1, num2,num3,grade, total;
	private static double avg;

	public static void main(String...args) throws IOException {
		
		initFile();
		getData();
		
	}
	
	public static void initFile() throws IOException
	  {
	    inFile = new FileInputStream ("C:\\!!VHSAPCS\\vowels.txt"); // notice the double slash marks
	    inReader = new InputStreamReader(inFile);
	    reader = new BufferedReader(inReader);
	  }
	
	public static void getData() throws IOException
	  {
	    line = reader.readLine();   //acquiring the data line as a string
	    System.out.println ("data line = " + line ); // view data line as one string
	    System.out.println();
	    
	    strTkn = new StringTokenizer(line);  // attaching the string tokenizer to the line
	    
	    // placing the first word and suffix in the dataline into a string variable    
	    word = strTkn.nextToken();
	    suffix = strTkn.nextToken();
	    
	    System.out.println(word + " " + suffix);
	    
	    line = reader.readLine();
	    
	  }  

}
