
//(1) What do you think the import statement does?
//It adds the Scanner class to the program
import java.util.Scanner;

public class Inputs {
	public static void main(String[] args) {
	
		//(2) What do you think is happening with the line below?
		//We are creating a new reference variable for the Scanner class.
		Scanner keyboard = new Scanner(System.in);
		
		//(3) What line of code takes in a number from the user and stores it in a variable?
		//18
		//(4) What type of number is it?
		//It is an integer.
		System.out.print("Enter in an integer:: ");
		int num1 = keyboard.nextInt();
		System.out.println("you entered:: " + num1);
		
		//(5) What line of code takes in a number from the user and stores it in a variable?
		//26
		//(6) What type of number is it?
		//It an a double.
		System.out.print("Enter in a double:: ");
		double num2 = keyboard.nextDouble();
		System.out.println("you entered:: " + num2);
	}
}