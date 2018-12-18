import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;
import javax.swing.JLabel;

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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    game.playerMove(false, 5);
                }
                game.gameLogic(false);
                if (game.gameOver) {
                    if (game.getWinner() == 1) {
                        repaint();
                    } else if (game.getWinner() == 2) {
                        repaint();
                    }
                    try {
                        out.reset();
                        out.writeObject(game);
                    } catch (IOException z) {
                    }
                }
                repaint();
                if (received) {
                    try {
                        out.reset();
                        out.writeObject(game);
                        System.out.println("send object");
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
        if (received) {
            game.drawGame(g,false);
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
        } catch (IOException z) {
        }

        try {
            while (true) {
                game = (Game) in.readObject();
                if (game.clientGot) {
                    received = true;
                }
                game.gameLogic(false);
                if (game.gameOver) {
                    if (game.getWinner() == 1) {
                        repaint();
                    } else if (game.getWinner() == 2) {
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
