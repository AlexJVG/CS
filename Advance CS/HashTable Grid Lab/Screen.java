import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Screen extends JPanel implements ActionListener{
	private static final long serialVersionUID = 31;
	private HashTable<Article> table;
	private Player p;
	public Screen(){
		setFocusable(true);
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	public void actionPerformed(ActionEvent e){
		
	}
}