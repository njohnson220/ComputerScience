/*
 * Copyright (c) 2015. Nathan Johnson
 */

public class methods

{

/* The use of private here establishes that only methods in this class can use these variables.
 *  Use of static indicates that these variables belong to the entire class. ( we will spend 
 *  more time on the static concept later )*/

private static int numberOfPeople;

private static double money;

private static double share;

public static void main(String Args[])

{

/* These are method call statements, they send control to the method to be executed. Once the method has been executed,
 *  control is returned to the line immediately following the call statement. setNumPeople() is called, 
 *  the method is carried out and then control returns back to main to execute the next line of code which 
 *  is a call to method calcShare() . Since all of this is in the same class, no objects of class Share need 
 *  to be declared or instantiated and just the method names can be used.*/

setNumPeople();

calcShare();

printResults();

}

// Notice the documentation lines identifying the task of the method.

 

// Establish the number of people with whom to share money.

public static void setNumPeople() // Each method begins with a header line and ends with the closing brace.

{

// Notice that each method has a set of braces that enclose the method's code.

numberOfPeople = 70;

}

// Amount of money to be shared

public static void calcShare() // no semi-colon ; is placed at the end of method header lines.

{

money = 7500;

share = money / numberOfPeople;

}

// output results

public static void printResults() {

System.out.println("Give each person " + share);

}

} // end of Share class