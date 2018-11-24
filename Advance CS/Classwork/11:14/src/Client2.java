import java.net.*;
import java.util.*;
import java.io.*;

public class Client2 {
    public static void main(String[] args){
        try{
            Scanner kb = new Scanner(System.in);
            Socket serverSocket = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            String servermessages = "";
            for(int i =0;i<2;i++){
                servermessages = in.readLine();
                System.out.println(servermessages);
            }
            while(true){
                out.println(kb.nextLine());
                servermessages = in.readLine();
                System.out.println(servermessages);
            }
        }catch(IOException e){

        }
    }
}
