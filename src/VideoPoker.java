import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideoPoker {
	
	Scanner scVP = new Scanner(System.in);	
	Dealer deal = new Dealer();
	Interface intf = new Interface(deal);
	Save save;
	
	public VideoPoker() throws ClassNotFoundException, IOException {
		vpMainMenu();
	}
	
	public void vpMainMenu() throws ClassNotFoundException, IOException {
		int playerInput;
		do {
			deal = new Dealer();
			intf = new Interface(deal);
			System.out.println("---Video Poker---");
			System.out.println("Välj:\n" + "1 - Ny hand\n" + "2 - Spara spel\n" + "3 - Ladda spel\n" + "0 - Avsluta spel");
			playerInput = scVP.nextInt();
			switch (playerInput) {
			case 1:
				vpGameMenu();
				break;
			case 2:
				System.out.println(deal.getHand());
				Save save = new Save(deal.getDeck(), deal.getHand(), 8);
				save.save();
				break;
			case 3:
				save = new Save();
				Dealer loadedDealer = save.load();
				this.deal.setDeck(loadedDealer.getDeck());
				this.deal.setHand(loadedDealer.getHand());
				intf.getHand();
				System.out.println("Spel laddat");
				vpGameMenu();
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
		do {
			System.out.println("Välj vilket kort du vill byta. \n" + "0: Byten klart. 9: för att spara");		//Visuellt vilket kort/alternativ som är kopplat till vilken inmatning
			intf.getHand();	
			playerInput = scVP.nextInt();
			switch (playerInput) {
			case 1:
				deal.discardCard(0);		
				break;
			case 2:
				deal.discardCard(1);		
				break;
			case 3:
				deal.discardCard(2);		
				break;
			case 4:
				deal.discardCard(3);		
				break;
			case 5:
				deal.discardCard(4);		
				break;
			case 9:
				save = new Save(deal.getDeck(), deal.getHand(), 8);
				save.save();
			case 0:
				break;

			default:
				System.out.println("Ogilltig inmatning");
				break;
			}
		} while (playerInput != 0);
		
		deal.redrawHand();					
		intf.getHand();					//INTERFACE -Metod finns inte ännu, (skriv ut nuvarande hand)
		intf.getScore();
		
		
		

		
	}
	
	
}
