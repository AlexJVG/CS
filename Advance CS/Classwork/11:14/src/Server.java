import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {

        int portNumber = 8080;
        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept(); //wait for a connection
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("What is the capital of California?");
            String answer = in.readLine();
            System.out.println(answer);
            if(answer.equals("Sacramento")){
                out.println("Correct");
                out.flush();
            }
            else{
                out.println("Incorrect");
                out.flush();
            }
            System.out.println("Sending question 2 to client");
            out.println("What is the capital of Washington?");
            String answer2 = in.readLine();
            System.out.println(answer2);
            if(answer2.equals("Olympia")){
                out.println("Correct");
                out.flush();
            }
            else{
                out.println("Incorrect");
                out.flush();
            }

            out.println("What is the world's highest mountain?");
            String answer3 = in.readLine();
            if(answer3.equals("Mount Everest")){
                System.out.println("sadf");
                out.println("Correct");
            }
            else{
                out.println("Incorrect");
            }

            out.println("Who many great lakes exist?");
            String answer4 = in.readLine();
            if(answer4.equals("5")){
                out.println("Correct");
            }
            else{
                out.println("Incorrect");
            }

            out.println("What is the world's biggest desert?");
            String answer5 = in.readLine();
            if(answer5.equals("Sahara")){
                out.println("Correct");
            }
            else{
                out.println("Incorrect");
            }
            in.close();
            out.close();

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}