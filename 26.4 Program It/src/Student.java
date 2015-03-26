import java.util.*;


public class Student implements Comparable<Student> {

    private String id;
    private String[] quizresult = new String[10];
    private int score;
    private String letterGrade;

    public Student() {

        id = " ";
        for (int i = 0; i < quizresult.length; i++) {
            quizresult[i] = "";
        }

        score = 0;
    }

    public Student(String a, String[] answers) {

        id = a;

        for (int i = 0; i < answers.length; i++) {

            quizresult[i] = answers[i];

        }

        score = 0;

    }

    public String[] getAnwers() {
        return quizresult;

    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;

    }

    public String getLetterGrade() { //returns the letter grade of said student
        return letterGrade;
    }


    public void grade(String[] answerkey, String[] studentanswer) {

        int count = 0;

        for (int i = 0; i < answerkey.length; i++) {

            if (answerkey[i].equals(studentanswer[i])) {

                count = count + 10;

            }

        }

        score = count;


    }

    private String setLetterGrade() { //this method gets a letter grade based on his/her number score
        int numberGrade = score;
        if (score >= 90) {
            letterGrade = "A";
        }
        else if (score >= 80 && score < 90) {
            letterGrade = "B";
        }
        else if (score >= 70 && score < 80) {
            letterGrade = "C";
        }
        else if (score >= 60 && score < 70) {
            letterGrade = "D";
        }
        else if (score < 60) {
            letterGrade = "F";
        }

        return letterGrade;
    }

    public String toString() {

        String a = "Student id: " + id + " " + Arrays.toString(quizresult) + " The score for this quiz is:  " + score
                    + " The letter grade for this quiz is: " + setLetterGrade() + "\n";

        return a;


    }

	@Override
	public int compareTo(Student that) {
		if (this.getScore() == that.getScore()) {
			return 0;
		} else if (this.getScore() < that.getScore()) {
			return -1;
		} else if (this.getScore() > that.getScore()) {
			return 1;
		}
		return 1;
	}
}

	


