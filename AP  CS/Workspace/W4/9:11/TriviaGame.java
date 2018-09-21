import java.util.Scanner;
public class TriviaGame{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is 75 + 1?");
		String answer = keyboard.next();
		if(answer.equals("76")){
			System.out.println("Good job");
		}
		else{
			System.out.println("Sorry wrong answer, the answer was 76");
		}
		System.out.println("Who do you print \"Hello World\" in java?");
		keyboard.nextLine();
		answer  = keyboard.nextLine();
		if(answer.equals("System.out.println(\"Hello World\");")){
			System.out.println("Good job");
		}
		else{
			System.out.println("Sorry wrong answer, the answer was System.out.println(\"Hello World\");");
		}
	}
}