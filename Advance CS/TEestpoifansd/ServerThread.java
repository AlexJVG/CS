import java.net.*;
import java.io.*;
import java.util.Random;
public class ServerThread implements Runnable{
	private Socket clientSocket;
  private PrintWriter out;
	private Manager man;
	public ServerThread(Socket clientSocket,Manager man){
		this.clientSocket = clientSocket;
		this.man = man;
	}
	public void sendMSG(String m){
		out.println(m);
	}
	public void run(){
		System.out.println(Thread.currentThread().getName() + ": connection opened.");
		try{
		  out = new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println(man.upON());
			while(true){
				String fromServer = in.readLine();
				if(fromServer!=null){
					man.broadcast(fromServer);
					if(fromServer.equals("bye")){
						man.remove(this);
						break;
					}
				}
			}
			out.flush();
			out.close();
			System.out.println(Thread.currentThread().getName() + ": connection closed.");
		} catch (IOException ex){
			System.out.println("Error listening for a connection");
			System.out.println(ex.getMessage());
		}
	}
}
