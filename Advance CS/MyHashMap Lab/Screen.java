import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
public class Screen extends JPanel implements ActionListener{
	private MyHashMap<Country,MyImage> map;
	private FileReader reader;
	private FileWriter writer;
	private File countryFile;
	private JTextField countryEnter;
	private JButton enterThingo;
	private JTextArea countryShow;
	private JScrollPane countryScrollPane;
	private JLabel name;
	private JLabel abbreviation;
	private JButton addImage;
	private Image currentShowImage;
	private int imagePointer;
	private DLList<MyImage> imageShow;
	private JButton changeButtonRight;
	private JButton changeButtonLeft;
	private JTextField urlEnter;
	private JTextField captionEnter;
	private JTextField dateEnter;
	private JLabel caption;
	private JLabel date;
	private JButton removeImage;
	public Screen(){
		this.setLayout(null);
		changeButtonLeft = new JButton("<");
		changeButtonLeft.setBounds(520,240,30,30);
		changeButtonLeft.addActionListener(this);
		changeButtonLeft.setVisible(false);
		this.add(changeButtonLeft);
		changeButtonRight = new JButton(">");
		changeButtonRight.setBounds(750,240,30,30);
		changeButtonRight.addActionListener(this);
		changeButtonRight.setVisible(false);
		this.add(changeButtonRight);
		enterThingo = new JButton("Search");
		enterThingo.setBounds(200,0,200,30);
		enterThingo.addActionListener(this);
		this.add(enterThingo);
		countryEnter = new JTextField();
		countryEnter.setBounds(0,0,200,30);
		this.add(countryEnter);
		countryShow = new JTextArea();
		countryShow.setBounds(0,30,400,770);
		this.add(countryShow);
		countryScrollPane = new JScrollPane(countryShow);
		countryScrollPane.setBounds(0,30,400,770);
		this.add(countryScrollPane);
		name = new JLabel();
		name.setBounds(550,30,200,30);
		this.add(name);
		abbreviation = new JLabel();
		abbreviation.setBounds(550,60,200,30);
		this.add(abbreviation);
		urlEnter = new JTextField("URL");
		urlEnter.setBounds(550,90,200,30);
		urlEnter.setVisible(false);
		this.add(urlEnter);
		captionEnter = new JTextField("Caption");
		captionEnter.setBounds(550,120,200,30);
		captionEnter.setVisible(false);
		this.add(captionEnter);
		dateEnter = new JTextField("Date");
		dateEnter.setBounds(550,150,200,30);
		dateEnter.setVisible(false);
		this.add(dateEnter);
		addImage = new JButton("Add Image");
		addImage.setBounds(550,180,200,30);
		addImage.addActionListener(this);
		addImage.setVisible(false);
		this.add(addImage);
		caption = new JLabel();
		caption.setBounds(600,300,200,30);
		this.add(caption);
		date = new JLabel();
		date.setBounds(600,330,200,30);
		this.add(date);
		removeImage = new JButton("Remove Image");
		removeImage.setBounds(600,360,200,30);
		removeImage.addActionListener(this);
		removeImage.setVisible(false);
		this.add(removeImage);
		imagePointer =0;
		imageShow = new DLList<MyImage>();
		map = new MyHashMap<>();
		loadData();
		countryShow.setText("");
		String text = "";
		for(int i =0;i<map.getKeys().size();i++){
			text+=map.getKeys().get(i).abv()+", "+map.getKeys().get(i).toString()+" - "+map.getKeys().get(i).numImg()+"\n";
		}
		countryShow.append(text);
		this.setVisible(true);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imageShow.size()>0&&!imageShow.get(imagePointer).url().equals("")){
			try{
				caption.setText(imageShow.get(imagePointer).caption());
				date.setText(imageShow.get(imagePointer).date());
				URL url = new URL(imageShow.get(imagePointer).url());
				currentShowImage = ImageIO.read(url).getScaledInstance(200, 68, Image.SCALE_DEFAULT);
				g.drawImage(currentShowImage,550,240,null);
			}catch(Exception x){
				x.printStackTrace();
			}
		}
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==enterThingo){
			urlEnter.setVisible(true);
			captionEnter.setVisible(true);
			dateEnter.setVisible(true);
			addImage.setVisible(true);
			removeImage.setVisible(true);
			changeButtonLeft.setVisible(true);
			changeButtonRight.setVisible(true);
			Country country = new Country(countryEnter.getText(),"",0);
			for(int i =0;i<map.getKeys().size();i++){
				if(map.getKeys().get(i).hashCode()==country.hashCode()){
					country = map.getKeys().get(i);
					name.setText(country.toString());
					abbreviation.setText(countryEnter.getText());
					imagePointer=0;
					imageShow = map.get(country);
					break;
				}
			}
		}
		if(e.getSource()==addImage){
			Country country = new Country(countryEnter.getText(),"",0);
			map.put(country,new MyImage(urlEnter.getText(),captionEnter.getText(),dateEnter.getText()));
			captionEnter.setText("Caption");
			urlEnter.setText("URL");
			dateEnter.setText("Date");
			imageShow = map.get(country);
			saveData();
		}
		if(e.getSource()==removeImage){
			map.remove(new Country(countryEnter.getText(),"",0),imageShow.get(imagePointer));
			saveData();
		}
		if(e.getSource()==changeButtonRight){
			if(imagePointer<imageShow.size()){
				imagePointer++;
			}
		}
		if(e.getSource()==changeButtonLeft){
			if(imagePointer>0){
				imagePointer--;
			}
		}
		countryShow.setText("");
		String text = "";
		for(int i =0;i<map.getKeys().size();i++){
			text+=map.getKeys().get(i).abv()+", "+map.getKeys().get(i).toString()+" - "+map.getKeys().get(i).numImg()+"\n";
		}
		countryShow.append(text);
		repaint();
	}

	private void saveData(){
		FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
        	PrintWriter writer = new PrintWriter("./save.txt");
			writer.close();
            fos = new FileOutputStream("./save.txt");
            out = new ObjectOutputStream(fos);
            out.writeObject(map);
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
		            map = (MyHashMap) in.readObject();
		            in.close();
		            fis.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}else{
				countryFile = new File("./countries.txt");
				try{
					reader = new FileReader(countryFile);
					BufferedReader br = new BufferedReader(reader);
					String line;
					while ((line = br.readLine()) != null) {
					    map.put(new Country(line.substring(0,line.indexOf(',')),line.substring(line.indexOf(',')+1,line.length()),0),new MyImage("","",""));
					}
				} catch(Exception e){
					e.printStackTrace();
				}
				Country country = new Country("ac","",3);
				map.put(country,new MyImage("http://rms-st-helena.com/manage/wp-content/uploads/bfi_thumb/rms-header-img-14-mpr2rvbng71r4eeps09xoh86d622z980wnj6mc4fns.jpg","testing the add","2002/11/24"));
				map.put(country,new MyImage("https://ichef.bbci.co.uk/news/660/cpsprodpb/E0E1/production/_89296575_landscape.jpg","testing the add","2002/11/24"));
				map.put(country,new MyImage("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Ascension_Island_Comfortless_Cove.jpg/220px-Ascension_Island_Comfortless_Cove.jpg","testing the add","2002/11/24"));
				country = new Country("ad","",3);
				map.put(country,new MyImage("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Andorra_la_Vella_-_footpath.jpg/300px-Andorra_la_Vella_-_footpath.jpg","testing the add","2002/11/24"));
				map.put(country,new MyImage("https://d3hne3c382ip58.cloudfront.net/files/uploads/bookmundi/resized/countrybanner/travelling-in-andorra-tours-and-vacation-packages-1503897331-1920X700.jpg","testing the add","2002/11/24"));
				map.put(country,new MyImage("https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Andorra_la_Vella_3.JPG/1200px-Andorra_la_Vella_3.JPG","testing the add","2002/11/24"));
				country = new Country("ae","",3);
				map.put(country,new MyImage("https://www.slh.com/globalassets/country-pages/hero-images/united_arab_emirates.jpg","testing the add","2002/11/24"));
				map.put(country,new MyImage("https://www.flydubai.com/en/media/UAE_Hero_tcm8-33300_w600.jpg","testing the add","2002/11/24"));
				map.put(country,new MyImage("https://www.redsavannah.com/-/media/countries/uae/primary-dubai-united-arab-emirates-shstck.jpg","testing the add","2002/11/24"));
				saveData();
			}
		} catch(Exception z){
			z.printStackTrace();
		}
	}
}