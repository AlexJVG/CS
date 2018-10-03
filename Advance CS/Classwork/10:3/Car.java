public class Car{
	private String name;
	private String make;
	private int year;
	public Car(String name, String make, int year){
		this.name =name;
		this.make = make;
		this.year = year;
	}
	public String getName(){
		return name;
	}
	public int getYear(){
		return year;
	}
	private String getMake(){
		return make;
	}
	@Override
	public boolean equals(Object o){
		Car t = (Car)o;
		if(name.equals(t.getName()) && year == t.getYear() && make.equals(t.getMake())){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int hashCode(){
		int hashCode = name.hashCode() = make.hashCode();
		hashCode = 31*hashCode+year;
		return hashCode;
	}
	@Override
	public String toString(){
		return "This is a string with a thing in it";	
	}
}