import java.util.*;
//hi
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
		readLine();
		getData();
		pluralFormer();
		
	}
	
	public static void initFile() throws IOException
	  {
	    inFile = new FileInputStream ("C:\\!!VHSAPCS\\vowels.txt"); // notice the double slash marks
	    inReader = new InputStreamReader(inFile);
	    reader = new BufferedReader(inReader);
	  }
	
	public static void readLine() throws IOException
	{
		line = reader.readLine();
	}
	
	public static void getData() throws IOException
	  {
	    System.out.println ("data line = " + line ); // view data line as one string
	    System.out.println();
	    
	    strTkn = new StringTokenizer(line);  // attaching the string tokenizer to the line
	    
	    // placing the first word and suffix in the dataline into a string variable    
	    word = strTkn.nextToken();
	    suffix = strTkn.nextToken();
	    
	    System.out.println(word + " " + suffix);
	    
	    line = reader.readLine();
	    //System.out.println(line);
	    
	  }  
	
	public static void pluralFormer() {
		String pluralWord = "";
		String finalLetter = word.substring(word.length() - 1, word.length());
		//System.out.println(finalLetter);
		
		if (finalLetter.equals("A") || finalLetter.equals("C") ||
		    finalLetter.equals("S") || finalLetter.equals("L"))
		{
			if (word.substring(word.length() - 2, word.length() - 1).equals("A") ||
				word.substring(word.length() - 2, word.length() - 1).equals("C") ||
				word.substring(word.length() - 2, word.length() - 1).equals("S") ||
				word.substring(word.length() - 2, word.length() - 1).equals("L"))
			{
				pluralWord = word + finalLetter + "H";
			}
			else
			{
				pluralWord = word.substring(0, word.length() - 1) + "G"; 
			}
			//System.out.println("Vowel");
			
		}
		
		System.out.println(pluralWord);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
