import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;

public class Admin extends JPanel {
    private JTextArea show;
    private PriorityQueue<Billed> temp;
    public Admin(){
        temp = new PriorityQueue<>();
        show = new JTextArea();
        show.setBounds(0,0,800,800);
        this.add(show);
        show.setText("");
        while(!Runner.billed.isEmpty()){
            Billed t = Runner.billed.poll();
            temp.add(t);
            show.append(t.toString()+"\n\n");
        }
        while(!temp.isEmpty()){
            Runner.billed.add(temp.poll());
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,800);
    }
    public void updateList(){
        show.setText("");
        while(!Runner.billed.isEmpty()){
            Billed t = Runner.billed.poll();
            temp.add(t);
            show.append(t.toString()+"\n\n");
        }
        while(!temp.isEmpty()){
            Runner.billed.add(temp.poll());
        }
    }
}
