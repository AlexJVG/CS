import java.awt.*;
public class Player{
	private int x,y;
	public Player(int x,int y){
		this.x = x;
		this.y = y;
	}
	public void drawMe(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x*20+5,y*20+5,5,5);
		g.setColor(Color.ORANGE);
		g.fillRect(x*20+5,y*20+10,5,10);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void moveUp(){
		if(!(y<=0)){
			y--;
		}
	}
	public void moveDown(){
		if(!(y>=19)){
			y++;
		}
	}
	public void moveLeft(){
		if(!(x<=0)){
			x--;
		}
	}
	public void moveRight(){
		if(!(x>=19)){
			x++;
		}
	}
}