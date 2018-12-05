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

public class ServerScreen extends JPanel implements MouseListener {
    private ObjectOutputStream out;
    private Gameboard localBoard;
    private JLabel serverScore;
    private JLabel clientScore;
    private int requestreceived;

    public ServerScreen() {
        this.setLayout(null);
        addMouseListener(this);
        localBoard = new Gameboard();
        requestreceived= 0;
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
        if(!localBoard.ai&&requestreceived>=2){
            localBoard.drawBoard(g);
        }else if(localBoard.ai&&requestreceived>=2){
            g.drawString("Ai is playing",100,100);
        }
    }
    public void ai(){
        localBoard.aiMakeMove();
        try {
            out.reset();
            out.writeObject(localBoard);
        } catch (IOException z) {
            System.out.println(z);
        }
        revalidate();
        repaint();
    }
    public void mouseClicked(MouseEvent e) {
        if(!localBoard.turn&&!localBoard.ai&&e.getY()<=300&&requestreceived>=2){
            localBoard.updateBoard(2, e.getX(), e.getY(),false);
            try {
                out.reset();
                out.writeObject(localBoard);
            } catch (IOException z) {
                System.out.println(z);
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
        ServerSocket serverSocket = new ServerSocket(1024);
        Socket clientSocket = serverSocket.accept();
        System.out.println("connection made");
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        try {
            out.reset();
            out.writeObject(localBoard);
            System.out.println("send object");
        } catch (IOException z) {
            System.out.println(z);
        }
        try {
            while (true) {
                localBoard = (Gameboard) in.readObject();
                requestreceived++;
                if(localBoard.reset){
                    requestreceived=0;
                    localBoard.reset = false;
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
                        localBoard.playSound(2);
                        break;
                    case 2:
                        localBoard.playSound(3);
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
                if(localBoard.ai&&requestreceived>=2&&gameOver==3&&!localBoard.reset){
                    ai();
                }

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