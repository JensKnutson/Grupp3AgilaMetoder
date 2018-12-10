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

<<<<<<< HEAD
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
=======
		public void Check_balance(List <Card> hand, int i) {
			Points point = new Points(hand);
			balance += point.getPointsVideoPoker();
			if(point.getPointsVideoPoker() > 0) {
				balance += i*point.getPointsVideoPoker();
			}
			else balance -= i; 

			}

	}
>>>>>>> 7a57f2c3309a937e10c7b5608d8cc5a3bcd02a7c

