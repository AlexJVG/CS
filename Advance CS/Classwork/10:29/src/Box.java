
public class Box {
	private String name;
	private double weight;
	public Box(String name,double weight) {
		this.name = name;
		this.weight = weight;
	}
	public String toString() {
		return "Name: "+ this.name +", Weight: "+ this.weight;
	}
	public double getWeight() {
		return this.weight;
	}

}
