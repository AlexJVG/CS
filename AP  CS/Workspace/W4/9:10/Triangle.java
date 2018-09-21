import java.util.Scanner;
public class Triangle{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the height and base as doubles");
		System.out.print("Height:");
		double height = kb.nextDouble();
		System.out.print("Base:");
		double base = kb.nextDouble();
		System.out.println("The area of the triangle is: "+ (1.0/2.0*base*height));
	}
}