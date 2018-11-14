import javax.swing.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Runner {
    public static PriorityQueue<Patient> notTreated;
    public static Queue<Patient> discharged;
    public static PriorityQueue<Billed> billed;
    public static Admin adminView;
    public static Nurse nurseView;
    public static Doctor doctorView;
    public static Biller billerView;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        notTreated = new PriorityQueue<>();
        discharged = new LinkedList<>();
        billed = new PriorityQueue<>();
        nurseView = new Nurse();
        doctorView = new Doctor();
        billerView = new Biller();
        adminView = new Admin();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Nurse View",nurseView);
        tabbedPane.addTab("Doctor View",doctorView);
        tabbedPane.addTab("Biller View",billerView);
        tabbedPane.addTab("Admin View",adminView);
        frame.add(tabbedPane);
        frame.setSize(800,800);
        frame.setVisible(true);
    }
    public static void showToast(String text){
        Toast t = new Toast(text);
        t.showToast();
    }


}
