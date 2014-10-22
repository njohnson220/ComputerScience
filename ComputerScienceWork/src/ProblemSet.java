//Nathan Johnson
//10/21/14
//7.5ProblemSet
//Demonstrates 9 different Math class and String class methods with interactive examples.

import java.util.Scanner;

public class ProblemSet {
	private static String prompt = "Enter a number:"; //a basic prompt string so I didn't have to type it over and over
	private static Scanner reader = new Scanner(System.in); //creates a scanner class for use in the methods below
	
	public static void main(String...Args) { //all the methods used
		
		getAbsoluteValue();
		roundUpNum();
		roundDownNum();
		findGreaterNum();
		findMinNum();
		getIndex();
		getStringLength();
		checkEmpty();
		getSubString();
		replaceCharacter();
	}
	
	private static void getAbsoluteValue() { //gets absolute value from an entered double number and outputs it
		System.out.println(prompt);
		double numInput = reader.nextDouble();
		double absoluteValue = Math.abs(numInput); //finds the absolute value of the entered input
		System.out.println("The absolute value of " + numInput + " is " + absoluteValue);
	}
	
	private static void roundUpNum() { //rounds up a number to the closest integer
		System.out.println(prompt);
		double numInput = reader.nextDouble();
		double roundUp = Math.ceil(numInput); //rounds up a number to the closest integer
		System.out.println(numInput + " rounds up to " + roundUp);
	}
	
	private static void roundDownNum() { //rounds down a number to the closest integer
		System.out.println(prompt);
		double numInput = reader.nextDouble();
		double roundDown = Math.floor(numInput); //rounds down a number to the closest integer
		System.out.println(numInput + " rounds down to " + roundDown);
	}
	
	private static void findGreaterNum() { //finds the greater of two entered integers and outputs
		System.out.println("Enter an integer:");
		int a = reader.nextInt();
		System.out.println("Enter another integer:");
		int b = reader.nextInt();
		int greaterNum = Math.max(a, b); //finds the larger of the two integers passed to it
		System.out.println("Out of " + a + " and " + b + ", " + greaterNum + " is the largest.");
	}
	
	private static void findMinNum() { //finds the smallest of two entered integers and outputs
		System.out.println("Enter an integer:");
		int a = reader.nextInt();
		System.out.println("Enter another integer:");
		int b = reader.nextInt();
		int smallerNum = Math.min(a, b); //finds the smaller of two integers passed to it
		System.out.println("Out of " + a + " and " + b + ", " + smallerNum + " is the smallest.");
	}
	
	private static void getIndex() { //names the first location of a specified character in a string
		Scanner reader = new Scanner(System.in); //for some reason the global scanner wouldn't work with the string methods, so I used local scanner methods thereafter
		System.out.println("Enter a string:");
		String testString = reader.nextLine();
		System.out.println("Enter a character you want to find:");
		char myChar = reader.next().charAt(0); //gets the character at the 0th place of a line
		int charOccurence = testString.indexOf(myChar) + 1;
		System.out.println(myChar + " occurs at the " + charOccurence + " character");
	}
	
	private static void getStringLength() { //gets how many characters are in an entered string
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string:");
		String string = reader.nextLine();
		int lengthOfString = string.length(); //gets the length of the string
		System.out.println("Your string is " + lengthOfString + " characters long.");
	}
	
	private static void checkEmpty() { //checks to see if entered string is empty and replies with appropriate responses
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string:");
		String string = reader.nextLine();
		boolean isStringEmpty = string.isEmpty();
		if (isStringEmpty == true) { //I looked up how to use if else statements and used it to give two outputs depending on string content
			System.out.println("Your string is empty!");
		} else {
			System.out.println("Your string has content!");
		}
	}
	
	private static void getSubString() { //grabs the substring of an existing string and outputs it
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string:");
		String myString = reader.nextLine();
		System.out.println("Enter character number of beginning cutoff:");
		int beginIndex = reader.nextInt();
		System.out.println("Enter character number of ending cutoff:");
		int endIndex = reader.nextInt();
		System.out.println(myString.substring(beginIndex, endIndex) + " is your new substring."); //I found that I can do my string methods inside the print statement
	}
	
	private static void replaceCharacter() { //replaces a specified type of character and replaces it with a new one
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string:");
		String myString = reader.nextLine();
		System.out.println("Enter the old character you'd like to replace:");
		char oldChar = reader.next().charAt(0);
		System.out.println("Enter the new character you'd like to insert:");
		char newChar = reader.next().charAt(0);
		System.out.println(myString.replace(oldChar, newChar)); //replaces the old characters with a new ones in the entered string
	}
}










