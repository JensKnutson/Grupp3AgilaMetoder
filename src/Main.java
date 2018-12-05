import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<Object> o = new ArrayList<>();
		Points p = new Points();
		Deck deck = new Deck();
		int pi = 100;
		Dealer deal = new Dealer();
		deal.getHand();
		Save s = new Save(deck, deal.getHand(), pi);
		s.serialization();
		o = (ArrayList<Object>) s.deSerialization();
		deck = (Deck) o.get(0);
		deal.setHand((List<Card>) o.get(1));
		System.out.println(deck);
		System.out.println(deal);
		
	}
}
