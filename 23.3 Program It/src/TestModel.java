// Case Study 10.1: Tester program for TestScoresModel
// Nathan Johnson
// Modified 3/3/15

import java.util.*;

public class TestModel{

   public static void main (String[] args){

      // Create and display empty model
	  ArrayList<Student> t = new ArrayList<Student>();
	  ArrayList<Integer> scores = new ArrayList<Integer>();
      scores.add(100);
      scores.add(50);
      
	  for (int i = 0; i < 30; i++) {
		  String test = "Test Student " + i;
		  t.add(i, new Student(test, scores));
	  }
      TestScoresModel model = new TestScoresModel(t);
      System.out.println(model);

      // Display size, current position, and current student
      System.out.println(model.size());
      System.out.println(model.currentPosition());
      System.out.println(model.currentStudent());

      // Add and display 3 students
      for (int i = 1; i <= 3; i++){
         Student s = new Student("S" + i);
         model.add(s);
      }
      System.out.println(model);

      // Move to first student and display it
      System.out.println(model.first());

      // Move to next and previous and display them
      System.out.println(model.next());
      System.out.println(model.previous());

      // Move to last and next and display them
      System.out.println(model.last());
      System.out.println(model.next());

      // Display size, current position, and current student
      System.out.println(model.size());
      System.out.println(model.currentPosition());
      System.out.println(model.currentStudent());

      // Replace current student and display the model
      ArrayList<Integer> grades = new ArrayList<Integer>();
      grades.add(99);
      grades.add(88);
      grades.add(77);
      Student newStudent = new Student("Beth", grades);
      model.replace(newStudent);
      System.out.println(model);

      // Add more students and display results
      for (int i = 6; i <= 13; i++){
         Student s = new Student("S" + i);
         System.out.println(model.add(s));
      }
   }
}

