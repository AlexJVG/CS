import java.util.Scanner;
public class Birthday{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.println("Please  enter the year you were born.");
		System.out.println("You are "+age(kb.nextInt())+" years old");
	}
	private static int age(int year){
		return 2018-year;
	}
}