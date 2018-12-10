import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideoPoker {
	
	Scanner scVP = new Scanner(System.in);
	
	Dealer deal = new Dealer();
	Interface intf = new Interface(deal);
	
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
		do {
			System.out.println("Välj vilket kort du vill byta");
			System.out.println("Välj vilket kort du vill byta. " + "0: Byten klart");		//Visuellt vilket kort/alternativ som är kopplat till vilken inmatning
			intf.getHand();					//INTERFACE -Metod finns inte ännu, (skriv ut nuvarande hand)
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
			case 7:
				Scanner scan = new Scanner(System.in);
				String[] discardString = scan.nextLine().split(" ");
				int discardCards[] = new int[discardString.length];
				
				for (int j = 0; j < discardCards.length; j++) {
					discardCards[j] = Integer.parseInt(discardString[j]);
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
		intf.getHand();					//INTERFACE -Metod finns inte ännu, (skriv ut nuvarande hand)
		intf.getScore();
		
		
		

		
	}
	
	
}
