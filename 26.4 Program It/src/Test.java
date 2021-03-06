/*
Nathan Johnson
3/25/15
Added sorting mechanism to the Test class, sorting students in order from lowest to highest grade.
Specifically, I used the selection sort model from the textbook by adapting it to this program's needs.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Test {


    private static FileInputStream inFile;
    private static InputStreamReader inReader;
    private static BufferedReader reader;


    private static List<Student> classroom = new ArrayList<Student>(); // ArrayList to store the classroom.

	public static void main(String args[]) throws IOException {
        initFile();
        getData();
        System.out.print(classroom + "\n\n\n");  //output of the complete class.
        //selectionSort();
		Collections.sort(classroom);
        System.out.print(classroom); //output after sorting.
        inFile.close();

    }

    public static int findLowestGrade(List<Student> unsortedList, int first) { //finds the lowest grade of the class in order to start the selection sort
        int minIndex = first;
        for (int i = first + 1; i < unsortedList.size(); i++) {
            if ((unsortedList.get(i).getScore()) < unsortedList.get(minIndex).getScore()) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(List<Student> swappingList, int x, int y) { //swaps two values of the student arraylist in order to facilitate sorting
        Student temporary = swappingList.get(x);
        swappingList.set(x, swappingList.get(y));
        swappingList.set(y, temporary);
    }

    public static void selectionSort() {  //selection sorts the student arraylist
        List<Student> sortedByGrade = classroom;
        for (int i = 0; i < sortedByGrade.size() - 1; i++) {
            int minIndex = findLowestGrade(sortedByGrade, i);
            if (minIndex != i) {
                swap(sortedByGrade, i, minIndex);
            }

        }
        classroom = sortedByGrade;
    }

    // preparing the file for input

    public static void initFile() throws IOException


    {
        inFile = new FileInputStream("c:\\!!VHSAPCS\\truefalse.txt");
        inReader = new InputStreamReader(inFile);
        reader = new BufferedReader(inReader);

    }


    //  Separate the id from the answers and store the answers in an array.

    public static void getData() throws IOException {
        String line = reader.readLine();  //Seed

        String[] answerkey = new String[10];  //Store the answer key from the first line of the txt file.

        for (int i = 0; i < answerkey.length; i++) { // take that line and place each answer in an array.

            answerkey[i] = line.substring(i, i + 1);
        }

        line = reader.readLine();    // read the following line of the txt file.


        while (line != null)   // Read and create a student for each line.
        {
            String[] answers = new String[10];
            StringTokenizer strTkn = new StringTokenizer(line);
            String id = strTkn.nextToken();
            String answerline = strTkn.nextToken();


            for (int i = 0; i < answers.length; i++) {

                answers[i] = answerline.substring(i, i + 1);

            }

            Student stu = new Student(id, answers);

            stu.grade(answerkey, answers);

            classroom.add(stu);


            line = reader.readLine();   //updating what is being read

        }

    }


    // In this method you should sort the classroom in ascending order depending on the score obtained on the quiz.
    public static void sort() {

        //Implementation of code here.


    }


}



