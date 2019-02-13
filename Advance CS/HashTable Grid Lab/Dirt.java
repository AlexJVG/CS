import java.awt.*;
public class Dirt extends Article{
	public Dirt(int x, int y){
		super(x,y,1,"Dirt");
	}

	public void drawMe(Graphics g){
		int x = getX();
		int y = getY();
		g.setColor(new Color(181,101,29));
		g.fillRect(x*20,y*20,20,20);
		g.setColor(Color.BLACK);
		g.drawRect(x*20,y*20,20,20);
	}
}