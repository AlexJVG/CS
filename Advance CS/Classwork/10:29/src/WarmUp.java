import java.util.Stack;
public class WarmUp {

	public static void main(String[] args) {
		Stack<Box> s = new Stack<Box>();
		double total = 0;
		Box temp;
		s.push(new Box("Shoes",2.5));
		s.push(new Box("Speakers",4.1));
		s.push(new Box("Cups",3));
		while(!s.empty()) {
			temp = s.pop();
			total += temp.getWeight();
			System.out.println(temp.toString());
		}
		System.out.println("The total wieght is: "+total+"lbs.");

	}

}
