import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Points {
	List<Card> hand = new ArrayList<Card>();

	// Tom konstruktor för att testa
	public Points() {
		hand.add(new Card(4, Suit.HEARTS));
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(6, Suit.HEARTS));
		hand.add(new Card(7, Suit.HEARTS));
		hand.add(new Card(8, Suit.HEARTS));
		Collections.sort(hand);
	}

	// Konstuktor som ska användas när man tillkallas klassen. Tar emot en arraylsit
	// som ska vara användarens hand
	public Points(List<Card> hand) {
		this.hand = hand;
		Collections.sort(hand);
	}
	
	//retunerar värdet för den hand du har. Tanken är att detta är den enda metoden som ska anropas från points
	public int getPointsVideoPoker() {
		if (pointsColoredLadder()) {
			return 12;
		} else if (pointsFours()) {
			return 9;
		} else if (pointsFullHouse()) {
			return 6;
		} else if (pointsColour()) {
			return 5;
		}
		else if (pointsLadder()) {
			return 4;
		}
		return pointsPar();
	}

	// Räkna ut par och tvåpar
	private int pointsPar() {
		int score = 0;
		for (int j = 0; j < hand.size(); j++) {
			for (int i = j + 1; i < hand.size(); i++) {
				if (hand.get(j).getValue() == hand.get(i).getValue()) {
					score += 1;
				}
			}
		}
		return score;
	}

	// Räkna ut om du har färg
	private boolean pointsColour() {
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(0).getSuit() != hand.get(i).getSuit()) {
				return false;
			}
		}
		return true;
	}

	// Räkna ut om du har har stege
	private boolean pointsLadder() {
		boolean b = false;
		int p = 0;
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getValue()+1 == hand.get(i+1).getValue()) {
				p++;
			}
		}
		if(p == 4) {
			b = true;
		}
		return b;
	}

	// räkna ut om du har färgstege
	private boolean pointsColoredLadder() {
		if (pointsLadder() && pointsColour()) {
			return true;
		}
		return false;
	}

	// Räkna ut om du har kåk
	private boolean pointsFullHouse() {
		if (pointsPar() == 4) {
			return true;
		}
		return false;
	}

	// Räkna ut om du har fyrpar
	private boolean pointsFours() {
		for (int i = 0; i < 2; i++) {
			if (hand.get(i).getValue() == hand.get(i + 3).getValue()) {
				return true;
			}
		}
		return false;
	}
}
