 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientScreen extends JPanel implements MouseListener, ActionListener {
    private ObjectOutputStream out;
    private Gameboard localBoard;
    private boolean server;
    private JLabel serverScore;
    private JLabel clientScore;
    private JButton ai;
    private JButton player;
    private boolean requestsent;

    public ClientScreen() {
        this.setLayout(null);
        addMouseListener(this);
        ai = new JButton("Play against AI");
        ai.setBounds(0,0,200,30);
        ai.addActionListener(this);
        this.add(ai);
        player = new JButton("Play against Player");
        player.setBounds(0,30,200,30);
        player.addActionListener(this);
        this.add(player);
        requestsent = false;
        server = false;
        serverScore = new JLabel("Server Score: "+ 0);
        serverScore.setBounds(0,300,100,30);
        serverScore.setVisible(false);
        this.add(serverScore);
        clientScore = new JLabel("Client Score: "+ 0);
        clientScore.setBounds(200,300,100,30);
        clientScore.setVisible(false);
        this.add(clientScore);
        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 330);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if(server&&requestsent){
            localBoard.drawBoard(g);
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==ai){
            ai.setVisible(false);
            player.setVisible(false);
            clientScore.setVisible(true);
            serverScore.setVisible(true);
            requestsent = true;
            localBoard.setChoice("ai");
        } else if (e.getSource()==player) {
            ai.setVisible(false);
            player.setVisible(false);
            clientScore.setVisible(true);
            serverScore.setVisible(true);
            requestsent = true;
            localBoard.setChoice("player");
        }
        try {
            out.reset();
            out.writeObject(localBoard);
        } catch (IOException z) {
            System.err.println(z);
        }
        revalidate();
        repaint();
    }
    public void mouseClicked(MouseEvent e) {
        if(!localBoard.turn&&e.getY()<=300){
            localBoard.updateBoard(1, e.getX(), e.getY(),false);
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
                if(localBoard.reset){
                    ai.setVisible(true);
                    player.setVisible(true);
                    requestsent=false;
                    out.reset();
                    out.writeObject(localBoard);
                }
                if(!localBoard.gameState&&!localBoard.reset){
                    localBoard.turn = false;
                }
                revalidate();
                repaint();
                int gameOver = localBoard.checkGameCompletion();
                switch(gameOver){
                    case 0:
                        localBoard.playSound(4);
                        break;
                    case 1:
                        localBoard.playSound(3);
                        break;
                    case 2:
                        localBoard.playSound(2);
                        break;
                }
                if(gameOver!=3&&localBoard.gameState&&!localBoard.reset){
                    localBoard.gameOver(gameOver);
                    localBoard.turn = true;
                }else if(gameOver!=3&&!localBoard.reset){
                    localBoard.gameOver(gameOver);
                    localBoard.turn = true;
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