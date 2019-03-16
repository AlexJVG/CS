import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
public class Screen extends JPanel implements ActionListener{
	private BinaryTree<Account> tree = new BinaryTree<Account>();
	private JTextArea textArea = new JTextArea();
	private FileReader reader;
	private FileWriter writer;
	private File nameFile;
	private JButton search = new JButton("Search");
	private JTextField first = new JTextField("First Name");
	private JTextField last = new JTextField("Last Name");
	private JTextArea label = new JTextArea();
	public Screen(){
		this.setLayout(null);
		textArea.setBounds(0,30,400,770);
		this.add(textArea);
		search.setBounds(200,0,200,30);
		search.addActionListener(this);
		this.add(search);
		first.setBounds(0,0,100,30);
		this.add(first);
		last.setBounds(100,0,100,30);
		this.add(last);
		label.setBounds(500,100,200,200);
		this.add(label);
		loadData();
		this.setVisible(true);
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void paintComponent(){

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==search){
			label.setText("");
			label.append("Name: "+tree.get(new Account(first.getText(),last.getText(),0,0)).getFirst()+","+tree.get(new Account(first.getText(),last.getText(),0,0)).getLast()+"\n");
			label.append("Pin: "+tree.get(new Account(first.getText(),last.getText(),0,0)).getPin()+"\n");
			label.append("Bal: "+tree.get(new Account(first.getText(),last.getText(),0,0)).getBal()+"\n");
			label.append("Passes: "+(tree.getPass()+1));
		}
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
				System.out.println("testiong the fakjsd;lfkjs");
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
		        textArea.append(tree.toString());
			}else{
				System.out.println("testing this");
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
				textArea.append(tree.toString());
				saveData();
			}
		} catch(Exception z){
			z.printStackTrace();
		}
	}
}