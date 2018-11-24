import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientScreen extends JPanel implements ActionListener {
    private PrintWriter out;
    private JTextArea chatMessages;
    private JTextField sendMessage;
    public ClientScreen(){
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
            chatMessages.append(message);
            out.println(message);
            sendMessage.setText("");
        }
    }
    public void poll() throws IOException{
        String hostname = "10.210.30.215";
        int portNumber =1024;
        Socket serverSocket = new Socket(hostname,portNumber);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        out = new PrintWriter(serverSocket.getOutputStream(), true);

        try{
            while(true){
                chatMessages.append(in.readLine()+"\n");
            }
        }  catch (UnknownHostException e) {
            System.err.println("Host unkown: " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostname);
            System.exit(1);
        }
    }
}
