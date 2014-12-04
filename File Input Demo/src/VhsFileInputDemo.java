// file input demo

import java.io.*;
import java.util.StringTokenizer;

public class VhsFileInputDemo 
{
  // variables necessary for file input
  private static FileInputStream inFile;
  private static InputStreamReader inReader;
  private static  BufferedReader reader;

  //  StringTokenizer variable used to separate line into different data elements
  private static StringTokenizer strTkn;

  // program variables to hold data
  private static String line,word;
  private static int num1, num2,num3,grade, total;
  private static double avg;
  
  // throws IOException will have the operating system handle any problems
  // that may occur while attempting to acquired data from the file.
  
  public static void main (String args[]) throws IOException
  {

    initFile();  
    getData();
    calcTotal();
    printResults();
    
    // closing the data file
    inFile.close();
  }
  
 
 // preparing the file for input
 
  public static void initFile() throws IOException
  {
    inFile = new FileInputStream ("C:\\!!VHSAPCS\\test.txt"); // notice the double slash marks
    inReader = new InputStreamReader(inFile);
    reader = new BufferedReader(inReader);
  }
  
  
  //data acquisition method
  
  public static void getData() throws IOException
  {
     line = reader.readLine();   //acquiring the data line as a string
    System.out.println ("data line = " + line ); // view data line as one string
    System.out.println();
    
    strTkn = new StringTokenizer(line);  // attaching the string tokenizer to the line
    
    // placing the first word in the dataline into a string variable    
    word = strTkn.nextToken();
     
    // extracting the parts of the line into separate int and double variables
    grade = Integer.parseInt(strTkn.nextToken());
    avg = Double.parseDouble(strTkn.nextToken());
    num1 = Integer.parseInt(strTkn.nextToken());
    num2 = Integer.parseInt(strTkn.nextToken());
    num3 = Integer.parseInt(strTkn.nextToken());
  }  
    
   // processing the int totals   
  public static void calcTotal()
  {
    total = num1 + num2 + num3;
   
  }  

    // output results

  public static void printResults()
  {
    System.out.println("Separated data line :");
    System.out.println(word);
    System.out.println (grade);
    System.out.println (avg);
    System.out.println(num1);
    System.out.println(num2);
    System.out.println(num3);
    
    System.out.println("sum of numbers = " + total); 
  }    
  
} // end of class 
 