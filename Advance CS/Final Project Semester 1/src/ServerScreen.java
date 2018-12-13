import javax.swing.JPanel;
import java.net.*;
import java.awt.event.KeyListener;
import java.io.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ServerScreen extends JPanel {
    public static final long serialVersionUID = 31;
    private Game game;
    public ObjectOutputStream out;
    private boolean received;

    public ServerScreen() {
        this.setLayout(null);
        game = new Game();
        received = false;
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    game.playerMove(false, 2);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.playerMove(false, 3);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.playerMove(false, 4);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    game.playerMove(false, 1);
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                   game.playerMove(false, 5); 
                }
                game.gameLogic(false);
                if(game.gameOver){
                    if(game.getWinner()==1){
                        System.out.println("The winner is: Client");
                    }else if(game.getWinner()==2){
                        System.out.println("The winner is: Server");
                    }
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                        System.out.println(z);
                    }
                    System.exit(0);
                }
                repaint();
                if(received){
                    try {
                        out.reset();
                        out.writeObject(game);
                        System.out.println("send object");
                    } catch (IOException z) {
                        System.out.println(z);
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
        if (received) {
            game.drawGame(g);
        }
    }

    public void poll() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1024);
        Socket clientSocket = serverSocket.accept();
        System.out.println("connection made");
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        try {
            out.reset();
            out.writeObject(game);
            System.out.println("send object");
        } catch (IOException z) {
            System.out.println(z);
        }
        
        try {
            while (true) {
                game = (Game) in.readObject();
                if (game.clientGot) {
                    received = true;
                }
                game.gameLogic(false);
                if(game.gameOver){
                    if(game.getWinner()==1){
                        System.out.println("The winner is: Client");
                    }else if(game.getWinner()==2){
                        System.out.println("The winner is: Server");
                    }
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                        System.out.println(z);
                    }
                    System.exit(0);
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
