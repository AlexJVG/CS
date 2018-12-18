import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.*;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.Dimension;
import java.awt.Graphics;

public class ClientScreen extends JPanel {
    public static final long serialVersionUID = 31;
    private Game game;
    ObjectOutputStream out;
    private boolean server;

    public ClientScreen() {
        this.setLayout(null);
        server = false;
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    game.playerMove(true, 2);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.playerMove(true, 3);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.playerMove(true, 4);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    game.playerMove(true, 1);
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    game.playerMove(true, 5); 
                 }
                game.gameLogic(true);
                if(game.gameOver){
                    if(game.getWinner()==1){
                        repaint();
                    }else if(game.getWinner()==2){
                        repaint();
                    }
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                    }
                }
                repaint();
                if(server){
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                    }
                }
            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension(900, 800);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (server) {
            game.drawGame(g,true);
        }
    }

    public void poll() throws IOException {
        Socket serverSocket = new Socket("localhost", 1024);
        out = new ObjectOutputStream(serverSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());

        try {
            while (true) {
                game = (Game) in.readObject();
                if(!game.clientGot){
                    server = true;
                    game.clientGot = true;
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                    }
                }
                game.gameLogic(true);
                if(game.gameOver){
                    if(game.getWinner()==1){
                        repaint();
                    }else if(game.getWinner()==2){
                        repaint();
                    }
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                    }
                }
                repaint();
            }
        } catch (UnknownHostException e) {
            System.err.println("Host unknown: localhost");
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
