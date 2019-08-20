import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {
		int portNumber = 1024;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		Manager cm = new Manager();
		while(true){
			System.out.println("Waiting for a connection");
			Socket clientSocket = serverSocket.accept();
			ServerThread s = new ServerThread(clientSocket,cm);
			cm.add(s);
			Thread thread = new Thread(s);
			thread.start();
		}
	}
}
