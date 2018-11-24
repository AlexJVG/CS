import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientScreen extends JPanel implements MouseListener {
    private ObjectOutputStream out;
    private Gameboard localBoard;
    private boolean server;
    private JLabel serverScore;
    private JLabel clientScore;

    public ClientScreen() {
        this.setLayout(null);
        addMouseListener(this);
        server = false;
        serverScore = new JLabel("Server Score: "+ 0);
        serverScore.setBounds(0,300,100,30);
        this.add(serverScore);
        clientScore = new JLabel("Client Score: "+ 0);
        clientScore.setBounds(200,300,100,30);
        this.add(clientScore);
        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 330);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if(server){
            localBoard.drawBoard(g);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(!localBoard.turn){
            localBoard.updateBoard(1, e.getX(), e.getY());
            try {
                out.reset();
                out.writeObject(localBoard);
            } catch (IOException z) {
                System.err.println(z);
            }
            revalidate();
            repaint();
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void poll() throws IOException {
        Socket serverSocket = new Socket("localhost",1024);
        out = new ObjectOutputStream(serverSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
        server = true;

        try {
            while (true) {
                localBoard = (Gameboard) in.readObject();
                if(!localBoard.gameState){
                    localBoard.turn = false;
                }
                revalidate();
                repaint();
                int gameOver = localBoard.checkGameCompletion();
                if(gameOver!=3&&localBoard.gameState){
                    localBoard.gameOver(gameOver);
                    localBoard.turn = true;
                }else if(gameOver!=3){
                    localBoard.gameOver(gameOver);
                    localBoard.turn = true;
                    localBoard.gameState = true;
                    out.reset();
                    out.writeObject(localBoard);
                }
                System.out.println(gameOver);
                serverScore.setText("Server Score: "+ localBoard.serverWins);
                clientScore.setText("Client Score: "+ localBoard.clientWins);
            }
        } catch (UnknownHostException e) {
            System.err.println("Host unknown: localhost");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to localhost");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}