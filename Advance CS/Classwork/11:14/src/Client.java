import java.net.*;
import java.io.*;
import java.util.*;
public class Client {
    public static void main(String[] args){
        String hostname = "localhost";
        int port = 8080;
        String test;
        try{
            Scanner kb = new Scanner(System.in);
            Socket serverSocket = new Socket(hostname, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            String servermessages = "";

            for(int i=0; i<5;i++){
                System.out.println("Reading new question");
                servermessages = in.readLine();
                System.out.println(servermessages);
                test = kb.nextLine();
                System.out.println(test);
                out.println(test);
                out.flush();
                servermessages = in.readLine();
                System.out.println(servermessages);
            }
            out.close();
            in.close();

        }catch (IOException e){
            System.err.println("Couldn't get I/O for the connection to " + hostname);
            System.exit(1);
        }
    }
}
