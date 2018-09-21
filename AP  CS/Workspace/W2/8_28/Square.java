import java.util.Scanner; 

public class Square{
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("I will be finding the area of square. Please give the length of one side.");
		double side = keyboard.nextDouble(); 
		double areaSquare = side*side;
		System.out.println("The area of this square is " + areaSquare); 
	}
}
