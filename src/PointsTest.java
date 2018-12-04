
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
		Points point = new Points(hand);
		assertEquals(3, point.getPointsVideoPoker());
	}
	
	@Test
	void ladder() {
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(6, Suit.DIAMONDS));
		hand.add(new Card(7, Suit.HEARTS));
		hand.add(new Card(8, Suit.HEARTS));
		hand.add(new Card(9, Suit.HEARTS));
		Points point = new Points(hand);
		assertEquals(4, point.getPointsVideoPoker());
	}
	
	@Test
	void colour() {
		hand.add(new Card(2, Suit.HEARTS));
		hand.add(new Card(4, Suit.HEARTS));
		hand.add(new Card(6, Suit.HEARTS));
		hand.add(new Card(8, Suit.HEARTS));
		hand.add(new Card(9, Suit.HEARTS));
		Points point = new Points(hand);
		assertEquals(5, point.getPointsVideoPoker());
	}
	
	@Test
	void fullHouse() {
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(5, Suit.DIAMONDS));
		hand.add(new Card(5, Suit.SPADES));
		hand.add(new Card(8, Suit.HEARTS));
		hand.add(new Card(8, Suit.DIAMONDS));
		Points point = new Points(hand);
		assertEquals(6, point.getPointsVideoPoker());
	}
	
	@Test
	void fours() {
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(5, Suit.DIAMONDS));
		hand.add(new Card(5, Suit.SPADES));
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(9, Suit.DIAMONDS));
		Points point = new Points(hand);
		assertEquals(9, point.getPointsVideoPoker());
	}
	
	@Test
	void straightFlush() {
		hand.add(new Card(5, Suit.SPADES));
		hand.add(new Card(6, Suit.SPADES));
		hand.add(new Card(7, Suit.SPADES));
		hand.add(new Card(8, Suit.SPADES));
		hand.add(new Card(9, Suit.SPADES));
		Points point = new Points(hand);
		assertEquals(12, point.getPointsVideoPoker());
	}
}
