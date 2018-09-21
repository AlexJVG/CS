import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args){
        JFrame frame = new JFrame("Screen");

        Screen sc = new Screen();
        frame.add(sc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class Screen extends JPanel implements ActionListener {
    private JButton ball;
    private JButton bteachers;
    private JButton bpolice;
    private JButton bbankers;
    private JButton bengineers;
    private JButton bsearch;
    private JTextField namesearch;
    private String query;
    private ArrayList<Employee> database = new ArrayList<Employee>();
    private ArrayList<JButton> buttonlist = new ArrayList<JButton>();
    private int show;
    public Screen() {
        database.add(new Government("Alex","alex.jpg","Teacher",11.46,"Palo Alto"));
        database.add(new Government("Natalie","natalie.png","Teacher",10.57,"San Francisco"));
        database.add(new Government("Clara","clara.jpeg","Police",28.19,"Los Altos"));
        database.add(new Government("Frank","frank.jpg","Police",20.38,"Mountain View"));
        database.add(new Company("Joe","joe.jpg","Banker",60.29,"Citi Bank"));
        database.add(new Company("Bob","bob.jpg","Banker",50.81,"Chase"));
        database.add(new Company("Gilda","gilda.png","Engineer",200.84,"Intel"));
        database.add(new Company("Luis","luis.jpg","Engineer",200.76,"Synopsys"));
        show=0;
        query="testthings";
        this.setLayout(null);
        bteachers = new JButton("Teachers");
        bteachers.setBounds(500,450, 200, 30); 
        bteachers.addActionListener(this);
        this.add(bteachers);
        bpolice = new JButton("Police");
        bpolice.setBounds(500,550, 200, 30); 
        bpolice.addActionListener(this);
        this.add(bpolice);
        bbankers = new JButton("Bankers");
        bbankers.setBounds(500,500, 200, 30); 
        bbankers.addActionListener(this);
        this.add(bbankers);
        bengineers = new JButton("Engineers");
        bengineers.setBounds(500,600, 200, 30); 
        bengineers.addActionListener(this);
        this.add(bengineers);
        ball = new JButton("All");
        ball.setBounds(500,400, 200, 30); 
        ball.addActionListener(this);
        this.add(ball);
        bsearch=new  JButton("Search");
        bsearch.setBounds(500,250,200,30);
        bsearch.addActionListener(this);
        this.add(bsearch);
        namesearch = new JTextField(20);
        namesearch.setBounds(500,200,200,30);
        this.add(namesearch);
        for(int i =0; i < database.size();i++){
            buttonlist.add(i,new JButton("Delete"));
            buttonlist.get(i).setBounds(75,100*i,200,20);
            buttonlist.get(i).addActionListener(this);
            this.add(buttonlist.get(i));
        }
        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0,0,800,800);
        Font font = new Font("Arial", Font.PLAIN, 10);
        g.setFont(font);
        g.setColor(Color.blue);
        for(int i =0; i < database.size(); i++){
            Employee temp = database.get(i);
            String tempjob = temp.getJob();
            String tempname = temp.getName();
            if(show==0){
            temp.drawPhoto(g,0,100*i);
            g.drawString(temp.toString(),75,100*i+40);
            buttonlist.get(i).setVisible(true);
            }
            else if(show ==1&& tempjob.equals("Teacher")){
                temp.drawPhoto(g,0,100*i);
                g.drawString(temp.toString(),75,100*i+40);
                buttonlist.get(i).setVisible(true);
            }
            else if(show ==2&& tempjob.equals("Police")){
                temp.drawPhoto(g,0,100*i);
                g.drawString(temp.toString(),75,100*i+40);
                buttonlist.get(i).setVisible(true);
            }
            else if(show ==3&& tempjob.equals("Banker")){
                temp.drawPhoto(g,0,100*i);
                g.drawString(temp.toString(),75,100*i+40);
                buttonlist.get(i).setVisible(true);
            }
            else if(show ==4&& tempjob.equals("Engineer")){
                temp.drawPhoto(g,0,100*i);
                g.drawString(temp.toString(),75,100*i+40);
                buttonlist.get(i).setVisible(true);
            }
            else if(show ==5&&tempname.equals(query)){
                temp.drawPhoto(g,0,100*i);
                g.drawString(temp.toString(),75,100*i+40);
                buttonlist.get(i).setVisible(true);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bteachers) {
            show=1;
            for(JButton each: buttonlist){
            each.setVisible(false);
        }
        }
        else if(e.getSource() == bpolice){
            show=2;
            for(JButton each: buttonlist){
            each.setVisible(false);
        }
        }
        else if(e.getSource() == bbankers){
            show=3;
            for(JButton each: buttonlist){
            each.setVisible(false);
        }
        }
        else if(e.getSource() == bengineers){
            show=4;
            for(JButton each: buttonlist){
            each.setVisible(false);
        }
        }
        else if(e.getSource() == ball){
            show=0;
            for(JButton each: buttonlist){
            each.setVisible(false);
        }
        }   
        else if(e.getSource() == bsearch){
            show=5;
            query = namesearch.getText();
            for(JButton each: buttonlist){
            each.setVisible(false);
        }
        }
        else{
            for(int i =buttonlist.size()-1;i>=0;i--){
                if(e.getSource()==buttonlist.get(i)){
                    super.remove(buttonlist.get(buttonlist.size()-1));
                    buttonlist.remove(buttonlist.size()-1);
                    database.remove(i);
                    show=0;
                    break;
                }
            }
        }
        repaint();
    }

}

abstract class Employee {
    private String name;
    private String photoFile;
    private String jobTitle;
    private double salary;
    private BufferedImage photoBuffer;
    public Employee(String name,String photoFile, String jobTitle,double salary){
        this.name = name;
        this.photoFile = photoFile;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }
    public void drawPhoto(Graphics g, int x, int y){
        try{
        photoBuffer = ImageIO.read(new File(photoFile));
    } catch(IOException e){
            e.printStackTrace();
        }
        g.drawImage(photoBuffer,x,y,null);
    }
    public String getJob(){
        return jobTitle;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "Name:"+name+", Job:"+ jobTitle+", Salary:"+ getSalary();
    }
}

class Government extends Employee{
    private String cityName;
    public Government(String jobTitle, String photoFile, String name, double salary,String cityName){
        super(jobTitle,photoFile,name,salary);
        this.cityName = cityName;
    }
    public String toString(){
        return super.toString() + ", City Name:"+cityName;
    }
}

class Company extends Employee{
    private String companyName;
    public Company(String jobTitle, String photoFile, String name, double salary,String companyName){
        super(jobTitle,photoFile,name,salary);
        this.companyName = companyName;
    }
    public String toString(){
        return super.toString() + ", Company Name:"+companyName;
    }
}