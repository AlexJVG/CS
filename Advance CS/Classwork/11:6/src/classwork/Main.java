package classwork;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Queue<Customer> waitingList = new LinkedList<Customer>();
		waitingList.add(new Customer("Alex", "6503086909"));
		waitingList.add(new Customer("Bob", "6503086908"));
		waitingList.add(new Customer("Jim", "6503086907"));
		while (!waitingList.isEmpty()) {
			System.out.println(waitingList.poll().toString());
		}

	}

}
