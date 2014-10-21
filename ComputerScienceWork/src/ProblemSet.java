import java.util.Scanner;

public class ProblemSet {
	private static String prompt = "Enter a number:";
	private static Scanner reader = new Scanner(System.in);
	private static double testVariable = 1.23;
	
	public static void main(String...Args) {
		
		//getAbsoluteValue();
		//roundUpNum();
		//roundDownNum();
		//findGreaterNum();
		//findMinNum();
		//getIndex();
		//getStringLength();
		checkEmpty();
	}
	
	private static void getAbsoluteValue() {	
		System.out.println(prompt);
		double numInput = reader.nextDouble();
		double absoluteValue = Math.abs(numInput);
		System.out.println("The absolute value of " + numInput + " is " + absoluteValue);
	}
	
	private static void roundUpNum() {
		System.out.println(prompt);
		double numInput = reader.nextDouble();
		double roundUp = Math.ceil(numInput);
		System.out.println(numInput + " rounds up to " + roundUp);
	}
	
	private static void roundDownNum() {
		System.out.println(prompt);
		double numInput = reader.nextDouble();
		double roundDown = Math.floor(numInput);
		System.out.println(numInput + " rounds down to " + roundDown);
	}
	
	private static void findGreaterNum() {
		System.out.println("Enter an integer:");
		int a = reader.nextInt();
		System.out.println("Enter another integer:");
		int b = reader.nextInt();
		int greaterNum = Math.max(a, b);
		System.out.println("Out of " + a + " and " + b + ", " + greaterNum + " is the largest.");
	}
	
	private static void findMinNum() {
		System.out.println("Enter an integer:");
		int a = reader.nextInt();
		System.out.println("Enter another integer:");
		int b = reader.nextInt();
		int smallerNum = Math.min(a, b);
		System.out.println("Out of " + a + " and " + b + ", " + smallerNum + " is the smallest.");
	}
	
	private static void getIndex() {
		System.out.println("Enter a string:");
		String string = reader.nextLine();
		System.out.println("Enter a character you want to find:");
		char myChar = reader.next().charAt(0);
		int charOccurence = string.indexOf(myChar) + 1;
		System.out.println(myChar + " occurs at the " + charOccurence + " character");
	}
	
	private static void getStringLength() {
		System.out.println("Enter a string:");
		String string = reader.nextLine();
		int lengthOfString = string.length();
		System.out.println("Your string is " + lengthOfString + " characters long.");
	}
	
	private static void checkEmpty() {
		System.out.println("Enter a string:");
		String string = reader.nextLine();
		boolean isStringEmpty = string.isEmpty();
		if (isStringEmpty == true) {
			System.out.println("Your string is empty!");
		} else {
			System.out.println("Your string has content!");
		}
	}
}
