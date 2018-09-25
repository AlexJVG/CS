import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class Screen extends JPanel implements ActionListener {
    private ArrayList < Forum > forumHolder;
    private ArrayList < Pair < String, String >> stringList;
    private Pair < String, String > current;
    private Education eduCurrent;
    private Job jobCurrent;
    private ArrayList < Education > eduList;
    private ArrayList < Job > jobList;
    private Forum firstScreen;
    private Forum secondScreen;
    private Forum thirdScreen;
    private JTextArea resume;
    private JButton submit;
    private JButton add;
    private int screenNum;
    private ListIterator < Pair < String, String >> it;
    private ListIterator < Education > eduit;
    private ListIterator < Job > jobit;
    private Writer data;
    private String loadtext;
    private int lines;
    private BufferedReader reader;
    private JButton readtext;
    private boolean read;
    public Screen() {
        this.setLayout(null);
        data = new Writer("resume.txt");
        screenNum = 0;
        forumHolder = new ArrayList < Forum > ();
        stringList = new ArrayList < Pair < String, String >> ();
        it = stringList.listIterator();
        eduList = new ArrayList < Education > ();
        eduit = eduList.listIterator();
        jobList = new ArrayList < Job > ();
        jobit = jobList.listIterator();
        firstScreen = new Forum();
        secondScreen = new Forum();
        thirdScreen = new Forum();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    firstScreen.addElement(new JTextField("Johnny Appleseed"));
                    break;
                case 1:
                    firstScreen.addElement(new JTextField("1234 CompSci Ave"));
                    break;
                case 2:
                    firstScreen.addElement(new JTextField("johnnyappleseed@gmail.com"));
                    break;
                case 3:
                    firstScreen.addElement(new JTextField("Pick some apples"));
                    break;
            }
            firstScreen.getElement(i).setBounds(0, 30 + 60 * i, 194, 30);
            firstScreen.getElement(i).addActionListener(this);
            this.add(firstScreen.getElement(i));
        }
        forumHolder.add(firstScreen);
        for (int i = 0; i < 2; i++) {
             switch (i) {
                case 0:
                    secondScreen.addElement(new JTextField("Mountain View High School"));
                    break;
                case 1:
                    secondScreen.addElement(new JTextField("XXXX-XX"));
                    break;
            }
            secondScreen.getElement(i).setBounds(0, 30 + 60 * i, 194, 30);
            secondScreen.getElement(i).addActionListener(this);
            secondScreen.getElement(i).setVisible(false);
            this.add(secondScreen.getElement(i));
        }
        forumHolder.add(secondScreen);
        for (int i = 0; i < 5; i++) {
            switch(i){
                case 0:
                thirdScreen.addElement(new JTextField("Job Title"));
                break;
                case 1:
                thirdScreen.addElement(new JTextField("Company Name"));
                break;
                case 2:
                thirdScreen.addElement(new JTextField("Start Date"));
                break;
                case 3:
                thirdScreen.addElement(new JTextField("End Date"));
                break;
                case 4:
                thirdScreen.addElement(new JTextField("Job Function"));
                break;
            }
            thirdScreen.getElement(i).setBounds(0, 30 + 60 * i, 194, 30);
            thirdScreen.getElement(i).addActionListener(this);
            thirdScreen.getElement(i).setVisible(false);
            this.add(thirdScreen.getElement(i));
        }
        forumHolder.add(thirdScreen);
        resume = new JTextArea();
        resume.setBounds(400, 0, 400, 800);
        resume.setEditable(false);
        resume.setLineWrap(true);
        this.add(resume);
        readtext = new JButton("Load Text");
        readtext.setBounds(0,270,100,30);
        readtext.addActionListener(this);
        this.add(readtext);
        submit = new JButton("Submit");
        submit.setBounds(0, 240, 100, 30);
        submit.addActionListener(this);
        this.add(submit);
        add = new JButton("Add");
        add.setBounds(0, 120, 100, 30);
        add.addActionListener(this);
        add.setVisible(false);
        this.add(add);
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
        switch(screenNum){
            case 0:
            g.drawString("Name", 22, 22);
            g.drawString("Address", 12, 82);
            g.drawString("Email", 20, 142);
            g.drawString("Objective", 7, 202);
            break;
            case 1:
            g.drawString("School Name", 22, 22);
            g.drawString("Graduation Date", 12, 82);
            break;
            case 2:
            g.drawString("Job Title", 22, 22);
            g.drawString("Company Name", 12, 82);
            g.drawString("Start Date", 25, 142);
            g.drawString("End Date", 7, 202);
            g.drawString("Job Function", 7, 262);

        }
        if(read){
        }
        else{
            resume.setText("");
            it = stringList.listIterator();
            resume.append("\t                    Profile\n-------------------------------------------------\n");
        for (int i = 0; i < stringList.size(); i++) {
            current = it.next();
            resume.append(current.getKey() + ": " + current.getValue() + "\n\n");
            if (!it.hasNext()) {
                break;
            }
        }
        eduit = eduList.listIterator();
        resume.append("\t                  Education\n-------------------------------------------------\n");
        for (int i = 0; i < eduList.size(); i++) {
            eduCurrent = eduit.next();
            resume.append(eduCurrent.toString());
            if (!eduit.hasNext()) {
                break;
            }
        }
        jobit = jobList.listIterator();
        resume.append("\t            Work Experience\n-------------------------------------------------\n");
        for (int i = 0; i < jobList.size(); i++) {
            jobCurrent = jobit.next();
            resume.append(jobCurrent.toString());
            if (!jobit.hasNext()) {
                break;
            }
        }
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (screenNum == 0) {
                read = false;
                it = stringList.listIterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                }
                Pair < String, String > temp;
                if (!forumHolder.get(screenNum).submit(0).trim().equals("")) {
                    temp = new Pair < String, String > ("Name", forumHolder.get(screenNum).submit(0).trim());
                    it.add(temp);
                }
                if (!forumHolder.get(screenNum).submit(1).trim().equals("")) {
                    temp = new Pair < String, String > ("Address", forumHolder.get(screenNum).submit(1).trim());
                    it.add(temp);
                }
                if (!forumHolder.get(screenNum).submit(2).trim().equals("")) {
                    temp = new Pair < String, String > ("Email", forumHolder.get(screenNum).submit(2).trim());
                    it.add(temp);
                }
                if (!forumHolder.get(screenNum).submit(3).trim().equals("")) {
                    temp = new Pair < String, String > ("Objective", forumHolder.get(screenNum).submit(3).trim());
                    it.add(temp);
                }
                if ((forumHolder.get(screenNum).submit(0).trim().equals("") || forumHolder.get(screenNum).submit(1).trim().equals("")) || (forumHolder.get(screenNum).submit(2).trim().equals("")) || forumHolder.get(screenNum).submit(3).trim().equals("")) {
                    screenNum = 0;
                } else {
                    for (JTextField each: forumHolder.get(screenNum).getArray()) {
                        each.setVisible(false);
                    }
                    for (JTextField each: forumHolder.get(screenNum + 1).getArray()) {
                        each.setVisible(true);
                    }
                    submit.setText("Done");
                    submit.setBounds(0, 150, 100, 30);
                    add.setVisible(true);
                    readtext.setVisible(false);
                    screenNum++;
                }
            } else if (screenNum == 1) {
                for (JTextField each: forumHolder.get(screenNum).getArray()) {
                    each.setVisible(false);
                }
                for (JTextField each: forumHolder.get(screenNum + 1).getArray()) {
                    each.setVisible(true);
                }
                add.setBounds(0, 300, 100, 30);
                submit.setBounds(0, 330, 100, 30);
                screenNum++;
            } else if (screenNum == 2) {
                for (JTextField each: forumHolder.get(screenNum).getArray()) {
                    each.setVisible(false);
                }
                add.setVisible(false);
                submit.setText("Save Text");
                screenNum++;
            } else if (screenNum == 3) {
                try {
                    data.writeToFile(resume.getText());
                } catch (IOException g) {
                    g.printStackTrace();
                }
            }
        } else if (e.getSource() == add) {
            if (screenNum == 1) {
                eduit = eduList.listIterator();
                Education edutemp;
                if (!forumHolder.get(screenNum).submit(0).trim().equals("") && !forumHolder.get(screenNum).submit(1).trim().equals("")) {
                    edutemp = new Education(forumHolder.get(screenNum).submit(0).trim(), forumHolder.get(screenNum).submit(1).trim());
                    while (eduit.hasNext()) {
                        if (edutemp.getYear() >= eduit.next().getYear() && edutemp.getMonth() >= eduit.previous().getMonth()) {
                            eduit.next();
                            eduit.previous();
                            break;
                        }
                    }
                    eduit.add(edutemp);
                    forumHolder.get(screenNum).getElement(0).setText("");
                    forumHolder.get(screenNum).getElement(1).setText("");
                }
            } else if (screenNum == 2) {
                jobit = jobList.listIterator();
                Job jobtemp;
                if (((!forumHolder.get(screenNum).submit(0).trim().equals("") && !forumHolder.get(screenNum).submit(1).trim().equals("")) && (!forumHolder.get(screenNum).submit(2).trim().equals("") && !forumHolder.get(screenNum).submit(3).trim().equals(""))) && !forumHolder.get(screenNum).submit(4).trim().equals("")) {
                    jobtemp = new Job(forumHolder.get(screenNum).submit(0).trim(), forumHolder.get(screenNum).submit(1).trim(), forumHolder.get(screenNum).submit(2).trim(), forumHolder.get(screenNum).submit(3).trim(), forumHolder.get(screenNum).submit(4).trim());
                    while (jobit.hasNext()) {
                        if (jobtemp.getYear() >= jobit.next().getYear() && jobtemp.getMonth() >= jobit.previous().getMonth()) {
                            jobit.next();
                            jobit.previous();
                            break;
                        }
                    }
                    jobit.add(jobtemp);
                    forumHolder.get(screenNum).getElement(0).setText("");
                    forumHolder.get(screenNum).getElement(1).setText("");
                    forumHolder.get(screenNum).getElement(2).setText("");
                    forumHolder.get(screenNum).getElement(3).setText("");
                    forumHolder.get(screenNum).getElement(4).setText("");
                }
            }
        }
        else if(e.getSource() == readtext){
            try {
            read = true;
            readtext.setVisible(false);
            submit.setText("Save Text");
            for (JTextField each: forumHolder.get(screenNum).getArray()) {
                        each.setVisible(false);
                    }

            screenNum=3;
            loadtext = "";
            lines = 0;
            reader = new BufferedReader(new FileReader("resume.txt"));
            while (reader.readLine() != null) {
                lines++;
            }
            reader = new BufferedReader(new FileReader("resume.txt"));
            for (int i = 0; i < lines; i++) {
                loadtext += reader.readLine()+"\n";
            }
            resume.setText(loadtext);
            reader.close();
        } catch (IOException h) {
            h.printStackTrace();
        }
        }
        repaint();
    }
}