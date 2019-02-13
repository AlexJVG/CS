import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Screen extends JPanel implements KeyListener{
	private static final long serialVersionUID = 31;
	private HashTable<Article> table;
	private Player p;
	public Screen(){
		setFocusable(true);
        addKeyListener(this);
		table = new HashTable<>();
		for(int i = 0;i<20;i++){
			for(int j = 0; j<20;j++){
				table.add(RandomThingo.getClass(i,j));
			}
		}
		for(int i =0;i<100;i++){
			Random rand = new Random();
			int x = rand.nextInt(20);
			int y = rand.nextInt(20);
			// table.add(RandomThingo.getObject(x,y));
			if(!table.get(x,y).containsWater(x,y)){
				table.add(RandomThingo.getObject(x,y));
			}
		}
		table.firstThingo();
		table.add(new Dirt(0,0));
		p = new Player(0,0);
		System.out.println("\n\n\n\n\n\n\n");
	}
	public Dimension getPreferredSize(){
		return new Dimension(400,400);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0;i<20;i++){
			for(int j = 0; j<20;j++){
				DLList<Article> temp = table.get(i,j);
				for(int k=0; k<temp.size();k++){
					temp.get(k).drawMe(g);
				}	
			}
		}
		p.drawMe(g);
	}
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	System.out.println(p.getX()+"|"+(p.getY()+1));
        	if(!table.get(p.getX(),p.getY()+1).containsWater(p.getX(),p.getY()+1)&&!table.get(p.getX(),p.getY()+1).containsObject(p.getX(),p.getY()+1)){
        		p.moveDown();
        	}
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	System.out.println((p.getX()-1)+"|"+p.getY());
            if(!table.get(p.getX()-1,p.getY()).containsWater(p.getX()-1,p.getY())&&!table.get(p.getX()-1,p.getY()).containsObject(p.getX()-1,p.getY())){
        		p.moveLeft();
        	}
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	System.out.println((p.getX()+1)+"|"+p.getY());
            if(!table.get(p.getX()+1,p.getY()).containsWater(p.getX()+1,p.getY())&&!table.get(p.getX()+1,p.getY()).containsObject(p.getX()+1,p.getY())){
            	p.moveRight();
        	}
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	System.out.println(p.getX()+"|"+(p.getY()-1));
            if(!table.get(p.getX(),p.getY()-1).containsWater(p.getX(),p.getY()-1)&&!table.get(p.getX(),p.getY()-1).containsObject(p.getX(),p.getY()-1)){
        		p.moveUp();
        	}
        }
        repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}