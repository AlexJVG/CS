import javax.swing.JFrame;
public class Client {
  public static void main(String[] args){
		JFrame frame = new JFrame("RAFE'S BIG BOI ADVENTURE");
        ClientScreen sc = new ClientScreen();
        frame.add(sc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        sc.poll();
	}
}
