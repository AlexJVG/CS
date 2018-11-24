import java.net.*;
import java.util.*;
import java.io.*;

public class Server2 {
    public static void main(String[] args){
        try {
            Boolean found = false;
            String word = "";
            String input = "";
            Map<String,String> keywords= new TreeMap<>();
            keywords.put("hello","How are you?");
            keywords.put("smoke","Isn\'t the smoke pretty bad outside");
            keywords.put("problem","Can you explain this problem?");
            keywords.put("xd","no u");
            keywords.put("bye","Goodbye");
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket clientSocket = serverSocket.accept(); //wait for a connection
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to this chatbot");
            out.println("Say something");
            while(true){
                input = in.readLine();
                for(String each:input.split(" ",input.length())){
                    if(each.toLowerCase().equals("bye")){
                        out.println(keywords.get("bye"));
                        System.exit(0);
                    }
                }
                for(String each : keywords.keySet()){
                    for(String other : input.split(" ",input.length())){
                        if(each.equals(other.toLowerCase())){
                            found = true;
                            word = each;
                            break;
                        }
                        else{
                            found = false;
                        }
                    }
                    if(found){
                        break;
                    }
                }
                if(found){
                    System.out.println(word);
                    out.println(keywords.get(word));
                }else{
                    out.println("I can't help you with that");
                }
            }
        }catch(IOException e){
            System.exit(1);
        }
    }
}
