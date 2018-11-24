import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerScreen extends JPanel implements ActionListener {
    private PrintWriter out;
    private JTextArea chatMessages;
    private JTextField sendMessage;
    public ServerScreen(){
        this.setLayout(null);
        chatMessages = new JTextArea();
        chatMessages.setBounds(0,0,500,500);
        this.add(chatMessages);
        sendMessage = new JTextField();
        sendMessage.setBounds(0,500,100,30);
        sendMessage.addActionListener(this);
        this.add(sendMessage);
    }
    public Dimension getPreferredSize(){
        return new Dimension(800,800);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sendMessage){
            String message = sendMessage.getText();
            chatMessages.append(message+"\n");
            out.println(message);
            sendMessage.setText("");
        }
    }
    public void poll() throws IOException{
        ServerSocket serverSocket = new ServerSocket(1024);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);

        try{
            while(true){
                chatMessages.append(in.readLine()+"\n");
            }
        }  catch (UnknownHostException e) {
            System.err.println("Host unkown: localhost" );
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to localhost");
            System.exit(1);
        }
    }
}
