import java.util.Scanner;

public class Example2dot3 {
	public static void main(String...args) {
		Scanner reader = new Scanner(System.in);
		
		double kilometers;
		double nautical;		
		System.out.println("Enter distance in kilometers: ");
		kilometers = (int)reader.nextDouble();
		
		nautical = ((60.0 * 90.0)/10000) * kilometers;
		System.out.println(kilometers);
		System.out.println("There are " + nautical + " nautical miles in " + kilometers + " kilometers");
	}
}
