import java.util.ArrayList;
import java.util.Collections;
//import blackjack.Card;

public class Points {
	ArrayList<Card> hand = new ArrayList<Card>();

	public Points() {
		hand.add(new Card(6, Suit.HEARTS));
		hand.add(new Card(4, Suit.HEARTS));
		hand.add(new Card(4, Suit.HEARTS));
		hand.add(new Card(4, Suit.HEARTS));
		hand.add(new Card(6, Suit.HEARTS));
		Collections.sort(hand);
	}
	
	public Points(ArrayList<Card> hand) {
		this.hand = hand;
		Collections.sort(hand);
	}

	private int PointsPar() {
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

	private int PointsColour() {
		boolean sameSuit = true;
		int score = 0;
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(0).getSuit() != hand.get(i).getSuit()) {
				sameSuit = false;
			}
		}
		if (sameSuit) {
			score = 5;
		}
		return score;
	}

	private int pointsLadder() {
		int score = 0;
		boolean ladder = true;
		for (int i = 0; i < hand.size() - 1; i++) {
			if (hand.get(i).getValue() == hand.get(i + 1).getValue()) {
				ladder = false;
			}
		}
		if (ladder) {
			score = 4;
		}
		return score;
	}

	private int pointsColoredLadder() {
		int score = 0;
		if (pointsLadder() == 4 && PointsColour() == 5) {
			score = 12;
		}
		return score;
	}

	private int pointsFullHouse() {
		int score = 0;
		if (PointsPar() == 4) {
			score = 6;
		}
		return score;
	}

	private int pointsFours() {
		for (int i = 0; i < 2; i++) {
			if (hand.get(i).getValue() == hand.get(i + 3).getValue()) {
				return 9;
			}
		}
		return 0;
	}
}
