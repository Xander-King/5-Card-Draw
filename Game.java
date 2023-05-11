import java.util.Arrays;
import java.util.Scanner;
/*
 * MAIN CLASS
 * Goes through the steps of playing the game, with many helper methods
 * Xander King
 */
public class Game {

	
	public static void main(String[] args) {
		
		//Building the generic deck
		
		Deck genericDeck = buildGenericDeck();
		
		//Shuffle & Deal
		
		genericDeck.shuffle();
		Card[] playerHand = genericDeck.deal();
		Card[] comHand = genericDeck.deal();
		Player player = new Player(playerHand);
		Player com = new Player(comHand);
		
		while(player.coins > 0) {
		//Deck reshuffle
			
		genericDeck.shuffle();
		player.hand = genericDeck.deal();
		com.hand = genericDeck.deal();
			
		//Display coins
		
		displayCoins(player);
		
		//Bet
		Scanner s = new Scanner(System.in);
		player.bet = 0;
		while(!betRead(player, s)) {}
		
		//Display Starting Hand

		displayStartingHand(player);
		
		//Renege Option
			
		while(!sequenceRead(player, genericDeck, s)) {}
		
		//Display final hand
		
		displayFinalHand(player, com);
		
		//Determine winner
		
		compareHands(player, com);
		
		}
		
		System.out.println("You lose the game!");
		System.out.println("You ran out of coins, try again :)");
		
		
		//End game
		
	}
	//===================================================Helper Methods
	
	//====================================================Deck Building
	
	/*
	 * Method that builds a generic 52 card deck.
	 */
	
	/*
	 * Ace = 1
	 * 2 = 2
	 * 3 = 3
	 * 4 = 4
	 * 5 = 5
	 * 6 = 6
	 * 7 = 7
	 * 8 = 8
	 * 9 = 9
	 * 10 = 10
	 * jack = 11
	 * queen = 12
	 * king = 13
	 */
	public static Deck buildGenericDeck() {
		Card aceSpade = new Card(1, "Spade");
		Card twoSpade = new Card(2, "Spade");
		Card threeSpade = new Card(3, "Spade");
		Card fourSpade = new Card(4, "Spade");
		Card fiveSpade = new Card(5, "Spade");
		Card sixSpade = new Card(6, "Spade");
		Card sevenSpade = new Card(7, "Spade");
		Card eightSpade = new Card(8, "Spade");
		Card nineSpade = new Card(9, "Spade");
		Card tenSpade = new Card(10, "Spade");
		Card jackSpade = new Card(11, "Spade");
		Card queenSpade = new Card(12, "Spade");
		Card kingSpade = new Card(13, "Spade");
		
		Card aceClub = new Card(1, "Club");
		Card twoClub = new Card(2, "Club");
		Card threeClub = new Card(3, "Club");
		Card fourClub = new Card(4, "Club");
		Card fiveClub = new Card(5, "Club");
		Card sixClub = new Card(6, "Club");
		Card sevenClub = new Card(7, "Club");
		Card eightClub = new Card(8, "Club");
		Card nineClub = new Card(9, "Club");
		Card tenClub = new Card(10, "Club");
		Card jackClub = new Card(11, "Club");
		Card queenClub = new Card(12, "Club");
		Card kingClub = new Card(13, "Club");
		
		Card aceHeart = new Card(1, "Heart");
		Card twoHeart = new Card(2, "Heart");
		Card threeHeart = new Card(3, "Heart");
		Card fourHeart = new Card(4, "Heart");
		Card fiveHeart = new Card(5, "Heart");
		Card sixHeart = new Card(6, "Heart");
		Card sevenHeart = new Card(7, "Heart");
		Card eightHeart = new Card(8, "Heart");
		Card nineHeart = new Card(9, "Heart");
		Card tenHeart = new Card(10, "Heart");
		Card jackHeart = new Card(11, "Heart");
		Card queenHeart = new Card(12, "Heart");
		Card kingHeart = new Card(13, "Heart");
		
		Card aceDim = new Card(1, "Diamond");
		Card twoDim = new Card(2, "Diamond");
		Card threeDim = new Card(3, "Diamond");
		Card fourDim = new Card(4, "Diamond");
		Card fiveDim = new Card(5, "Diamond");
		Card sixDim = new Card(6, "Diamond");
		Card sevenDim = new Card(7, "Diamond");
		Card eightDim = new Card(8, "Diamond");
		Card nineDim = new Card(9, "Diamond");
		Card tenDim = new Card(10, "Diamond");
		Card jackDim = new Card(11, "Diamond");
		Card queenDim = new Card(12, "Diamond");
		Card kingDim = new Card(13, "Diamond");
		
		Card[] cArr = {aceSpade, twoSpade, threeSpade, fourSpade,
				fiveSpade, sixSpade, sevenSpade, eightSpade, nineSpade,
				tenSpade, jackSpade, queenSpade, kingSpade, aceClub,
				twoClub, threeClub, fourClub, fiveClub, sixClub,
				sevenClub, eightClub, nineClub, tenClub, jackClub,
				queenClub, kingClub, aceHeart, twoHeart, threeHeart,
				fourHeart, fiveHeart, sixHeart, sevenHeart, eightHeart,
				nineHeart, tenHeart, jackHeart, queenHeart, kingHeart,
				aceDim, twoDim, threeDim, fourDim, fiveDim, sixDim,
				sevenDim, eightDim, nineDim, tenDim, jackDim, queenDim,
				kingDim};
		
		Deck genericDeck = new Deck(cArr);
		return genericDeck;
		
	}
	//============================================================Display
	
