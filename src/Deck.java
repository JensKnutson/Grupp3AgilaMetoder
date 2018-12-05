
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Deck implements Serializable {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Suit suit;
	private int counter = 0;

	public Deck() {
		for (int i = 0; i < 4; i++) {
			switch (i) {
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
