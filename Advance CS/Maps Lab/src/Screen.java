import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener{
	private static final long serialVersionUID = 8000740513298401109L;
	private Map<Item,Double> hashStore;
	private Map<Item,Double> treeStore;
	
	private ArrayList<Pair<Item,Integer>> shoppingCart;
	private int totalitem;
	private double totalprice;
	private double totalshipping;
	private double totalweight;
	private boolean updateOrAdd;
	private Item tempItem;
	
	private JTextField nameField;
	private JTextField quantityField;
	private JButton addButton;
	
	private JScrollPane itemPane;
	private JTextArea itemArea;
	
	private JScrollPane shoppingPane;
	private JTextArea shoppingArea;
	
	private JDialog adminPanel;
	private JPanel adminPanelReal;
	private JButton adminButton;
	private JTextField passwordField;
	private JButton passwordButton;
	private JButton addItem;
	private JButton removeItem;
	private JTextField changeItemName;
	private JTextField changeItemPrice;
	private JTextField addItemCompany;
	private JTextField addItemWeight;
	private boolean returnToMain;
	
	private BufferedReader reader;
	private int lines;
	private String temptxt;
	private JFrame testFrame;
	public Screen(JFrame parentFrame) {
		testFrame = parentFrame;
		this.setLayout(null);
		hashStore = new HashMap<Item,Double>();
		treeStore = new TreeMap<Item,Double>();
		lines = 0;
		totalprice=0;
		totalitem=0;
		totalweight=0;
		totalshipping=0;
		updateOrAdd = false;
		returnToMain = true;
		try {
			reader = new BufferedReader(new FileReader("storeB.txt"));
			while(reader.readLine()!=null) {
				lines++;
			}
			reader = new BufferedReader(new FileReader("storeB.txt"));
			for(int i = 0;i<lines;i++){
				temptxt = reader.readLine();
				hashStore.put((new Item(temptxt.substring(0, temptxt.indexOf(",")),temptxt.substring(temptxt.indexOf(",")+1, temptxt.indexOf(",",temptxt.lastIndexOf(","))),round((Math.random()*100),2))),Double.parseDouble(temptxt.substring(temptxt.lastIndexOf(",")+1)));
				treeStore.put((new Item(temptxt.substring(0, temptxt.indexOf(",")),temptxt.substring(temptxt.indexOf(",")+1, temptxt.indexOf(",",temptxt.lastIndexOf(","))),round((Math.random()*100),2))),Double.parseDouble(temptxt.substring(temptxt.lastIndexOf(",")+1)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		shoppingCart = new ArrayList<Pair<Item,Integer>>();
		shoppingArea = new JTextArea();
		shoppingArea.setEditable(false);
		shoppingArea.setLineWrap(true);
		shoppingPane = new JScrollPane(shoppingArea);
		shoppingPane.setBounds(100, 0, 300, 800);
		shoppingPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		shoppingPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(shoppingPane);
		nameField = new JTextField();
		nameField.setBounds(0, 0, 100, 30);
		this.add(nameField);
		quantityField = new JTextField();
		quantityField.setBounds(0, 30, 100, 30);
		this.add(quantityField);
		addButton = new JButton("Add");
		addButton.setBounds(0,60,100,30);
		addButton.addActionListener(this);
		this.add(addButton);
		adminButton = new JButton("Open Admin View");
		adminButton.setBounds(0,90,100,30);
		adminButton.addActionListener(this);
		this.add(adminButton);
		adminPanelReal = new JPanel();
		adminPanelReal.setLayout(null);
		passwordField = new JTextField();
		passwordField.setBounds(0,0,100,30);
		adminPanelReal.add(passwordField);
		passwordButton = new JButton("Enter Password");
		passwordButton.setBounds(0,30,100,30);
		passwordButton.addActionListener(this);
		adminPanelReal.add(passwordButton);
		addItem = new JButton("Add Item");
		addItem.setBounds(0, 30, 100, 30);
		addItem.addActionListener(this);
		addItem.setVisible(false);
		adminPanelReal.add(addItem);
		removeItem = new JButton("Remove Item");
		removeItem.setBounds(0, 60, 100, 30);
		removeItem.addActionListener(this);
		removeItem.setVisible(false);
		adminPanelReal.add(removeItem);
		changeItemName = new JTextField();
		changeItemName.setBounds(0,0,100,30);
		changeItemName.setVisible(false);
		adminPanelReal.add(changeItemName);
		changeItemPrice = new JTextField();
		changeItemPrice.setBounds(0,30,100,30);
		changeItemPrice.setVisible(false);
		adminPanelReal.add(changeItemPrice);
		addItemCompany = new JTextField();
		addItemCompany.setBounds(0,30,100,30);
		addItemCompany.setVisible(false);
		adminPanelReal.add(addItemCompany);
		addItemWeight = new JTextField();
		addItemWeight.setBounds(100,0,100,30);
		addItemWeight.setVisible(false);
		adminPanelReal.add(addItemWeight);
		adminPanel = new JDialog(testFrame,"Admin View Tab");
		adminPanel.add(adminPanelReal);
		adminPanel.setSize(300,120);
		itemArea = new JTextArea();
		itemArea.setEditable(false);
		itemArea.setLineWrap(true);
		itemPane = new JScrollPane(itemArea);
		itemPane.setBounds(400, 0, 400, 800);
		itemPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(itemPane);
		itemArea.append("Store Items:\n\n");
    	for(Item each : treeStore.keySet()) {
    		System.out.println(each.getItemName());
    		itemArea.append(each.toString()+treeStore.get(each)+"\n\n");
    	}
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics G) {
		
	}
	public double round(double value,int places) {
		if(places<0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==adminButton) {
			adminPanel.setVisible(true);
			passwordField.setVisible(true);
			passwordButton.setText("Enter Password");
			passwordButton.setBounds(0,30,100,30);
			addItem.setVisible(false);
			removeItem.setVisible(false);
			changeItemName.setVisible(false);
			changeItemPrice.setVisible(false);
			returnToMain = false;
		}
		else if(e.getSource()==passwordButton||e.getSource()==addItem||e.getSource()==removeItem) {
			if(e.getSource()==passwordButton&&passwordField.getText().equals("CompSci Rules")&&passwordButton.getText().equals("Enter Password")||returnToMain == true) {
				if(e.getSource()==passwordButton&&passwordButton.getText().equals("Change Item")&&returnToMain == true) {
					for(Item each : hashStore.keySet()) {
						if(each.equals(new Item(changeItemName.getText(),"",0))) {
							tempItem = each;
							break;
						}
					}
					hashStore.remove(tempItem);
					hashStore.put(new Item(changeItemName.getText(),tempItem.getCompanyName(),tempItem.getWeight()), round(Double.parseDouble(changeItemPrice.getText()),3));
					for(Item each : treeStore.keySet()) {
						if(each.equals(new Item(changeItemName.getText(),"",0))) {
							tempItem = each;
							break;
						}
					}
					treeStore.remove(tempItem);
					treeStore.put(new Item(changeItemName.getText(),tempItem.getCompanyName(),tempItem.getWeight()), round(Double.parseDouble(changeItemPrice.getText()),3));
					itemArea.setText("");
					itemArea.append("Store Items:\n\n");
			    	for(Item each : treeStore.keySet()) {
			    		itemArea.append(each.toString()+treeStore.get(each)+"\n\n");
			    	}
			    	changeItemName.setText("");
			    	changeItemPrice.setText("");
			    	addItemCompany.setText("");
				}
				else if(e.getSource()==addItem && returnToMain == true) {
					for(Item each : hashStore.keySet()) {
						if(each.equals(new Item(changeItemName.getText(),"",0))) {
							tempItem = each;
							break;
						}
					}
					hashStore.remove(tempItem);
					hashStore.put(new Item(changeItemName.getText(),addItemCompany.getText(),round(Double.parseDouble(addItemWeight.getText()),2)), round(Double.parseDouble(changeItemPrice.getText()),3));
					for(Item each : treeStore.keySet()) {
						if(each.equals(new Item(changeItemName.getText(),"",0))) {
							tempItem = each;
							break;
						}
					}
					treeStore.remove(tempItem);
					treeStore.put(new Item(changeItemName.getText(),addItemCompany.getText(),round(Double.parseDouble(addItemWeight.getText()),2)), round(Double.parseDouble(changeItemPrice.getText()),3));
					itemArea.setText("");
					itemArea.append("Store Items:\n\n");
			    	for(Item each : treeStore.keySet()) {
			    		itemArea.append(each.toString()+treeStore.get(each)+"\n\n");
			    	}
			    	changeItemName.setText("");
			    	changeItemPrice.setText("");
			    	addItemCompany.setText("");
				}
				else if(e.getSource()==removeItem && returnToMain == true) {
					for(Item each : hashStore.keySet()) {
						if(each.equals(new Item(changeItemName.getText(),"",0))) {
							tempItem = each;
							break;
						}
					}
					hashStore.remove(tempItem);
					for(Item each : treeStore.keySet()) {
						if(each.equals(new Item(changeItemName.getText(),"",0))) {
							treeStore.remove(each);
							break;
						}
					}
					itemArea.setText("");
					itemArea.append("Store Items:\n\n");
			    	for(Item each : treeStore.keySet()) {
			    		itemArea.append(each.toString()+treeStore.get(each)+"\n\n");
			    	}
			    	changeItemName.setText("");
			    	changeItemPrice.setText("");
			    	addItemCompany.setText("");
				}
				passwordField.setVisible(false);
				passwordField.setText("");
				passwordButton.setText("Change Item");
				passwordButton.setBounds(0, 0, 100, 30);
				addItem.setBounds(0, 30, 100, 30);
				removeItem.setBounds(0, 60, 100, 30);
				addItem.setVisible(true);
				removeItem.setVisible(true);
				passwordButton.setVisible(true);
				changeItemName.setVisible(false);
				changeItemPrice.setVisible(false);
				addItemCompany.setVisible(false);
				addItemWeight.setVisible(false);
				returnToMain = false;
			}
			else if(e.getSource()==passwordButton&&passwordButton.getText().equals("Change Item")&&returnToMain == false) {
				returnToMain = true;
				passwordButton.setBounds(0, 60, 100, 30);
				changeItemName.setVisible(true);
				changeItemPrice.setVisible(true);
				changeItemPrice.setBounds(0,30,100,30);
				addItem.setVisible(false);
				removeItem.setVisible(false);
			}
			else if(e.getSource()==addItem && returnToMain == false) {
				returnToMain = true;
				changeItemName.setVisible(true);
				changeItemPrice.setVisible(true);
				changeItemPrice.setBounds(0,60,100,30);
				addItemCompany.setVisible(true);
				addItemWeight.setVisible(true);
				addItem.setVisible(true);
				addItem.setBounds(100,30,100,30);
				passwordButton.setVisible(false);
				removeItem.setVisible(false);
			}
			else if(e.getSource()==removeItem && returnToMain == false) {
				returnToMain = true;
				changeItemName.setVisible(true);
				addItem.setVisible(false);
				removeItem.setBounds(0,30,100,30);
				passwordButton.setVisible(false);
				removeItem.setVisible(true);
			}
		}
		else if(e.getSource()==addButton) {
			if(!nameField.getText().equals("")&&!quantityField.getText().equals("")) {
				if(hashStore.containsKey(new Item(nameField.getText(),"",0))) {
					for(Item each : hashStore.keySet()) {
						if(each.equals(new Item(nameField.getText(),"",0))) {
							for(Pair<Item,Integer> each2 : shoppingCart) {
								if(each2.getKey().equals(new Item(nameField.getText(),"",0))) {
									each2.updateValue(each2.getValue()+Integer.parseInt(quantityField.getText()));
									updateOrAdd = true;
								}
							}
							if(updateOrAdd==false) {
								shoppingCart.add(new Pair<Item,Integer>(each,Integer.parseInt(quantityField.getText())));
							}
							else {
								updateOrAdd=false;
							}
						}
					}
				}
				nameField.setText("");
				quantityField.setText("");
			}
		}
		totalitem=0;
		totalprice=0;
		totalweight=0;
		totalshipping=0;
		for(Pair<Item,Integer> each : shoppingCart) {
			totalitem+=each.getValue();
			totalprice+=hashStore.get(each.getKey())*each.getValue();
			totalweight+=each.getKey().getWeight();
			totalshipping+=each.getKey().getWeight()*2.40;
		}
		shoppingArea.setText("");
		shoppingArea.append("Shopping Cart\n# of Items: "+totalitem+"\nTotal Cost: "+round(totalprice,3)+"\nTotal Weigth: "+totalweight*totalitem+"\nShipping Cost: "+round(totalshipping*totalitem,2)+"\n\n");
		for(Pair<Item,Integer> each : shoppingCart) {
			shoppingArea.append("Item Name: "+ each.getKey().getItemName()+" - Item Price: "+hashStore.get(each.getKey())+" - Quantity: "+each.getValue()+"\n");
		}
		repaint();
		
	}

}
