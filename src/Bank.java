import java.io.Serializable;

public class Bank implements Serializable {
	



	/*
	 *Denna klassen innehåller metoder för:
	 * One player should be as the banker
	 * Set the chips " money in the bank"
	 * get chips  form the bank
	 * chips can be returned to the banker to get credit
	 */


		public int bank;

		public Bank() { // méthode banque pour prendre les valeur banque
			bank = 0;
		}

		public Bank(int indata) { 
			this.bank = indata;
		}
		public int getBank() {
			return bank;
		}

		public void setBank(int setdata) {
			bank = setdata;
		}

		public void Bankroll(int chips) {
			bank += setchips;
		}

	}

