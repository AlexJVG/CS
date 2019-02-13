	import java.awt.*;
public class Tree extends Article{
	public Tree(int x, int y){
		super(x,y,2,"Tree");
	}

	public void drawMe(Graphics g){
		int x = getX();
		int y = getY();
		g.setColor(Color.RED);
		g.fillOval(x*20+5,y*20+5,10,10);
	}	
}