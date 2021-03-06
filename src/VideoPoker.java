import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideoPoker {
	
	Scanner scVP = new Scanner(System.in);	
	Dealer deal = new Dealer();
	Interface intf = new Interface(deal);
	Bank bank = new Bank();
	Save save;
	boolean playForMoney = false;
	
	public VideoPoker() throws ClassNotFoundException, IOException {
		vpMainMenu();
	}
	
	public void vpMainMenu() throws ClassNotFoundException, IOException {
		int playerInput;
		do {
			deal = new Dealer();
			intf = new Interface(deal);
			System.out.println("---Video Poker---");
			System.out.println("Välj:\n" + "1 - Ny hand\n" + "2 - Spara spel\n" + "3 - Ladda spel\n" + "4 - Spela för pengar\n" + "0 - Avsluta spel");
			playerInput = scVP.nextInt();
			switch (playerInput) {
			case 1:
				vpGameMenu();
				break;
			case 2:
				System.out.println(deal.getHand());
				Save save = new Save(deal.getDeck(), deal.getHand(), bank.getBalance());
				save.save();
				break;
			case 3:
				save = new Save();
				Dealer loadedDealer = save.load();
				this.deal.setDeck(loadedDealer.getDeck());
				this.deal.setHand(loadedDealer.getHand());
				this.bank.setBalance(save.balance);
				intf.getHand();
				System.out.println("Spel laddat");
				vpGameMenu();
				break;
			case 4:
				playForMoney = true;
				System.out.println("Hur mycket vill du sätta in?");
				bank.setBalance(scVP.nextInt());
				System.out.println("Saldo " + bank.getBalance() + " kr.");
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
	public void vpGameMenu() throws IOException {
		int playerInput;
		int bet = 0;
		if (playForMoney) {
			System.out.println("Ditt saldo är: " + bank.getBalance() + " Hur mycket vill du satsa?");
			bet = scVP.nextInt();
			while(bet > bank.getBalance()) {
				System.out.println("Du får inte satsa mer än du äger\nDitt saldo är " + bank.getBalance());
				bet = scVP.nextInt();
			}
		}
		do {
			System.out.println("1: Byt kort\n" + "0: Byten klart\n" + "9: För att spara\n");		//Visuellt vilket kort/alternativ som är kopplat till vilken inmatning
			intf.getHand();					
			
			System.out.println("1: Byt kort " + "0: Byten klart " + "9: Spara");		
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
			case 9:
				save = new Save(deal.getDeck(), deal.getHand(), bank.getBalance());
				save.save();
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
		System.out.println();
		
		if (playForMoney) {
			bank.Check_balance(deal.getHand(), bet);
		}

	}
	
	
}
