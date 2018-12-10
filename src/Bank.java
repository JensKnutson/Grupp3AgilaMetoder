import java.io.Serializable;
/*
 *Denna klassen innehåller metoder för:
 * One player should be as the banker
 * Set the chips " money in the bank"
 * get chips  form the bank
 * chips can be returned to the banker to get credit
 */
import java.util.List;

public class Bank implements Serializable {

		

	private int balance=1000;
	private int poäng;// poäng account
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPoäng() {
		return poäng;
	}

	public void setPoäng(int poäng) {
		this.poäng = poäng;
	}
	// EN METHOD SOM KOLLAR VAD MAN HAR FÅTT FÖR POÄNG

		public void Check_balance(List <Card> hand, int i) {
			Points point = new Points(hand);
			balance += point.getPointsVideoPoker();
			if(point.getPointsVideoPoker() > 0) {
				i *= point.getPointsVideoPoker();
			}
			else balance -= i; 

			}

	}

