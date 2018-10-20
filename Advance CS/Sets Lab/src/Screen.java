import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Screen extends JPanel implements ActionListener{

	private static final long serialVersionUID = -5618841507180329267L;
	private ArrayList<Integer> lineamount;
	private ArrayList<Integer> quantvals;
	private ArrayList<Pair<Item,Integer>> shoppingCart;
	private ArrayList<JTextField> quantityList;
	private Set<Item> hashSet;
	private Set<Item> treeSet;
	private BufferedReader reader;
	private int lines;
	private int totalitem;
	private double totalprice;
	private String temptxt;
	private JScrollPane scrollPane;
	private JScrollPane shoppingPane;
	private JTextArea textArea;
	private JTextArea shoppingArea;
	private JTextField namepro;
	private JTextField pricepro;
	private JTextField quanitypro;
	private JLabel nameLabel;
	private JLabel quanityLabel;
	private JLabel priceLabel;
	private JButton addButton;
	private boolean updateOrAdd;
	public Screen(int numberofquan,ArrayList<Integer> lineslist,ArrayList<Integer> quantval){
		System.out.println("TEST");
		System.out.println(numberofquan);
		System.out.println(lineslist);
		this.setLayout(null);
		shoppingCart = new ArrayList<Pair<Item,Integer>>();
		quantityList = new ArrayList<JTextField>();
		hashSet = new HashSet<Item>();
		treeSet = new TreeSet<Item>();
		lines =0;
		updateOrAdd = false;
		try {
			reader = new BufferedReader(new FileReader("StoreA.txt"));
			while(reader.readLine()!=null) {
				lines++;
			}
			reader = new BufferedReader(new FileReader("StoreA.txt"));
			for(int i = 0;i<lines;i++){
				temptxt = reader.readLine();
				hashSet.add(new Item(temptxt.substring(0, temptxt.indexOf(",")),Double.parseDouble(temptxt.substring(temptxt.indexOf(",")+1))));
				treeSet.add(new Item(temptxt.substring(0, temptxt.indexOf(",")),Double.parseDouble(temptxt.substring(temptxt.indexOf(",")+1))));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		addButton = new JButton("Add");
		addButton.setBounds(0,90,100,30);
		addButton.addActionListener(this);
		this.add(addButton);
		namepro= new JTextField();
		namepro.setBounds(0, 0, 100, 30);
		this.add(namepro);
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(100, 0, 100, 30);
		this.add(nameLabel);
		nameLabel = new JLabel("Price");
		nameLabel.setBounds(100, 30, 100, 30);
		this.add(nameLabel);
		nameLabel = new JLabel("Quantity");
		nameLabel.setBounds(100, 60, 100, 30);
		this.add(nameLabel);
		pricepro= new JTextField();
		pricepro.setBounds(0, 30, 100, 30);
		this.add(pricepro);
		quanitypro= new JTextField();
		quanitypro.setBounds(0, 60, 100, 30);
		this.add(quanitypro);
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	scrollPane.setBounds(600,0,200,800);
    	this.add(scrollPane);
    	shoppingArea = new JTextArea();
    	shoppingArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    	shoppingArea.setEditable(false);
    	shoppingArea.setLineWrap(true);
		shoppingPane = new JScrollPane(shoppingArea);
		shoppingPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		shoppingPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		shoppingPane.setBounds(200,0,400,800);
    	this.add(shoppingPane);
//    	for(int i =0;i<numberofquan;i++) {
//    		quantityList.add(i,new JTextField(Integer.toString(quantval.get(i))));
//    		quantityList.get(i).setBounds(25+(12*lineslist.get(i)),(i+5)*12,20, 20);
//    		this.add(quantityList.get(i));
//    	}
    	textArea.append("Store Items:\n\n");
    	for(Item each : treeSet) {
    		textArea.append(each.toString());
    	}
		this.setFocusable(true);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
    	g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        for(int i =0;i<quantityList.size();i++) {
			quantityList.get(i).getDocument().addDocumentListener(new DocumentListener() {
    			public void changedUpdate(DocumentEvent e) {
    			  }
    			  public void removeUpdate(DocumentEvent e) {
    				  updateText();
    			  }
    			  public void insertUpdate(DocumentEvent e) {
    				  updateText();
    			  }
    			  public void updateText() {
    				  System.out.println("Trigger");
    				  System.out.println(quantityList.size());
    				  System.out.println(shoppingCart.size());
    				  if(quantityList.size()>0&&shoppingCart.size()>0) {
    					  for(int i = 0; i<quantityList.size();i++) {
            				  if(!quantityList.get(i).getText().equals("")) {
            					  System.out.println("TEstasd123");
            					  shoppingCart.get(i).updateValue(Integer.parseInt(quantityList.get(i).getText()));
            				  } 
        				  }
    				  }
    				}
    		});
		}
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		if(!namepro.getText().equals("")&&!pricepro.getText().equals("")&&!quanitypro.getText().equals("")) {
			if(e.getSource()==addButton) {
				Item temp = new Item(namepro.getText(),Double.parseDouble(pricepro.getText()));
				for(Item each : hashSet) {
					if(each.hashCode()==temp.hashCode()) {
						for(Pair<Item,Integer> item: shoppingCart) {
							if(item.getKey().hashCode()==temp.hashCode()) {
								item.updateValue(item.getValue()+Integer.parseInt(quanitypro.getText()));
								updateOrAdd = true;
							}
						}
						if(updateOrAdd==false) {
							shoppingCart.add(new Pair<Item,Integer>(temp,Integer.parseInt(quanitypro.getText())));
						}
						else {
							updateOrAdd=false;
						}
						namepro.setText("");
						pricepro.setText("");
						quanitypro.setText("");
					}
				}
			}
		}
		System.out.println("Testlength:"+shoppingCart.size());
		for(int i = 0; i < shoppingCart.size(); i++) {
			if(shoppingCart.get(i).getValue()==0) {
				shoppingCart.remove(i);
			}
		}
		shoppingArea.setText("");
		shoppingArea.append("Shopping Cart\n# of Items: "+totalitem+"\nTotal Cost: "+totalprice+"\n\n");
		for(Pair<Item,Integer> each : shoppingCart) {
			shoppingArea.append("Item Name: "+ each.getKey().getName()+" - Item Price: "+each.getKey().getPrice()+" - Quantity: "+each.getValue()+"\n");
		}
		totalitem=0;
		totalprice=0;
		for(Pair<Item,Integer> each : shoppingCart) {
			totalitem+=each.getValue();
			totalprice+=each.getKey().getPrice()*each.getValue();
		}
		lineamount= new ArrayList<Integer>();
		for(String each : shoppingArea.getText().split("\\n")) {
			lineamount.add(each.length());
		}
		quantvals = new ArrayList<Integer>();
		for(Pair<Item,Integer> each : shoppingCart) {
			quantvals.add(each.getValue());
		}
		repaint();
		Runner.remake(shoppingArea.getLineCount()-5,lineamount,quantvals);
	}
}
