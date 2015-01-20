/*Nathan Johnson
 * 12/4/14
 * Vowels-R-Us project
 * This project takes words from planet ACSL and attaches suffixes and pluralizes them using appropriate extra-terrestrial
 * grammar rules.
 * 
 * UPDATE 12/4/14
 * The pluralizer is functional, though could be revised.
 * 
 * UPDATE 12/8/14
 * The suffix adder is functional, though could be revised.
 * 
 * UPDATE 12/14/14
 * Everything is cleaned up, comments have been added for better code readability
 */

import java.util.*;
import java.io.*;

public class VowelsRus {

	// variables necessary for file input
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static  BufferedReader reader;

	//program variables to hold data
	private static String wordFinal, suffixFinal; //variables to store the original word and the suffix


	
	public static void main(String...args) throws IOException {
		initFile(); //initialize the file
		executeEverything(countLines()); //analyzes and prints data for as many lines as there are in the document
		
	}
	
	public static void executeEverything(int lineCount) throws IOException //executes all methods for data analyzation in the program
	{
		
		for (int i = 0; i < lineCount; i++) { //this loop executes as many times as there are lines in the document
			
			//getData(); //get data
			pluralFormer(setWord(getWord()), setSuffix(getSuffix())); //form the plural of the input word
			findPattern(wordFinal, suffixFinal); //find the leftmost vowel/consonant pattern letter in the input word
			addSuffix(wordFinal, suffixFinal, pluralFormer(wordFinal, suffixFinal), findPattern(wordFinal, suffixFinal)); //add the suffix to the input word
			}
	}
	
	public static void initFile() throws IOException //initialize the file for reading
	  {
	    inFile = new FileInputStream ("C:\\!!VHSAPCS\\vowels.txt"); // notice the double slash marks
	    inReader = new InputStreamReader(inFile);
	    reader = new BufferedReader(inReader);
	  }
	
	private static int countLines() throws IOException //count how many data lines are in the document
	{
		String checkLine;
		int lineCount = 0;
		while ((checkLine = reader.readLine()) != null) { //if the reader doesn't encounter a nonexistent line, continue to count lines
			lineCount++;
		}
		
		reader.close(); //closed to reset the reader's position in the document
		initFile(); //reinitialize the reader at the top of the doucument
		
		return lineCount;
	}
	
	public static String getWord() throws IOException //tokenize the data lines in the file
	  {
		Scanner docReader = new Scanner(reader.readLine()); //I use a scanner for reading the tokens
		String word = "";
		String suffix = "";
	    
	    // placing the first word and suffix in the dataline into string variables    
	    word = docReader.next();
	    suffix = docReader.next();
	    
	    System.out.println("Line read is " + word + " " + suffix); //print the unmodified, tokenized data line
	    docReader.close();
	    
	    return word;
	  }
	
	public static String getSuffix() throws IOException //tokenize the data lines in the file
	  {
		Scanner docReader = new Scanner(reader.readLine()); //I use a scanner for reading the tokens
		String word = "";
		String suffix = "";
	    
	    // placing the first word and suffix in the dataline into string variables    
	    word = docReader.next();
	    suffix = docReader.next();
	    
	    System.out.println("Line read is " + word + " " + suffix); //print the unmodified, tokenized data line
	    docReader.close();
	    
	    return suffix;
	  }
	
	public static String setWord(String word) {
		wordFinal = word;
		
		return wordFinal;
	}
	
	public static String setSuffix(String suffix) {
		suffixFinal = suffix;
		
		return suffixFinal;
	}
	
	public static int pluralFormer(String word, String suffix) throws IOException { //this method makes the plurals
		String pluralWord = "";
		int suffixIdentity;
		
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

		return suffixIdentity;
	}
	
