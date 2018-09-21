import java.util.Scanner;
 
public class ScannerStrings{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
 
         
        //There are issues with nextLine() and the variable sentence.  Fix it. 
        //(1) What is happening that is not working correctly?
        //The sentence variable has not been declared properly.
        //(2) What type of errors are these? runtime or syntax?
        //This is a syntax error
         
        System.out.print("Enter an integer :: ");
        int num = keyboard.nextInt();
         
        System.out.print("Enter a sentence :: ");
        keyboard.nextLine();
        String sentence = keyboard.nextLine();
     
        System.out.print("Enter your favorite color :: ");
        String color = keyboard.next();

        System.out.print("Enter your favorite saying :: ");
        keyboard.nextLine();
        String saying = keyboard.nextLine();
         
        System.out.println("Your number is :: " + num);
        System.out.println("Your sentence is :: " + sentence);
        System.out.println("Your color is :: " + color);
        System.out.println("Your saying is :: " + saying);
         
        //Add code to do the following.  Decide if you should use next() or nextLine().
        //(3) Ask the user for their favorite color, then print it out.
        //(4) Ask the user for their favorite saying, then print it out.
         
    }
}