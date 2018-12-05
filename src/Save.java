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
//	Deck deck;
//	List<Card> playerHand;
//	int score;
	File file;
	ArrayList<Object> list = new ArrayList<>();
	
	//Konstruktor som tar emot objekten vi vill spara och skapar filen save.bat
	Save(Deck deck, List<Card> playerHand, int score) throws IOException {
	this.file = new File("save.txt");
	file.createNewFile();
	list.add(deck);
	list.add(playerHand);
	list.add(score);
	}
	
	
	//
	public void serialization() throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream ois = new ObjectOutputStream(fos);
		ois.writeObject(list);
	//	ois.writeObject(list.get(1));
	//	ois.writeObject(list.get(2));
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
}