	/*
	 * Displays amount of coins and prompts player to bet
	 */
	public static void displayCoins(Player p) {
		System.out.println("Coins: " + p.coins);
		System.out.println("Type amount to bet");
	}
	
	/*
	 * Instructs the player and displays their given starting hand
	 */
	public static void displayStartingHand(Player p) {
		System.out.println("Type letter sequence to renege");
		System.out.println("Type 0 to keep hand");
		System.out.println("Starting Hand:");
		System.out.println(p.toString());
	}
	/*
	 * Displays the players final hand and the computers hand
	 */
	public static void displayFinalHand(Player p, Player com) {
		System.out.println("Final Hand:");
		System.out.println(p.toString());
		System.out.println("Opponent Hand:");
		System.out.println(com.toString());
	}
	
	//===========================================================Bet
	/*
	 * retrieves the bet given by input of player
	 */
	public static int getBet(Scanner s) {
			String bet = s.nextLine();
		int intBet = Integer.parseInt(bet);
		return intBet;
	}
	/*
	 * reads the given amount for a bet, checks that it is viable, and places
	 * that bet
	 */
	public static boolean betRead(Player p, Scanner s) {
		int bet = getBet(s);
		if(!betCheck(p, bet)) {
			System.out.println("Incorrect input");
			System.out.println("Try again:");
			return false;
		}
		p.coins = p.coins - bet;
		p.bet = bet;
		System.out.println("A " + bet + " coin bet is placed.");
		return true;
	}
	/*
	 * Helper method for betRead. Checks the bet to make sure it is a viable one. 
	 */
	public static boolean betCheck(Player p, int bet) {
		
		if(bet <= 0 || bet > p.coins) {
			return false;
		}
		return true;
	}
		
	
	//===========================================================Renege
	/*
	 * retrieves the sequence given by input of the player
	 */
	public static String getSequence(Scanner s) {
		
		String sequence = s.nextLine();
		return sequence;
	}
	
	
	/*
	 * reads the sequence and reneges cards in the given positions.
	 * Reprompts if the input is incorrect syntax
	 */
	public static boolean sequenceRead(Player p, Deck d, Scanner s) {
		String sequence = getSequence(s);
		if(!sequenceCheck(sequence)) {
			System.out.println("Incorrect input");
			System.out.println("Try again:");
			return false;
			
		}
		for(int i = 0; i < sequence.length(); i++) {
			
			if(sequence.charAt(i) == 'a') {
				p.hand[0] = d.nextCard();
			}
			
			else if(sequence.charAt(i) == 'b') {
				p.hand[1] = d.nextCard();
			}
			
			else if(sequence.charAt(i) == 'c') {
				p.hand[2] = d.nextCard();
			}
			
			else if(sequence.charAt(i) == 'd') {
				p.hand[3] = d.nextCard();
			}
			
			else if(sequence.charAt(i) == 'e') {
				p.hand[4] = d.nextCard();
			}
			
			else if(sequence.charAt(i) == '0') {
				return true;
			}
			
		}
		return true;
	}
	
