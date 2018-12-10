import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Save   {
	File file;
	ArrayList<Object> list = new ArrayList<>();	
	
	//Tillkalla den tomma konstruktorn när du vill ladda. Pekar ut filen som ska heta save.txt och ligga i src
	Save(){
		this.file = new File("save.txt");
	}
	
	//Konstruktor som tar emot objekten vi vill spara och skapar filen save.txt i src
	//Värt att tänka på är att klassen där objekten finns måste extenda Serializable
	Save(Deck deck, List<Card> playerHand, int bank) throws IOException {
	this.file = new File("save.txt");
	file.createNewFile();
	list.add(deck);
	list.add(playerHand);
	list.add(bank);
	}
	
	
	//Skriv lista till filen och stänga outputstreams, konstuktorn med flera ska användas för att data ska dyka upp i filen
	public void save() throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream ois = new ObjectOutputStream(fos);
		ois.writeObject(list);
		ois.close();
		fos.close();
	}
	
	//Ladda in från filen file. Retunera en arraylist som du får läsa in i set metoder, se lösningsförslag längst ner
	public Object serialization() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object object = ois.readObject();
		ois.close();
		return object;
	}
	
	//retunerar objektet deal där hand och deck är satt till vad som fanns i filen save.txt
	public Dealer load() throws ClassNotFoundException, IOException {
		Dealer deal = new Dealer();
		Object o = serialization();
		this.list = (ArrayList<Object>) o;
		Deck deck = (Deck) list.get(0);
		deal.setDeck(deck);
		List<Card> hand = (List<Card>) list.get(1);
		deal.setHand(hand);
		return deal;

	}
}


//		Dealer deal = new Dealer();
//Save save = new Save(deal.getDeck(), deal.getHand(), 8);
//System.out.println(deal.getHand() + " " + deal.getDeck());
//save.save();
//deal = save.loads();
//System.out.println(deal.getHand() + " " + deal.getDeck());
//Ett exempel på hur en sparning hade kunnat se ut
//Save s = new Save(deal.getDeck, deal.getHand(), int);
//s.save();

//Ett exempel på hur man kan skriva laddningen
//Save sl = new Save();
//o = (ArrayList<Object>) sl.load();
//deal.setDeck = (Deck) o.get(0);
//deal.setHand((List<Card>) o.get(1));