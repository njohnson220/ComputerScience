import java.util.*;


public class Student {
	
	private String id;
	private String [] quizresult=new String[10]; 
	private int score;
	
	public Student(){
		
		id=" ";
		for(int i =0; i<quizresult.length; i++){
		     quizresult[i]="";
		     			
		}
		
		score =0;
	}
	
	
	public Student(String a, String[] answers){
		
		id=a;
		
		for(int i=0; i<answers.length; i++){
			
			quizresult[i]=answers[i];
			
		}
		
		score = 0;
		
	}
	
	public String [] getAnwers(){
		
		return quizresult;
		
	}
	
	public String getId(){
		
		return id;
		
	}
	
	
	public void grade(String [] answerkey, String[] studentanswer){
		
		int count=0;
		
				for(int i=0; i<answerkey.length; i++){
					
					if(answerkey[i].equals(studentanswer[i])){
						
						count = count+10;
						
					}
					
				}
		
				score = count;
		
		
	}
	
	public String toString(){
		
		String a = "Student id: " + id + " " +  Arrays.toString(quizresult) + " The score for this quiz is:  " +  score + "\n";
		
		return a;
		
		
			
			}

}
	
	


