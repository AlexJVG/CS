import javax.swing.*;
import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Sever");
        ServerScreen ss = new ServerScreen();
        frame.add(ss);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ss.poll();
    }
}
