import java.util.Stack;
import java.util.Scanner;
public class SecondClasswrok {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		Scanner kb = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("What would you like todo?\n0. Quit\n" + 
					"1. View the entire stack\n" + 
					"2. View just the top of the stack.\n" + 
					"3. Add a word to a stack.\n" + 
					"4. Print the size of the stack");
			choice = kb.nextInt();
			switch(choice) {
			case(0):
				System.out.println("Thank you for using this program");
				System.exit(0);
				break;
			case(1):
				System.out.println(s);
				break;
			case(2):
				if(s.empty()) {
					System.out.println("Your stack is empty");
				}
				else {
					System.out.println(s.peek());
				}
				break;
			case(3):
				System.out.println("What word would you like to add?");
				s.push(kb.next());
				break;
			case(4):
				System.out.println(s.size());
				break;
				
			}
		}

	}

}


//
//Then, write a program to do the following. 
//Your program will ask the user for the following options in a loop and run it accordingly.  You will create a stack of strings.
//
//0. Quit
//View the entire stack
//View just the top of the stack.
//Add a word to a stack.
//Print the size of the stack.
//
//
//Test all the scenarios given above. 
