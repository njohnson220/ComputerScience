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
	private static int lineCount, suffixIdentity, vowelCount; //variable to count how many lines are in the document
	private static String pluralWord, suffixWord, currentLetter = ""; //this is the plural form of the input word


	
	public static void main(String...args) throws IOException {
		initFile(); //initialize the file
		countLines(); //count how many lines of data are in the document
		
		for (int i = 0; i < lineCount; i++) { //this loop executes as many times as there are lines in the document
		
		getData(); //get data
		pluralFormer(); //form the plural of the input word
		findPattern(); //find the leftmost vowel/consonant pattern letter in the input word
		addSuffix(); //add the suffix to the input word
		
		
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
		while ((checkLine = reader.readLine()) != null) { //if the reader doesn't encounter a nonexistent line, continue to count lines
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
				suffixIdentity = 1; //ends in two vowels
			}
			else
			{
				pluralWord = word.substring(0, word.length() - 1) + "G";
				suffixIdentity = 2; //ends in a single vowel
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
				suffixIdentity = 3; //word ends in a single consonant
			}
			else //if the second to last letter is a consonant, double the final consonant and add H
			{
				pluralWord = word + finalLetter + "H"; 
				suffixIdentity = 1; //word ends in two consonants
			}
		}
		
		System.out.println("Plural word is " + pluralWord); //print the plural form of the word

	}
	
	public static void addSuffix() {
		
		/* I created different identities for different types of words based on their endings, called suffixIdentity
		 * Since pluralFormer already analyzes the word, it would be repetitive and inefficient to do it again within this
		 * method. 
		 * 
		 * suffixIdentity = 1...This means the word ends in two consonants/vowels
		 * suffixIdentity = 2...This means the word ends in a single vowel
		 * suffixIdentity = 3...This means the word ends in a single consonant
		 */
		
		//returns true if the first letter of the suffix is a vowel
		boolean firstSuffixLetter = suffix.substring(0, 1).equals("A") || suffix.substring(0, 1).equals("C") 
						   || suffix.substring(0, 1).equals("S") || suffix.substring(0, 1).equals("L");
		
		if (suffixIdentity == 3) { //if the word ends in a single consonant
			suffixWord = word + suffix; //add the suffix and nothing else
		}
		else if (suffixIdentity == 2) //if the word ends in a single vowel
		{
			if (firstSuffixLetter == true) //if the first letter of the suffix is a vowel
			{
				suffix = suffix.substring(1, suffix.length()); //the suffix now is the original suffix without the first letter
				suffixWord = word + suffix; //add the suffix to the word
			}
			else //if the first letter of the suffix is a consonant
			{
				suffix = suffix.substring(0, 1) + suffix; //add the first letter of the suffix to the suffix
				suffixWord = word + suffix; //add the suffix to the word
			}
		}
		else if (suffixIdentity == 1) //if the word ends in two consonants/vowels
		{
			if (firstSuffixLetter == true) //if the first suffix letter is a vowel
			{
				suffix = suffix.substring(0, 1) + suffix; //add the first letter of the suffix to the suffix
				suffixWord = word + suffix; //add the suffix to the word
			}
			else
			{
				//the suffix word before the leftmost letter in the vowel/consonant pattern
				String beginOfSuffixWord = word.substring(0, word.length() - vowelCount - 1); 
				//the suffix word after the leftmost letter in the vowel/consonant pattern
				String endOfSuffixWord = word.substring(word.length() - vowelCount, word.length());
				
				//add the two together without the leftmost letter in the pattern, then add the suffix
				suffixWord = beginOfSuffixWord + endOfSuffixWord + suffix; 
			}
		}
		
		System.out.println("Suffix word is " + suffixWord);
		System.out.println();
	}
	
	private static void findPattern() {
		int count = 1;
		boolean vowelIdentity = word.substring(word.length() - 1, word.length()).equals("A") ||
		                        word.substring(word.length() - 1, word.length()).equals("C") ||
		                        word.substring(word.length() - 1, word.length()).equals("S") ||
		                        word.substring(word.length() - 1, word.length()).equals("L");
		
		boolean letterCheck = (word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
							   word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
							   word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
							   word.substring(word.length() - count, word.length() - count + 1).equals("L"));
		
		boolean consonantCheck = !(word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
				   				   word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
				   				   word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
				   				   word.substring(word.length() - count, word.length() - count + 1).equals("L"));
				
		if (vowelIdentity == true)
		{
			while (letterCheck == true && count <= word.length())
			{
				count++;
				//System.out.println(count);
				letterCheck = (word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
						       word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
						       word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
						       word.substring(word.length() - count, word.length() - count + 1).equals("L"));
			}
		}
		else
		{
			while (consonantCheck == true && count <= word.length())
			{
				count++;
				//System.out.println(count);
				consonantCheck = !(word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
		   				           word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
		   				           word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
		   				           word.substring(word.length() - count, word.length() - count + 1).equals("L"));
			}
		}
		
		vowelCount = count - 2;
		//System.out.println(vowelCount);
		//System.out.println(word.substring(word.length() - vowelCount, word.length()));
		
	}
	
	
	
	
	
	
	
	

}
