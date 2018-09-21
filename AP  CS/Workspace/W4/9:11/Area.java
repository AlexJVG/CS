import java.util.Scanner;
public class Area{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.print("Length: ");
		int length = kb.nextInt();
		System.out.print("Width: ");
		double width = kb.nextDouble();
		System.out.println("Length = " + length);
		System.out.println("Width = " + width);
		double area = length * width;
		System.out.println("Area = " + area);
	}
}