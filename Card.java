
public class Card implements Comparable<Object> {
	private int value;
	private Suit suit;

	// konstruktor för card klassen
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	// Retunera värdet för krotet
	public int getValue() {
		return this.value;
	}

	// Retunera färgen för kortet
	public Suit getSuit() {
		return this.suit;

	}

	@Override
	public boolean equals(Object o) {
		Card card = (Card) o;
		return getSuit().equals(card.suit) && getValue() == card.value;

	}
	
	@Override
	public int compareTo(Object o) {
		Card e = (Card) o;
		return Integer.compare(getValue(), e.getValue());
	}
}
