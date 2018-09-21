public class Quadratic{
	public static void main(String[] args){
		double a = 38;
		double b = 3289;
		double c = 120;
		System.out.println("a: "+ a + ", b: " + b + ", c: "+ c);
		System.out.println("x = " +(-b + Math.sqrt(Math.pow(b,2) -4*a*c))/(2*a) +" or "+ (-b - Math.sqrt(Math.pow(b,2) -4*a*c))/(2*a));
	}
}