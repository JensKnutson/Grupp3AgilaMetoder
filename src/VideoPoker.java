import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideoPoker {
	
	Scanner scVP = new Scanner(System.in);
	
	Dealer deal = new Dealer();
	Interface intf = new Interface(deal);
	Bank bank = new Bank();
	
	boolean playForMoney = false;
	
	public VideoPoker() {
		vpMainMenu();
	}
	
	public void vpMainMenu() {
		int playerInput;
		do {
			deal = new Dealer();
			intf = new Interface(deal);
			System.out.println("---Video Poker---");
			System.out.println("Välj:\n" + "1 - Ny hand\n" + "2 - Ladda spel\n" + "0 - Avsluta spel");
			playerInput = scVP.nextInt();
			switch (playerInput) {
			case 1:
				vpGameMenu();
				break;
			case 2:
				//Ladda spel
				break;
			case 4:
				playForMoney = true;
				System.out.println("Hur mycket vill du sätta in?");
				Scanner mScan = new Scanner(System.in);
				bank.setBalance(mScan.nextInt());
				System.out.println("Saldo " + bank.getBalance() + " kr.");
				mScan.close();
				break;
			case 0:
				break;

			default:
				System.out.println("Felaktig inmatning");
				break;
			}
			
		} while (playerInput != 0);
	}
	
//	Spelmenyn: - anpassad för att handmodifikation skall ske i Dealer
	public void vpGameMenu() {
		int playerInput;
		int bet;
		do {
			intf.getHand();					
			
			if (playForMoney) {
				System.out.println("Ditt saldo är: " + bank.getBalance() + " Hur mycket vill du satsa?");
				bet = scVP.nextInt();
			}
			
			System.out.println("1: Byt kort " + "0: Byten klart");		
			playerInput = scVP.nextInt();
			
			switch (playerInput) {
			case 1:
				System.out.println("Mata in vilka kort du vill byta med mellanslag som avskiljare ex. 1 4 2");
				Scanner scan = new Scanner(System.in);
				String[] discardString = scan.nextLine().split(" ");
				int discardCards[] = new int[discardString.length];
				
				for (int j = 0; j < discardCards.length; j++) {
					discardCards[j] = Integer.parseInt(discardString[j])-1;
				}
				
				deal.discardCard(discardCards);		
				break;
			case 0:
				break;

			default:
				System.out.println("Ogilltig inmatning");
				break;
			}
		} while (playerInput != 0);
		
		deal.redrawHand();					
		intf.getHand();					//skriv ut nuvarande hand
		intf.getScore();
		
		if (playForMoney) {
			bank.bet(bet);				//BANK -Metod finns inte ännu
		}
		
		

		
	}
	
	
}
