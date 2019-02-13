import java.awt.*;
public class City extends Article{
	public City(int x, int y){
		super(x,y,2,"City");
	}

	public void drawMe(Graphics g){
		int x = getX();
		int y = getY();
		g.setColor(Color.YELLOW);
		g.fillOval(x*20+5,y*20+5,10,10);
	}
}