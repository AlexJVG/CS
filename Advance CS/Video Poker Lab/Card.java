import java.awt.*;
public class Card{
	private String name;
	private String suit;
	private boolean playerKeep;
	public Card(String name, String suit){
		this.name = name;
		this.suit = suit;
		playerKeep = false;
	}
	public String getName(){
		return name;
	}
	public String getSuit(){
		return suit;
	}
	public void playerKeep(){
		playerKeep = !playerKeep;
	}
	public boolean equals(Object o){
		Card other = (Card)o;
		if(name.equals(other.getName())&&suit.equals(other.getSuit())){
			return true;
		}else{
			return false;
		}
	}
	public void drawMe(Graphics g){
		if(suit.equals("club")){

		}else if(suit.equals("diamond")){

		}else if(suit.equals("heart")){

		}else if(suit.equals("spade")){

		}
	}
}