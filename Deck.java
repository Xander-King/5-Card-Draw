
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Class for deck
//Xander King (alexanderking864@gmail.com)
//03/13/2022
public class Deck {
///////////////////////////////////////////////Instance Variable
Card[] cardArr;
int deckSpace = 0;
////////////////////////////////////////////////Constructor
	public Deck(Card[] cardArr) {
		this.cardArr = cardArr;
	}
/////////////////////////////////////////////////Other Methods
	/*
	 * Shuffles the deck placing random cards in each index of the 
	 * array.
	 */
	public void shuffle() {
		Random rnd = ThreadLocalRandom.current();
	    for (int i = cardArr.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Card a = cardArr[index];
	      cardArr[index] = cardArr[i];
	      cardArr[i] = a;
	    }
	    deckSpace = 0;
	}
	/*
	 * deal 5 cards out to the player
	 */
	public Card[] deal() {
		Card[] newCardArr = new Card[5];
		int j = 0;
		int k = deckSpace + 5;
		for(int i=deckSpace; i < k; i++) {
			newCardArr[j] = cardArr[i];
			j++;
			deckSpace++;
		}
		return newCardArr;
	}
	/*
	 * reneg the player
	 */
	public Card nextCard() {
		Card c = cardArr[deckSpace];
		deckSpace++;
		return c;
	}
}
