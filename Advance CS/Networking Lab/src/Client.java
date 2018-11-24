import javax.swing.*;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Client");
        ClientScreen cs = new ClientScreen();
        frame.add(cs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        cs.poll();
    }
}
