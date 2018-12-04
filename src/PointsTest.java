
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;



public class PointsTest {
	
	ArrayList<Card> hand = new ArrayList<Card>();

	
	@Test
	void pair() {
		hand.add(new Card(2, Suit.HEARTS));
		hand.add(new Card(2, Suit.DIAMONDS));
		hand.add(new Card(3, Suit.HEARTS));
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(7, Suit.HEARTS));
		Collections.sort(hand);
		Points point = new Points(hand);
		assertEquals(1, point.getPointsVideoPoker());
	}
	
	@Test
	void twoPair() {
		hand.add(new Card(2, Suit.HEARTS));
		hand.add(new Card(2, Suit.DIAMONDS));
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(7, Suit.HEARTS));
		Collections.sort(hand);
		Points point = new Points(hand);
		assertEquals(2, point.getPointsVideoPoker());
	}
	
	@Test
	void threeOfAKind() {
		hand.add(new Card(2, Suit.HEARTS));
		hand.add(new Card(2, Suit.DIAMONDS));
		hand.add(new Card(2, Suit.HEARTS));
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(7, Suit.HEARTS));
		Collections.sort(hand);
		Points point = new Points(hand);
		assertEquals(3, point.getPointsVideoPoker());
	}
}
