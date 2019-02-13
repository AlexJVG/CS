import java.awt.*;
public class Water extends Article{
	public Water(int x, int y){
		super(x,y,1,"Water");
	}

	public void drawMe(Graphics g){
		int x = getX();
		int y = getY();
		g.setColor(Color.BLUE);
		g.fillRect(x*20,y*20,20,20);
		g.setColor(Color.BLACK);
		g.drawRect(x*20,y*20,20,20);
	}
}