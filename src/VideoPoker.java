import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdk.nashorn.internal.ir.WhileNode;

//	Mikel
public class VideoPoker {
//	Sortera efter färg/värde? -INTERFACE / DEALER
	
	//private List<Card> playerHand = new ArrayList<>(); //FLYTTA ALL handmodifikation till dealer??
	Dealer deal = new Dealer();
	Interface intf = new Interface();
	
	
//	Spelmenyn: - anpassad för att handmodifikation skall ske i Dealer
	public void vpMenu() {
		int playerInput;
		do {
			Scanner scVP = new Scanner(System.in);
			playerInput = scVP.nextInt();
			System.out.println("Välj vilket kort du vill byta");
			System.out.printf("LÄGG IN FORMATTERING!", 1, 2, 3, 4, 5, "0: Byten klart");		//Visuellt vilket kort/alternativ som är kopplat till vilken inmatning
			intf.getHand();					//INTERFACE -Metod finns inte ännu, (skriv ut nuvarande hand)
			switch (playerInput) {
			case 1:
				deal.discardCard(0);		//Metod finns inte ännu
				break;
			case 2:
				deal.discardCard(1);		//Metod finns inte ännu
				break;
			case 3:
				deal.discardCard(2);		//Metod finns inte ännu
				break;
			case 4:
				deal.discardCard(3);		//Metod finns inte ännu
				break;
			case 5:
				deal.discardCard(4);		//Metod finns inte ännu
				break;
			case 0:
				scVP.close();
				break;

			default:
				System.out.println("Ogilltig inmatning");
				break;
			}
		} while (playerInput != 0);
		
		deal.redrawHand();					//DEALER -Metod finns inte ännu, (dra nya kort för varje bytt kort)
		intf.getHand();					//INTERFACE -Metod finns inte ännu, (skriv ut nuvarande hand)
		intf.getScore();				//INTERFACE -Metod finns inte ännu, (skriv ut Score, kanske lagra score, alt skriv ut vinst i pengar?
		
//		Kommande problem: Fortsätta spela samma spel(/session) -> Alternativ här eller gjort genom main?
//						  Hur byta till spela för pengar?
		
	}
	
//	Metod för hämta hand från dealern
//	public void fetchHand() {
//		playerHand = deal.getHand();	//DEALER-metod
//	}
	
//	Metod för slänga kort    FLYTTA TILL DEALER! ->    lägg till byta kort - skicka till dealer - ta emot hand+nya kort från dealer
//	public void discardCard(int index) {
//		playerHand.remove(index);
//	}
	
//	Metod för att skicka in modifierad hand i Dealer och få nya kort för varje kasserad
//	public void newCards() {
//		playerHand = deal.dealNewCards(playerHand);		//DEALER-metod
//	}
	
//	Metod för stand/get score -----Tänk om, denna är onödig -"Löst" i spelmenyn
//	public void stand() {
//		intf.getScore(playerHand);		//INTERFACE-metod
//	}
	
//	Getter för playerHand
//	public List<Card> getPlayerHand() {
//		return playerHand;
//	}
	
}
