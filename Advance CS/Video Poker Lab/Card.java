import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Card{
	private String name;
	private String suit;
	private boolean playerKeep;
	private Font font;
	public Card(String name, String suit){
		this.name = name;
		this.suit = suit;
		this.playerKeep = false;
		font = new Font("Arial", Font.PLAIN, 50);
	}
	public String getName(){
		return name;
	}
	public String getSuit(){
		return suit;
	}
	public boolean getKeep(){
		return playerKeep;
	}
	public void cardClicked(int num,int x, int y){
		if(x>0+(160*num)&&x<150+(160*num)&&y>450&&y<750){
			playerKeep();
		}
	}
	public void resetCards(){
		if(playerKeep){
			playerKeep();
		}
	}
	private void playerKeep(){
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
	public void drawMe(Graphics g,int i){
		BufferedImage image;
		g.setFont(font);
		if(playerKeep){
			g.setColor(new Color(255, 243, 216));
		}else{
			g.setColor(Color.white);
		}
		if(suit.equals("club")){
			try {
	            image = ImageIO.read(new File("club.png"));
	            Image newImage = image.getScaledInstance(30,30, Image.SCALE_DEFAULT);
				g.fillRect(0+(160*i),450,150,300);
				g.drawImage(newImage, 0+(160*i), 450, null);
				g.drawImage(newImage, 120+(160*i), 719, null);
				g.setColor(Color.black);
				g.drawRect(0+(160*i),450,150,300);
				if(name.equals("10")){
					g.drawString(name, 50+(160*i), 615);
				}else{
					g.drawString(name, 60+(160*i), 615);
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}else if(suit.equals("diamond")){
			try {
	            image = ImageIO.read(new File("diamond.png"));
	            Image newImage = image.getScaledInstance(30,30, Image.SCALE_DEFAULT);
				g.fillRect(0+(160*i),450,150,300);
				g.drawImage(newImage, 0+(160*i), 450, null);
				g.drawImage(newImage, 120+(160*i), 719, null);
				g.setColor(Color.black);
				g.drawRect(0+(160*i),450,150,300);
				if(name.equals("10")){
					g.drawString(name, 50+(160*i), 615);
				}else{
					g.drawString(name, 60+(160*i), 615);
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}else if(suit.equals("heart")){
			try {
	            image = ImageIO.read(new File("heart.png"));
	            Image newImage = image.getScaledInstance(30,30, Image.SCALE_DEFAULT);
				g.fillRect(0+(160*i),450,150,300);
				g.drawImage(newImage, 0+(160*i), 450, null);
				g.drawImage(newImage, 120+(160*i), 719, null);
				g.setColor(Color.black);
				g.drawRect(0+(160*i),450,150,300);
				if(name.equals("10")){
					g.drawString(name, 50+(160*i), 615);
				}else{
					g.drawString(name, 60+(160*i), 615);
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}else if(suit.equals("spade")){
			try {
	            image = ImageIO.read(new File("spade.png"));
	            Image newImage = image.getScaledInstance(30,30, Image.SCALE_DEFAULT);
				g.fillRect(0+(160*i),450,150,300);
				g.drawImage(newImage, 0+(160*i), 450, null);
				g.drawImage(newImage, 120+(160*i), 719, null);
				g.setColor(Color.black);
				g.drawRect(0+(160*i),450,150,300);
				if(name.equals("10")){
					g.drawString(name, 50+(160*i), 615);
				}else{
					g.drawString(name, 60+(160*i), 615);
				}
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
}