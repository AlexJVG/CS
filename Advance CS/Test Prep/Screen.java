import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Screen extends JPanel{
	private Drawer d;
	public Screen(){
		this.setLayout(null);
		d = new Drawer();
		Thread t = new Thread(d);
		t.start();
		this.setFocusable(true);
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		d.drawMe(g);
		repaint();
	}
}