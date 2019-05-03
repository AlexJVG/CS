import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.*;
import java.util.*;
public class Screen extends JPanel implements ActionListener {
    Map < Integer, Integer > list1 = new HashMap < > ();
    Map < Integer, Integer > list2 = new HashMap < > ();
    String data = "";
    int sem = 1;
    public Screen() {
        list1.put(0, 0);
        list1.put(1, 0);
        list1.put(2, 0);
        list1.put(3, 0);
        list1.put(4, 0);
        list1.put(5, 0);
        list1.put(6, 0);
        list1.put(7, 0);
        list2.put(0, 0);
        list2.put(1, 0);
        list2.put(2, 0);
        list2.put(3, 0);
        list2.put(4, 0);
        list2.put(5, 0);
        list2.put(6, 0);
        list2.put(7, 0);
        loadFile();
    }
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
    public void paintComponent() {

    }
    public void actionPerformed(ActionEvent e) {

    }
    private void loadFile() {
        try {
            File f = new File("./data.txt");
            if (f.exists()) {
                FileInputStream fis = null;
                ObjectInputStream in = null;
                try {
                    Scanner sc = new Scanner(new File("data.txt"));
                    data = "";
                    BufferedReader br = new BufferedReader(new FileReader("data.txt"));
                    String st = "";
                    while ((st = br.readLine()) != null) {
                        int temp = 0;
                        if (st.toCharArray()[1] == ',') {
                            temp = 9;
                        } else {
                            temp = Integer.parseInt(st.toCharArray()[0] + "" + st.toCharArray()[1]);
                        }
                        System.out.println(list1);
                        System.out.println(list2);
                        if (temp == 9 || temp == 10 || temp == 11 || temp == 12) {
                        	System.out.println("Line: "+st);
                        	sem=1;
                            for (String output2: st.split(",")) {
                            	System.out.println("Sem :"+ sem);
                                if (sem == 2 || sem == 3) {
                                    for (char strout: output2.toCharArray()) {
                                        if (Character.isDigit(strout)) {
                                            if (Integer.parseInt(strout + "") != 9 || Integer.parseInt(strout + "") == 10 || Integer.parseInt(strout + "") == 11 || Integer.parseInt(strout + "") == 12) {
                                            	System.out.println(Integer.parseInt(strout + ""));
                                                list1.put(Integer.parseInt(strout + ""), list1.get(Integer.parseInt(strout + "")) + 1);
                                            }
                                        }
                                    }
                                } else if (sem == 4 || sem == 5) {
                                    for (char strout: output2.toCharArray()) {
                                        if (Character.isDigit(strout)) {
                                            if (Integer.parseInt(strout + "") != 9 || Integer.parseInt(strout + "") == 10 || Integer.parseInt(strout + "") == 11 || Integer.parseInt(strout + "") == 12) {
                                            	System.out.println(Integer.parseInt(strout + ""));
                                                list2.put(Integer.parseInt(strout + ""), list2.get(Integer.parseInt(strout + "")) + 1);
                                            }
                                        }
                                    }
                                }
                                sem++;
                            }
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception z) {
            z.printStackTrace();
        }
    }
}