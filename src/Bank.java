import java.io.Serializable;

public class Bank implements Serializable {
	


		private int bank;

		public Bank() { // méthode banque pour prendre les valeur banque
			bank = 0;
		}

		public Bank(int n) { 
			this.bank = n;
		}
 //  en method bank 
		public int getBank() {
			return bank;
		}

		public void setBank(int n) {
			bank = n;
		}

		public void Bankroll(int n) {
			bank += n;
		}

	}

	// bank och deck är samma.
	// ********************************************************************************************************//

	// ta emot ett värde
	// hämt värdet

