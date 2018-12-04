import java.util.ArrayList;
import java.util.List;

//	Mikel
public class VideoPoker {
// 	Importera spelarhand
//	Sortera efter färg/värde?
//	Exportera spelarhand(modifierad) -för redraw dealer -final för poängsystemet---interface? interface efter varje aktion i slutändan
	
	
//	Stanna
//	Byta/kassera kort
	
	private List<Card> playerHand = new ArrayList<>();
	Dealer deal = new Dealer();
	Interface intf = new Interface();
	
//	Metod för hämta hand från dealern
	public void fetchHand() {
		playerHand = deal.getHand();	//DEALER-metod
	}
	
//	Metod för slänga kort     ->    lägg till byta kort - skicka till dealer - ta emot hand+nya kort från dealer
	public void discardCard(int index) {
		playerHand.remove(index);
	}
	
//	Metod för att skicka in modifierad hand i Dealer och få nya kort för varje kasserad
	public void newCards() {
		playerHand = deal.dealNewCards(playerHand);		//DEALER-metod
	}
	
//	Metod för stand/get score
	public void stand() {
		intf.getScore(playerHand);		//INTERFACE-metod
	}
	
//	Getter för playerHand
	public List<Card> getPlayerHand() {
		return playerHand;
	}
	
}
