import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
public class Screen extends JPanel implements ActionListener{
	private static final long serialVersionUID = -615407811213953435L;
	private ArrayList<Student> database;
	private ListIterator<Student> it;
	private JTextArea studentList;
	private JScrollPane scroll;
	private BufferedReader reader;
	private String temptext;
	private int lines;
	private int num;
	private JButton binaryButton;
	private JButton sequentialButton;
	private JButton scrambleButton;
	private JButton bubbleButton;
	private JButton mergeButton;
	private Search searchEngine;
	private JTextField searchBar;
	private JLabel searchLabel;
	private JLabel recurRes;
	private JLabel locRes;
	public Screen(){
		this.setLayout(null);
		database = new ArrayList<Student>();
		searchEngine = new Search();
		lines =0;
		num=1;
		try{
			reader = new BufferedReader(new FileReader("names.txt"));
			while(reader.readLine()!=null){
				lines++;
			}
			reader = new BufferedReader(new FileReader("names.txt"));
			for(int i = 0; i<lines;i++){
				temptext = reader.readLine();
				it = database.listIterator();
				while(it.hasNext()){
					if(temptext.substring(temptext.indexOf(' ')+1).compareTo(it.next().getLastName())<0){
						it.previous();
						break;
					}
				}
				it.add(new Student(temptext.substring(0,temptext.indexOf(' ')),temptext.substring(temptext.indexOf(' ')+1),(int)(Math.random() * ((18 - 14) + 1)) + 14));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		recurRes=new JLabel("");
		recurRes.setBounds(200,0,200,30);
		this.add(recurRes);
		locRes=new JLabel("");
		locRes.setBounds(200,30,200,30);
		this.add(locRes);
		searchLabel=new JLabel("Search");
		searchLabel.setBounds(80,0,200,30);
		this.add(searchLabel);
		searchBar=new JTextField();
		searchBar.setBounds(0,30,200,30);
		this.add(searchBar);
		binaryButton=new JButton("Binary Search");
		binaryButton.setBounds(0,60,200,30);
		binaryButton.addActionListener(this);
		this.add(binaryButton);
		sequentialButton=new JButton("Sequential Search");
		sequentialButton.setBounds(0,90,200,30);
		sequentialButton.addActionListener(this);
		this.add(sequentialButton);
		scrambleButton=new JButton("Scramble List");
		scrambleButton.setBounds(0,120,200,30);
		scrambleButton.addActionListener(this);
		this.add(scrambleButton);
		bubbleButton=new JButton("Bubble Sort");
		bubbleButton.setBounds(0,150,200,30);
		bubbleButton.addActionListener(this);
		this.add(bubbleButton);
		mergeButton=new JButton("Merge Sort");
		mergeButton.setBounds(0,180,200,30);
		mergeButton.addActionListener(this);
		this.add(mergeButton);;
		studentList = new JTextArea();
		studentList.setEditable(false);
		studentList.setLineWrap(true);
		scroll = new JScrollPane(studentList);
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	scroll.setBounds(400,0,400,800);
    	this.add(scroll);
    	it = database.listIterator();
        while(it.hasNext()){
        	studentList.append(num+". "+it.next().toString()+"\n");
        	num++;
        }
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
    }
    public void actionPerformed(ActionEvent e) {
    	if(!searchBar.getText().equals("")){
    		if(e.getSource()==binaryButton){
    			String tempt =searchBar.getText();
    			int temp = searchEngine.binarySearch(database,0,database.size()-1,tempt);
				locRes.setText("Location:"+Integer.toString(temp));
				recurRes.setText("Recursions: "+Integer.toString(searchEngine.getRecursions()));
				searchEngine.setRecursions();
			}
			if(e.getSource()==sequentialButton){
				String tempt =searchBar.getText();
    			int temp = searchEngine.sequentialSearch(database,tempt);
    			locRes.setText("Location:"+Integer.toString(temp));
				recurRes.setText("Recursions: "+Integer.toString(searchEngine.getRecursions()));
				searchEngine.setRecursions();
			}
    	}
    	if(e.getSource()==scrambleButton) {
			database = searchEngine.scramble(database);
			
		}
    	if(e.getSource()==bubbleButton) {
    		database = searchEngine.bubbleSort(database,database.size());
    		recurRes.setText("Number of Passes: "+Integer.toString(searchEngine.getRecursions()));
			searchEngine.setRecursions();
    	}
    	if(e.getSource()==mergeButton) {
    		database = searchEngine.mergeSort(database, 0, database.size()-1);
    		recurRes.setText("Number of Passes: "+Integer.toString(searchEngine.getRecursions()));
			searchEngine.setRecursions();
    	}
    	studentList.setText("");
        num=1;
        it = database.listIterator();
        while(it.hasNext()){
        	studentList.append(num+". "+it.next().toString()+"\n");
        	num++;
        }
    }
}