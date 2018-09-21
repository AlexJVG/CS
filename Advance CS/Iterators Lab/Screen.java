import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener{
	private ArrayList<Forum> forumHolder;
	private ArrayList<Pair<String,String>> stringList;
	private Pair<String,String> current;
	private Education eduCurrent;
	private ArrayList<Education> eduList;
	private Forum firstScreen;
	private Forum secondScreen;
	private JTextArea resume;
	private JButton submit;
	private JButton add;
	private int screenNum;
	private ListIterator<Pair<String,String>> it;
	private ListIterator<Education> eduit;
	public Screen(){
		this.setLayout(null);
		screenNum = 0;
		forumHolder = new ArrayList<Forum>();
		stringList = new ArrayList<Pair<String,String>>();
		it = stringList.listIterator();
		eduList = new ArrayList<Education>();
		eduit = eduList.listIterator();
		firstScreen = new Forum();
		secondScreen = new Forum();
		for(int i =0;i<4;i++){
			firstScreen.addElement(new JTextField());
			firstScreen.getElement(i).setBounds(0,0+30*i,100,30);
			firstScreen.getElement(i).addActionListener(this);
			this.add(firstScreen.getElement(i));
		}
		forumHolder.add(firstScreen);
		for(int i =0;i<2;i++){
			secondScreen.addElement(new JTextField());
			secondScreen.getElement(i).setBounds(0,0+30*i,100,30);
			secondScreen.getElement(i).addActionListener(this);
			this.add(secondScreen.getElement(i));
		}
		forumHolder.add(secondScreen);
		resume = new JTextArea();
		resume.setBounds(400,0,400,800);
		resume.setEditable(false);
		resume.setLineWrap(true);
		this.add(resume);
		submit = new JButton("Submit");
		submit.setBounds(0,120,100,30);
		submit.addActionListener(this);
		this.add(submit);
		add = new JButton("Add");
		add.setBounds(0,60,100,30);
		add.addActionListener(this);
		add.setVisible(false);
		this.add(add);
		this.setFocusable(true);

	}
	public Dimension getPreferredSize() {
		return new Dimension(800,800);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.blue);
        resume.setText("");
        it = stringList.listIterator();
        for(int i =0; i<stringList.size();i++){
        	current=it.next();
			resume.append(current.getKey()+": "+current.getValue()+"\n");
			if(!it.hasNext()){
				break;
			}
        }
        eduit = eduList.listIterator();
        for(int i =0; i<eduList.size();i++){
        	eduCurrent=eduit.next();
        	resume.append(eduCurrent.toString());
        	if(!eduit.hasNext()){
        		break;
        	}
        }
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==submit){
			if(screenNum==0){
				it = stringList.listIterator();
				while(it.hasNext()){
					it.next();
					it.remove();
				}
				Pair<String,String> temp;
				if(!forumHolder.get(screenNum).submit(0).trim().equals("")){
					temp = new Pair<String,String>("Name",forumHolder.get(screenNum).submit(0).trim());
					it.add(temp);
				}
				if(!forumHolder.get(screenNum).submit(1).trim().equals("")){
					temp = new Pair<String,String>("Address",forumHolder.get(screenNum).submit(1).trim());
					it.add(temp);
				}
				if(!forumHolder.get(screenNum).submit(2).trim().equals("")){
					temp = new Pair<String,String>("Email",forumHolder.get(screenNum).submit(2).trim());
					it.add(temp);
				}
				if(!forumHolder.get(screenNum).submit(3).trim().equals("")){
					temp = new Pair<String,String>("Objective",forumHolder.get(screenNum).submit(3).trim());
					it.add(temp);
				}
				if((forumHolder.get(screenNum).submit(0).trim().equals("")||forumHolder.get(screenNum).submit(1).trim().equals(""))||(forumHolder.get(screenNum).submit(2).trim().equals(""))||forumHolder.get(screenNum).submit(3).trim().equals("")){
					screenNum=0;
				}
				else{
					for(JTextField each : forumHolder.get(screenNum).getArray()){
						each.setVisible(false);
					}
					submit.setText("Done");
					submit.setBounds(0,90,100,30);
					add.setVisible(true);
					screenNum=1;
				}
			}
			else if(screenNum==1){
				screenNum=2;
			}
		}
		else if(e.getSource()==add){
			if(screenNum==1){
				eduit=eduList.listIterator();
			Education edutemp;
			if(!forumHolder.get(screenNum).submit(0).trim().equals("")&&!forumHolder.get(screenNum).submit(1).trim().equals("")){
				edutemp = new Education(forumHolder.get(screenNum).submit(0).trim(),forumHolder.get(screenNum).submit(1).trim());
				while(eduit.hasNext()){
					if(edutemp.getYear()>=eduit.next().getYear()&&edutemp.getMonth()>=eduit.previous().getMonth()){
						eduit.next();
						eduit.previous();
						break;
					}
				}
				eduit.add(edutemp);
				forumHolder.get(screenNum).getElement(0).setText("");
				forumHolder.get(screenNum).getElement(1).setText("");
			}
			}
		}
		repaint();
	}
}