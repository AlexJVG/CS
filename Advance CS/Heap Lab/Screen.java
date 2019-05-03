zimport javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
public class Screen extends JPanel implements ActionListener{
	public Screen(){
		this.setLayout(null);
		this.setFocusable(true);
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);z
	}
	public void actionPerformed(ActionEvent e){
	}
}