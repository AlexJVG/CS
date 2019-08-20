import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
public class ClientScreen extends JPanel implements ActionListener{
  String hostName = "10.210.29.185";
  int portNumber = 1024;
  String username = "";
  String message = "";
  Socket serverSocket;
  BufferedReader in;
  PrintWriter out;
  JTextArea Messages = new JTextArea();
  JTextField AddUsername = new JTextField("Enter your Username");
  JTextField SendMessage = new JTextField();
  JButton AddButton = new JButton("Set your Username");
  JButton SendButton = new JButton("Send Message");
  JScrollPane vertical;
  public ClientScreen(){
    this.setLayout(null);
    try{
      serverSocket = new Socket(hostName, portNumber);
      in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
      out = new PrintWriter(serverSocket.getOutputStream(), true);
    }catch(Exception e){
      System.out.println(e);
    }

    AddButton.setBounds(300,300, 100, 50);
    AddButton.addActionListener(this);
    AddButton.setFocusable(false);
    this.add(AddButton);
    AddUsername.setBounds(300,400,100,50);
    AddUsername.setFocusable(true);
    this.add(AddUsername);

    Messages.setBounds(0,0,800,770);
    Messages.setVisible(false);
    Messages.setFocusable(false);
    Messages.setEditable(false);
    this.add(Messages);

    vertical = new JScrollPane(Messages);
    vertical.setBounds(0,0,800,770);
    vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    vertical.setVisible(true);
    this.add(vertical);
    SendMessage.setBounds(0,770,700,30);
    SendMessage.setVisible(false);
    SendMessage.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode()==10){
          JTextField textField = (JTextField) e.getSource();
          if(!textField.equals("")){
            String msg = textField.getText();
            textField.setText("");
            out.println(username+": "+msg);
            message=msg;
          }
        }
      }

      public void keyTyped(KeyEvent e) {
      }

      public void keyPressed(KeyEvent e) {
      }
    });
    this.add(SendMessage);
    SendButton.setBounds(700,770, 100, 30);
    SendButton.setVisible(false);
    SendButton.setFocusable(false);
    SendButton.addActionListener(this);
    this.add(SendButton);
		this.setFocusable(true);
  }
  public Dimension getPreferredSize() {
        return new Dimension(800,800);
	}
  public void poll(){
      try {
        String text = in.readLine();
        Messages.append(text.trim());
        while(true){
          if(in.ready()){
            Messages.append(in.readLine()+"\n");
          }
          if(get().equals("bye")){
            System.exit(1);
          }
        }
      } catch (UnknownHostException e) {
        System.err.println("Don't know about host " + hostName);
        System.exit(1);
      } catch (IOException e) {
        System.err.println("Error connecting to " + hostName);
        System.exit(1);
      }
  }
  public String get(){
    return message;
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==SendButton){
      if(!SendMessage.equals("")){
        String msg = SendMessage.getText();
        out.println(username+": "+msg);
        message=msg;
      }
    }
    if(e.getSource()==AddButton){
      if(!AddUsername.getText().equals("")){
        username = AddUsername.getText();
        SendMessage.setVisible(true);
        SendButton.setVisible(true);
        Messages.setVisible(true);
        AddButton.setVisible(false);
        AddUsername.setVisible(false);
      }
    }
	}
}
