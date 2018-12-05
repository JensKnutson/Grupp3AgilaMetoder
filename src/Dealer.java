
import java.util.*;

public class Dealer {
	
	private Deck deck;
	private List<Card> hand;
	
//	Konstruktor. Ny deck och hand. Fyll hand med 5 kort.
	public Dealer() {
		deck = new Deck();
		deck.shuffle();
		hand = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			hand.add(deck.draw());
		}
		
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
//	Metod för att hämta hand.
	public List<Card> getHand() {
		return hand;
	}
	
//	Ersätt alla kastade kort med nya
	public List<Card> dealNewCards() {
		while (hand.size() < 5) {
			Card card = deck.draw();
			System.out.println(card);
			hand.add(card);
		}
		System.out.println("Här skrivs handen ut!");
		return hand;
	}
	
}
