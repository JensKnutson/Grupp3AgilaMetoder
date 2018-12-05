import java.util.ArrayList;
import java.util.List;
/* metoderna här kommer att användas i classer den implementerar.
 * skriva ut videoklassern
 */





// skriva ut värden. 1-12
//anropa klasser med kontruktor.
//få in värden. 
//videopoker 

//Videopoker interface 
//getscore.
public class Interface {
	
	List <Card> cardIf = new ArrayList<>();
	
	
	
	
	public void stand() {
		
	
		Dealer d = new Dealer();
		
		
		
		
		cardIf = d.getHand(); // hämta från dealer 
		
		

		// skriver ut det dragna kortet.
		for (int i = 0; i < cardIf.size(); i++) {

			System.out.println("Dina kort: " + cardIf.get(i));
			

		}
		

	}
       

	
	//skriv ut nuvarande hand, skriver utefter aranget
	public void getHand()
	{
		
	}
	
	
	//hämta poäng skriv ut från videopoker.
	//koppla till poäng score
	public  void getScore()
	{
	
		//poäng. 
		
		
			int score = 0;
			int value;
			
			
			for (int i = 0 ; i < cardIf.size(); i++) {
				
								
			}
				
						
			
	        // en for loop.
			for (int i = 0; i < playerhand.size(); i++) {
			//en for loop, loppar igenom spelarenshand
			//for (int i = 0; i < vd.getPlayerHand(); i++) {
				
				//hämtar spelarens kort. 
				value = playerhand.get(i).getValue(); //+ 1;
	            
				// test av value
				 //System.out.println("vad är value " + value);//positionen i arrayen.
				
				// value är enligt reglerna
				
				/* straiht flush 
				 * se handen om handen är straight flush
				 * se handen är 
				 * if()
				 */
				
				//jämför vad man har på handen.
				// switch case. 
				switch (value) {
				case 0:
					//System.out.println("Inget kort.");
					break;
				case 1:
					//if (Suit)
					
					
					score = score + 11;
					break;
				case 2:
					score = score + 2;
					break;
				case 3:
					score = score + 3;
					break;
				case 4:
					score = score + 4;
					break;
				case 5:
					score = score + 5;
					break;
				case 6:
					score = score + 6;
					break;

				case 7:
					score = score + 7;
					break;
				case 8:
					score = score + 8;

					break;

				case 9:
					score = score + 9;

					break;

				case 10:

					score = score + 10;

					break;

				case 11:
					score = score + 10;

					break;
				case 12:

					score = score + 10;
					break;

				case 13:
					score = score +10;

					break;
				default:
					score += value;
					break;
				} // end switch case

			} // end for
			
			///poäng//
/*
			//skrivet ut summan på de dragna kort eller korten.
			System.out.println("summan är  " + score + " " + value);

			if (score < 10)
		 {
				
			return aces = score + 11;
		 }
			else if (score == 10 ) {
				return aces = +11;
				
			}
			else {
				return score;
				
			}
				
				

			
			return score;

			}
	} */
	
	

}
}


