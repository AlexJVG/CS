import java.util.Scanner;
 
public class NextLineIssue {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
         
        System.out.print("Enter an integer :: ");
        int num = keyboard.nextInt();
        System.out.print("Enter a sentence :: ");
        keyboard.nextLine();
        String sentence = keyboard.nextLine();
        System.out.println(sentence);
         
        //What is the problem when running this code?
        //It will pick up the enter key from the preivious input and that prevents the user from entering a new input.
    }
}