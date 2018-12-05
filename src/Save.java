import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Save   {
	Deck deck;
	List<Card> playerHand;
	int score;
	File file;
	
	//Konstruktor som tar emot objekten vi vill spara och skapar filen save.bat
	Save(Deck deck, List<Card> playerHand, int score) throws IOException {
	this.file = new File("save.bat");
	this.deck = deck;
	this.score = score;
	this.playerHand = playerHand;
	}
	
	
	//
	public void serialization() throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream ois = new ObjectOutputStream(fos);
		ois.writeObject(deck);
		ois.writeObject(playerHand);
		ois.writeObject(score);
		ois.close();
		fos.close();
	}
	
	public Object deSerialization() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object object = ois.readObject();
		ois.close();
		return object;
	}
	
	
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public List<Card> getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
