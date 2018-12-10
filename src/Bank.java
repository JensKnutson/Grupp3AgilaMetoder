import java.io.Serializable;
/*
 *Denna klassen innehåller metoder för:
 * One player should be as the banker
 * Set the chips " money in the bank"
 * get chips  form the bank
 * chips can be returned to the banker to get credit
 */

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

		public void Check_balance() {

			if (poäng == 0) {
				System.out.println("");

			} else if (poäng > 0) {
				balance = balance + poäng;
				System.out.println(" Din balance" + balance);

			}

	}

