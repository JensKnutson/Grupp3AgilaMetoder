
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
	
//	Sätt hand. Används vid inladdning av sparade värden
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
//	Sätt deck. Används vid inladdning av sparade värden
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
//	Metod för att hämta hand.
	public List<Card> getHand() {
		return hand;
	}
	
//	Metod för att hämta deck.
	public Deck getDeck() {
		return deck;
	}
	
//	Ersätt alla kastade kort med nya
	public List<Card> redrawHand() {
		while (hand.size() < 5) {
			Card card = deck.draw();
			System.out.println(card);
			hand.add(card);
		}
		System.out.println("Här skrivs handen ut!");
		return hand;
	}
	
//	Släng ett kort
	public void discardCard(int i) {
		try {
			hand.remove(i);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Det finns inget kort med index " + i);
		}
		
	}
	
}
