
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
<<<<<<< HEAD
/*
 *  Author Mikael 
 *  Vi har använt olika methoder och just array list passar till det här projektet
 *  Ska 
 * 
 * 
 */
public class Deck {
=======

public class Deck implements Serializable {
>>>>>>> 2754d2e80014e2598aa7952905658db2318644d8
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Suit suit;
	private int counter = 0;

	public Deck() {
		for (int i = 0; i < 4; i++) {
			switch (i) {
<<<<<<< HEAD
			case 0: suit = Suit.HEARTS;
				break;
			case 1: suit = Suit.SPADES;
				break;
			case 2: suit = Suit.DIAMONDS;
				break;
			case 3: suit = Suit.CLUBS;
=======
			case 0:
				suit = suit.HEARTS;
				break;
			case 1:
				suit = suit.SPADES;
				break;
			case 2:
				suit = suit.DIAMONDS;
				break;
			case 3:
				suit = suit.CLUBS;
>>>>>>> 2754d2e80014e2598aa7952905658db2318644d8
				break;
			}
			for (int j = 1; j < 14; j++) {
				cards.add(counter, new Card(j, suit));
				counter++;
			}
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public Card draw() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}

	public void shuffle() {
		ArrayList<Card> tempCards = new ArrayList<Card>();
		Random random = new Random();
		Card card;

		while (cards.size() > 0) {
			card = cards.get(random.nextInt(cards.size()));
			tempCards.add(card);
			cards.remove(card);
		}

		cards = tempCards;
	}

}
