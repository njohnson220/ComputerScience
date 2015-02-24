/*Nathan Johnson
 * 2/24/15
 * This deck tester utilizes the Deck class which in itself utilizes the Card class.
 * It shuffles a deck of cards contained in the Deck class.
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
		
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();
		
		/* *** TO BE COMPLETED IN ACTIVITY 4 *** */
        //I made a deck to simulate a standard deck of playing cards
		System.out.println("THIS IS A NEW DECK FOR THE ACTIVITY 4 PROMPT");
		System.out.println("THIS IS A NEW DECK FOR THE ACTIVITY 4 PROMPT");
		System.out.println("THIS IS A NEW DECK FOR THE ACTIVITY 4 PROMPT\n");

		
		String[] ranks2 = {"jack", "queen", "king", "ace", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		String[] suits2 = {"clubs", "hearts", "diamonds", "spades"};
		int[] pointValues2 = {11, 12, 13, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Deck deck2 = new Deck(ranks2, suits2, pointValues2);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + deck2.toString());
		System.out.println("  isEmpty: " + deck2.isEmpty());
		System.out.println("  size: " + deck2.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + deck2.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + deck2.toString());
		System.out.println("  isEmpty: " + deck2.isEmpty());
		System.out.println("  size: " + deck2.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 51 Cards ****");
		for (int i = 0; i < 51; i++) {
			System.out.println("  deal: " + deck2.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + deck2.toString());
		System.out.println("  isEmpty: " + deck2.isEmpty());
		System.out.println("  size: " + deck2.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + deck2.deal());
		System.out.println();
		System.out.println();

	}
}
