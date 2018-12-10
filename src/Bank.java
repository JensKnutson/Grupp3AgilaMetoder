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

		public void Check_balance(List <Card> hand, int i) {
			Points point = new Points(hand);
			if(point.getPointsVideoPoker() > 0) {
				balance += i*point.getPointsVideoPoker();
				System.out.println("Vinst! " + i*point.getPointsVideoPoker() + " Nytt saldo: " + getBalance());
			}
			else {
				balance -= i;
				System.out.println("Du förlorade. Nytt saldo: " + getBalance());
			}
		}

	}

