import java.util.ArrayList;
import java.util.List;

public class Interface {
	
	List <Card> cardIf = new ArrayList<>();
	
	
	
	//från videopoker. skrivet ut spelarens hand
	public void stand() {
		
		Dealer d = new Dealer();			
		cardIf = d.getHand(); // hämta från dealer 
		// skriver ut de dragna kortet.
		for (int i = 0; i < cardIf.size(); i++) {
			System.out.println("Dina kort: " + cardIf.get(i));	
		}
		
	}
       

	
	//skriv ut nuvarande hand från videopoker
	//***eventuellt tar bort.
	public void getHand()
	{
		VideoPoker vp = new VideoPoker();
		//vp.get
		
		System.out.println("Din nuvarande hand " );
		
	}
	
	
	//hämta poäng skriv ut från videopoker.
	//koppla till poäng score
	//*******obs inte klar***********
	public  void getScore()
	{
		Points p = new Points();
		Dealer d = new Dealer();
		
		cardIf = d.getHand();	
		p.getPointsVideoPoker();
		
		for (int i = 0; i< cardIf.size();i++) {
			System.out.println("Dina poäng" + cardIf.get(i));
					
		}
	}
			
		//skriva ut kort 11,12,13,14
	
		public String getCard()
		{
			Card card = new Card();
			card.getSuit();
			card.getValue();
			String k = "K";
			String q = "Q";
			String j = "J";
			String a = "A";
			
			
			if (card.getValue() == 11) {
				return j;
		}
			else if (card.getValue() == 13) {
				return q;
		}
			else if (card.getValue() == 14) {
				return k;
		}
			else if (card.getValue() == 1) {
				return a;
			}
			
			//test
			//System.out.println(a);		
		
	}
		//ta emot värde 1-12,  returnerar färg och siffra.
		//**inte helt klar
             public void getValue()
             {
            	 Card card = new Card();
            	 
            	            	 
             }
             
             
             //färg
             public void getSuit() {
            	 
             }
		

}

