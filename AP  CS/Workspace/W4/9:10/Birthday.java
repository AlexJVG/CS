import java.util.Scanner;
public class Birthday{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter your birth year as an integer:");
		int birthyear = kb.nextInt();
		System.out.println("You are "+ (2018-birthyear)+" years old");
	}
}