import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends JPanel implements ActionListener{
	private static final long serialVersionUID = 615407811213953435L;
	private JTextField enterField1 = new JTextField("Name");
	private JTextField enterField2 = new JTextField("Price");
	private JTextArea showText = new JTextArea();
	private JLabel total = new JLabel();
	private JButton enterButton = new JButton("Add Item");
	private JButton removeButton = new JButton("Remove Item");
	private JButton timeButton = new JButton("Sort by Time");
	private JButton nameButton = new JButton("Sort by Name");
	private JButton priceButton = new JButton("Sort by Price");
	private SLL list = new SLL();
	public Screen(){
		this.setLayout(null);
		showText.setBounds(400,0,400,800);
		this.add(showText);
		total.setBounds(200,0,200,30);
		this.add(total);
		enterField1.setBounds(0,0,200,30);
		this.add(enterField1);
		enterField2.setBounds(0,30,200,30);
		this.add(enterField2);
		enterButton.setBounds(0,60,200,30);
		enterButton.addActionListener(this);
		this.add(enterButton);
		removeButton.setBounds(0,90,200,30);
		removeButton.addActionListener(this);
		this.add(removeButton);
		timeButton.setBounds(0,120,200,30);
		timeButton.addActionListener(this);
		this.add(timeButton);
		nameButton.setBounds(0,150,200,30);
		nameButton.addActionListener(this);
		this.add(nameButton);
		priceButton.setBounds(0,180,200,30);
		priceButton.addActionListener(this);
		this.add(priceButton);
		list.add("Apple",1234.60,37,new Date());
		list.add("Egg",68.63,2,new Date());
		list.add("Banana",123.55,98,new Date());
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	showText.setText("");
    	for(int i =1; i<list.size()+1;i++){
    		showText.append("Name: "+list.get(i).getName()+"\n"+"Price: "+list.get(i).getPrice()+"\n"+"Quantity: "+list.get(i).getQuantity()+"\n\n");
    	}
    	double price = 0;
    	for(int i =1; i<list.size()+1;i++){
    		price+=list.get(i).getQuantity()*list.get(i).getPrice();
    	}
    	total.setText("Total Price: "+price);
    	repaint();

    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==enterButton||e.getSource()==removeButton){
    		if(enterField1.getText().equals("")!=true&&enterField2.getText().equals("")!=true){
    			if(e.getSource()==enterButton){
    				list.add(enterField1.getText(),Double.parseDouble(enterField2.getText()));
    			}else if(e.getSource()==removeButton){
    				list.remove(enterField1.getText(),Double.parseDouble(enterField2.getText()));
    			}
    		}
    	}
    	if(e.getSource()==timeButton){
    		list.sortType(3);
    	}
    	if(e.getSource()==nameButton){
    		list.sortType(2);
    	}
    	if(e.getSource()==priceButton){
    		list.sortType(1);
    	}
    	System.out.println(list);
    	repaint();
    }
}
