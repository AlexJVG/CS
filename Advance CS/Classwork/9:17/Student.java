public class Student{
	private int grade;
	private String name;
	public Student(String name,int grade){
		this.grade = grade;
		this.name = name;
	}
	public String toString(){
		return "Name: " + name+", Grade: "+grade;
	}
	public String getName(){
		return name;
	}
}