	public static void addSuffix(String word, String suffix, int suffixIdentity, int vowelCount) { //adds suffixes to the words
		
		/* I created different identities for different types of words based on their endings, called suffixIdentity
		 * Since pluralFormer already analyzes the word, it would be repetitive and inefficient to do it again within this
		 * method. 
		 * 
		 * suffixIdentity = 1...This means the word ends in two consonants/vowels
		 * suffixIdentity = 2...This means the word ends in a single vowel
		 * suffixIdentity = 3...This means the word ends in a single consonant
		 */
		
		//the word with the suffix added
		String suffixWord = "";
		
		//returns true if the first letter of the suffix is a vowel
		boolean firstSuffixLetter = suffix.substring(0, 1).equals("A") || suffix.substring(0, 1).equals("C") 
						         || suffix.substring(0, 1).equals("S") || suffix.substring(0, 1).equals("L");
		
		//if the word ends in a single consonant
		if (suffixIdentity == 3) {
			
			//add the suffix and nothing else
			suffixWord = word + suffix; 
		}
		
		//if the word ends in a single vowel
		else if (suffixIdentity == 2) 
		{
			//if the first letter of the suffix is a vowel
			if (firstSuffixLetter == true) 
			{
				//the suffix now is the original suffix without the first letter
				suffix = suffix.substring(1, suffix.length()); 
				
				//add the suffix to the word
				suffixWord = word + suffix; 
			}
			
			//if the first letter of the suffix is a consonant
			else 
			{
				//add the first letter of the suffix to the suffix
				suffix = suffix.substring(0, 1) + suffix; 
				
				//add the suffix to the word
				suffixWord = word + suffix; 
			}
		}
		
		//if the word ends in two consonants/vowels
		else if (suffixIdentity == 1) 
		{
			//if the first suffix letter is a vowel
			if (firstSuffixLetter == true) 
			{
				//add the first letter of the suffix to the suffix
				suffix = suffix.substring(0, 1) + suffix; 
				
				//add the suffix to the word
				suffixWord = word + suffix; 
			}
			
			//if the first suffix letter is a consonant
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
		
		System.out.println("Suffix word is " + suffixWord); //print the suffix word
		System.out.println(); //print an extra line
	}
	
	private static int findPattern(String word, String suffix) { //finds the vowel/consonant pattern necessary for dropping the leftmost letter of a pattern
		
		//the count from which the program will search for a pattern in the word
		int count = 1;
		int vowelCount;
		
		//checks if the first letter of the suffix is a vowel
		boolean vowelIdentity = word.substring(word.length() - 1, word.length()).equals("A") ||
		                        word.substring(word.length() - 1, word.length()).equals("C") ||
		                        word.substring(word.length() - 1, word.length()).equals("S") ||
		                        word.substring(word.length() - 1, word.length()).equals("L");
		
		//checks, from right to left, whether each letter is a vowel, returning true if it is
		boolean letterCheck = (word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
							   word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
							   word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
							   word.substring(word.length() - count, word.length() - count + 1).equals("L"));
		
		//checks, from right to left, whether each letter is a consonant, returning true if it is
		boolean consonantCheck = !(word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
				   				   word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
				   				   word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
				   				   word.substring(word.length() - count, word.length() - count + 1).equals("L"));
		
		//if the first letter of the suffix is a vowel
		if (vowelIdentity == true)
		{
			//executes while the letter is a vowel and the count isn't longer than word length (so as to not return out of bounds error)
			while (letterCheck == true && count <= word.length())
			{
				//add one to the count
				count++;
				
				//check if the next letter to the left is still a vowel
				letterCheck = (word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
						       word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
						       word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
						       word.substring(word.length() - count, word.length() - count + 1).equals("L"));
			}
		}
		//executes if the first letter of the suffix is a consonant
		else
		{
			//executes while the letter is a consonant and the count isn't longer than the word length (no out of bounds errors)
			while (consonantCheck == true && count <= word.length())
			{
				//add one to the count
				count++;
				
				//check if the next letter to the left is a consonant
				consonantCheck = !(word.substring(word.length() - count, word.length() - count + 1).equals("A") ||
		   				           word.substring(word.length() - count, word.length() - count + 1).equals("C") ||
		   				           word.substring(word.length() - count, word.length() - count + 1).equals("S") ||
		   				           word.substring(word.length() - count, word.length() - count + 1).equals("L"));
			}
		}
		
		//sets the vowel or consonant pattern cutoff to 2 minus the count
		vowelCount = count - 2;
		
		return vowelCount;
	}
}
