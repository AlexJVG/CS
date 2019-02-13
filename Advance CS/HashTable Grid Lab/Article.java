import java.awt.*;
public abstract class Article{
	private int x,y,layer;
	private String name;

	public Article(int x,int y, int layer, String name){
		this.x = x;
		this.y = y;
		this.layer = layer;
		this.name = name;
	}	

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public String getName(){
		return name;
	}

	public int getLayer(){
		return layer;
	}

	public int hashCode(){
		return x+(101*y);
	}

	public abstract void drawMe(Graphics g);
}