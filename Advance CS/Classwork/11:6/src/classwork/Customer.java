package classwork;

public class Customer {
	private String name;
	private String phoneNumber;

	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "Name: " + name + "\tPhoneNumber: " + phoneNumber;
	}
}
