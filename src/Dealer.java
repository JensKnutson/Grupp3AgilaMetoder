
import java.util.*;
import java.util.stream.Collectors;

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
	public void redrawHand() {
		while (hand.size() < 5) {
			Card card = deck.draw();
			System.out.println(card);
			this.hand.add(card);
		}
	}
	
//	Släng ett kort
	public void discardCard(int i) {
		try {
			hand.remove(i);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Det finns inget kort med index " + i);
		}
		
		
	}
//	Släng flera kort (tar array av heltal som parameter)
	public void discardCard(int[] i) {
		List<Integer> j = Arrays.stream(i).boxed().collect(Collectors.toList());
		Collections.sort(j, Collections.reverseOrder());
		for (Integer k : j) {
			hand.remove(k.intValue());
		}
	}
	
}
