import java.util.ArrayList;
import java.util.List;

public class Interface {

	List<Card> cardInterface = new ArrayList<>();
	Dealer deal;

	Interface(Dealer deal) {
		this.deal = deal;
	}

	// skrivet ut spelarens hand
	public void getHand() {

		cardInterface = deal.getHand(); // hämta från dealer

		// skriver ut de dragna kortet.
		System.out.print("Your Hand: ");
		for (int i = 0; i < cardInterface.size(); i++) {
			System.out.print(getCardPrint(cardInterface.get(i)));
		}
		System.out.println();

	}

	//Utskrift till konsol för vad man har på handen
	public void getScore() {
		Points p = new Points(deal.getHand());
		int i = p.getPointsVideoPoker();
		if (i == 1) {
			System.out.println("Du fick par(1 poäng)");
		} else if (i == 2) {
			System.out.println("Du fick tvåpar(2 poäng)");
		} else if (i == 3) {
			System.out.println("Du fick triss(3 poäng)");
		} else if (i == 4) {
			System.out.println("Du fick stege(4 poäng)");
		} else if (i == 5) {
			System.out.println("Du fick färg(5 poäng)");
		} else if (i == 6) {
			System.out.println("Du fick kåk(6 poäng)");
		} else if (i == 9) {
			System.out.println("Du fick fyrtal(9 poäng)");
		} else if (i == 12) {
			System.out.println("Du fick färgstege(12 poäng)");
		}
	}

	// Ändra valör för klädda kort
	public String getCourtCard(Card card) {

		if (card.getValue() == 11) {
			return "J";

		} else if (card.getValue() == 12) {

			return "Q";
		} else if (card.getValue() == 13) {

			return "K";
		} else if (card.getValue() == 14) {

			return "A";
		} else

			return null;
	}

	// Utskrift till konsol
	public String getCardPrint(Card card) {

		if (card.getValue() <= 10) {
			return card.getSuit() + " " + card.getValue() + ", ";
		} else
			return card.getSuit() + " " + getCourtCard(card) + ", ";

	}

}
