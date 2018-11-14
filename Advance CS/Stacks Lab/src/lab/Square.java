
import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int r;
	private int g;
	private int b;
	public Square(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public void changeColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public int getR() {
		return this.r;
	}
	public int getG() {
		return this.g;
	}
	public int getB() {
		return this.b;
	}
	public void drawMe(int x, int y, Graphics g) {
		g.setColor(new Color(this.r,this.g,this.b));
		g.fillRect(x, y, 20, 20);
		g.setColor(new Color(0,0,0));
		g.drawRect(x, y, 20, 20);
		
	}
}
