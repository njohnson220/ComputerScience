/*Nathan Johnson
 * 2/9/15
 * Deck tester class intended to test the Deck class and its included methods.
 */

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		//information for the first deck
		String[] ranks1 = {"ace", "king", "queen", "jack", "10", "9", "8", "7", "6", "5", "4", "3", "2",};
		String[] suits1 = {"spades", "hearts", "diamonds", "clubs"};
		int[] values1 = {11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		
		//information for the second deck
		String[] ranks2 = {"D", "E", "F", "G"};
		String[] suits2 = {"Giraffes", "Lions"};
		int[] values2 = {5, 7, 9};
		
		//information for the third deck
		String[] ranks3 = {"G", "H", "I", "J", "K"};
		String[] suits3 = {"Giraffes", "Lions", "Bears", "Pigs"};
		int[] values3 = {10, 13, 16, 19, 22, 25};
		
		//decks to be tested
		Deck deck1 = new Deck(ranks1, suits1, values1);
		Deck deck2 = new Deck(ranks2, suits2, values2);
		Deck deck3 = new Deck(ranks3, suits3, values3);

		//Method testing for deck1 object
		System.out.println(deck1.isEmpty());
		System.out.println(deck1.size());
		Card myCard = deck1.deal();
		System.out.println(myCard.toString()); //print the information included in the recently dealt card
		System.out.println(deck1.toString());
		
		//Method testing for deck2 object
		System.out.println(deck2.isEmpty());
		System.out.println(deck2.size());
		Card myCard2 = deck2.deal();
		System.out.println(myCard2.toString()); //print the information included in the recently dealt card
		System.out.println(deck2.toString());
		
		//Method testing for deck3 object
		System.out.println(deck3.isEmpty());
		System.out.println(deck2.size());
		Card myCard3 = deck3.deal();
		System.out.println(myCard3.toString()); //print the information included in the recently dealt card
		System.out.println(deck3.toString());

	}
}
