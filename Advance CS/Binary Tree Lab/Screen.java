import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
public class Screen extends JPanel implements ActionListener{
	private BinaryTree<Account> tree = new BinaryTree<Account>();
	private JTextArea textArea = new JTextArea();
	private JScrollPane countryScrollPane;
	private FileReader reader;
	private FileWriter writer;
	private File nameFile;
	private JButton search = new JButton("Search");
	private JTextField first = new JTextField("First Name");
	private JTextField last = new JTextField("Last Name");
	private JTextArea label = new JTextArea();
	private JButton addUser = new JButton("Add User");
	private JTextField nameFirst = new JTextField("Enter First Name");
	private JTextField nameLast = new JTextField("Enter Last Name");
	private JTextField namePin = new JTextField("Enter Pin");
	private JTextField nameBal = new JTextField("Enter Balance");
	private JButton nameAdd = new JButton("Add User");
	private JTextArea namePass = new JTextArea();
	private JButton removeUser = new JButton("Remove User");
	public Screen(){
		this.setLayout(null);
		textArea.setBounds(0,30,200,770);
		this.add(textArea);
        countryScrollPane = new JScrollPane(textArea);
        countryScrollPane.setBounds(0,30,200,770);
        this.add(countryScrollPane);
		search.setBounds(200,0,200,30);
		search.addActionListener(this);
		this.add(search);
		first.setBounds(0,0,100,30);
		this.add(first);
		last.setBounds(100,0,100,30);
		this.add(last);
		label.setBounds(500,100,200,200);
		this.add(label);
		removeUser.setBounds(500,300,200,30);
		removeUser.addActionListener(this);
		this.add(removeUser);
		nameFirst.setBounds(500,100,200,30);
		this.add(nameFirst);
		nameLast.setBounds(500,200,200,30);
		this.add(nameLast);
		namePin.setBounds(500,300,200,30);
		this.add(namePin);
		nameBal.setBounds(500,400,200,30);
		this.add(nameBal);
		nameAdd.setBounds(500,500,200,30);
		nameAdd.addActionListener(this);
		this.add(nameAdd);
		namePass.setBounds(500,600,200,30);
		this.add(namePass);
		addUser.setBounds(200,30,200,30);
		addUser.addActionListener(this);
		this.add(addUser);
		loadData();
		label.setVisible(false);
		removeUser.setVisible(false);
		nameFirst.setVisible(false);
		nameLast.setVisible(false);
		namePin.setVisible(false);
		nameBal.setVisible(false);
		nameAdd.setVisible(false);
		namePass.setVisible(false);
		this.setVisible(true);
		// tree.printNode();
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(){

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==search){
			label.setVisible(true);
			removeUser.setVisible(true);
			nameFirst.setVisible(false);
			nameLast.setVisible(false);
			namePin.setVisible(false);
			nameBal.setVisible(false);
			nameAdd.setVisible(false);
			namePass.setVisible(false);
			label.setText("");
			label.append("Name: "+tree.get(new Account(first.getText(),last.getText(),0,0)).getFirst()+","+tree.get(new Account(first.getText(),last.getText(),0,0)).getLast()+"\n");
			label.append("Pin: "+tree.get(new Account(first.getText(),last.getText(),0,0)).getPin()+"\n");
			label.append("Bal: "+tree.get(new Account(first.getText(),last.getText(),0,0)).getBal()+"\n");
			label.append("Passes: "+(tree.getPass()+1));
		}else if(e.getSource()==addUser){
			label.setVisible(false);
			removeUser.setVisible(false);
			nameFirst.setVisible(true);
			nameLast.setVisible(true);
			namePin.setVisible(true);
			nameBal.setVisible(true);
			nameAdd.setVisible(true);
			namePass.setVisible(true);
		}else if(e.getSource()==nameAdd){
			textArea.append(nameFirst.getText()+","+nameLast.getText()+"\n");
			tree.add(new Account(nameFirst.getText(),nameLast.getText(),Integer.parseInt(namePin.getText()),Double.parseDouble(nameBal.getText())));
			namePass.setText("");
			nameFirst.setText("");
			nameLast.setText("");
			namePin.setText("");
			nameBal.setText("");
			namePass.append("Passes: "+(tree.getPass()+1));
			// tree.printNode();
		}else if(e.getSource()==removeUser){
			tree.remove(new Account(first.getText(),last.getText(),0,0));
			label.setVisible(false);
			removeUser.setVisible(false);
		}
		saveData();
		textArea.setText(tree.toStringReverse());
	}
	private void saveData(){
		FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
        	PrintWriter writer = new PrintWriter("./save.txt");
			writer.close();
            fos = new FileOutputStream("./save.txt");
            out = new ObjectOutputStream(fos);
            out.writeObject(tree);
            out.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	private void loadData(){
		try{
			File f = new File("./save.txt");
			if(f.exists()&&!f.isDirectory()&&!f.createNewFile()){
				FileInputStream fis = null;
		        ObjectInputStream in = null;
		        try {
		            fis = new FileInputStream("./save.txt");
		            in = new ObjectInputStream(fis);
		            tree = (BinaryTree) in.readObject();
		            in.close();
		            fis.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        textArea.append(tree.toStringReverse());
			}else{
				nameFile = new File("./names.txt");
				try{
					reader = new FileReader(nameFile);
					BufferedReader br = new BufferedReader(reader);
					String line;
					while ((line = br.readLine()) != null) {
					    tree.add(new Account(line.substring(line.indexOf(',')+1),line.substring(0,line.indexOf(',')),(int)(Math.random() * ((9999 - 0) + 1)),(Math.random() * ((100000 - 0) + 1))));
					}
				} catch(Exception e){
					e.printStackTrace();
				}	
				textArea.append(tree.toStringReverse());
				saveData();
			}
		} catch(Exception z){
			z.printStackTrace();
		}
	}
}