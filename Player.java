

//Class for a player
//03/26/2022
//Xander king (alexanderking864@gmail.com)

public class Player {
	
//============================================Instance Variable
	Card[] hand;
	int coins = 50;
	int bet = 0;

//============================================Constructor
	public Player(Card[] hand) {
		this.hand = hand;
	}

//============================================toString
	
	@Override
	public String toString() {
		//initialize the string values of the numbers
		String zero = String.valueOf(hand[0].number);
		String one = String.valueOf(hand[1].number);
		String two = String.valueOf(hand[2].number);
		String three = String.valueOf(hand[3].number);
		String four = String.valueOf(hand[4].number);
		
		//checks for numbers above 10 and gives them the proper name
			if(hand[0].number == 1) {
				zero = "Ace";
			}
			if(hand[0].number == 11) {
				zero = "Jack";
			}
			if(hand[0].number == 12) {
				zero = "Queen";
			}
			if(hand[0].number == 13) {
				zero = "King";
			}
			
			if(hand[1].number == 1) {
				one = "Ace";
			}
			if(hand[1].number == 11) {
				one = "Jack";
			}
			if(hand[1].number == 12) {
				one = "Queen";
			}
			if(hand[1].number == 13) {
				one = "King";
			}

			
			if(hand[2].number == 1) {
				two = "Ace";
			}
			if(hand[2].number == 11) {
				two = "Jack";
			}
			if(hand[2].number == 12) {
				two = "Queen";
			}
			if(hand[2].number == 13) {
				two = "King";
			}
			
			
			if(hand[3].number == 1) {
				three = "Ace";
			}
			if(hand[3].number == 11) {
				three = "Jack";
			}
			if(hand[3].number == 12) {
				three = "Queen";
			}
			if(hand[3].number == 13) {
				three = "King";
			}
			
			
			if(hand[4].number == 1) {
				four = "Ace";
			}
			if(hand[4].number == 11) {
				four = "Jack";
			}
			if(hand[4].number == 12) {
				four = "Queen";
			}
			if(hand[4].number == 13) {
				four = "King";
			}
		
		return "[a = (" + zero + " " + hand[0].suit
				+ ") | b = (" + one + " " + hand[1].suit + 
				") | c = (" + two + " " + hand[2].suit + 
				") | d = (" + three + " " + hand[3].suit +
				") | e = (" + four + " " + hand[4].suit + ")]";
	}
	
	












}
