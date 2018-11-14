import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.PriorityQueue;

public class Nurse extends JPanel implements ActionListener {
    private JButton viewAll;
    private JTextArea showPane;
    private JButton addPatient;
    private JTextField lastName;
    private JTextField firstName;
    private JTextField illness;
    private JTextField priority;
    private JButton add;
    private JButton searchPatient;
    private JTextField lastNameSearch;
    private JTextField firstNameSearch;
    private JButton search;
    private JTextField updateIllness;
    private JTextField updatePriority;
    private Patient updatePatient;
    private JButton update;
    private boolean thingo;
    private PriorityQueue<Patient> temp;
    public Nurse(){
        this.setLayout(null);
        temp = new PriorityQueue<>();
        viewAll = new JButton("View All");
        viewAll.setBounds(0,0,100,30);
        viewAll.addActionListener(this);
        this.add(viewAll);
        showPane = new JTextArea();
        showPane.setBounds(400,0,400,800);
        showPane.setVisible(false);
        this.add(showPane);

        addPatient = new JButton("Add Patient");
        addPatient.setBounds(0,30,100,30);
        addPatient.addActionListener(this);
        this.add(addPatient);
        lastName = new JTextField("Last Name");
        lastName.setBounds(400,0,100,30);
        lastName.setVisible(false);
        this.add(lastName);
        firstName = new JTextField("First Name");
        firstName.setBounds(400,30,100,30);
        firstName.setVisible(false);
        this.add(firstName);
        illness = new JTextField("Illness");
        illness.setBounds(400,60,100,30);
        illness.setVisible(false);
        this.add(illness);
        priority = new JTextField("Priority");
        priority.setBounds(400,90,100,30);
        priority.setVisible(false);
        this.add(priority);
        add = new JButton("Add");
        add.setBounds(400,120,100,30);
        add.setVisible(false);
        add.addActionListener(this);
        this.add(add);

        searchPatient = new JButton("Search Patient");
        searchPatient.setBounds(0,60,100,30);
        searchPatient.addActionListener(this);
        this.add(searchPatient);
        lastNameSearch = new JTextField("Last Name");
        lastNameSearch.setBounds(400,0,100,30);
        this.add(lastNameSearch);
        firstNameSearch = new JTextField("First Name");
        firstNameSearch.setBounds(400,30,100,30);
        this.add(firstNameSearch);
        search = new JButton("Search");
        search.setBounds(400,60,100,30);
        search.addActionListener(this);
        this.add(search);

        updateIllness = new JTextField("Update Illness");
        updateIllness.setBounds(400,0,100,30);
        this.add(updateIllness);
        updatePriority = new JTextField("Update Priority");
        updatePriority.setBounds(400,30,100,30);
        this.add(updatePriority);
        update = new JButton("Update");
        update.setBounds(400,60,100,30);
        update.addActionListener(this);
        this.add(update);

        Runner.notTreated.add(new Patient("Kosh","Lia","Depression","High",new Date().getTime()));
        Runner.notTreated.add(new Patient("Villablanca","Alex","Genius","Low",new Date().getTime()));
        Runner.notTreated.add(new Patient("Maguire","Caprice","Hypertension of the Knee","Medium",new Date().getTime()));
        Runner.notTreated.add(new Patient("Shaffer","Alysha","Poisoning by Dihydrogen Monoxide","Low",new Date().getTime()));
        Runner.notTreated.add(new Patient("Corrigan","Morwenna","Anime Addiction","High",new Date().getTime()));

        this.setFocusable(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewAll){
            showPane.setVisible(true);
            lastName.setVisible(false);
            firstName.setVisible(false);
            illness.setVisible(false);
            priority.setVisible(false);
            add.setVisible(false);
            firstNameSearch.setVisible(false);
            lastNameSearch.setVisible(false);
            search.setVisible(false);
            updateIllness.setVisible(false);
            updatePriority.setVisible(false);
            update.setVisible(false);

            showPane.setText("");
            while(!Runner.notTreated.isEmpty()){
                Patient t = Runner.notTreated.poll();
                temp.add(t);
                showPane.append(t.toString()+"\n\n");
            }
            while(!temp.isEmpty()){
                Runner.notTreated.add(temp.poll());
            }
        }else if(e.getSource()==addPatient){
            showPane.setVisible(false);
            lastName.setVisible(true);
            firstName.setVisible(true);
            illness.setVisible(true);
            priority.setVisible(true);
            add.setVisible(true);
            firstNameSearch.setVisible(false);
            lastNameSearch.setVisible(false);
            search.setVisible(false);
            updateIllness.setVisible(false);
            updatePriority.setVisible(false);
            update.setVisible(false);
        }else if(e.getSource()==add){
            showPane.setVisible(false);
            lastName.setVisible(false);
            firstName.setVisible(false);
            illness.setVisible(false);
            priority.setVisible(false);
            add.setVisible(false);
            firstNameSearch.setVisible(false);
            lastNameSearch.setVisible(false);
            search.setVisible(false);
            updateIllness.setVisible(false);
            updatePriority.setVisible(false);
            update.setVisible(false);
            Runner.notTreated.add(new Patient(lastName.getText(),firstName.getText(),illness.getText(),priority.getText(),new Date().getTime()));
        }else if(e.getSource()==searchPatient){
            showPane.setVisible(false);
            lastName.setVisible(false);
            firstName.setVisible(false);
            illness.setVisible(false);
            priority.setVisible(false);
            add.setVisible(false);
            firstNameSearch.setVisible(true);
            lastNameSearch.setVisible(true);
            search.setVisible(true);
            updateIllness.setVisible(false);
            updatePriority.setVisible(false);
            update.setVisible(false);
        }
        else if(e.getSource()==search){
            showPane.setVisible(false);
            lastName.setVisible(false);
            firstName.setVisible(false);
            illness.setVisible(false);
            priority.setVisible(false);
            add.setVisible(false);
            firstNameSearch.setVisible(false);
            lastNameSearch.setVisible(false);
            search.setVisible(false);
            updateIllness.setVisible(false);
            updatePriority.setVisible(false);
            update.setVisible(false);
            while(!Runner.notTreated.isEmpty()){
                Patient t = Runner.notTreated.poll();
                temp.add(t);
                if(t.findPatient(lastNameSearch.getText(),firstNameSearch.getText())){
                    thingo = true;
                    updatePatient =t;
                    break;
                }
                thingo = false;
            }
            if(thingo){
                updateIllness.setVisible(true);
                updatePriority.setVisible(true);
                update.setVisible(true);
                while(!temp.isEmpty()){
                    Patient t = temp.poll();
                    if(!t.equals(updatePatient)){
                        Runner.notTreated.add(t);
                    }
                }
                thingo = false;
            }else{
                while(!temp.isEmpty()){
                    Runner.notTreated.add(temp.poll());
                }
                Runner.showToast("Could not find that user");
            }
        }else if(e.getSource()==update){
            showPane.setVisible(false);
            lastName.setVisible(false);
            firstName.setVisible(false);
            illness.setVisible(false);
            priority.setVisible(false);
            add.setVisible(false);
            firstNameSearch.setVisible(false);
            lastNameSearch.setVisible(false);
            search.setVisible(false);
            updateIllness.setVisible(false);
            updatePriority.setVisible(false);
            update.setVisible(false);
            if(updateIllness.getText().equals("")){
                updatePatient.updatePriority(updatePriority.getText());
                Runner.notTreated.add(updatePatient);
            }else if(updatePriority.getText().equals("")){
                updatePatient.updateIllness(updateIllness.getText());
                Runner.notTreated.add(updatePatient);
            }else if(updateIllness.getText().equals("")&&updatePriority.getText().equals("")){

            }
            else{
                updatePatient.updateIllness(updateIllness.getText());
                updatePatient.updatePriority(updatePriority.getText());
                Runner.notTreated.add(updatePatient);
            }
        }
        revalidate();
        repaint();
    }
}
