
public class Example2dot4 {
	public static void main(String...args) {
		
		double days = 365.25; //days per year
		double hours = 24; //hours per day
		double minutes = 60; //minutes per hour
		double minutesPerYear = days * hours * minutes;
		
		System.out.println("There are " + minutesPerYear + " minutes in every year.");
	}

}
