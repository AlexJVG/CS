import java.awt.*;
public class Grass extends Article{
	public Grass(int x, int y){
		super(x,y,1,"Grass");
	}

	public void drawMe(Graphics g){
		int x = getX();
		int y = getY();
		g.setColor(Color.GREEN);
		g.fillRect(x*20,y*20,20,20);
		g.setColor(Color.BLACK);
		g.drawRect(x*20,y*20,20,20);
	}
}