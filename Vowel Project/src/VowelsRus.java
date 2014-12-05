/*Nathan Johnson
 * 12/4/14
 * Vowels-R-Us project
 * This project takes words from planet ACSL and attaches suffixes and pluralizes them using appropriate extra-terrestrial
 * grammar rules.
 * 
 * UPDATE 12/4/14
 * The pluralizer is functional, though could be revised.
 */

import java.util.*;
import java.io.*;

public class VowelsRus {

	// variables necessary for file input
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static  BufferedReader reader, prelimReader;
	private static String pluralWord = "";

	//program variables to hold data
	private static String word,suffix;
	private static int lineCount;


	
	public static void main(String...args) throws IOException {
		initFile();
		countLines();
		
		for (int i = 0; i < lineCount; i++) {
		
		getData();
		pluralFormer();
		
		
		}
	}
	
	public static void initFile() throws IOException
	  {
	    inFile = new FileInputStream ("C:\\!!VHSAPCS\\vowels.txt"); // notice the double slash marks
	    inReader = new InputStreamReader(inFile);
	    reader = new BufferedReader(inReader);
	  }
	
	private static void countLines() throws IOException
	{
		String checkLine;
		lineCount = 0;
		while ((checkLine = reader.readLine()) != null) {
			lineCount++;
		}
		
		reader.close();
		initFile();
	}
	
	
	public static void getData() throws IOException
	  {
		Scanner docReader = new Scanner(reader.readLine());

		
	    //System.out.println ("data line = " + line ); // view data line as one string
	    //System.out.println();
	    

		//StringTokenizer strTkn = new StringTokenizer(line);

	    // placing the first word and suffix in the dataline into a string variable    
	    word = docReader.next();
	    suffix = docReader.next();
	    
	    System.out.println("Line read is " + word + " " + suffix);
	    
	    //line = reader.readLine();
	    //System.out.println(line);
	    
	  }  
	
	public static void pluralFormer() throws IOException {
		String finalLetter = word.substring(word.length() - 1, word.length());
		//System.out.println(finalLetter);
		
		String secondToLast = word.substring(word.length() - 2, word.length() - 1);
		
		if (finalLetter.equals("A") || finalLetter.equals("C") ||
		    finalLetter.equals("S") || finalLetter.equals("L"))
		{
			if (secondToLast.equals("A") ||
				secondToLast.equals("C") ||
				secondToLast.equals("S") ||
				secondToLast.equals("L"))
			{
				pluralWord = word + finalLetter + "H";
			}
			else
			{
				pluralWord = word.substring(0, word.length() - 1) + "G"; 
			}
			//System.out.println("Vowel");
			
		}
		else
		{
			if (secondToLast.equals("A") == true ||
				 secondToLast.equals("C") == true ||
				 secondToLast.equals("S") == true ||
			     secondToLast.equals("L") == true)
			{
				pluralWord = word + "GH";
			}
			else
			{
				pluralWord = word + finalLetter + "H";
			}
		}
		
		System.out.println("Plural word is " + pluralWord);
		System.out.println();
		//line = reader.readLine();

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
