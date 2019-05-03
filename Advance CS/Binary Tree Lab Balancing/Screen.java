import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Screen extends JPanel implements ActionListener{
	public Screen(){
		this.setLayout(null);
		this.setVisible(true);
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g){
	}
	public void actionPerformed(ActionEvent e){
	}
}