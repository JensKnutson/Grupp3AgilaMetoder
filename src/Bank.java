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

	//Hanterar användarens saldo vid vinster och förluster
	public void Check_balance(List<Card> hand, int i) {
		Points point = new Points(hand);
		if (point.getPointsVideoPoker() > 0) {
			balance += (i * point.getPointsVideoPoker()) * 0.5;
			System.out.println("Vinst! Du fick " + (i * point.getPointsVideoPoker()) * 0.5 + " kr\nNytt saldo: " + getBalance());
		} else {
			balance -= i;
			System.out.println("Du förlorade. Nytt saldo: " + getBalance());
		}
	}

}
