import java.awt.*;
public class Boulder extends Article{
	public Boulder(int x, int y){
		super(x,y,2,"Boulder");
	}

	public void drawMe(Graphics g){
		int x = getX();
		int y = getY();
		g.setColor(new Color(128,128,128));
		g.fillOval(x*20+5,y*20+5,10,10);
	}
}