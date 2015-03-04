import java.util.ArrayList;

// Case Study 10.1: The main application class

public class TestScoresApp{

   public static void main(String[] args){
	  ArrayList<Student> t = new ArrayList<Student>();
	  TestScoresModel model = new TestScoresModel(t);
      new TestScoresView(model);
   }
}