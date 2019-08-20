import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
public class Screen extends JPanel implements ActionListener,KeyListener{
	public static Fighter p1;
	private Enemy en;
	private ColManager col;
	public static Thread g
	private EnemyManager enM;
	public Screen(){
		this.setLayout(null);
		p1 = new Fighter(350,750);
		col = new ColManager();
		g = new Thread(col);
        g.start();
        enM = new EnemyManager();
        Thread z = new Thread(enM);
        z.start();
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		p1.drawMe(g);
		for(Projectile each : Runner.manager_projectile.values()){
			each.drawMe(g);
		}
		for(Enemy each2 : Runner.manager_enemy.values()){
			each2.drawMe(g);
		}
		repaint();
	}
	public void actionPerformed(ActionEvent e){

	}
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 40) {
        	p1.moveDown();
        }
        if (e.getKeyCode() == 38) {
        	p1.moveUp();
        }
        if (e.getKeyCode() == 37) {
            p1.moveLeft();
        }
        if (e.getKeyCode() == 39) {
            p1.moveRight();
        }
        if(e.getKeyCode()==32){
        	p1.shoot();
        }
    }
 
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}