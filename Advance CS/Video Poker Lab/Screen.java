import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class Screen extends JPanel implements ActionListener{
	private DLList<Card> deck = new DLList<>();
	private DLList<Card> player = new DLList<>();
	private String[] cardName = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private String[] suitName = new String[]{"club","diamond","heart","spade"};
	private int playerPoints = 50;
	private 
	public Screen(){
		this.setLayout(null);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(Color.green);
        g.fillRect(0, 0, 1500, 800);
    }
    public void actionPerformed(ActionEvent e) {
    }
	public void drawDeck(){
		for(int i = 0; i<suitName.length;i++){
			for(int j = 0; j<cardName.length;j++){
				deck.add(new Card(cardName[j],suitName[i]));
			}
		}
		shuffle();
	}
	public void shuffle(){
		for(int i =0;i<7;i++){
			Random random = ThreadLocalRandom.current();
			for(int i = deck.size();i>0;i--){
				int index = random.nextInt(i);
				Card one = deck.get(index);
				Card two = deck.get(i);
				deck.set(index,two);
				deck.set(i,one);
			}
		}
		for(int i =0;i<5;i++){
			player.add(deck.get(i));
			deck.remove(i);
		}
	}
	public void changeCards(){
		for(int i =0;i<5;i++){
			if(player.get(i).)
		}
	}
}