import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		VideoPoker startGame = new VideoPoker();
		Dealer deal = new Dealer();
		Interface inter = new Interface(deal);
		for(int i = 0; i < 1000000; i++) {
		deal = new Dealer();
		inter = new Interface(deal);
	//	inter.getHand();
		inter.getScore();
		}
	}
}
