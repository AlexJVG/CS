import java.util.*;
public class Runner{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ListIterator<Integer> it = intList.listIterator();
		for(int i =0; i<5; i++){
			System.out.println("Please enter a number");
			int num = kb.nextInt();
			it = intList.listIterator();
			while(it.hasNext()){
				if(it.next()>num){
					it.previous();
					break;
				}
			}
			it.add(num);
		}
		it = intList.listIterator();
		while(it.hasNext()){
			System.out.println("\n"+it.next());
		}
	}
}