	/*
	 * Helper method for sequence read, checks to make sure all characters used are
	 * valid response characters.
	 */
	public static boolean sequenceCheck(String sequence) {
		for(int i=0; i < sequence.length(); i++) {
			if(sequence.charAt(i) != 'a' && sequence.charAt(i) != 'b' &&
					sequence.charAt(i) != 'c' && sequence.charAt(i) != 'd' &&
					sequence.charAt(i) != 'e' && sequence.charAt(i) != '0') {
				return false;
			}
		}
		return true;
	}
	
	//============================================================Determine Winner
	/*
	 * Method to determine which player wins the game from 
	 * comparing their hands, returns the player that wins
	 */
	public static void compareHands(Player p, Player c) {
		
		int playerRanking = getRanking(p);
		int comRanking = getRanking(c);
		
		if(playerRanking == 1 && comRanking == 1 ||
				playerRanking == 5 && comRanking == 5 ||
				playerRanking == 6 && comRanking == 6 ||
				playerRanking == 9 && comRanking == 9) {
			genericTie(p, c);
		}
		
		if(playerRanking == 2 && comRanking == 2) {
			pairTie(p, c);
		}
		
		if(playerRanking == 3 && comRanking == 3) {
			twoPairTie(p, c);
		}
		
		if(playerRanking == 4 && comRanking == 4 ||
				playerRanking == 7 && comRanking == 7) {
			threeOfAKindTie(p, c);
		}
		
		if(playerRanking == 8 && comRanking == 8) {
			fourOfAKindTie(p, c);
		}
		
		if(playerRanking == 10 && comRanking == 10) {
			playerTie(p);
		}
		
		if(playerRanking > comRanking) {
			playerWin(p);
		}
		
		if(playerRanking < comRanking) {
			playerLose(p);
		}

	
	}
	
	/*
	 * Helper method for compareHands, gets the ranking of 
	 * each players hand to later compare them
	 * Rankings go in this order:
	 * 
	 * Royal Flush
	 * Straight Flush
	 * Four of a Kind
	 * Full House
	 * Flush
	 * Straight
	 * Three of a Kind
	 * Two Pair
	 * Pair
	 * High Card
	 */
	public static int getRanking(Player p) {
		if(royalFlushCheck(p)) {
			return 10;
		}
		if(flushCheck(p) && straightCheck(p)) {
			return 9;
		}
		if(fourOfAKindCheck(p)) {
			return 8;
		}
		if(fullHouseCheck(p)) {
			return 7;
		}
		if(flushCheck(p)) {
			return 6;
		}
		if(straightCheck(p)) {
			return 5;
		}
		if(threeOfAKindCheck(p)) {
			return 4;
		}
		if(twoPairCheck(p)) {
			return 3;
		}
		if(pairCheck(p)) {
			return 2;
		}
		//signals the highest card comparison mode if both players
		//Receive ranking 1
		return 1;
	}
	
	/*
	 * Changes card numbers into an int array for sorting
	 * and easier checks.
	 */
	public static int[] cardTrans(Player p) {
		int[] handArr = new int[5];
		for(int i = 0; i < 5; i++) {
			handArr[i] = p.hand[i].number;
		}
		Arrays.sort(handArr);
		return handArr;
	}
	
