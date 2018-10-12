import java.util.ArrayList;

import javax.swing.JFrame;

public class Runner {
	static JFrame frame;
	static Screen sc;
	
	public static void main(String[] args) {
		frame = new JFrame("Screen");
		sc = new Screen(0,new ArrayList<Integer>(),new ArrayList<Integer>());
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
	public static void remake(int height,ArrayList<Integer> linelength,ArrayList<Integer> quantvals) {
        sc = new Screen(height,linelength,quantvals);
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}
