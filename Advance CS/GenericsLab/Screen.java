import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {
    private static final long serialVersionUID =42L;
    private ArrayList<Pair<Student, Schedule>> masterSchedule;
    private ArrayList<JButton> selectButtonList;
    private JTextField query;
    private JButton queryButton;
    private String queryText;
    private boolean queryEntered;
    private boolean studentSelected;
    private int student;
    private JTextArea scheduleDisplay;
    private JButton backButton;
    private int periodText;
    private String classsText;
    private JTextField period;
    private JTextField classs;
    private JButton addClass;
    private JButton deleteClass;
    public Screen() {
    	studentSelected = false;
    	student = 10;
    	this.setLayout(null);
    	masterSchedule= new ArrayList<Pair<Student, Schedule>>();
    	selectButtonList = new ArrayList<JButton>();
        masterSchedule.add(new Pair<Student,Schedule>(new Student("Alex", "alex.jpg"), new Schedule()));
        masterSchedule.add(new Pair<Student,Schedule>(new Student("Bob", "bob.jpg"), new Schedule()));
        masterSchedule.add(new Pair<Student,Schedule>(new Student("Frank", "frank.jpg"), new Schedule()));
        masterSchedule.get(0).getValue().addClass(2, "Biology");
        masterSchedule.get(0).getValue().addClass(1, "Algebra");
        masterSchedule.get(0).getValue().addClass(3, "Computer Science");
        masterSchedule.get(1).getValue().addClass(1, "Geometry");
        masterSchedule.get(1).getValue().addClass(2, "Chemistry");
        masterSchedule.get(1).getValue().addClass(3, "World History");
        masterSchedule.get(2).getValue().addClass(1, "Algebra 2");
        masterSchedule.get(2).getValue().addClass(2, "Physics");
        masterSchedule.get(2).getValue().addClass(3, "Health");
        query = new JTextField(20);
        query.setBounds(600,0,100,30);
        this.add(query);
        queryButton = new JButton("Select");
        queryButton.setBounds(700,0,100,30);
        queryButton.addActionListener(this);
        this.add(queryButton);
        backButton = new JButton("Back");
        backButton.setBounds(0,0,100,30);
        backButton.addActionListener(this);
        backButton.setVisible(false);
        this.add(backButton);
        scheduleDisplay = new JTextArea(500,500);
        scheduleDisplay.setBounds(350,400,500,500);
        scheduleDisplay.setEditable(false);
        scheduleDisplay.setLineWrap(true);
        scheduleDisplay.setVisible(false);
        this.add(scheduleDisplay);
    	period = new JTextField();
    	period.setBounds(580,0,100,30);
    	period.addActionListener(this);
    	this.add(period);
    	classs = new JTextField();
    	classs.setBounds(580,30,100,30);
    	classs.addActionListener(this);
    	this.add(classs);
    	addClass = new JButton("Add Class");
    	addClass.setBounds(680,0,120,30);
    	addClass.addActionListener(this);
    	this.add(addClass);
    	deleteClass = new JButton("Delete Class");
    	deleteClass.setBounds(680,30,120,30);
    	deleteClass.addActionListener(this);
    	this.add(deleteClass);
        for(int i =0; i<masterSchedule.size();i++){
        	selectButtonList.add(i,new JButton("Select"));
            selectButtonList.get(i).setBounds(150*(i+1)-24,380,100,30);
            selectButtonList.get(i).addActionListener(this);
            this.add(selectButtonList.get(i));
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
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.blue);
        if(studentSelected==true){
        	for(JButton each : selectButtonList){
        		each.setVisible(false);
        	}
        	query.setVisible(false);
    		queryButton.setVisible(false);
    		backButton.setVisible(true);
    		scheduleDisplay.setVisible(true);
    		period.setVisible(true);
    		classs.setVisible(true);
    		addClass.setVisible(true);
    		deleteClass.setVisible(true);
        	if(queryEntered==true){
        		for(int i =0; i<masterSchedule.size()-1;i++){
        			if(masterSchedule.get(i).getKey().toString().equals(queryText)){
        				student=i;
        				break;
        			}
        		}
        	}
        	scheduleDisplay.setText(masterSchedule.get(student).getValue().toString());
        	masterSchedule.get(student).getKey().drawStudent(g,350,300);
        	g.drawString(masterSchedule.get(student).getKey().toString(),350,375);
        }
        else{
        	query.setVisible(true);
    		queryButton.setVisible(true);
    		backButton.setVisible(false);
    		scheduleDisplay.setVisible(false);
    		period.setVisible(false);
    		classs.setVisible(false);
    		addClass.setVisible(false);
    		deleteClass.setVisible(false);
    		for(JButton each : selectButtonList){
        		each.setVisible(true);
        	}
        	for (int i = 0; i < masterSchedule.size(); i++) {
            masterSchedule.get(i).getKey().drawStudent(g, 150 * (i + 1), 300);
            g.drawString(masterSchedule.get(i).getKey().toString(), (150 * (i + 1)), 375);
        }
        }

    }

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==queryButton){
    		queryText=query.getText();
    		studentSelected=true;
    		queryEntered=true;
    	}
    	else if(e.getSource()==backButton){
    		studentSelected=false;
    	}
    	else if(e.getSource()==addClass){
    		periodText=Integer.parseInt(period.getText());
    		classsText=classs.getText();
    		masterSchedule.get(student).getValue().addClass(periodText, classsText);
    	}
    	else if(e.getSource()==deleteClass){
    		if(period.getText().equals("")){
    			classsText=classs.getText();
    			masterSchedule.get(student).getValue().deleteClass(classsText);
    		}
    		else if(classs.getText().equals("")){
    			periodText=Integer.parseInt(period.getText());
    			masterSchedule.get(student).getValue().deleteClass(periodText);
    		}
    		else{
    			periodText=Integer.parseInt(period.getText());
    			classsText=classs.getText();
    			masterSchedule.get(student).getValue().deleteClass(periodText);
    			masterSchedule.get(student).getValue().deleteClass(classsText);
    		}
    	}
    	for(int i =selectButtonList.size()-1;i>=0;i--){
                if(e.getSource()==selectButtonList.get(i)){
                    studentSelected=true;
                    student=i;
                }
            }
            repaint();
    }
}