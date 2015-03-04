// Case Study 10.1: Student class
// Nathan Johnson
// Revised 3/3/15

import java.util.*;

public class Student {

   private String name;
   //private int[] tests;
   private ArrayList<Integer> tests;

   // Default: Name is "" and 3 scores are 0
   public Student(){
      this("");
   }
    
   // Name is nm and 3 scores are 0
   public Student(String nm){
      this(nm, 3);
   }

   // Name is nm and n scores are 0
   public Student(String nm, int n){
      name = nm;
      //tests = new int[n];
      tests = new ArrayList<Integer>(n);
      for (int i = 0; i < tests.size(); i++) {
    	  tests.add(0);
      }
   }

   // Name is nm and scores are in t
   public Student(String nm, ArrayList<Integer> t){
	   name = nm;
	   tests = new ArrayList<Integer>(t.size());
	   for (int i = 0; i < t.size(); i++) {
		   tests.add(t.get(i));
	   }
   }
    
   // Builds a copy of s
   public Student(Student s){
      this(s.name, s.tests);
   }
    
   public void setName (String nm){
      name = nm;
   }
    
   public String getName (){
      return name;
   }
    
   public void setScore (int i, int score){
	   tests.set(i - 1, score);
   }

   public int getScore (int i){
	   return tests.get(i - 1);
   }
   
   public int getAverage(){
        int sum = 0;
        for (int i = 0; i < tests.size(); i++) {
        	int score = tests.get(i);
            sum += score;	
        }
        if (tests.size() == 0) {
        	return 0;
        }
        else {
        	return sum / tests.size();
        }
   }
    
   public int getHighScore(){
      int highScore = 0;
      for (int score : tests)
         highScore = Math.max (highScore, score);
      return highScore;
   }
    
   public String toString(){
      String str = "Name:    " + name  + "\n";
      for (int i = 0; i < tests.size(); i++)
         str += "test " + i + ":  " + tests.get(i) + "\n";
      str += "Average: " + getAverage();
      return str;
   } 

   //Returns null if there are no errors else returns
   //an appropriate error message.
   public String validateData(){
      if (name.equals ("")) return "SORRY: name required";
      for (int score : tests){
         if (score < 0 || score > 100){
            String str = "SORRY: must have "+ 0
                         + " <= test score <= " + 100;  
            return str;
         }
      }
      return null;
   }  
}

