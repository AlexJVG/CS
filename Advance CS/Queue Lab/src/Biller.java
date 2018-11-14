import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Biller extends JPanel implements ActionListener {
    private Patient current;
    private JLabel currentName;
    private JLabel currentIllness;
    private JTextField enterNote;
    private JButton bill;
    private JLabel thi;
    public Biller(){
        this.setLayout(null);
        if(!Runner.discharged.isEmpty()){
            current = Runner.discharged.peek();
            currentName = new JLabel(current.getName());
            currentName.setBounds(0,0,100,30);
            this.add(currentName);
            currentIllness = new JLabel(current.getIllness());
            currentIllness.setBounds(0,30,100,30);
            this.add(currentIllness);
            enterNote = new JTextField("Amount to Bill");
            enterNote.setBounds(0,60,100,30);
            this.add(enterNote);
            bill = new JButton("Bill Patient");
            bill.setBounds(0,90,100,30);
            bill.addActionListener(this);
            this.add(bill);
            thi = new JLabel("No Patient");
            thi.setBounds(0,0,100,30);
            thi.setVisible(false);
            this.add(thi);
        }else{
            current = new Patient("test","test","test","high",new Date().getTime());
            currentName = new JLabel(current.getName());
            currentName.setBounds(0,0,100,30);
            currentName.setVisible(false);
            this.add(currentName);
            currentIllness = new JLabel(current.getIllness());
            currentIllness.setBounds(0,30,100,30);
            currentIllness.setVisible(false);
            this.add(currentIllness);
            enterNote = new JTextField("Amount to Bill");
            enterNote.setBounds(0,60,100,30);
            enterNote.setVisible(false);
            this.add(enterNote);
            bill = new JButton("Bill Patient");
            bill.setBounds(0,90,100,30);
            bill.addActionListener(this);
            bill.setVisible(false);
            this.add(bill);
            thi = new JLabel("No Patient");
            thi.setBounds(0,0,100,30);
            thi.setVisible(true);
            this.add(thi);
        }
        this.setFocusable(true);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bill&&!enterNote.equals("")||!enterNote.equals("Bill Note")){
            Patient t = Runner.discharged.poll();
            t.updateNote(enterNote.getText());
            Runner.billed.add(new Billed(t.toString(),t.getLastName(),t.getFirstName()));
            Runner.adminView.updateList();
            if(!Runner.discharged.isEmpty()){
                current = Runner.discharged.peek();
                currentName.setText(current.getName());
                currentIllness.setText(current.getIllness());
                enterNote.setText("Enter Note");
                thi.setVisible(false);
                currentName.setVisible(true);
                currentIllness.setVisible(true);
                enterNote.setVisible(true);
                bill.setVisible(true);
            }
            else{
                thi.setVisible(true);
                currentName.setVisible(false);
                currentIllness.setVisible(false);
                enterNote.setVisible(false);
                bill.setVisible(false);
            }
        }
    }
}
