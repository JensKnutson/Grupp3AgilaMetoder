import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideoPoker {
	
	
	Dealer deal = new Dealer();
	Interface intf = new Interface(deal);
	
	
//	Spelmenyn: - anpassad för att handmodifikation skall ske i Dealer
	public void vpMenu() {
		int playerInput;
		Scanner scVP = new Scanner(System.in);
		do {
			playerInput = scVP.nextInt();
			System.out.println("Välj vilket kort du vill byta");
			System.out.printf("LÄGG IN FORMATTERING!", 1, 2, 3, 4, 5, "0: Byten klart");		//Visuellt vilket kort/alternativ som är kopplat till vilken inmatning
			intf.getHand();					//INTERFACE -Metod finns inte ännu, (skriv ut nuvarande hand)
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
			case 0:
				scVP.close();
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
