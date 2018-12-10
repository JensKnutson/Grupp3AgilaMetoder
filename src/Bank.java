import java.io.Serializable;
/*
 *Denna klassen innehåller metoder för:
 * One player should be as the banker
 * Set the chips " money in the bank"
 * get chips  form the bank
 * chips can be returned to the banker to get credit
 */

public class Bank implements Serializable {

		

	private int balance;
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void bet(int b) {
		Dealer d = new Dealer();
		Points p = new Points(d.getHand());
		if (p.getPointsVideoPoker() > 0) {
			balance += p.getPointsVideoPoker()*b;
		}
		else {
			balance -= b;
		}
	}

// EN METHOD SOM KOLLAR VAD MAN HAR FÅTT FÖR POÄNG

//	public void Check_balance() {
//
//			if (poäng == 0) {
//				System.out.println("");
//
//			} else if (poäng > 0) {
//				balance = balance + poäng;
//				System.out.println(" Din balance" + balance);
//
//			}
//
//	}
}

