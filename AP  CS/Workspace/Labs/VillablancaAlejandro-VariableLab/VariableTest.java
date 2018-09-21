import java.util.Scanner;
public class VariableTest{
	public static void main(String[] args){
		System.out.println("Part 1");

		byte one = 5;
		System.out.println("one is a byte and has the value of "+one+".");
		int two = 1000023;
		System.out.println("two is a integer and has the value of "+two+".");
		double three = 75.48;
		System.out.println("three is a double and has the value of "+three+".");
		short four = 3820;
		System.out.println("four is a short and has the value of "+four+".");
		long five = 18238923;
		System.out.println("five is a long and has the value of "+five+".");
		float six = 48.9823f;
		System.out.println("six is a float and has the value of "+six+".");
		char seven = 'a';
		System.out.println("seven is a char and has the value of "+seven+".");
		boolean eight = true;
		System.out.println("eight is a boolean and has the value of "+eight+".");



		System.out.println("\nPart 2");

		char charh = 72;
		char chare =101;
		char charl  =108;
		char charo  =111;
		char charspace =32;
		char charw =87;
		char charr = 114;
		char chard =100;
		char charquote = 34;
		char charexclimation = 33;

		System.out.print(charquote);
		System.out.print(charh);
		System.out.print(chare);
		System.out.print(charl);
		System.out.print(charl);
		System.out.print(charo);
		System.out.print(charspace);
		System.out.print(charw);
		System.out.print(charo);
		System.out.print(charr);
		System.out.print(charl);
		System.out.print(chard);
		System.out.print(charexclimation);
		System.out.println(charquote);

		

		System.out.println("\nPart 3");

		//Area of Rectangle
		int length = 5;
		int width  =3;
		int area = length*width;
		System.out.println("Area of Rectangle");
		System.out.println("area = length * width");
		System.out.println("length = " + length + ", width = " + width);
		System.out.println("area = " + area);

		//Area of Square
		int side =  5;
		area = side*side;
		System.out.println("Area of Square");
		System.out.println("area = side * side");
		System.out.println("side = "+ side);
		System.out.println("area = "+ area);

		//Volume of a Rectangluar Solid
		length = 10;
		width = 39;
		int height = 54;
		int volume = height * width * length;
		System.out.println("Volume of a Rectangluar Solid");
		System.out.println("volume = height * width * length");
		System.out.println("height = " + height + ", width = " + width + ", length = " + length);
		System.out.println("volume = "+ volume);

		//Volume of a Cube
		side = 93;
		volume = side * side * side;
		System.out.println("Volume of a Square");
		System.out.println("volume = side * side * side");
		System.out.println("side = "+ side);
		System.out.println("volume = volume");

		//Pounds to Ounces
		int pounds = 16;
		int ounces = pounds * 16;
		System.out.println("Pounds to Ounces");
		System.out.println("ounces = pounds * 16");
		System.out.println("pounds = "+ pounds);
		System.out.println("ounces = "+ ounces);


		System.out.println("\nPart 4");

		//Celcius to Fahrenheit
		double celcius = 10;
		double fahrenheit = celcius * (9/5) +32;
		System.out.println("Celcius to Fahrenheit");
		System.out.println("fahrenheit = celcius * (9/5) + 32");
		System.out.println("celcius = " + celcius);
		System.out.println("fahrenheit = " + fahrenheit);

		//Pythagorean Theorem
		double leg1 = 16;
		double leg2 = 9;
		double hypotenuse = Math.sqrt(Math.pow(leg1,2)+Math.pow(leg2,2));
		System.out.println("Pythagorean Theorem");
		System.out.println("hypotenuse = Math.sqrt(Math.pow(leg1,2) + Math.pow(leg2,2))");
		System.out.println("leg1 = "+ leg1 +", leg2 = "+ leg2);
		System.out.println("hypotenuse = " +hypotenuse);

		//Distance Formula
		double x1 = 12;
		double x2 = 6;
		double y1 = 7;
		double y2 =  83;
		double distance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
		System.out.println("Distance Formula");
		System.out.println("distance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1))");
		System.out.println("x1 = "+ x1+",  x2 = "  + x2 + ", y1 = " + y1 + ", y2 = "+ y2);
		System.out.println("distance =" +  distance);



		System.out.println("\nChallenge");

		Scanner sc = new Scanner(System.in);

		//Area of a Circle
		System.out.println("Area of a Circle");
		System.out.println("What is the radius of the circle?");
		double radius = sc.nextDouble();
		double pi = 3.14;
		double ciclearea = Math.pow(radius,2) *  pi;
		System.out.println("radius ="+radius+", pi = "+pi);
		System.out.println("area = "+area);

		//Circumference of a Circle
		System.out.println("Circumference of a Circle");
		System.out.println("What is the radius of the circle?");
		radius = sc.nextDouble();
		pi = 3.14;
		double circlecumference = radius*2 *  pi;
		System.out.println("radius ="+radius+", pi = "+pi);
		System.out.println("circlecumference = "+circlecumference);
	}
}