	/*
	 * Checks hand for a flush
	 */
	public static boolean flushCheck(Player p) {
		for(int i = 1; i < p.hand.length; i++) {
			if(!(p.hand[0].suit.equals(p.hand[i].suit))) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Checks hand for a straight
	 */
	public static boolean straightCheck(Player p) {
		int[] handArr = cardTrans(p);
	
		for(int i = 1; i < handArr.length; i++) {
			if(handArr[i-1] + 1 != handArr[i]) {
				return false;
			}
		}
		return true;
	}
	/*
	 * Checks hand for a royal flush.
	 */
	public static boolean royalFlushCheck(Player p) { 
		if(flushCheck(p) && straightCheck(p) &&
				p.hand[4].number == 13) {
			return true;
		}
		return false;
	}

	/*
	 * Checks hand for a four of a kind
	 */
	public static boolean fourOfAKindCheck(Player p) {
		
		int[] handArr = cardTrans(p);

		
		if(handArr[0] == handArr[3] || handArr[1] == handArr[4]) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * Checks hand for a three of a kind
	 */
	public static boolean threeOfAKindCheck(Player p) {
		
		int[] handArr = cardTrans(p);
		
		if(handArr[0] == handArr[2] || handArr[1] == handArr[3] ||
				handArr[2] == handArr[4]) {
			return true;
		}
		return false;
	}
	
	/*
	 * checks the players hand for a two pair
	 */
	public static boolean twoPairCheck(Player p) {
		
		int[] handArr = cardTrans(p);
		
		if((handArr[0] == handArr[1] && (handArr[2] == handArr[3]
				|| handArr[3] == handArr[4])) || (handArr[1] == handArr[2]
						&& handArr[3] == handArr[4])) {
			return true;
		}
		return false;
	}
	
	/*
	 * Checks hand for a two pair
	 */
	public static boolean pairCheck(Player p) {
		
		int[] handArr = cardTrans(p);
		
		if(handArr[0] == handArr[1] || handArr[1] == handArr[2] ||
				handArr[2] == handArr[3] || handArr[3] == handArr[4]) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * Checks hand for a full house
	 */
	public static boolean fullHouseCheck(Player p) {
			
		int[] handArr = cardTrans(p);
			
			if((handArr[0] == handArr[2] && handArr[3] == handArr[4])
					|| (handArr[0] == handArr[1]
							&& handArr[2] == handArr[4])) {
				return true;
				
			}
			
			return false;
		}
	
	//=============================================Ties
	
	//NO TRICK
	/*
	 * in the case of a no trick tie compares the highest cards
	 */
	public static void genericTie(Player p, Player c) {
		
		int[] playerHand = cardTrans(p);
		int[] comHand = cardTrans(c);
		
		if(playerHand[4] == comHand[4]) {
			playerTie(p);
		}
		if(playerHand[4] > comHand[4]) {
			playerWin(p);
		}
		if(playerHand[4] < comHand[4]) {
			playerLose(p);
		}
	}
	
		//PAIR
		/*
		 * in the case of a pair tie, compares the pairs to see which is
		 * higher
		 */
	public static void pairTie(Player p, Player c) {
		
		int[] playerHand = cardTrans(p);
		int[] comHand = cardTrans(c);
		
		int playerPair = findPairValue(playerHand);
		int comPair = findPairValue(comHand);
		
		if(playerPair == comPair) {
			playerTie(p);
		}
		
		if(playerPair > comPair) {
			playerWin(p);
		}
		
		if(playerPair < comPair) {
			playerLose(p);
		}
		
	}
	
	/*
	 * finds the value of the players pair
	 */
	public static int findPairValue(int[] hand) {
		int i = 1;
	
		while(hand[i-1] != hand[i]) {
			i++;
		}
	
		return hand[i];
	}

	//TWO PAIR
	/*
	 * In the case of a two pair tie, compares the highest
	 *  pair of each player
	 */
	public static void twoPairTie(Player p, Player c) {
		
		int[] playerHand = cardTrans(p);
		int[] comHand = cardTrans(c);
		
		int playerTwoPair = findTwoPairValue(playerHand);
		int comTwoPair = findTwoPairValue(comHand);
		
		if(playerTwoPair == comTwoPair) {
			playerTie(p);
		}
		
		if(playerTwoPair > comTwoPair) {
			playerWin(p);
		}
		
		if(playerTwoPair < comTwoPair) {
			playerLose(p);
		}
		
	}
	
	/*
	 * Helper method for twoPairTie finds the value of the
	 *  highest pair in the deck 
	 */
	public static int findTwoPairValue(int[] hand) {
		
		int pair1 = 0;
		int pair2 = 0;
		
		for(int i = 1; i < hand.length; i++) {
			if(hand[i-1] == hand[i]) {
				if(pair1 == 0) {
					pair1 = hand[i];
				}
				else {
					pair2 = hand[i];
				}
			}
		}
		
		if(pair1 > pair2) {
			return pair1;
		}
		
		return pair2;
	}
	
	//THREE OF A KIND 
	/*
	 * In the case of a three of a kind tie, finds the player with the 
	 * higher three of a kind.
	 */
	public static void threeOfAKindTie(Player p, Player c) {
		
		int[] playerHand = cardTrans(p);
		int[] comHand = cardTrans(c);
		
		int playerThreeOfAKind = findThreeOfAKindValue(playerHand);
		int comThreeOfAKind = findThreeOfAKindValue(comHand);
		
		if(playerThreeOfAKind == comThreeOfAKind) {
			playerTie(p);
		}
		
		if(playerThreeOfAKind > comThreeOfAKind) {
			playerWin(p);
		}
		
		if(playerThreeOfAKind < comThreeOfAKind) {
			playerLose(p);
		}
	}
	
	/*
	 * Helper method for threeOfAKindTie, finds the value of the 
	 * players three of a kind.
	 */
	public static int findThreeOfAKindValue(int[] hand) {
		int value = 0;
		
		for(int i = 1; i < hand.length-1; i++) {
			if(hand[i-1] == hand[i] && hand[i] == hand[i+1]) {
				value = hand[i];
			}
		}
		return value;
	}
	
	/*
	 * In the case of a four of a kind tie, finds the player with
	 * the higher 4 of a kind hand.
	 */
	public static void fourOfAKindTie(Player p, Player c) {

		int[] playerHand = cardTrans(p); 
		int[] comHand = cardTrans(c);
		
		int playerFourOfAKind = findFourOfAKindValue(playerHand);
		int comFourOfAKind = findFourOfAKindValue(comHand);
		
		if(playerFourOfAKind == comFourOfAKind) {
			playerTie(p);
		}
		
		if(playerFourOfAKind > comFourOfAKind) {
			playerWin(p);
		}
		
		if(playerFourOfAKind < comFourOfAKind) {
			playerLose(p);
		}
		
	}
	
	/*
	 * Helper method for fourOfAKindTie, retrieves the value of the four
	 * of a kind in the players hand.
	 */
	public static int findFourOfAKindValue(int[] hand) {
		
		int value = 0;
		
		if(hand[0] == hand[3]) {
			value = hand[0];
		}
		
		if(hand[1] == hand[4]) {
			value = hand[1];
		}
		
		return value;
	}
	
	
	//=============================================Win Sequence
	/*
	 * Sequence for when the player wins the hand (gains half of the bet
	 * they placed)
	 */
	public static void playerWin(Player p) {
		
		int newBet = (int)(p.bet * .5);
		p.coins = p.coins + newBet + p.bet;
		
		System.out.println("You won the hand!");
		System.out.println("Added " + newBet + " to your coins");
		
	}
	
	//=============================================Lose Sequence
	/*
	 * Sequence for when the player loses the hand (loses half of the bet
	 * they placed)
	 */
	public static void playerLose(Player p) {
		
		
		System.out.println("You lose the hand!");
		System.out.println("Subtracted " + p.bet + " from your coins");
	}
	
	//=============================================Tie Sequence
	/*
	 * Sequence for when the player and the computer tie
	 */
	public static void playerTie(Player p) {
		p.coins = p.coins + p.bet;
		System.out.println("You and the computer tied hands");
		System.out.println("No effect on your coins");
	}
	
	
	
	
}