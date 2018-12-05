
import java.util.*;

public class Dealer {
	
	private Deck deck;
	private List<Card> hand;
	
	public Dealer() {
		deck = new Deck();
		hand = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			hand.add(deck.draw());
		}
		
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void dealNewCards(List<Card> playerHand) {
		while (hand.size() < 5) {
			Card card = deck.draw();
			hand.add(card);
		}
	}
	
}
