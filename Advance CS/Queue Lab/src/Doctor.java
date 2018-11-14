import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctor extends JPanel implements ActionListener {
    private Patient current;
    private JLabel currentName;
    private JLabel currentIllness;
    private JTextField enterNote;
    private JButton discharge;
    private JLabel thi;
    public Doctor(){
        this.setLayout(null);
        current = Runner.notTreated.peek();
        currentName = new JLabel(current.getName());
        currentName.setBounds(0,0,100,30);
        this.add(currentName);
        currentIllness = new JLabel(current.getIllness());
        currentIllness.setBounds(0,30,100,30);
        this.add(currentIllness);
        enterNote = new JTextField("Enter Note");
        enterNote.setBounds(0,60,100,30);
        this.add(enterNote);
        discharge = new JButton("Discharge Patient");
        discharge.setBounds(0,90,100,30);
        discharge.addActionListener(this);
        this.add(discharge);
        thi = new JLabel("No Patient");
        thi.setBounds(0,0,100,30);
        thi.setVisible(false);
        this.add(thi);
        this.setFocusable(true);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==discharge&&!enterNote.equals("")||!enterNote.equals("Enter Note")){
            Patient t = Runner.notTreated.poll();
            t.updateNote(enterNote.getText());
            Runner.discharged.add(t);
            if(!Runner.notTreated.isEmpty()){
                current = Runner.notTreated.peek();
                currentName.setText(current.getName());
                currentIllness.setText(current.getIllness());
                enterNote.setText("Enter Note");
                thi.setVisible(false);
                currentName.setVisible(true);
                currentIllness.setVisible(true);
                enterNote.setVisible(true);
                discharge.setVisible(true);
            }
            else{
                thi.setVisible(true);
                currentName.setVisible(false);
                currentIllness.setVisible(false);
                enterNote.setVisible(false);
                discharge.setVisible(false);
            }
        }
    }
}
