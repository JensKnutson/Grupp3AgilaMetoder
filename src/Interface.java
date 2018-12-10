import java.util.ArrayList;
import java.util.List;

//Jag hoppas detta är något på rätt väg.
public class Interface {

	List<Card> cardInterface = new ArrayList<>();
	Dealer deal;

	
	Interface(Dealer deal) {
		this.deal = deal;
	}
	// skrivet ut spelarens hand
	public void stand() {

		Dealer d = new Dealer();
		cardInterface = d.getHand(); // hämta från dealer

		// skriver ut de dragna kortet.
		for (int i = 0; i < cardInterface.size(); i++) {
			System.out.println("Your playerhand: " + cardInterface.get(i));
		}

	}

	// skriv ut nuvarande hand från videopoker
	// ***eventuellt tar bort.
	/*public void getHand() {
		VideoPoker vp = new VideoPoker();
		

		System.out.println("Your playerhand: ");

	} */

	//poäng.
	public void getScore() {
		Points p = new Points();
		Dealer d = new Dealer();
		cardInterface = d.getHand();
		
         for (int i = 0; i< cardInterface.size();i++ ) {
		System.out.println("Points: " + p.getPointsVideoPoker());
         }
	}


	// metod förkortning av suit.
	public String getSuit() {
		// test värden
		Card card = new Card(13, Suit.SPADES);

		String H = "H";
		String S = "S";
		String D = "D";
		String C = "C";
		String n = "";

		if (card.getSuit().equals(Suit.HEARTS)) {

			return H;
		}

		else if (card.getSuit().equals(Suit.SPADES)) {
			return S;
		}

		else if (card.getSuit().equals(Suit.DIAMONDS))

		{
			return D;
		} else if (card.getSuit().equals(Suit.CLUBS)) {
			return C;
		} else

			return n;

	}

	// metod valör på korten
	public String getCard() {

		// test värden.
		Card card = new Card(2, Suit.SPADES);

		if (card.getValue() == 11) {
			return "J";

		} else if (card.getValue() == 13) {

			return "Q";
		} else if (card.getValue() == 14) {

			return "K";
		} else if (card.getValue() == 1) {

			return "A";
		} else

			return null;
	}

	// metod siffra kort
	public static int getCardValue() {
		// test värden
		Card card = new Card(1, Suit.SPADES);
		int in = 0;

		if (card.getValue() == 2) {

			return 2;
		} else if (card.getValue() == 3) {

			return 3;
		} else if (card.getValue() == 4) {

			return 4;
		} else if (card.getValue() == 5) {

			return 5;
		} else if (card.getValue() == 6) {

			return 6;
		} else if (card.getValue() == 7) {

			return 7;
		} else if (card.getValue() == 8) {

			return 8;
		} else if (card.getValue() == 9) {

			return 9;
		} else

			return in;

	}

	// skriver ut
	public String getCardPrint() {
		// ett värde som konstruktorn vill ha.
		Card card = new Card(2, Suit.CLUBS);

		if (card.getValue() <= 10 && card.getValue() > 2) {
			return getSuit() + " " + getCardValue() + ",";
		} else
			return getSuit() + " " + getCard() + ",";

	}

}
