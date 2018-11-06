import java.util.Stack;
public class Classwork2 {

	public static void main(String[] args) {
		Stack<Double> s = new Stack<Double>();
		String[] test  = new String[5];
		test[0] = "2 7 + 1 2 + +";
		test[1] = "1 2 3 4 + + +";
		test[2] = "3 3 + 7 * 9 2 / +";
		test[3] = "9 3 / 2 * 7 9 * + 4 -";
		test[4] = "5 5 + 2 * 4 / 9 +";
		for(int i = 0; i<test.length; i++) {
			String[] temp = test[i].split(" ");
			for(String each: temp) {
				System.out.println(each);
				if(each.equals("*")) {
					Double temp1 = s.pop();
					Double temp2 = s.pop();
					Double temp3 = temp1 *temp2;
					s.push(temp3);
				}else if(each.equals("+")) {
					Double temp1 = s.pop();
					Double temp2 = s.pop();
					Double temp3 = temp1 +temp2;
					s.push(temp3);
				}else if(each.equals("-")) {
					Double temp1 = s.pop();
					Double temp2 = s.pop();
					Double temp3 = temp2 -temp1;
					s.push(temp3);
				}else if(each.equals("/")) {
					Double temp1 = s.pop();
					Double temp2 = s.pop();
					Double temp3 = temp2 /temp1;
					s.push(temp3);
				}else {
					s.push(Double.parseDouble(each));
				}
			}
			System.out.println(s);
			s.pop();
		}

	}

}
