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
	private static  BufferedReader reader;

	//program variables to hold data
	private static String word,suffix; //variables to store the original word and the suffix
	private static int lineCount, suffixIdentity, count; //variable to count how many lines are in the document
	private static String pluralWord, suffixWord, currentLetter = ""; //this is the plural form of the input word


	
	public static void main(String...args) throws IOException {
		initFile();
		countLines();
		
		for (int i = 0; i < lineCount; i++) { //this loop executes as many times as there are lines in the document
		
		getData();
		pluralFormer();
		findPattern();
		addSuffix();
		
		
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
		
		reader.close(); //closed to reset the reader's position in the document
		initFile(); //reinitialize the reader at the top of the doucument
	}
	
	public static void getData() throws IOException
	  {
		Scanner docReader = new Scanner(reader.readLine()); //I use a scanner for reading the tokens
	    
	    // placing the first word and suffix in the dataline into string variables    
	    word = docReader.next();
	    suffix = docReader.next();
	    
	    System.out.println("Line read is " + word + " " + suffix);
	  }
	
	public static void pluralFormer() throws IOException { //this method makes the plurals
		String finalLetter = word.substring(word.length() - 1, word.length());		
		String secondToLast = word.substring(word.length() - 2, word.length() - 1);
		
		if (finalLetter.equals("A") || finalLetter.equals("C") || //if the final letter of the word is a vowel
		    finalLetter.equals("S") || finalLetter.equals("L"))
		{
			if (secondToLast.equals("A") || //if the second to last letter of the word is a vowel
				secondToLast.equals("C") ||
				secondToLast.equals("S") ||
				secondToLast.equals("L"))
			{
				pluralWord = word + finalLetter + "H"; //the plural is the word plus the last vowel plus H
				suffixIdentity = 1;
			}
			else
			{
				pluralWord = word.substring(0, word.length() - 1) + "G";
				suffixIdentity = 2;
			}
			//System.out.println("Vowel");
			
		}
		else //executes if the final letter of the word is a consonant
		{
			if (secondToLast.equals("A") == true || //if the second to last is a vowel, plural is the word plus GH
				secondToLast.equals("C") == true ||
				secondToLast.equals("S") == true ||
			    secondToLast.equals("L") == true)
			{
				pluralWord = word + "GH";
				suffixIdentity = 3;
			}
			else //if the second to last letter is a consonant, double the final consonant and add H
			{
				pluralWord = word + finalLetter + "H";
				suffixIdentity = 1;
			}
		}
		
		System.out.println("Plural word is " + pluralWord); //print the plural form of the word

	}
	
	public static void addSuffix() {
		
		boolean firstLetter = suffix.substring(0, 1).equals("A") || suffix.substring(0, 1).equals("C")
						   || suffix.substring(0, 1).equals("S") || suffix.substring(0, 1).equals("L");
		
		if (suffixIdentity == 3) {
			suffixWord = word + suffix;
		}
		else if (suffixIdentity == 2)
		{
			if (firstLetter == true)
			{
				suffix = suffix.substring(1, suffix.length());
				suffixWord = word + suffix;
			}
			else
			{
				suffix = suffix.substring(0, 1) + suffix;
				suffixWord = word + suffix;
			}
		}
		else if (suffixIdentity == 1)
		{
			if (firstLetter == true)
			{
				suffix = suffix.substring(0, 1) + suffix;
				suffixWord = word + suffix;
			}
			else
			{
				
			}
		}
		
		System.out.println(suffixWord);
	}
	
	private static void findPattern() {
		String newWord = word + " ";
		int count = 2;
		while (word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
		       word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
		       word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
		       word.substring(word.length() - count, word.length() - count + 1).equals("L")) 
		{
			count++;
			System.out.println(count);
		}
	}
	
	
	
	
	
	
	
	

}
